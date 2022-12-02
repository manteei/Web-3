package validate;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ApplicationScoped
@ManagedBean
@FacesValidator("xValidator")
public class XValidator implements Validator {
    public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
        double x = (double) obj;
        if (x < -5 || x > 3) {
            FacesMessage xVal = new FacesMessage("Координата X задается числом в промежутке [-5...3]!");
            xVal.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(xVal);
        }
    }
}
