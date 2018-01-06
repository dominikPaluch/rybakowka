import { Component, OnInit } from '@angular/core';
import {Type} from "../../../model/type";
import {Message} from "primeng/primeng";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TypeService} from "../../../services/type.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-types',
  templateUrl: './types.component.html',
  styleUrls: ['./types.component.scss']
})
export class TypesComponent implements OnInit {

  types: any;
  displayDialogAddType: boolean;
  displayDialogUpdateType: boolean;
  selectedType: Type;
  type: Type = new Type();
  newType: boolean;
  msgs: Message[] = [];
  public addTypeForm: FormGroup;

  constructor(private typeService: TypeService,
              private fb: FormBuilder,
              private router: Router) {
    this.createAddTypeForm();
    this.loadTypes();
  }

  ngOnInit(): void {
  }

  createAddTypeForm() {
    this.addTypeForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      normalPrice: ['', [Validators.required]],
      seasonPrice: ['', [Validators.required]],
      deleted: ['false'],
    });
  }

  addType() {
    this.msgs = [];
    this.typeService.addType(this.addTypeForm.getRawValue())
      .subscribe(
        () => {
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!', detail: 'Typ sprzętu został dodany'
          });
          this.types = this.loadTypes();
          // this.router.navigate(['home']);
          console.log('Type ' + this.type.name + ' added successfully!');
          this.type = null;
        },
        () => {
          console.log('Error in TypeComponent (addType())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Niepoprawne dane przy dodawaniu typu sprzętu!'
          });
        }
      );
    this.displayDialogAddType = false;
  }

  showDialogToAddType() {
    this.newType = true;
    this.type = new Type();
    this.displayDialogAddType = true;
  }

  removeType() {
    this.msgs = [];
    const index = this.findSelectedTypeIndex();
    this.types = this.types.filter((val, i) => i !== index);
    this.displayDialogUpdateType = false;
    console.log(this.type);
    this.typeService.removeType(this.type)
      .subscribe(() => {
          // this.router.navigate(['home']);
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!',
            detail: 'Typ sprzętu został usunięty'
          });
          this.types = this.loadTypes();
          console.log('Type ' + this.type.name + ' removed succesfully!');
          this.type = null;
        },
        () => {
          this.msgs.push({
            severity: 'error',
            summary: 'Błąd!',
            detail: 'Typ sprzętu: ' + this.type.name + ' nie został usunięty!'
          });
          this.types = this.loadTypes();
          this.type = null;
          console.log('Error in TypeComponent (removeType())');
        });
  }

  updateType() {
    this.msgs = [];
    const index = this.findSelectedTypeIndex();
    this.types = this.types.filter((val, i) => i !== index);
    this.displayDialogUpdateType = false;
    console.log(this.type);
    this.typeService.updateType(this.type)
      .subscribe(() => {
          this.msgs.push({
            severity: 'success',
            summary: 'Gratulacje!',
            detail: 'Typ sprzętu zaktualizowany'
          });
          this.types = this.loadTypes();
          // this.router.navigate(['home']);
          console.log('Type ' + this.type.name + ' updated succesfully!');
          this.type = null;
        },
        () => {
          console.log('Error in TypeComponent (updateType())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Typ sprzętu ' + this.type.name + 'nie został edytowany!'
          });
          this.types = this.loadTypes();
          this.type = null;
        });
  }

  onRowSelectType(event) {
    this.newType = false;
    this.type = this.cloneType(event.data);
    console.log(this.type);
    this.displayDialogUpdateType = true;
  }

  cloneType(a: Type): Type {
    const user = new Type();
    for (const prop in a) {
      user[prop] = a[prop];
    }
    return user;
  }

  findSelectedTypeIndex(): number {
    return this.types.indexOf(this.selectedType);
  }

  loadTypes() {
    this.typeService.getTypes()
      .subscribe(
        response => {
          response = response.filter((val) => val.deleted !== true);
          this.types = response;
        }
      );
  }
}
