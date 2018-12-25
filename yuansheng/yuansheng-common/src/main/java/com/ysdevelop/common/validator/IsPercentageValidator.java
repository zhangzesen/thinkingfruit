package com.ysdevelop.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.ysdevelop.common.utils.RegexUtil;

public class IsPercentageValidator implements ConstraintValidator<IsPercentage, String> {

	private boolean required = false;

	@Override
	public void initialize(IsPercentage constraintAnnotation) {
		required = constraintAnnotation.required();

	}

	@Override
	public boolean isValid(String percentage, ConstraintValidatorContext context) {
		if (percentage == null) {
			return true;
		}
		if (required) {
			System.out.println(percentage);
			return RegexUtil.checkPercentage(percentage);
		} else {
			if (StringUtils.isEmpty(percentage)) {
				return true;
			} else {
				return RegexUtil.checkPercentage(percentage);
			}
		}

	}

}
