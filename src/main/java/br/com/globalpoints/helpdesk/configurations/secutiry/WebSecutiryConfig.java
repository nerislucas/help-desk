package br.com.globalpoints.helpdesk.configurations.secutiry;

import br.com.globalpoints.helpdesk.business.enums.ProfileEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.globalpoints.helpdesk.configurations.secutiry.providers.JwtTokenProvider;

@Configuration
@EnableWebSecurity
public class WebSecutiryConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/healthy/ping").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login/authenticate").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                .addFilterBefore(new AuthenticationTokenExtractor(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // create default account
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("password")
                .roles(ProfileEnum.ADMIN.getProfile());
    }
}
