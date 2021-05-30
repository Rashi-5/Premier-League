import { Component, OnInit } from '@angular/core';
import {LeagueServiceService} from "../league-service.service";

@Component({
  selector: 'app-sorted-goals',
  templateUrl: './sorted-goals.component.html',
  styleUrls: ['./sorted-goals.component.css']
})
export class SortedGoalsComponent implements OnInit {

  goalSorted: any;

  constructor(private _leagueService: LeagueServiceService) { }

  ngOnInit() {
    this._leagueService.sortByGoals()
      .subscribe(goals => this.goalSorted = goals);
  }
}
