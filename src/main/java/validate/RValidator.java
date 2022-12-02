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
@FacesValidator("rValidator")
public class RValidator implements Validator {
    public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
        double r = (double) obj;
        if (r < 0 || r> 3) {
            FacesMessage rVal = new FacesMessage("Радиус задается числом в промежутке [0...3]!");
            rVal.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(rVal);
        }
    }
}
