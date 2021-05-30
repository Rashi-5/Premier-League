import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LagueTableComponent } from './lague-table.component';

describe('LagueTableComponent', () => {
  let component: LagueTableComponent;
  let fixture: ComponentFixture<LagueTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LagueTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LagueTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
