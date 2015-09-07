package com.jescy.spotter.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

import com.jescy.spotter.model.ExerciseDecorator;

@ManagedBean(name="exerciseConverer")
public class ExerciseDropdownConverter extends SelectItemsBaseConverter{

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value	 == null) {
			return "";
		}

		if (!(value instanceof ExerciseDecorator)) {
			throw new ConverterException("Value is not valid instance of ExerciseDecorator.");
		}

		Integer id = ((ExerciseDecorator) value).getId();
		return (id != null) ? id.toString() : "";
	}

}
