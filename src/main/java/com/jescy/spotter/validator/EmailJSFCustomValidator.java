package com.jescy.spotter.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("com.cai.contact.validator.EmailJSFCustomValidator")
public class EmailJSFCustomValidator implements Validator {

	private final static Pattern EMAIL_PATTERN = Pattern
			.compile(".+@.+\\.[a-z]+");
	private Matcher matcher;

	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		matcher = EMAIL_PATTERN.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("E-mail validation failed.",
					"Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

}
