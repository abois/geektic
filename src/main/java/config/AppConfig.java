package config;

import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.DateFormatterRegistrar;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Spring webapp configuration
 * @author JB
 */
@Configuration
@ComponentScan({"controller", "model", "service", "dao", "config"})
@EnableWebMvc
@EnableTransactionManagement
public class AppConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource result = new ResourceBundleMessageSource();
        result.setBasenames("errors");
        result.setUseCodeAsDefaultMessage(true);
        return result;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateFormatterRegistrar registrar = new DateFormatterRegistrar();
        registrar.setFormatter(dateFormatter());
        registrar.registerFormatters(registry);
    }

    @Bean
    public DateFormatter dateFormatter() {
        DateFormatter dateFormatter = new DateFormatter();
        dateFormatter.setStylePattern("S-");
        return dateFormatter;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean result = new LocalContainerEntityManagerFactoryBean();
        result.setPersistenceUnitName("Geektic");
        result.setDataSource(dataSource());
        result.setPersistenceProviderClass(HibernatePersistence.class);
        return result;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource result = new DriverManagerDataSource("jdbc:hsqldb:hsql://localhost/geektic", "sa", "");
        result.setDriverClassName(org.hsqldb.jdbc.JDBCDriver.class.getName());
        return result;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf().getObject());
        return txManager;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(openEntityManagerInViewInterceptor());
    }

    @Bean
    public OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor() {
        OpenEntityManagerInViewInterceptor result = new OpenEntityManagerInViewInterceptor();
        result.setEntityManagerFactory(emf().getObject());
        return result;
    }

}
