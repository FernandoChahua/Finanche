import { Component, OnInit } from '@angular/core';
import { Letter } from 'src/app/model/letter';

@Component({
  selector: 'app-letters',
  templateUrl: './letters.component.html',
  styleUrls: ['./letters.component.scss']
})
export class LettersComponent implements OnInit {
  letters: Letter[] =[
    {
        "id": 1,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "D",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 1,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 1
            }
        ],
        "finalCosts": [
            {
                "id": 1,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 1
            }
        ]
    },
    {
        "id": 2,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "D",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 2,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 2
            }
        ],
        "finalCosts": [
            {
                "id": 2,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 2
            }
        ]
    },
    {
        "id": 3,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "S",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 3,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 3
            }
        ],
        "finalCosts": [
            {
                "id": 3,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 3
            }
        ]
    },
    {
        "id": 4,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "D",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 4,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 4
            }
        ],
        "finalCosts": [
            {
                "id": 4,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 4
            }
        ]
    },
    {
        "id": 5,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "D",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 5,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 5
            }
        ],
        "finalCosts": [
            {
                "id": 5,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 5
            }
        ]
    },
    {
        "id": 6,
        "nominalValue": 50000.0,
        "retention": 1000.0,
        "netWorth": 45418.46,
        "deliveredValue": 49300.0,
        "receivedValue": 39418.46,
        "discountValue": 4581.54,
        "tcea": 0.2483731,
        "discountRate": 0.0916308,
        "totalFinalCost": 300.0,
        "totalStartupCost": 5000.0,
        "expirationDate": new Date(),
        "typeOfCurrency": "S",
        "idPortfolio": 1,
        "startupCosts": [
            {
                "id": 6,
                "amountReason": 0.1,
                "reason": "Portes",
                "typeCost": "P",
                "idLetter": 6
            }
        ],
        "finalCosts": [
            {
                "id": 6,
                "amountReason": 300.0,
                "reason": "string",
                "typeCost": "string",
                "idLetter": 6
            }
        ]
    }
];
  constructor() { }
  displayedColumns: string[] = ['expirationDate', 'nominalValue', 'retention', 'discountRate','discountValue','totalStartupCost','totalFinalCost','netWorth','receivedValue','deliveredValue','tcea'];

  dataSource = this.letters;
  ngOnInit() {

  }
  type(tipo: string){
    if(tipo == "S"){
      return "S/. ";
    }
    return "$ ";
  }

}
