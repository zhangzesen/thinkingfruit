package com.ysdevelop.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.ysdevelop.common.utils.RegexUtil;

public class IsNumValidator implements ConstraintValidator<IsNum, Double>  {

	private boolean required = false;
	
	@Override
	public void initialize(IsNum constraintAnnotation) {
		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(Double value, ConstraintValidatorContext context) {
		if (value == null) {
			return false;
		}
		if (required) {
			return RegexUtil.checkNum(value.toString());
		} else {
			if (StringUtils.isEmpty(value.toString())) {
				return false;
			} else {
				return RegexUtil.checkNum(value.toString());
			}
		}
	}

}
