package services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.imd.domain.Usuario;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class TokenService {

    public static final String HEADER_STRING = "Authorization";
    static final byte[] SECRET = "secret".getBytes();

    static Authentication getAuthentication(HttpServletRequest request) {
        var token = request.getHeader(HEADER_STRING);
        if (token == null) {
            return null;
        }
        token = token.replace("Bearer ", "");
        return parseTokenSubject(token);
    }

    private static UsernamePasswordAuthenticationToken parseTokenSubject(String token) {
        var jwt = JWT.require(Algorithm.HMAC512(SECRET))
                .withIssuer("auth0")
                .build()
                .verify(token);

        if(jwt.getExpiresAtAsInstant().isBefore(Instant.now())) {
            return null;
        }

        var subject = jwt.getSubject();
        if(subject == null) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(subject, null, List.of());
    }

    public  String buildJWT(Usuario user) {
        return JWT.create().withIssuer("auth0")
                .withSubject(user.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .sign(Algorithm.HMAC512(SECRET));
    }
}
