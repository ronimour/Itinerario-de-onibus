package br.ufrn.controller.service.validator;

import br.ufrn.exceptions.ValidationException;

public interface ValidatorInterface<E> {
	public void validate(E value) throws ValidationException;
}
