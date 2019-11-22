import { StartupCost } from './startup-cost';
import { FinalCost } from './final-cost';

export class Letter {
    id: number;
    nominalValue: number;
    retention: number;
    netWorth: number;
    deliveredValue: number;
    receivedValue: number;
    discountValue: number;
    tcea: number;
    discountRate: number;
    totalFinalCost: number;
    totalStartupCost: number;
    expirationDate: string;
    typeOfCurrency: string;
    idPortfolio: number;
    startupCosts: StartupCost[];
    finalCosts: FinalCost[];
  }
