import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {

  public loginForm: FormGroup;

  constructor(private fb: FormBuilder,
              private userService: UserService) {
    this.createLoginForm();
  }

  createLoginForm() {
    this.loginForm = this.fb.group({
      login: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  login() {
    const formModel = this.loginForm.value;
    this.userService.login(formModel.login, formModel.password);
  }
}
