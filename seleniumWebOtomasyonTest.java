package com.beymen;

import com.beymen.core.utilities.expection.business.BusinessException;
import com.beymen.core.utilities.results.ErrorDataResult;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;


@SpringBootApplication
@Configuration
@RestControllerAdvice
public class seleniumWebOtomasyonTest {

	public static void main(String[] args) {
		SpringApplication.run(seleniumWebOtomasyonTest.class, args);
	}
	@Bean
	public ModelMapper getModelMapper(){

		return new ModelMapper();
	}

	@Bean
	public ResourceBundleMessageSource bundleMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		// Konfigurasyonlar

		messageSource.setBasename("messages");
		//
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		//Session,Cookie
		// Header => Her istekte headerda bir değer varsa bunu baz al.
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		// Accept-Language alanı boş ise default olarak 'US' alanı olarak değerlendir.
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBusinessException(BusinessException businessException){
		return new ErrorDataResult<>(businessException.getMessage(),"BUSINESS_EXCEPTION");
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(MethodArgumentNotValidException exception){
		Map<String, String> validationErrors  = new HashMap<String, String>();
		for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
			validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
		}

		return new ErrorDataResult<Object>(validationErrors,"VALIDATION_EXCEPTION");
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorDataResult<Object> handleNoSuchElementException(NoSuchElementException exception){
		return new ErrorDataResult<>(exception.getMessage(),"NO_SUCH_ELEMENT_EXCEPTION");
	}


}
