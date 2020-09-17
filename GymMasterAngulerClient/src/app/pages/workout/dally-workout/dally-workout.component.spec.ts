import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DallyWorkoutComponent } from './dally-workout.component';

describe('DallyWorkoutComponent', () => {
  let component: DallyWorkoutComponent;
  let fixture: ComponentFixture<DallyWorkoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DallyWorkoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DallyWorkoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
