import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {TemplateModule} from './template/template.module';
import { HomeComponent } from './home/home.component'
import { ClientesModule } from './clientes/clientes.module';
import{ClientesServiceService} from './clientes-service.service';
import { ClientesListaComponent } from './clientes-app/clientes-lista/clientes-lista.component'
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ClientesListaComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    TemplateModule,
    ClientesModule
  ],
  providers: [
    ClientesServiceService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
