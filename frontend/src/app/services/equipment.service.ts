import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {Http, Response} from '@angular/http';
import 'rxjs';
import {environment} from "../../environments/environment";
import {Router} from "@angular/router";
import {Equipment} from "../model/equipment";

@Injectable()
export class EquipmentService {

  public user;
  public loading = false;
  public error = false;

  private backendUrl: string = environment.backendUrl;

  constructor(private router: Router,
              private http: Http) {
  }

  getEquipments(): Observable<any> {
    return this.http
      .get(`${this.backendUrl}/equipments`)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        return Observable.throw(new Error(error.status));
      });
  }

  addEquipment(newEquipment: Equipment): Observable<any> {
    newEquipment.statusEquipmentEnum = 0;
    return this.http
      .post(`${this.backendUrl}/equipments`, newEquipment)
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  removeEquipment(equipment: Equipment): Observable<any> {
    return this.http.put(`${this.backendUrl}/equipments/delete/${equipment.id}`, equipment)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }

  updateEquipment(equipment: Equipment): Observable<any> {
    return this.http.put(`${this.backendUrl}/equipments/update/${equipment.id}`, equipment)
      .map((response: Response) => response)
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }
}
