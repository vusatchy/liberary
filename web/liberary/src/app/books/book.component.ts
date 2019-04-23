import { Component, OnInit } from '@angular/core';

import { IBook } from '../shared/interfaces';
import { DataService } from '../core/data.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html'
})
export class BooksComponent implements OnInit {

    books: IBook[];
    
    constructor(private dataService: DataService) {}
    
    ngOnInit() {
        this.dataService.getBooks()
            .subscribe((result: any) => 
            this.books = result["content"]);
        
    }
}