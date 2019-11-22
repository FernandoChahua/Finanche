import { Component, OnInit } from '@angular/core';
import { Portfolio } from 'src/app/model/portfolio';
import { ApiServiceService } from 'src/app/service/api-service.service';
import { Router } from '@angular/router';
import { prototype } from 'events';

@Component({
  selector: 'app-portfolios',
  templateUrl: './portfolios.component.html',
  styleUrls: ['./portfolios.component.scss']
})
export class PortfoliosComponent implements OnInit {
  portfolios: Portfolio[];
  constructor(private apiService: ApiServiceService,
    private router: Router) { }
  displayedColumns: string[] = ['name', 'totalRecieved', 'typeMoney'];
  dataSource = this.portfolios;
  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.apiService.getPortafoliosOfUser().subscribe(portfolios => this.dataSource = portfolios);
  }
  type(tipo: string){
    if(tipo == "S"){
      return "S/. ";
    }
    return "$ ";
  }
  name(tipo: string){
    if(tipo == "S"){
      return "Soles";
    }
    return "Dolares";
  }
}
