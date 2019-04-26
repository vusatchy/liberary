import { NgModule }      from '@angular/core';
import { FormsModule }      from '@angular/forms';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { BooksComponent } from './book.component';
import { BooksListComponent } from './books-list/books-list.component';
import { BooksRoutingModule } from './books-routing.module';
import { BooksPageComponent } from '../book-page/book-page.component';
import { BooksPaginationComponent } from './book-pagination/books-pagination.component';
import { BooksSearchComponent } from './book-search/book-search.component';

@NgModule({
  imports:      [ CommonModule, SharedModule , FormsModule, BooksRoutingModule ],
  declarations: [ BooksComponent , BooksListComponent, BooksPaginationComponent, BooksSearchComponent ],
  exports: [ BooksComponent, BooksListComponent, BooksPaginationComponent, BooksSearchComponent ]
})
export class BooksModule { }