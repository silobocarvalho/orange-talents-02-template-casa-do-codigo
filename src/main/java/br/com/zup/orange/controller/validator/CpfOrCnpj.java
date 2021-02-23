package br.com.zup.orange.controller.validator;

import javax.transaction.Transactional;
import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.lang.annotation.*;

@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR) // CPF OR CNPJ
@Documented
@Constraint(validatedBy = {  }) //dont need a validator
@Target({ ElementType.FIELD }) //This annotation define the scope of the Validator
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface CpfOrCnpj {
	String message() default "{CPF or CNPJ is not valid.}";

	Class<?> domainClass();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}