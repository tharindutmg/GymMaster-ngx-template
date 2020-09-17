import { NgModule } from '@angular/core';


import { ThemeModule } from '../../@theme/theme.module';
import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe';
import { ReportComponent } from './report.component';

@NgModule({
  imports: [
    ThemeModule,
    Ng2SearchPipeModule, //including into imports
    Ng2OrderModule //add here
  ],
  declarations: [
    ReportComponent,
  ],
})
export class ReportModule { }