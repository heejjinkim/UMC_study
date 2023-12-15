package umc.spring.validation.annotation;

import umc.spring.validation.validator.CheckPageValidator;
import umc.spring.validation.validator.MemberExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지가 너무 작습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
