package br.com.zup.orange.controller.validator;

import javax.transaction.Transactional;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({ElementType.FIELD}) //Only the field where annotation is add is passed to validator.
@Retention(RetentionPolicy.RUNTIME)
@Transactional
public @interface ExistsId {
    String message() default "{_not_found_field}";
    String fieldName();
    Class<?> domainClass();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}