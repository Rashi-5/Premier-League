import { Component, OnInit } from '@angular/core';
import {LeagueServiceService} from "../league-service.service";

@Component({
  selector: 'app-sorted-wins',
  templateUrl: './sorted-wins.component.html',
  styleUrls: ['./sorted-wins.component.css']
})
export class SortedWinsComponent implements OnInit {

  winsSorted: any;

  constructor(private _leagueService: LeagueServiceService) { }

  ngOnInit() {
    this._leagueService.sortByWins()
      .subscribe(wins => this.winsSorted = wins);
  }

}
