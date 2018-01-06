import {Injectable} from '@angular/core';
import {Observable} from "rxjs/Observable";
import {environment} from "../../environments/environment";
import {Headers, Http, Response} from '@angular/http';
import 'rxjs';
import {Router} from "@angular/router";
import {PushService} from "./push.service";
import {User} from "../model/user";

@Injectable()
export class UserService {

  public user;
  public loading = false;
  public error = false;

  private backendUrl: string = environment.backendUrl;

  constructor(private router: Router,
              private pushService: PushService,
              private http: Http) {
    // this.initUserData();
  }

  getUsers(): Observable<any> {
    return this.http
      .get(`${this.backendUrl}/users`)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  addUser(newUser: User): Observable<any> {
    console.log(newUser);
    return this.http
      .post(`${this.backendUrl}/users`, newUser)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  removeUser(user: User): Observable<any> {
    return this.http.put(`${this.backendUrl}/users/delete/${user.id}`, user)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  updateUser(user: User): Observable<any> {
    return this.http.put(`${this.backendUrl}/users/update/${user.id}`, user)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  public isLogged(): boolean {
    return this.user !== null;
  }

  public clean() {
    this.user = null;
  }

  private initUserData() {
    if (!this.user) {
      this.pushService.authenticate()
        .subscribe(
          response => {
            this.user = response;
            if (this.router.url === '/login') { // ==
              this.router.navigate(['home']);
            }
          },
          () => {
            this.router.navigate(['login']);
          }
        );
    }
  }

  public login(login: string, password: string) {
    this.loading = true;

    this.pushService.authenticate(login, password)
      .subscribe(
        response => {
          this.user = response;
          this.loading = false;
          this.error = false;
          this.router.navigate(['home']);
        },
        () => {
          this.loading = false;
          this.error = true;
        }
      );
  }
}
