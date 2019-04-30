import { NgModule }      from '@angular/core';
import { FormsModule }      from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RegistrationRoutingModule } from './registration-routing.module';
import { RegistrationComponent } from './registration.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  imports:      [ CommonModule, SharedModule , FormsModule, RegistrationRoutingModule ],
  declarations: [ RegistrationComponent ],
  exports: [ RegistrationComponent ]
})
export class RegistrationModule { }