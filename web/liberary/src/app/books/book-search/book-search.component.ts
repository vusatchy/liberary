import { Component, OnInit, Input } from '@angular/core';

import { IBook, IPageData } from '../../shared/interfaces';
import { Router } from '@angular/router';

@Component({
    selector: 'app-books-search',
    templateUrl: './book-search.component.html',
    styleUrls: ['./book-search.component.css']
})
export class BooksSearchComponent implements OnInit {

    constructor( private router: Router) {}

    onEnter(value: string) { 
        var params = {};
        params["q"] = value.length != 0 ?  value : '*';
        params["page"]  = 1;
        this.router.navigate(['/books'],  { queryParams: params });
     }


    ngOnInit() {

    }

}