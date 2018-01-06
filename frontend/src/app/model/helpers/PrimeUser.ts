import {User} from "../user";
import {AccessLevelEnum} from "../accessLevelEnum";

export class PrimeUser implements User {

  constructor(public id?: number,
              public login?: string,
              public password?: string,
              public firstname?: string,
              public lastname?: string,
              public email?: string,
              public phone?: number,
              public isConfirmed?: boolean,
              public accessLevelEnum?: AccessLevelEnum) {
  }
}
