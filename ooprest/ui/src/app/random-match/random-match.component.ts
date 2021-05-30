import { Component, OnInit } from '@angular/core';
import {LeagueServiceService} from "../league-service.service";

@Component({
  selector: 'app-random-match',
  templateUrl: './random-match.component.html',
  styleUrls: ['./random-match.component.css']
})
export class RandomMatchComponent implements OnInit {

  randomMatch: any;

  constructor(private _leagueService: LeagueServiceService) { }

  ngOnInit() {

  }
  generateRandomMatch(){
    this._leagueService.getRandomMatch()
      .subscribe(random => this.randomMatch = random);
  }
}
