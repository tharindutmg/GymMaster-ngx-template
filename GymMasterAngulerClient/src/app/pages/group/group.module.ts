import { NgModule } from '@angular/core';


import { ThemeModule } from '../../@theme/theme.module';
import { Ng2SearchPipeModule } from 'ng2-search-filter'; //importing the module
import { Ng2OrderModule } from 'ng2-order-pipe';
import { GroupComponent } from './group.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';

/* const ENTRY_COMPONENTS = [
  GroupModalComponent,
]; */
@NgModule({
  imports: [
    ThemeModule,
    Ng2SearchPipeModule, //including into imports
    Ng2OrderModule, //add here
    Ng2SmartTableModule,
  ],
  declarations: [
    GroupComponent,
  ],
  /* entryComponents: [
    ...ENTRY_COMPONENTS,
  ], */
})
export class GroupModule { }