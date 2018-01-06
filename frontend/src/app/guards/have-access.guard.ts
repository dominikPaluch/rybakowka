import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {UserService} from "../services/user.service";

@Injectable()
export class HaveAccessGuard implements CanActivate {

  constructor(private router: Router,
              private userService: UserService) {
  }

  public canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    if (!this.userService.isLogged()) {
      this.router.navigate(['login']);
      return false;
    }
    return true;
  }

}
