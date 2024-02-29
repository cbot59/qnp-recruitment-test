package dev.rivaldi.qnprecruitmenttest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpMethod;
import org.springframework.web.filter.GenericFilterBean;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader = request.getHeader("Authorization");

        if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.setStatus(401);
                return;
            }
        }
        var secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("bVdQaDBRb1FqTjd4WVNCZHl2UGJnMHd2V1d4QWR2SDlSdzJGV3o0T2g0cFRuSnZSWE1KNjVTTTVyUm41cWVoag=="));
        String token = authHeader.substring(7);
        Claims claims = (Claims) Jwts.parser().verifyWith(secretKey)
            .build()
            .parse(token)
            .getPayload();
        request.setAttribute("claims", claims);
        request.setAttribute("blog", request.getParameter("id"));
        filterChain.doFilter(request, response);
    }
}
