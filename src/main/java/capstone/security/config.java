package capstone.security;


import capstone.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class config {

    @Autowired
    UserServiceImpl service;

    @Bean
    public DaoAuthenticationProvider provider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(encoder());
        return provider;
    }

    @Bean
    public PasswordEncoder encoder() { return new BCryptPasswordEncoder(11);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/players/sign-up", "/players/login", "/",
                        "/static/**").permitAll()

                .requestMatchers( "/bracket",  "/home", "/list-players",
                        "/scores")
                .hasAnyAuthority("user", "admin")
                .requestMatchers("/playerForm", "/updateForm",
                        "/showFormForAdd", "/showFormForUpdate")
                .hasAuthority("admin")
//                .anyRequest()
//                .authenticated()
                .and()
                .formLogin()
                .loginPage("/players/login")
                .defaultSuccessUrl("/", true)
                .and()
                .httpBasic()
                .and()
                .logout()
                .logoutSuccessUrl("/");

        return http.build();
    }


}
