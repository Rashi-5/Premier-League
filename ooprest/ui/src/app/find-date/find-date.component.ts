import { Component, OnInit } from '@angular/core';
import {LeagueServiceService} from "../league-service.service";

@Component({
  selector: 'app-find-date',
  templateUrl: './find-date.component.html',
  styleUrls: ['./find-date.component.css']
})
export class FindDateComponent implements OnInit {

  matchByDate: any;
  public date = "";

  constructor(private _matchHistoryService : LeagueServiceService) { }

  ngOnInit()  {
  }

  findMatchByDate(inputDate: string) {
      this.date = inputDate;
      this._matchHistoryService.findMatch(this.date)
      .subscribe(matchDate => this.matchByDate = matchDate);
  }
}
