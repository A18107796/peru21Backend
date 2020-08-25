package com.peru21.apirest.configs.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import org.springframework.security.authentication.AuthenticationManager;

@Configuration
@EnableAuthorizationServer
public class Peru21AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired()
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenInfo tokeninfo;

	// PERMISOS DE NUESTRAS RUTAS DE ACCESO: 1 PARA INICIAR SESIÓN(GENERA TOKEN,
	// PUBLICA)
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// generar TOKEN
		security.tokenKeyAccess("permitAll()")
				// VALIDAR TOKEN
				.checkTokenAccess("isAuthenticated()");
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("angularapp").secret(passwordEncoder.encode("12345")).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(1600)
				.refreshTokenValiditySeconds(1600);
	}

	// SE ENCARGA DE TODO EL PROCESOD DE AUTENTICACIÓN, SI TODO SALE BIEN GENERA EL
	// TOKEN.
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
		enhancerChain.setTokenEnhancers(Arrays.asList(tokeninfo, accessTokenConverter()));
		
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				// AccesTokenCoverter: Encargado de manejar cosas relacionadas al
				// TOKEN(Almacenar datos de authenticación, username, roles) en
				// general se encarga de traducir datos del token.
				.accessTokenConverter(accessTokenConverter()).tokenEnhancer(enhancerChain);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter.setSigningKey(JWTConfig.RSA_PRIVATE);
		accessTokenConverter.setVerifierKey(JWTConfig.RSA_PUBLIC);
		return accessTokenConverter;
	}

}
