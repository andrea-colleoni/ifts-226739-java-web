import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { SalutiComponent } from './saluti/saluti.component';
import { ElencoLibriComponent } from './elenco-libri/elenco-libri.component';

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    SalutiComponent,
    ElencoLibriComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
