package com.rev.BACalculator.validator;

import org.springframework.stereotype.Component;

import com.rev.BACalculator.Exceptions.ValidatorException;
import com.rev.BACalculator.model.User;

@Component
public class UserValidator {

	public void validateUser(User user) {
		if ((user.getFirstname() == null || "".equals(user.getFirstname()))
				|| (user.getLastname() == null || "".equals(user.getLastname()))
				|| (user.getEmail() == null || "".equals(user.getEmail()))
				|| (user.getGender() == null || "".equals(user.getGender()))
				|| (user.getUsername() == null || "".equals(user.getUsername()))
				|| (user.getPassword() == null || "".equals(user.getPassword())) || (user.getBodyweight() <= 0)) {
			throw new ValidatorException("Invalid User Information");
		}
	}

}
