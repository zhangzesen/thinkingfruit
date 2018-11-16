package com.ysdevelop.common.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * @author oldHuang
 *
 * @Package com.ysdevelop.common.validator
 * 
 * @Description 校验是否数字注解
 *
 * @Date 2018年6月2日
 *
 * @Version
 *
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
	ElementType.CONSTRUCTOR, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { IsDecimalsValidator.class })
public @interface IsDecimals {
	
	boolean required() default true;

	String message() default "当前值不是数字";
	
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
