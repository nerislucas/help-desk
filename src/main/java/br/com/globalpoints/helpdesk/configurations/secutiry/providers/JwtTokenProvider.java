package br.com.globalpoints.helpdesk.configurations.secutiry.providers;

import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import br.com.globalpoints.helpdesk.business.entitites.UserPrincipal;
import br.com.globalpoints.helpdesk.business.enums.ProfileEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import br.com.globalpoints.helpdesk.business.models.AuthenticatedUser;

import javax.annotation.PostConstruct;

@Component
public class JwtTokenProvider {
    private static final String CLAIM_ID = "id";
    private static final String CLAIM_BU = "bu";
    private static final String CLAIM_CAMPAIGNID = "bu";
    private static final String CLAIM_ROLE = "role";

    @Value("${security.jwt.token.secretKey}")
    private String secretKey;

    @Value("${security.jwt.token.expireLength}")
    private long validityInMilliseconds;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(AuthenticatedUser user) {
        return createTokenFor(user.getId(), user.getBuId(), user.getCampaingId(), user.getName(), user.getProfile());
    }

    private String createTokenFor(String id, UUID buId, UUID campaignId, String name, ProfileEnum profile) {
        Map<String, Object> claims = new LinkedHashMap<>();
        claims.put(CLAIM_ID, id);
        claims.put(CLAIM_BU, buId);
        claims.put(CLAIM_CAMPAIGNID, campaignId);
        claims.put(CLAIM_ROLE, profile.getProfile());
        Date now = new Date();
        var builder = Jwts.builder()
                .setClaims(claims)
                .setSubject(name)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + validityInMilliseconds))
                .signWith(SignatureAlgorithm.HS256, secretKey);


        return builder.compact();

    }

    private Claims getJwtBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException ex) {
            throw new Error("Sessão expirada, por favor, efetue login novamente.");
        } catch (JwtException | IllegalArgumentException e) {
            throw new Error("Sessão inválida, por favor, efetue login novamente.");
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claims = getJwtBody(token);
        UserPrincipal userDetails = new UserPrincipal(claims.get(CLAIM_ID).toString(), claims.get(CLAIM_BU).toString(),
                claims.getSubject(), claims.get(CLAIM_ROLE).toString());
        return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getUsername(), userDetails.getAuthorities());
    }
}
