package chamorro.edisson.contabilidad.security;

import chamorro.edisson.contabilidad.services.EmpleadoService;
import chamorro.edisson.contabilidad.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyUserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers(
                        "/modificar-movimiento",
                        "/modificar-empresa",
                        "/eliminar-empresa",
                        "/eliminar-movimiento",
                        "/enterprises**",
                        "/modificar-empleado*",
                        "/adm-empleados",
                        "/lista-empleados",
                        "/registro-empleado*",
                        "/adm-empresas",
                        "/lista-empresas",
                        "/adm-movimientos",
                        "/lista-movimientos",
                        "/registro-empresa",
                        "/user"

                )
                .authenticated()
                .antMatchers("/home","/","/login").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");

    }
}
