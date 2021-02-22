package br.com.zup.orange.controller.validator;

import javax.transaction.Transactional;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = { UniqueStateCountryNameValidator.class })
@Target({ ElementType.TYPE }) //This annotation define the scope of the Validator for Class scope. When your validator is called, the Class Object is passed to Validator.
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface UniqueStateCountryName {
	String message() default "{Duplicated State name for this Country}";

	String stateName(); //atributte 1

	String countryId(); //atributte 2

	Class<?> domainClass();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}