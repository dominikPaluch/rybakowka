import {StatusEquipmentEnum} from "./statusEquipmentEnum";

export class Equipment {

  constructor(public id?: number,
              public statusEquipmentEnum?: StatusEquipmentEnum,
              public serialNumber?: string,
              public deleted?: boolean,
              public typeId?: number) {
  }
}
