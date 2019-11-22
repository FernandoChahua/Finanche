import {AfterViewInit, Component, Input, OnInit} from '@angular/core';
import {Letter} from '../../model/letter';
import {StartupReason} from '../../model/startup-reason';
import {FinalReason} from '../../model/final-reason';
import {ApiServiceService} from '../../service/api-service.service';
import {StartupCost} from '../../model/startup-cost';
import {FinalCost} from '../../model/final-cost';
import {Portfolio} from '../../model/portfolio';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {

  letter: Letter;
  @Input() portfolio: Portfolio;

  startUPCost: StartupCost = new StartupCost();
  finalCost: FinalCost = new FinalCost();


  // orphans
  daysPerYear: number;
  typeOfCurrency: number;
  discountDate: Date = new Date();
  termLength: number;
  tea: number;

  daysPerYearOptions = [ 360, 365 ];
  currency = {
    S: 'Soles',
    D: 'Dolares'
  };
  terms: {} = {
    1: 'Diario',
    15: 'Quincenal',
    30: 'Mensual'
  };
  costType: {
    E: 'Efectivo',
    P: 'Porcentaje'
  };

  reasonsStart: StartupReason[] = [];
  reasonEnd: FinalReason[] = [];



  constructor(private apiService: ApiServiceService) { }

  createNew() {
    if (this.letter == null) {
      this.letter = new Letter();
      this.letter.expirationDate = new Date();
      this.reasonEnd = [];
      this.reasonsStart = [];
    }
  }

  post() {
    this.apiService.postLetter(this.letter);
  }

  addFinalCost() {
    this.letter.finalCosts.push(this.finalCost);
    this.finalCost = new FinalCost();
  }

  addStartUpCost() {
    this.letter.startupCosts.push(this.startUPCost);
    this.startUPCost = new StartupCost();
  }

  ngOnInit() {
    this.createNew();
    this.loadStartReasons();
    this.loadFinalReasons();
  }

  postLetter() {
    
  }

  loadStartReasons() {
    this.apiService.getStartupReasons().subscribe(res => {
      this.reasonsStart = res;
      console.log(res, 'EXITO');
    }, err => {
      console.log(err, 'ERROR');
    });
  }

  loadFinalReasons() {
    this.apiService.getFinalReasons().subscribe(res => {
      this.reasonEnd = res;
      console.log(res, 'EXITO');
    }, err => {
      console.log(err, 'ERROR');
    });
  }



}
