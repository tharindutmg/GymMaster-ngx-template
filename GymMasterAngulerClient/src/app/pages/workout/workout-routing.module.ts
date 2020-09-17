import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkoutComponent } from './workout.component';
import { DallyWorkoutComponent } from './dally-workout/dally-workout.component';
import { AssignWorkoutComponent } from './assign-workout/assign-workout.component';

const routes: Routes = [{
  path: '',
    component: WorkoutComponent,
  children: [ {
    path: 'assign-workout',
    component: AssignWorkoutComponent,
  }, {
    path: 'dally-workout',
    component: DallyWorkoutComponent,
  }],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class WorkoutRoutingModule { }
