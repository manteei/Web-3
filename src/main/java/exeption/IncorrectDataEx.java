package exeption;

import javax.faces.application.FacesMessage;

public class IncorrectDataEx extends RuntimeException {
    public IncorrectDataEx(FacesMessage message) {
        super(String.valueOf(message));
    }
}
