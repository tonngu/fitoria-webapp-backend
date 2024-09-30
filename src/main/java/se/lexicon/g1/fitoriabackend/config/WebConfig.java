package se.lexicon.g1.fitoriabackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// This config class is made to resolve this issue of CORS (Cross-Origin Resource Sharing)
// in the browsers not allowing requests from one domain to another domain unless explicitly allowed
// in this case the two domains are my localhost:3000 and localhost:8080
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") //Allows requests only from your frontend (React) application running on port 3000.
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") //Specifies the HTTP methods that are allowed.
                .allowedHeaders("*") //allowedHeaders("*"): Allows all headers.
                .allowCredentials(true); //Enables sending credentials like cookies, authorization headers, etc.
    }
}
