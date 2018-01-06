import {Component, OnInit} from '@angular/core';
import {Message} from "primeng/primeng";
import {User} from "../../../model/user";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-data-table',
  templateUrl: './data-table.component.html',
  styleUrls: ['./data-table.component.scss']
})
export class DataTableComponent implements OnInit {

  users: User[];
  msgs: Message[] = [];

  ngOnInit() {

  }

  constructor(private userService: UserService) {
    this.loadUsers();
  }

  loadUsers() {
    this.userService.getUsers()
      .subscribe(
        response => {
          this.users = response;
        }
      );
  }

  selectedAccount(user: User) {
    this.msgs = [];
    this.msgs.push({severity: 'info', summary: 'User Select', detail: 'Login: ' + user.login});
  }
}
