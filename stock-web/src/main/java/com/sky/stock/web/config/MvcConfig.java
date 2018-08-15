package com.sky.stock.web.config;

import com.sky.commons.utils.context.ApplicationContextUtils;
import com.sky.commons.web.context.EmptyToNullFormatAnnotationFormatterFactory;
import com.sky.commons.web.context.ResponseBodyWrapFactoryBean;
import com.sky.stock.web.utils.SessionUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by sky on 4/2/17.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    ApplicationContextUtils applicationContextUtils(){return new ApplicationContextUtils();}

    @Bean
    ResponseBodyWrapFactoryBean responseBodyWrapFactoryBean(){return new ResponseBodyWrapFactoryBean();}

    @Bean
    LocalValidatorFactoryBean getLocalValidatorFactoryBean(){
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
        return localValidatorFactoryBean;
    }

    @Bean
    SessionUtils sessionUtils(){
        return new SessionUtils();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        EmptyToNullFormatAnnotationFormatterFactory annoFormater =new EmptyToNullFormatAnnotationFormatterFactory();
        registry.addFormatterForFieldAnnotation(annoFormater);
    }



}

