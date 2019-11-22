import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Letter} from '../../model/letter';
import {StartupReason} from '../../model/startup-reason';
import {FinalReason} from '../../model/final-reason';
import {ApiServiceService} from '../../service/api-service.service';
import {StartupCost} from '../../model/startup-cost';
import {FinalCost} from '../../model/final-cost';
import {Portfolio} from '../../model/portfolio';
import {Convertidor} from '../../model/converter-tasa';
import * as moment from 'moment';
import {OauthService} from '../../service/oauth.service';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {

  letter: Letter;
  portfolio: Portfolio;
  fixedRate: number;

  termLength: number;
  capitalization: number;


  get fixedPortfolio(): boolean {
    return this.portfolio.id != null;
  }

  startUPCost: StartupCost = new StartupCost();
  finalCost: FinalCost = new FinalCost();


  // orphans
  daysPerYear: number;
  typeOfCurrency: number;
  discountDate: Date = new Date();
  expirationDate: Date = new Date();

  rate: number;

  nominalRate: boolean;
  daysPerYearOptions = [360, 365];
  currency = {
    S: 'Soles',
    D: 'Dolares'
  };
  terms = {
    Diario: 1,
    Quincenal: 15,
    Mensual: 30,
    Semestral: 180
  };
  costType = {
    E: 'Efectivo',
    P: 'Porcentaje'
  };

  reasonsStart: StartupReason[] = [];
  reasonEnd: FinalReason[] = [];

  constructor(private apiService: ApiServiceService, private authService: OauthService) {
  }

  cleanPortfolio() {
    this.portfolio = new Portfolio();
    this.portfolio.exchangeRate = 3.39;
    this.portfolio.letters = [];
    this.discountDate = new Date();

  }

  cleanLetter() {
    this.letter = new Letter();
    this.letter.idPortfolio = this.portfolio == null ? undefined : this.portfolio.id;
    this.letter.finalCosts = [];
    this.letter.startupCosts = [];
    this.expirationDate = new Date();

    this.loadStartReasons();
    this.loadFinalReasons();
  }

  postPortfolio() {
    this.convertRates();
    this.portfolio.tea = this.fixedRate;
    this.portfolio.discountDate = moment(this.discountDate).format('YYYY-MM-DD');
    this.portfolio.idUser = this.authService.idUser;

    this.apiService.postPortfolio(this.portfolio).subscribe(res => {
      this.portfolio.id = res.id;
      console.log(res);
    }, err => console.log(err));
  }

  postLetter() {
    if (this.portfolio.id == null) {
      return;
    }
    if (this.letter.idPortfolio == null) {
      this.letter.idPortfolio = this.portfolio.id;
    }
    this.letter.expirationDate = moment(this.expirationDate).format('YYYY-MM-DD');

    this.apiService.postLetter(this.letter).subscribe(res => {
      console.log(res);
    }, err => {
      console.log(err);
    });
  }

  convertRates() {
    const conv = new Convertidor();
    switch (this.nominalRate) {
      case true:
        this.fixedRate = conv.tasaNominalATasaEfectiva(this.rate / 100, this.termLength, this.capitalization, this.portfolio.daysPerYear);
        break;
      case false:
        this.fixedRate = conv.tasaEfectivaATasaEfectiva(this.rate / 100, this.termLength, this.portfolio.daysPerYear);
        break;
    }
  }

  removeFinalCost(cost: FinalCost) {
    const index = this.letter.finalCosts.indexOf(cost);
    if (index >= 0) {
      this.letter.finalCosts.splice(index, 1);
    }
  }

  addFinalCost() {
    this.letter.finalCosts.push(this.finalCost);
    this.finalCost = new FinalCost();
  }

  removeStartUpCost(cost: StartupCost) {
    const index = this.letter.startupCosts.indexOf(cost);
    if (index >= 0) {
      this.letter.startupCosts.splice(index, 1);
    }
  }

  addStartUpCost() {
    this.letter.startupCosts.push(this.startUPCost);
    this.startUPCost = new StartupCost();
  }

  ngOnInit() {
    this.cleanPortfolio();
    this.cleanLetter();
  }

  loadStartReasons() {
    this.apiService.getStartupReasons().subscribe(res => {
      this.reasonsStart = res;
      console.log('EXITO');
    }, err => {
      console.log(err, 'ERROR');
    });
  }

  loadFinalReasons() {
    this.apiService.getFinalReasons().subscribe(res => {
      this.reasonEnd = res;
      console.log('EXITO');
    }, err => {
      console.log(err, 'ERROR');
    });
  }


}
