import {AccessLevelEnum} from "./accessLevelEnum";

export class User {

  constructor(public id?: number,
              public login?: string,
              public password?: string,
              public firstname?: string,
              public lastname?: string,
              public email?: string,
              public phone?: number,
              public confirmed?: boolean,
              public deleted?: boolean,
              public accessLevelEnum?: AccessLevelEnum) {
  }
}
