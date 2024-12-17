package BS.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        // 配置跨域拦截规则
        CorsConfiguration config = new CorsConfiguration();
        // 允许来自 http://localhost:8081 的请求
        config.setAllowedOrigins(List.of("http://localhost:8081"));
        // 设置是否支持凭证，默认为false
        config.setAllowCredentials(true);
        // 允许所有的HTTP方法
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH"));
        // 允许所有的请求头
        config.setAllowedHeaders(Collections.singletonList("*"));

        // 配置拦截路径的匹配
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
