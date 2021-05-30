import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortedGoalsComponent } from './sorted-goals.component';

describe('SortedGoalsComponent', () => {
  let component: SortedGoalsComponent;
  let fixture: ComponentFixture<SortedGoalsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortedGoalsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortedGoalsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
