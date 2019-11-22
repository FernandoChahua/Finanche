export interface Endpoint {
  account: {
    REGISTER_USER: string;
    GET_BY_USERNAME: string;
    GET_BY_ID: string;
  };
  finalReason: {
    GET_FINAL_REASON: string;
    POST_FINAL_REASON: string;
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
    GET_STARTUP_REASON: string;
    POST_STARTUP_REASON: string;
    GET_BY_ID: string;
  };
}
