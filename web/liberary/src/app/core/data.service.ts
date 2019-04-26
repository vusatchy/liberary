import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


import { map, catchError } from 'rxjs/operators';

import { IBook } from '../../app/shared/interfaces';
import { Observable } from 'rxjs';

@Injectable()
export class DataService {
 
    baseUrl: string = 'http://localhost:8090/';
    
    constructor(private http: HttpClient) { }

    getBooks(q: string, page: number) : Observable<any[]> {
        let url = this.baseUrl + 'books?page=' + page;
        if(q) {
            url += '&q=' + q;
        } 
        return this.http.get<any[]>(url)
            .pipe(catchError(this.handleError));
    }

    getBook(id: number) : Observable<IBook> {
        return this.http.get<IBook>(this.baseUrl + 'book/' + id)
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