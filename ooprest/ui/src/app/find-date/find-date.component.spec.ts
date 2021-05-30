import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindDateComponent } from './find-date.component';

describe('FindDateComponent', () => {
  let component: FindDateComponent;
  let fixture: ComponentFixture<FindDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FindDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FindDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
