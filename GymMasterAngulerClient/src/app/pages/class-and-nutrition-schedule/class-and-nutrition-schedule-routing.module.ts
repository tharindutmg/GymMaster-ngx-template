import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClassAndNutritionScheduleComponent } from './class-and-nutrition-schedule.component';
import { ClassScheduleComponent } from './class-schedule/class-schedule.component';
import { NutritionScheduleComponent } from './nutrition-schedule/nutrition-schedule.component';

const routes: Routes = [{
  path: '',
  component: ClassAndNutritionScheduleComponent,
  children: [ {
    path: 'class-schedule',
    component: ClassScheduleComponent,
  }, {
    path: 'nutrition-schedule',
    component: NutritionScheduleComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ClassAndNutritionScheduleRoutingModule { }
