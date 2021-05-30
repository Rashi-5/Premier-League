import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeagueServiceService } from './league-service.service';
import { HttpClientModule } from "@angular/common/http";


@NgModule({
  declarations: [AppComponent, routingComponents],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LeagueServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }

