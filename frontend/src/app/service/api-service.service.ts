import { Injectable } from '@angular/core';
import {HttpClient ,HttpHeaders} from '@angular/common/http';
import {API_ROUTES} from './api-routes';
import { OauthService } from './oauth.service';
import { Letter } from '../model/letter';
import { catchError, map } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
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
}
