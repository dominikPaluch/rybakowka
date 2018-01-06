import { Component, OnInit } from '@angular/core';
import {User} from "../../../model/user";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {PushService} from "../../../services/push.service";
import {UserService} from "../../../services/user.service";
import {Message} from "primeng/primeng";
import {accessLevels} from '../../../model/accesLevels';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  users: any;
  displayDialogAddUser: boolean;
  displayDialogUpdateUser: boolean;
  selectedUser: User;
  user: User = new User();
  newUser: boolean;
  accessLevels = accessLevels;
  msgs: Message[] = [];
  public addUserForm: FormGroup;
  public updateUserForm: FormGroup;

  constructor(private userService: UserService,
              private fb: FormBuilder,
              private router: Router) {
    this.createUserForm();
    this.loadUsers();
  }

  ngOnInit(): void {
  }

  onChangeLevel(level) {
    this.user.accessLevelEnum = level;
  }

  createUserForm() {
    this.addUserForm = this.fb.group({
      login: ['', [Validators.required]],
      password: ['', [Validators.required]],
      firstname: ['', [Validators.required]],
      lastname: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phone: ['', [Validators.required]],
      confirmed: ['true'],
      deleted: ['false'],
      accessLevelEnum: ['', [Validators.required]]
    });
  }

  addUser() {
    this.msgs = [];
    this.userService.addUser(this.addUserForm.getRawValue())
      .subscribe(
        () => {
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!', detail: 'Użytkownik został dodany'
          });
          this.users = this.loadUsers();
          // this.router.navigate(['home']);
          console.log('User' + this.user.login + ' added successfully!');
          this.user = null;
        },
        () => {
          console.log('Error in EmployyComponent (addUser())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Niepoprawne dane przy dodawaniu użytkownika!'
          });
        }
      );
    this.displayDialogAddUser = false;
  }

  showDialogToAddUser() {
    this.newUser = true;
    this.user = new User();
    this.displayDialogAddUser = true;
  }

  showDialogToUpdateUser() {
    this.displayDialogUpdateUser = true;
  }

  removeUser() {
    this.msgs = [];
    const index = this.findSelectedUserIndex();
    this.users = this.users.filter((val, i) => i !== index);
    this.displayDialogUpdateUser = false;
    console.log(this.user);
    this.userService.removeUser(this.user)
      .subscribe(() => {
          // this.router.navigate(['home']);
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!',
            detail: 'Użytkownik został usunięty'
          });
          this.users = this.loadUsers();
          console.log('User ' + this.user.login + ' removed succesfully!');
          this.user = null;
        },
        () => {
          this.msgs.push({
            severity: 'error',
            summary: 'Błąd!',
            detail: 'Użytkownik: ' + this.user.login + ' nie został usunięty!'
          });
          this.users = this.loadUsers();
          this.user = null;
          console.log('Error in EmployyComponent (removeUser())');
        });
  }

  updateUser() {
    this.msgs = [];
    const index = this.findSelectedUserIndex();
    this.users = this.users.filter((val, i) => i !== index);
    this.displayDialogUpdateUser = false;
    console.log(this.user);
    this.userService.updateUser(this.user)
      .subscribe(() => {
          this.msgs.push({
            severity: 'success',
            summary: 'Gratulacje!',
            detail: 'Użytkownik zaktualizowany'
          });
          this.users = this.loadUsers();
          // this.router.navigate(['home']);
          console.log('User ' + this.user.login + ' updated succesfully!');
          this.user = null;
        },
        () => {
          console.log('Error in EmployyComponent (updateUser())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Użytkownik ' + this.user.login + 'nie został edytowany!'
          });
          this.users = this.loadUsers();
          this.user = null;
        });
  }

  onRowSelectUser(event) {
    this.newUser = false;
    this.user = this.cloneUser(event.data);
    console.log(this.user);
    this.displayDialogUpdateUser = true;
  }

  cloneUser(a: User): User {
    const user = new User();
    for (const prop in a) {
      user[prop] = a[prop];
    }
    return user;
  }


  findSelectedUserIndex(): number {
    return this.users.indexOf(this.selectedUser);
  }

  loadUsers() {
    this.userService.getUsers()
      .subscribe(
        response => {
          response = response.filter((val) => val.deleted !== true);
          this.users = response;
        }
      );
  }
}
