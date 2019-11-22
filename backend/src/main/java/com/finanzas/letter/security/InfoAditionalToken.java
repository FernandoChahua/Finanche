package com.finanzas.letter.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.finanzas.letter.model.Account;
import com.finanzas.letter.service.AccountService;


@Component
public class InfoAditionalToken  implements TokenEnhancer{


	@Autowired
	private AccountService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		Account user = userService.findByUsername(authentication.getName());

		// ingrese cualquier atributo mas para mostrar en el token
		info.put("id", user.getId());
		info.put("email",user.getEmail());
		info.put("username", user.getUsername());
		info.put("firstName",user.getFirstName());
		info.put("lastName",user.getLastName());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
