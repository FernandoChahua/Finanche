export class Convertidor {
    tasaEfectivaATasaEfectiva(tep: number, plazo: number, diasPerYear: number) {
        return (1 + tep) ** (diasPerYear / plazo) - 1;
    }
    tasaNominalATasaEfectiva(tnp: number, plazo: number, capitalizacion: number, diasPerYear: number) {
        const tep = (1 + tnp / (plazo / capitalizacion)) ** (plazo / capitalizacion) - 1;
        return (1 + tep) ^ (diasPerYear / (plazo / capitalizacion)) - 1;
    }
}
