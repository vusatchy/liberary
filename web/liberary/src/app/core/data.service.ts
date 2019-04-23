import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { map, catchError } from 'rxjs/operators';

import { IBook } from '../../app/shared/interfaces';
import { Observable } from 'rxjs';

@Injectable()
export class DataService {

    baseUrl: string = 'http://localhost:8090/';
    
    constructor(private http: HttpClient) { }

    getBooks() : Observable<any[]> {
        return this.http.get<any[]>(this.baseUrl + 'books')
            .pipe(
                catchError(this.handleError)
            );
    }

    private handleError(error: any) {
      console.error('server error:', error);
      if (error.error instanceof Error) {
          const errMessage = error.error.message;
          return Observable.throw(errMessage);
          // Use the following instead if using lite-server
          // return Observable.throw(err.text() || 'backend server error');
      }
      return Observable.throw(error || 'Node.js server error');
    }

}