package com.ysdevelop.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.ysdevelop.common.utils.RegexUtil;

public class IsBankNoValidator implements ConstraintValidator<IsBankNo, String> {

	private boolean required = false;

	@Override
	public void initialize(IsBankNo constraintAnnotation) {

		required = constraintAnnotation.required();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		if (required) {
			return RegexUtil.checkBankCard(value);
		} else {
			if (StringUtils.isEmpty(value)) {
				return true;
			} else {
				return RegexUtil.checkBankCard(value);
			}
		}
	}

}
