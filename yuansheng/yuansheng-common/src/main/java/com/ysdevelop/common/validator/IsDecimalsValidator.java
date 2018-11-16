package com.ysdevelop.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import com.ysdevelop.common.utils.RegexUtil;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.common.validator
 * 
 * @Description 校验值是不是数字
 * 
 * @Date 2018年6月2日
 * 
 * @Version
 * 
 */
public class IsDecimalsValidator implements ConstraintValidator<IsDecimals, String> {

	private boolean required = false;

	@Override
	public void initialize(IsDecimals constraintAnnotation) {
		required = constraintAnnotation.required();

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		if (required) {
			return RegexUtil.checkDecimals(value);
		} else {
			if (StringUtils.isEmpty(value)) {
				return true;
			} else {
				return RegexUtil.checkDecimals(value);
			}
		}
	}

}
