import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountentComponent } from './accountent.component';

describe('AccountentComponent', () => {
  let component: AccountentComponent;
  let fixture: ComponentFixture<AccountentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
