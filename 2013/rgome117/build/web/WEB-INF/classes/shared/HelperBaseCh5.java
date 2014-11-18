package shared;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.engine.PathImpl;
import static shared.HelperBaseCh5.validatorFactory;

/**
 *
 * @author Rob
 */
public abstract class HelperBaseCh5 extends HelperBaseCh4 {
    public HelperBaseCh5(
            HttpServlet servlet,
            HttpServletRequest request,
            HttpServletResponse response) 
    {
        super(servlet, request, response);
    
    }
    
    public Map<String, String> errorMap = 
            new HashMap<String, String>();
    public Map getErrors() {
        return errorMap;
    }
    
    public void clearErrors() {
        if (errorMap != null) {
        errorMap.clear();
        }
    }
    
    protected static final ValidatorFactory validatorFactory
            = Validation.buildDefaultValidatorFactory();
    protected static final Validator validator
            = validatorFactory.getValidator();
    
    public void setErrors(Object data)
    {
        Set<ConstraintViolation<Object>> violations
                = validator.validate(data);
        
        errorMap.clear();
                if(!violations.isEmpty()) {
                    for (ConstraintViolation<Object> msg : violations) {
                        PathImpl value = (PathImpl) msg.getPropertyPath();
                        errorMap.put((String) value.getLeafNode().getName(),
                                msg.getMessage());
                    }
                }
    }
    
    public boolean isValid(Object bean) {
        setErrors(bean);
        return errorMap.isEmpty();
        
    }
    
    public boolean isValidProperty(String name) {
        if (errorMap == null) return true;
        String msg = errorMap.get(name);
        return msg == null || msg.isEmpty();
    }
}
