import { NgModule }      from '@angular/core';
import { FormsModule }      from '@angular/forms';
import { CommonModule } from '@angular/common';

import { SharedModule } from '../shared/shared.module';
import { BooksPageComponent } from './book-page.component';
import { BooksPageRoutingModule } from './book-page-routing.module';

@NgModule({
  imports:      [ CommonModule, SharedModule , FormsModule, BooksPageRoutingModule ],
  declarations: [ BooksPageComponent   ],
  exports: [ BooksPageComponent ]
})
export class BooksPageModule { }