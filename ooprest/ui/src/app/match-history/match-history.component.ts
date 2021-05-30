import { Component, OnInit } from '@angular/core';
import {LeagueServiceService} from "../league-service.service";

@Component({
  selector: 'app-match-history',
  templateUrl: './match-history.component.html',
  styleUrls: ['./match-history.component.css']
})
export class MatchHistoryComponent implements OnInit {

  matchArray: any;

  constructor(private _matchHistoryService : LeagueServiceService) { }

  ngOnInit(){
    this._matchHistoryService.getMatchDate()
      .subscribe(match => this.matchArray = match);
  }

}
