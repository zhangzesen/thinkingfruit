package com.ysdevelop.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import com.ysdevelop.common.utils.RegexUtil;

public class IsFirstCategoryValidator implements ConstraintValidator<IsFirstCategory, Long> {

	private boolean required = false;
	
	@Override
	public void initialize(IsFirstCategory constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if (required) {
			return RegexUtil.checkNumber(value.toString());
		} else {
			if (StringUtils.isEmpty(value.toString())) {
				return false;
			} else {
				return RegexUtil.checkNumber(value.toString());
			}
		}
	}

}
