package Auth.Comment;
import org.mvel2.MVEL;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchesValidator implements ConstraintValidator<Matches, Object> {

  private String field;
  private String verifyField;


  public void initialize(Matches constraintAnnotation) {
    this.field = constraintAnnotation.field();
    this.verifyField = constraintAnnotation.verifyField();
  }

  @SuppressWarnings("deprecation")
public boolean isValid(Object value, ConstraintValidatorContext context) {
    Object fieldObj = MVEL.getProperty(field, value);
    Object verifyFieldObj = MVEL.getProperty(verifyField, value);

    boolean neitherSet = (fieldObj == null) && (verifyFieldObj == null);

    if (neitherSet) {
      return true;
    }

    boolean matches = (fieldObj != null) && fieldObj.equals(verifyFieldObj);

    if (!matches) {
      String messageTemplate = context.getDefaultConstraintMessageTemplate();  
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(messageTemplate)
          .addNode(verifyField)
          .addConstraintViolation();
    }

    return matches;
  }
}