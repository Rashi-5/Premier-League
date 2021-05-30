import { Component, OnInit } from '@angular/core';
import { LeagueServiceService } from '../league-service.service';

@Component({
  selector: 'app-lague-table',
  templateUrl: './lague-table.component.html',
  styleUrls: ['./lague-table.component.css']
})
export class LagueTableComponent implements OnInit {

  pointSorted: any;

  constructor(private _leagueService: LeagueServiceService) { }

  ngOnInit() {
    this._leagueService.sortByPoints()
      .subscribe(points => this.pointSorted = points);
  }
}
