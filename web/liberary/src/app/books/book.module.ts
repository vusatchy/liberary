import { NgModule }      from '@angular/core';
import { FormsModule }      from '@angular/forms';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { BooksComponent } from './book.component';
import { BooksListComponent } from './books-list/books-list.component';

@NgModule({
  imports:      [ CommonModule, SharedModule , FormsModule ],
  declarations: [ BooksComponent , BooksListComponent ],
  exports: [ BooksComponent, BooksListComponent ]
})
export class BooksModule { }