import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core/core.module';
import { BooksModule } from './books/book.module';
import { BooksPageModule } from './book-page/book-page.module';
import { LoginModule } from './login/login.module';
import { RegistrationModule } from './registration/registration.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    CoreModule,
    BooksModule,
    BooksPageModule,
    LoginModule,
    RegistrationModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
