export class RegistrationForm {

  private _login: string;
  private _password: string;
  private _firstName: string;
  private _lastName: string;
  private _email: string;
  private _phone: number;

  constructor(login: string,
              password: string,
              firstName: string,
              lastName: string,
              email: string,
              phone: number) {
    this._login = login;
    this._password = password;
    this._firstName = firstName;
    this._lastName = lastName;
    this._email = email;
    this._phone = phone;
  }

  get login(): string {
    return this._login;
  }

  set login(value: string) {
    this._login = value;
  }

  get password(): string {
    return this._password;
  }

  set password(value: string) {
    this._password = value;
  }

  get firstName(): string {
    return this._firstName;
  }

  set firstName(value: string) {
    this._firstName = value;
  }

  get lastName(): string {
    return this._lastName;
  }

  set lastName(value: string) {
    this._lastName = value;
  }

  get email(): string {
    return this._email;
  }

  set email(value: string) {
    this._email = value;
  }

  get phone(): number {
    return this._phone;
  }

  set phone(value: number) {
    this._phone = value;
  }


}
