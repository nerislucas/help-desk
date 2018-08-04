package br.com.globalpoints.helpdesk.configurations.secutiry;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import br.com.globalpoints.helpdesk.configurations.secutiry.providers.JwtTokenProvider;

public class AuthenticationTokenExtractor extends GenericFilterBean {
    public static final String AUTH_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private JwtTokenProvider jwtTokenProvider;

    public AuthenticationTokenExtractor(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
            throws IOException, ServletException {
        String token = extractTokenFromRequest((HttpServletRequest) req);
        // System.out.println("Token: " + token);
        if (token != null) {
            Authentication auth = null;
            try {
                auth = jwtTokenProvider.getAuthentication(token);
            } catch (Exception ex) {
                refuseRequestWithException(res, ex);
                return;
            }
            SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        filterChain.doFilter(req, res);
    }

    private String extractTokenFromRequest(HttpServletRequest req) {
        String bearerToken = req.getHeader(AUTH_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length(), bearerToken.length());
        }
        return null;
    }

    private void refuseRequestWithException(ServletResponse res, Exception ex) throws IOException {
        if (res instanceof HttpServletResponse) {
            ((HttpServletResponse) res).setStatus(HttpStatus.FORBIDDEN.value());
        }
        res.setCharacterEncoding("UTF-8");
        res.getWriter().print(ex.getMessage());
        res.flushBuffer();
    }
}
