import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';


import { map, catchError } from 'rxjs/operators';

import { IBook } from '../../app/shared/interfaces';
import { Observable } from 'rxjs';
import { SessionStorageService } from 'angular-web-storage';
import { Router } from '@angular/router';

@Injectable()
export class DataService {
 
    baseUrl: string = 'http://localhost:8090/';
    
    constructor(public session: SessionStorageService, private http: HttpClient, public router: Router) { }

    getBooks(q: string, page: number) : Observable<any[]> {
        let url = this.baseUrl + 'books?page=' + page;
        if(q) {
            url += '&q=' + q;
        } 
        const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(this.session.get("login") + ":" + this.session.get("password"))});
        return this.http.get<any[]>(url, {headers})
            .pipe(catchError((error: HttpErrorResponse) => {
                return this.handleError(error, this.router) ;
            }));
    }

    getBook(id: number) : Observable<IBook> {
        const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(this.session.get("login") + ":" + this.session.get("password"))});
        return this.http.get<IBook>(this.baseUrl + 'book/' + id, {headers})
        .pipe(catchError((error: HttpErrorResponse) => {
            return this.handleError(error, this.router) ;
        }));
    }

    handleError(error: any, router: Router) {
      console.error('server error:', error);
      if (error.status == 401) {
          console.log(router);
          router.navigate(['/login']);
      }
      else if (error.error instanceof Error) {
          const errMessage = error.error.message;
          return Observable.throw(errMessage);
      }
      return Observable.throw(error || 'Node.js server error');
    }

}