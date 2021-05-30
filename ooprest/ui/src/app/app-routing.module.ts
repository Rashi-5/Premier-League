import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LagueTableComponent } from './lague-table/lague-table.component';
import { MatchHistoryComponent } from './match-history/match-history.component';
import {SortedGoalsComponent} from "./sorted-goals/sorted-goals.component";
import {SortedWinsComponent} from "./sorted-wins/sorted-wins.component";
import {RandomMatchComponent} from "./random-match/random-match.component";
import {FindDateComponent} from "./find-date/find-date.component";
import {HomePageComponent} from "./home-page/home-page.component";

const routes: Routes = [
  {path:'leagueTable', component: LagueTableComponent},
  {path:'matchHistory', component: MatchHistoryComponent},
  {path:'sortedGoals', component: SortedGoalsComponent },
  {path:'sortedWins', component: SortedWinsComponent },
  {path:'randomMatch', component: RandomMatchComponent },
  {path:'findDate', component: FindDateComponent},
  {path:'homePage', component: HomePageComponent},
  {path:'', redirectTo: '/homePage', pathMatch: 'prefix'}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const routingComponents = [LagueTableComponent,
  MatchHistoryComponent,
  SortedGoalsComponent,
  SortedWinsComponent,
  RandomMatchComponent,
  FindDateComponent,
  HomePageComponent
];
