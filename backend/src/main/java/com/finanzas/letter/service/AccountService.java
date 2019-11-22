package com.finanzas.letter.service;

import com.finanzas.letter.model.Account;

public interface AccountService extends CrudService<Account>{
	Account findByUsername(String username);
	Account register(Account requestBody);
}
