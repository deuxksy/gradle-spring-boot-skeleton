package gradle.spring.boot.skeleton.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.nio.charset.Charset;

@Configuration
public class BeanConfig {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeHeaders(true);
    loggingFilter.setIncludeQueryString(true);
    loggingFilter.setIncludePayload(true);
    loggingFilter.setIncludeClientInfo(true);
    loggingFilter.setMaxPayloadLength(100);
    loggingFilter.setBeforeMessagePrefix("=== Before Prefix ===\n");
    loggingFilter.setBeforeMessageSuffix("\n=== Before Suffix ===");
    loggingFilter.setAfterMessagePrefix("=== After Prefix ===\n");
    loggingFilter.setAfterMessageSuffix("\n=== After Suffix ===");
    return loggingFilter;
  }

  @Bean
  public HttpMessageConverter<String> responseBodyConverter() {
    return new StringHttpMessageConverter(Charset.forName("UTF-8"));
  }
}