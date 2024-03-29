package by.arbitrage.springconfig;

import by.arbitrage.filter.CORSFilter;
import com.allanditzel.springframework.security.web.csrf.CsrfTokenResponseHeaderBindingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;

import javax.sql.DataSource;

/**
 * Created by Nikita Tkachuk
 */
//@GoalCompleteInfo(1)
@Configuration
@EnableWebMvcSecurity
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Qualifier("userDetailsServiceImpl")
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		CsrfTokenResponseHeaderBindingFilter csrfTokenFilter = new CsrfTokenResponseHeaderBindingFilter();
		http.addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);
		http.addFilterAfter(csrfTokenFilter, CsrfFilter.class);
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/resources/**").permitAll()
				.antMatchers(HttpMethod.GET, "/sitestat").permitAll()
				.antMatchers(HttpMethod.POST, "/sitevisit").permitAll()
				.antMatchers(HttpMethod.POST, "/addSite").authenticated()
				.antMatchers(HttpMethod.POST, "/goalComplete").permitAll()
				.antMatchers("/registration").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.defaultSuccessUrl("/index")
				.loginProcessingUrl("/j_spring_security_check")
				.usernameParameter("j_username")
				.passwordParameter("j_password")
				.loginPage("/login")
				.permitAll()
				.and()
				.httpBasic();
				/*.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("login.html")
				.permitAll();*/

		if ("true".equals(System.getProperty("httpsOnly"))) {
			http.requiresChannel().anyRequest().requiresSecure();
		}

	}
}
