import { Injectable } from '@angular/core';
import {HttpClient ,HttpHeaders} from '@angular/common/http';
import {API_ROUTES} from './api-routes';
import { OauthService } from './oauth.service';
import { Letter } from '../model/letter';
import { catchError, map } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { User } from '../model/user';
import { FinalReason } from '../model/final-reason';
import { StartupReason } from '../model/startup-reason';
import { Portfolio } from '../model/portfolio';
const ENDPOINT = API_ROUTES;

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private authService: OauthService) { }

  private addAuthorizationHeader() {
    const token = this.authService.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  private unAthorized(e): boolean {
    if (e.status == 401) {
      if (this.authService.isAuthenticated) {
        this.authService.logout();
      }

     // this.router.navigate(['/login']);
      return true;
    }
    return false;
  }
  postLetter(letter: Letter) {
    return this.http.post(ENDPOINT.letter.POST_LETTER, letter)
      .pipe(
        map((response: any) => response as Letter),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }

  putLetter(letter: Letter){
    return this.http.put(ENDPOINT.letter.PUT_LETTER,letter)
      .pipe(
        map((response: any) => response as Letter),
        catchError(e=>{
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
  deleteLetter(id: number){
    return this.http.delete(ENDPOINT.letter.DELETE_LETTER+id)
      .pipe(
        map((response: any) => response as Letter),
        catchError(e=>{
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
  registerUser(user: User){
    return this.http.post(ENDPOINT.account.REGISTER_USER,user)
      .pipe(
        map((response: any) => response as User),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
  getFinalReasons(){
    return this.http.get<FinalReason[]>(ENDPOINT.finalReason.GET_FINAL_REASON);
  }
  postFinalReason(finalReason: FinalReason){
    return this.http.post(ENDPOINT.finalReason.POST_FINAL_REASON,finalReason)
      .pipe(
        map((response: any) => response as FinalReason),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
  getStartupReasons(): Observable<StartupReason[]> {
    return this.http.get<StartupReason[]>(ENDPOINT.startUpReason.GET_STARTUP_REASON);
  }

  postStartupReason(startupReason: StartupReason){
    return this.http.post(ENDPOINT.startUpReason.POST_STARTUP_REASON, startupReason)
      .pipe(
        map((response: any) => response as StartupReason),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
  getPortafoliosOfUser(){
    let id = this.authService.idUser;
    return this.http.get<Portfolio[]>(ENDPOINT.portfolio.GET_PORTFOLIOS_USER+id);
  }
  postPortfolio(portfolio: Portfolio){
    return this.http.post(ENDPOINT.portfolio.POST_PORTFOLIO,portfolio)
      .pipe(
        map((response: any) => response as Portfolio),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          // swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }


}
