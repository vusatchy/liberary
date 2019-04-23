import { Component, OnInit, Input } from '@angular/core';

import { IBook } from '../../shared/interfaces';

@Component({
    selector: 'app-books-list',
    templateUrl: './books-list.component.html',
    styleUrls: ['./books-list.component.css']
})
export class BooksListComponent implements OnInit {
    private _books: IBook[] = [];
    @Input() get books(): IBook[] {
        return this._books;
    }
    
    set books(value: IBook[]) {
        if (value) {
            this._books = value;
        }
    }

    ngOnInit() {

    }

}