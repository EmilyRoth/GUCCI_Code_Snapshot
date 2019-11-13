import java.util.regex.*;

public enum input{
        NUMERAL_ASSIGNMENT,
        UNIT_ASSIGNMENT(),
        NUMERAL_VALUE,
        CREDIT_VALUE,
        INVALID;

        String numAssignRegex = "(\\w*) (means) ([IVXLCDM]*)";
        String unitAssignRegex = "(.*) units of (\\w*) are worth (\\d*) Credits";
        String numValueRegex = "how much is (.*) ?";
        String creditValueRegex = "how many Credits is (.*) ?";

        input getInputType(String input){
            if(Pattern.matches(numAssignRegex, input)){
                return NUMERAL_ASSIGNMENT;
            }
            if(Pattern.matches( unitAssignRegex, input)){
                return UNIT_ASSIGNMENT;
            }
            if(Pattern.matches(numValueRegex, input)){
                return NUMERAL_VALUE;
            }
            if (Pattern.matches(creditValueRegex, input)){
                return CREDIT_VALUE;
            }
            return INVALID;
        }
    }


