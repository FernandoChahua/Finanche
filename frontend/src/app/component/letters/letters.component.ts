import { Component, OnInit } from '@angular/core';
import { Letter } from 'src/app/model/letter';

@Component({
  selector: 'app-letters',
  templateUrl: './letters.component.html',
  styleUrls: ['./letters.component.scss']
})
export class LettersComponent implements OnInit {
  letters: Letter[];
  constructor() { }
  displayedColumns: string[] = ['expirationDate', 'nominalValue', 'retention', 'discountRate','discountValue','totalStartupCost','totalFinalCost','netWorth','receivedValue','deliveredValue','tcea'];

  dataSource = this.letters;
  ngOnInit() {

  }

}
