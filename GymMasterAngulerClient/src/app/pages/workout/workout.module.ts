import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { WorkoutComponent } from './workout.component';
import { WorkoutRoutingModule } from './workout-routing.module';
import { AssignWorkoutComponent } from './assign-workout/assign-workout.component';
import { DallyWorkoutComponent } from './dally-workout/dally-workout.component';

const components = [
    WorkoutComponent,
    AssignWorkoutComponent,
    DallyWorkoutComponent,
];

@NgModule({
  imports: [
    ThemeModule,
    WorkoutRoutingModule,
  ],
  declarations: [
    ...components,
  ],
})
export class WorkoutModule { }