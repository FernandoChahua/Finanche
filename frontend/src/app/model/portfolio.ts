import { Letter } from './letter';

export class Portfolio {
    id: number;
    name: string;
    discountDate: string;
    daysPerYear: number;
    tea: number;
    tceaPortfolio: number;
    totalReceive: number;
    typeOfCurrency: string;
    exchangeRate: number;
    letters: Letter[];
    idUser: number;
  }
