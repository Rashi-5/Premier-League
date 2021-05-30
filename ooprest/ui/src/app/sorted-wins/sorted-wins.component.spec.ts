import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SortedWinsComponent } from './sorted-wins.component';

describe('SortedWinsComponent', () => {
  let component: SortedWinsComponent;
  let fixture: ComponentFixture<SortedWinsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SortedWinsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SortedWinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
