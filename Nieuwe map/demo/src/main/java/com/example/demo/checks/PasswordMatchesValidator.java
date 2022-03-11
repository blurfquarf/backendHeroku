package com.example.demo.checks;

import com.example.demo.checks.PasswordMatch;
import com.example.demo.transfers.PersonTransfer;

import javax.validation.*;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatch, Object> {

    @Override
    public void initialize(final PasswordMatch constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final PersonTransfer p = (PersonTransfer) obj;
        return p.getPassword().equals(p.getMatchingPassword());
    }
}