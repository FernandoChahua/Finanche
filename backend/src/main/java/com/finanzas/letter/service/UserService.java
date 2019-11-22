package com.finanzas.letter.service;

import java.util.List;

import com.finanzas.letter.model.Account;

public interface UserService {
	Account findByUsername(String username);
}
