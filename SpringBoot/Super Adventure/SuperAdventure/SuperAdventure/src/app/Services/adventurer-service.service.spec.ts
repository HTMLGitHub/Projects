import { TestBed } from '@angular/core/testing';

import { AdventurerServiceService } from './adventurer-service.service';

describe('AdventurerServiceService', () => {
  let service: AdventurerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdventurerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
