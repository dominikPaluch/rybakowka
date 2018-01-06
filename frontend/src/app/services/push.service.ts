import {Injectable} from '@angular/core';
import {Headers, Http, Response} from "@angular/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs/Observable";

@Injectable()
export class PushService {

  private backendUrl: string = environment.backendUrl;

  constructor(private http: Http) {
  }

  authenticate(login?: string, password?: string): Observable<any> {
    let headers = new Headers();

    if (login && password) {
      headers = new Headers({
        'Authorization': `Basic ${btoa(`${login}:${password}`)}`,
        'Access-Control-Allow-Headers': '*',
        'Access-Control-Allow-Methods': '*',
        'Access-Control-Allow-Origin': '*'
      });
    }

    return this.http
      .get(`${this.backendUrl}/login`, {
        headers: headers,
        withCredentials: !!(login && password)
      })
      .map((response: Response) => response.json())
      .catch((error: any) => {
        if (error.status >= 400) {
          return Observable.throw(new Error(error.status));
        }
      });
  }


}
