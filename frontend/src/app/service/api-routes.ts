import {Endpoint} from '../model/endpoint';
const BASE_URL = 'http://localhost:9001';

export const API_ROUTES: Endpoint = {
  account: {
    REGISTER_USER: `${BASE_URL}/users`,
    GET_BY_USERNAME: `${BASE_URL}/users/getByUsername`,
    GET_BY_ID: `${BASE_URL}/users/`,
  },
  finalReason: {
    GET_FINALREASON: `${BASE_URL}/finalReason`,
    POST_FINALREASON: `${BASE_URL}/finalReason`,
    GET_BY_ID: `${BASE_URL}/finalReason/`,
  },
  letter: {
    POST_LETTER: `${BASE_URL}/letter`,
    PUT_LETTER: `${BASE_URL}/letter`,
    DELETE_LETTER:`${BASE_URL}/letter/`,
  },
  portfolio: {
    GET_PORTFOLIOS_USER: `${BASE_URL}/portfolios/user/`,
    GET_BY_ID_PORTFOLIO: `${BASE_URL}/portfolios/`,
    POST_PORTFOLIO: `${BASE_URL}/portfolios`,
  },
  startUpReason: {
    GET_STARTUPREASON: `${BASE_URL}/startupReason`,
    POST_STARTUPREASON: `${BASE_URL}/startupReason`,
    GET_BY_ID: `${BASE_URL}/startupReason/`,
  }
}

