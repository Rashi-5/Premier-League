import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {PremierLeague} from "./premierLeague";
import {catchError} from "rxjs/operators";
import {throwError as observableThrowError, Observable} from "rxjs";
import {Matches} from "./matches";

@Injectable({
  providedIn: 'root'
})
export class LeagueServiceService {

  private _url: string = "http://localhost:9000/";
  private _dateUrl : string = "http://localhost:9000/searchDate";


  constructor(private http: HttpClient) { }

  sortByPoints(): Observable<PremierLeague[]>{
    return this.http.get<PremierLeague[]>(this._url + "sortedPointsList")
      .pipe(catchError(this.handleErrors));
  }

  sortByGoals(): Observable<PremierLeague[]>{
    return this.http.get<PremierLeague[]>(this._url + "sortedGoalsList")
      .pipe(catchError(this.handleErrors));
  }

  sortByWins(): Observable<PremierLeague[]>{
    return this.http.get<PremierLeague[]>(this._url + "sortedWinsList")
      .pipe(catchError(this.handleErrors));
  }

  getRandomMatch(): Observable<PremierLeague[]>{
    return this.http.get<PremierLeague[]>(this._url + "randomMatchList")
      .pipe(catchError(this.handleErrors));
  }

  getMatchDate(): Observable<Matches[]>{
    return this.http.get<Matches[]>(this._url + "matchHistory")
      .pipe(catchError(this.handleErrors));
  }

  findMatch(date : String): Observable<Matches[]>{
    return this.http.get<Matches[]>(this._dateUrl + "?date=" + date)
      .pipe(catchError(this.handleErrors));
  }

  handleErrors(errorRes: HttpErrorResponse){
    return observableThrowError(errorRes.message || "Server error Occurred!")
  }
}
