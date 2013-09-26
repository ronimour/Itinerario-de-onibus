package br.ufrn.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


public class TarifaValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		
		Double tarifa = (Double) arg2;
		
		if(tarifa > 2.2){
			FacesMessage message = new FacesMessage();
			message.setDetail("aumentaram a tarifa!");
			message.setSummary("aumentaram a passagem dinovo");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ValidatorException(message);
		}
		
	}

}
