package com.peru21.apirest.configs.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.peru21.apirest.entities.Users;
import com.peru21.apirest.services.IUserService;

@Component
public class TokenInfo implements TokenEnhancer {

	@Autowired
	private IUserService userService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Users users = userService.findByUsername(authentication.getName());

		System.out.println(authentication.getName());
		Map<String, Object> info = new HashMap<>();
		info.put("ADITIONAL_INFO", authentication.getName());
		info.put("USER_NAME", users.getUserName());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		return accessToken;
	}

}
