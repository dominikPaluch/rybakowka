import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent {

  public registrationForm: FormGroup;

  constructor(private fb: FormBuilder,
              private userService: UserService) {
    this.createLoginForm();
  }

  createLoginForm() {
    this.registrationForm = this.fb.group({
      login: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  login() {
    const formModel = this.registrationForm.value;
    this.userService.login(formModel.login, formModel.password);
  }

}
