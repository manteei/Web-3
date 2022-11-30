package validate;

import exeption.IncorrectDataEx;

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
@FacesValidator("yValidator")
public class YValidator implements Validator {
   public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException {
       double y = (double) obj;
       if (y < -5 || y > 3)  {
           FacesMessage yVal = new FacesMessage("Координата Y задается числом в промежутке [-5...3]!");
           yVal.setSeverity(FacesMessage.SEVERITY_ERROR);
           throw new ValidatorException(yVal);
       }

   }
}
