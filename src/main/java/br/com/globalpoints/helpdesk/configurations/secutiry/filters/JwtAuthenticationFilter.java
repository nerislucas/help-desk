package br.com.globalpoints.helpdesk.configurations.secutiry.filters;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.globalpoints.helpdesk.business.users.models.AuthUser;
import br.com.globalpoints.helpdesk.business.users.models.AuthenticatedUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.globalpoints.helpdesk.configurations.secutiry.providers.JwtTokenProvider;


public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private JwtTokenProvider jwtTokenProvider;

    public JwtAuthenticationFilter(String url, AuthenticationManager authManager, JwtTokenProvider jwtTokenProvider) {
        super(new AntPathRequestMatcher(url));
        this.jwtTokenProvider = jwtTokenProvider;
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        AuthUser creds = new ObjectMapper().readValue(req.getInputStream(), AuthUser.class);
        System.out.println(creds.getUser());
        System.out.println(creds.getPassword());
        try {
            return getAuthenticationManager()
                    .authenticate(new UsernamePasswordAuthenticationToken(
                            creds.getUser(), String.valueOf(creds.getPassword()), Collections.<GrantedAuthority>emptyList())
                    );
        } catch (AuthenticationException ex) {
            System.out.println("Exception: " + ex.getMessage());
            res.setStatus(401);
            res.setCharacterEncoding("UTF-8");
            res.getWriter().print("Usuário e/ou senha inválidos.");
            return null;
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res,
                                            FilterChain chain, Authentication auth) throws IOException, ServletException {
        AuthenticatedUser authenticatedUser = null;
        if (auth.getPrincipal() == null || !(auth.getPrincipal() instanceof AuthenticatedUser)) {
            throw new Error("Usuário e/ou senha inválidos.");
        }
        authenticatedUser = ((AuthenticatedUser) auth.getPrincipal());
        String token = jwtTokenProvider.createToken(authenticatedUser);
        res.getWriter().print("{\"access_token\":\"" + token + "\"}");
    }
}
