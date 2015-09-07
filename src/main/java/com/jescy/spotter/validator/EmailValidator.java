package com.jescy.spotter.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	private final static Pattern EMAIL_PATTERN = Pattern
			.compile(".+@.+\\.[a-z]+");

	public void initialize(Email arg0) {
		// TODO Auto-generated method stub
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		return EMAIL_PATTERN.matcher(value).matches();
	}

}
