import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {API_ROUTES} from './api-routes';

const ENDPOINT = API_ROUTES;

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http: HttpClient) { }
}
