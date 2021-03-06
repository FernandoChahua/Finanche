import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LayoutComponent } from './component/layout/layout.component';
import { AppMaterialModule } from './module/app-material.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { IConfig, NgxMaskModule } from 'ngx-mask';
import {FlexLayoutModule} from '@angular/flex-layout';
import { HomeComponent } from './component/home/home.component';
import { DataComponent } from './component/data/data.component';
import { LoginComponent } from './component/auth/login/login.component';
import { RegisterComponent } from './component/auth/register/register.component';
import { LettersComponent } from './component/letters/letters.component';
import { PortfoliosComponent } from './component/portfolios/portfolios.component';
import { PortfolioComponent } from './component/portfolio/portfolio.component';

export let maskOptions: Partial<IConfig> | (() => Partial<IConfig>);

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    HomeComponent,
    DataComponent,
    LoginComponent,
    RegisterComponent,
    LettersComponent,
    PortfoliosComponent,
    PortfolioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    NgxMaskModule.forRoot(maskOptions)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
