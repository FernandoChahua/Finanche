export interface Endpoint {
  account: {
    REGISTER_USER: string;
    GET_BY_USERNAME: string;
    GET_BY_ID: string;
  };
  finalReason: {
    GET_FINALREASON: string;
    POST_FINALREASON: string;
    GET_BY_ID: string;
  };
  letter: {
    POST_LETTER: string;
    PUT_LETTER: string;
    DELETE_LETTER: string;
  };
  portfolio: {
    GET_PORTFOLIOS_USER: string;
    GET_BY_ID_PORTFOLIO: string;
    POST_PORTFOLIO: string;

  };
  startUpReason: {
    GET_STARTUPREASON: string;
    POST_STARTUPREASON: string;
    GET_BY_ID: string;
  };
}
