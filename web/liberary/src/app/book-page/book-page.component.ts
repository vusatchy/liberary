import { Component, OnInit } from '@angular/core';

import { IBook } from '../shared/interfaces';
import { DataService } from '../core/data.service';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-book-page',
    templateUrl: './book-page.component.html' ,
    styleUrls: ["./book-page.component.css"]
})
export class BooksPageComponent implements OnInit {

    book: IBook;

    constructor(private dataService: DataService, 
        private route: ActivatedRoute) { }

    ngOnInit() {
        let id = + this.route.snapshot.paramMap.get('id');
        console.log(id)
        this.dataService.getBook(id)
            .subscribe((result: IBook) => 
            this.book = result);
        
    }
}