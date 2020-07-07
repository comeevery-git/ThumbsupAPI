package com.boot.api.thumbsup.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *
스프링에서 제공하는 LocaleChangeInterceptor를 사용하여 lang이라는 RequestParameter가 요청에 있으면 해당 값을 읽어 로케일 정보를 변경합니다.
아래에서 로케일 정보는 기본으로 Session에서 읽어오고 저장하도록 SessionLocaleResolver를 사용하였는데 아래와 같이 다른 리졸버도 있으므로 상황에 따라 적절한 리졸버를 설정하여 사용하면 됩니다.
AbstractLocaleContextResolver
AbstractLocaleResolver
AcceptHeaderLocaleResolver
CookieLocaleResolver
FixedLocaleResolver
SessionLocaleResolver
	
 */

@Configuration
public class MessageConfiguration implements WebMvcConfigurer {

	/* test중 ksh 
    @Bean // 세션에 지역설정. default는 KOREAN = 'ko'
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREAN);
        return slr;
    }
    
    
    @Bean // 지역설정을 변경하는 인터셉터. 요청시 파라미터에 lang 정보를 지정하면 언어가 변경됨.
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    
    @Override // 인터셉터를 시스템 레지스트리에 등록
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
    @Bean // yml 파일을 참조하는 MessageSource 선언
    public MessageSource messageSource(
            @Value("${spring.messages.basename}") String basename,
            @Value("${spring.messages.encoding}") String encoding
    ) {
        YamlMessageSource ms = new YamlMessageSource();
        ms.setBasename(basename);
        ms.setDefaultEncoding(encoding);
        ms.setAlwaysUseMessageFormat(true);
        ms.setUseCodeAsDefaultMessage(true);
        ms.setFallbackToSystemLocale(true);
        return ms;
    }
    
    // locale 정보에 따라 다른 yml 파일을 읽도록 처리
    private static class YamlMessageSource extends ResourceBundleMessageSource {
        @Override
        protected ResourceBundle doGetBundle(String basename, Locale locale) throws MissingResourceException {
            return ResourceBundle.getBundle(basename, locale, YamlResourceBundle.Control.INSTANCE);
        }
    }
   */
    
}