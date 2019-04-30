import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksPageComponent } from './book-page.component';

const routes: Routes = [
    { path: 'book/:id', component: BooksPageComponent }
];

@NgModule({
    imports: [ RouterModule.forChild(routes) ], 
    exports: [ RouterModule ]
})
export class BooksPageRoutingModule {

}