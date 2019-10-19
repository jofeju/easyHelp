package br.uem.easyhelp.validator;

import br.uem.easyhelp.metadata.entity.User;
import br.uem.easyhelp.util.LocalDateTimeUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Douglas
 */
public class UserValidator {

    private User user;
    private List<String> errorMessages;

    public UserValidator(User user) {
        this.user = user;
        errorMessages = new ArrayList<>();
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }

    public boolean validate() {
        return validateAge(user.getBirthDate());
    }

    private boolean validateAge(Date birthDate) {
        boolean valid = true;

        LocalDate today = LocalDate.now();

        if (birthDate == null) {
            errorMessages.add("Data de nascimento do usuário deve ser informada");
            valid = false;
        }

        if (birthDate != null && today.getYear() - LocalDateTimeUtil.toLocalDate(birthDate).getYear() < 18) {
            errorMessages.add("Idade do usuário deve ser maior ou igual a 18 anos");
            valid = false;
        }

        return valid;
    }
}
