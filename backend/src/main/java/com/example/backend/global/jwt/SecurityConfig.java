package com.example.backend.global.jwt;

import com.example.backend.domain.managers.repository.ManagerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final ManagerRepository managerRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 사용하지 않겠다는 의미
                .and()
                .formLogin().disable() //form 태그 만들어서 로그인하는 것 안 함
                .httpBasic().disable()
                .apply(new CustomAbstractHttpConfigurer())
                .and()
                .authorizeHttpRequests(
                        requests -> requests.antMatchers("/api/manager/signup/**", "/api/manager/login").permitAll()
                                .anyRequest().authenticated() //회원가입, 로그인 이외에는 권한 필요
                )
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);

        return http.build();
    }

    public class CustomAbstractHttpConfigurer extends AbstractHttpConfigurer<CustomAbstractHttpConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity http) throws Exception {
            AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
            http
                    .addFilter(corsFilter)
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, managerRepository));
        }
    }

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> cookieProcessorCustomizer() {
        return (factory) -> factory
                .addContextCustomizers((context) -> context.setCookieProcessor(new LegacyCookieProcessor()));
    }
}