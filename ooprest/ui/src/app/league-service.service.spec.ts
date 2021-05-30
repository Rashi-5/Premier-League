import { TestBed } from '@angular/core/testing';

import { LeagueServiceService } from './league-service.service';

describe('LeagueServiceService', () => {
  let service: LeagueServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LeagueServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
