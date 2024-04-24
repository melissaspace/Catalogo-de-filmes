package configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mbf.trabalho_final.entities.Adm;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/adm").permitAll()
                .antMatchers(HttpMethod.GET, "/filme").permitAll()
                .antMatchers(HttpMethod.GET, "/Genero").permitAll() 
                .antMatchers(HttpMethod.POST, "/adm").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/adm").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/adm").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
            .httpBasic();
    }
    
    public void criarAdm(Adm adm) {
        adm.setSenha(new BCryptPasswordEncoder().encode(adm.getSenha()));
    }

    @Bean                
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
