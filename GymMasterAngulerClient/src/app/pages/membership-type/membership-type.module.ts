import { NgModule } from '@angular/core';


import { ThemeModule } from '../../@theme/theme.module';
import { MembershipTypeComponent } from './membership-type.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SmartTableModule } from 'ng2-smart-table';

@NgModule({
  imports: [
    ThemeModule,
    Ng2SmartTableModule,
    Ng2SearchPipeModule, //including into imports
    Ng2OrderModule //add here
  ],
  declarations: [
    MembershipTypeComponent,
  ],
})
export class MembershipTypeModule { }