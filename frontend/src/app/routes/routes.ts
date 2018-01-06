import {Routes} from "@angular/router";
import {LoginComponent} from "../components/login/login.component";
import {RegistrationComponent} from "../components/registration/registration.component";
import {HomeComponent} from "../components/content/home/home.component";
import {EmployeeComponent} from "../components/employee/employee.component";
import {MyAccountComponent} from "../components/my-account/my-account.component";
import {RegulationsComponent} from "../components/regulations/regulations.component";

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/home'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'registration',
    component: RegistrationComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    // canActivate: [HaveAccessGuard]
  },
  {
    path: 'employee',
    component: EmployeeComponent,
    // canActivate: [HaveAccessGuard]
  },
  {
    path: 'my-account',
    component: MyAccountComponent,
    // canActivate: [HaveAccessGuard]
  },
  {
    path: 'regulations',
    component: RegulationsComponent,
    // canActivate: [HaveAccessGuard]
  },
];
