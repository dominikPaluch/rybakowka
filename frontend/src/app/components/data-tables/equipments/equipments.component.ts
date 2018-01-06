import {Component, OnInit} from '@angular/core';
import {Equipment} from "../../../model/equipment";
import {Message} from "primeng/primeng";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {EquipmentService} from "../../../services/equipment.service";
import {Router} from "@angular/router";
import {TypeService} from "../../../services/type.service";

@Component({
  selector: 'app-equipments',
  templateUrl: './equipments.component.html',
  styleUrls: ['./equipments.component.scss']
})
export class EquipmentsComponent implements OnInit {

  equipments: any;
  types: any;
  displayDialogAddEquipment: boolean;
  displayDialogUpdateEquipment: boolean;
  selectedEquipment: Equipment;
  equipment: Equipment = new Equipment();
  newEquipment: boolean;
  msgs: Message[] = [];
  public addEquipmentForm: FormGroup;

  constructor(private equipmentService: EquipmentService,
              private typeService: TypeService,
              private fb: FormBuilder,
              private router: Router) {
    this.createAddEquipmentForm();
    this.loadEquipments();
    // this.getNameOfTypeById()
    this.loadTypes();
  }

  ngOnInit(): void {
  }

  createAddEquipmentForm() {
    this.addEquipmentForm = this.fb.group({
      statusEquipmentEnum: ['', [Validators.required]],
      serialNumber: ['', [Validators.required]],
      deleted: ['false'],
      typeId: ['', [Validators.required]]
    });
  }

  addEquipment() {
    this.msgs = [];
    this.equipmentService.addEquipment(this.addEquipmentForm.getRawValue())
      .subscribe(
        () => {
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!', detail: 'Sprzęt został dodany'
          });
          this.equipments = this.loadEquipments();
          // this.router.navigate(['home']);
          console.log('Sprzęt' + this.equipment.serialNumber + ' added successfully!');
          this.equipment = null;
        },
        () => {
          console.log('Error in EquipmentComponent (addEquipment())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Niepoprawne dane przy dodawaniu sprzetu!'
          });
        }
      );
    this.displayDialogAddEquipment = false;
  }

  showDialogToAddEquipment() {
    this.newEquipment = true;
    this.equipment = new Equipment();
    this.displayDialogAddEquipment = true;
  }

  removeEquipment() {
    this.msgs = [];
    const index = this.findSelectedEquipmentIndex();
    this.equipments = this.equipments.filter((val, i) => i !== index);
    this.displayDialogUpdateEquipment = false;
    console.log(this.equipment);
    this.equipmentService.removeEquipment(this.equipment)
      .subscribe(() => {
          // this.router.navigate(['home']);
          this.msgs.push({
            severity: 'success', summary: 'Gratulacje!',
            detail: 'Sprzęt został usunięty'
          });
          this.equipments = this.loadEquipments();
          console.log('Equipment ' + this.equipment.serialNumber + ' removed succesfully!');
          this.equipment = null;
        },
        () => {
          this.msgs.push({
            severity: 'error',
            summary: 'Błąd!',
            detail: 'Sprzęt: ' + this.equipment.serialNumber + ' nie został usunięty!'
          });
          this.equipments = this.loadEquipments();
          this.equipment = null;
          console.log('Error in EmployyComponent (removeEquipmentr())');
        });
  }

  updateEquipment() {
    this.msgs = [];
    const index = this.findSelectedEquipmentIndex();
    this.equipments = this.equipments.filter((val, i) => i !== index);
    console.log(this.equipment);
    this.displayDialogUpdateEquipment = false;
    this.equipmentService.updateEquipment(this.equipment)
      .subscribe(() => {
          this.msgs.push({
            severity: 'success',
            summary: 'Gratulacje!',
            detail: 'Sprzęt zaktualizowany'
          });
          this.equipments = this.loadEquipments();
          // this.router.navigate(['home']);
          console.log('Sprzęt ' + this.equipment.serialNumber + ' updated succesfully!');
          this.equipment = null;
        },
        () => {
          console.log('Error in EquipmentComponent (updateEquipment())');
          this.msgs.push({
            severity: 'error', summary: 'Błąd!',
            detail: 'Sprzęt ' + this.equipment.serialNumber + ' nie został edytowany!'
          });
          this.equipments = this.loadEquipments();
          this.equipment = null;
        });
  }

  deleteEquipment() {
    const index = this.findSelectedEquipmentIndex();
    this.equipments = this.equipments.filter((val, i) => i !== index);
    this.equipment = null;
  }

  onRowSelectEquipment(event) {
    this.newEquipment = false;
    this.equipment = this.cloneEquipment(event.data);
    this.displayDialogUpdateEquipment = true;
    // console.log(this.equipment);
    // console.log(this.getNameOfTypeById(this.equipment.typeId));
    // this.getNameOfTypeById(this.equipment.typeId);
  }

  cloneEquipment(a: Equipment): Equipment {
    const equipment = new Equipment();
    for (const prop in a) {
      equipment[prop] = a[prop];
    }
    return equipment;
  }

  findSelectedEquipmentIndex(): number {
    return this.equipments.indexOf(this.selectedEquipment);
  }

  loadEquipments() {
    this.equipmentService.getEquipments()
      .subscribe(
        response => {
          response = response.filter((val) => val.deleted !== true
          );
          this.equipments = response;
        }
      );
  }

  getNameOfTypeById(typeId: number) {
    const selectedType =  this.types.filter((val) => val.id === typeId);
    if (selectedType[0]) {
      return selectedType[0].name;
    }
  }

  loadTypes() {
    this.typeService.getTypes()
      .subscribe(
        response => {
          response = response.filter((val) => val.deleted !== true
          );
          this.types = response;
        }
      );
  }
}
