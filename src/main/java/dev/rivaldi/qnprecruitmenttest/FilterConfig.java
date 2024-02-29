package dev.rivaldi.qnprecruitmenttest;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FilterConfig {

    @Bean
    FilterRegistrationBean<JwtFilter> jwtFilter() {
        var filter = new FilterRegistrationBean<JwtFilter>();
        filter.setFilter(new JwtFilter());
        filter.addUrlPatterns("/contacts/*", "/user-post/*");
        return filter;
    }
}
