import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import {PushService} from "./push.service";
import {Headers, Http, Response} from '@angular/http';
import 'rxjs';
import {Observable} from "rxjs/Observable";
import {Type} from "../model/type";

@Injectable()
export class TypeService {

  private backendUrl: string = environment.backendUrl;

  constructor(private router: Router,
              private pushService: PushService,
              private http: Http) {
  }

  getTypes(): Observable<any> {
    return this.http
      .get(`${this.backendUrl}/types`)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  addType(newType: Type): Observable<any> {
    console.log(newType);
    return this.http
      .post(`${this.backendUrl}/types`, newType)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  removeType(type: Type): Observable<any> {
    return this.http.put(`${this.backendUrl}/types/delete/${type.id}`, type)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  updateType(type: Type): Observable<any> {
    return this.http.put(`${this.backendUrl}/types/update/${type.id}`, type)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }
}
