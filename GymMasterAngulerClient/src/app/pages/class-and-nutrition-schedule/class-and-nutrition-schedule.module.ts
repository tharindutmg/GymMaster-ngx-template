import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { ClassAndNutritionScheduleRoutingModule } from './class-and-nutrition-schedule-routing.module';
import { ClassAndNutritionScheduleComponent } from './class-and-nutrition-schedule.component';
import { NutritionScheduleComponent } from './nutrition-schedule/nutrition-schedule.component';
import { ClassScheduleComponent } from './class-schedule/class-schedule.component';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { NgbTimepicker, NgbModule } from '@ng-bootstrap/ng-bootstrap';

const components = [
  ClassAndNutritionScheduleComponent,
  ClassScheduleComponent,
  NutritionScheduleComponent,
];
/* const ENTRY_COMPONENTS = [
  ModalComponent,
];
 */
@NgModule({
  imports: [
    ThemeModule,
    ClassAndNutritionScheduleRoutingModule,
    Ng2SmartTableModule,
    NgMultiSelectDropDownModule.forRoot(),
  ],
  declarations: [
    ...components,
  ],
  /* entryComponents: [
    ...ENTRY_COMPONENTS,
  ], */
})
export class ClassAndNutritionScheduleModel { }