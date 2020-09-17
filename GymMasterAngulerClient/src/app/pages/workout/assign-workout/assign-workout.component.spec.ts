import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignWorkoutComponent } from './assign-workout.component';

describe('AssignWorkoutComponent', () => {
  let component: AssignWorkoutComponent;
  let fixture: ComponentFixture<AssignWorkoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AssignWorkoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignWorkoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
