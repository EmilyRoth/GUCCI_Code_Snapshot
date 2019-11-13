import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Assumptions: Does not always go in order and numbers can be reassigned

public class main {
    public static void main(String[] args) throws Exception{
        // Taking inputs inputs from txt file
        // Assumptions: Input read in as file named input.txt
        URL path = main.class.getResource("input.txt");
        File file = new File(path.getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));

        conversions con = new conversions();

        // Reading the file
        // Assumptions: Output to console rather than to a file
        String str;
        Pattern numAssignRegex = Pattern.compile("(\\w*) means ([IVXLCDM]*)");
        Pattern unitAssignRegex = Pattern.compile("(.*) units of (\\w*) are worth (\\d*) Credits");

        Pattern numValueRegex = Pattern.compile("how much is (.*)( [?])");
        Pattern creditValueRegex = Pattern.compile("how many Credits is (.*)( [?])");

        while ((str = br.readLine()) != null) {
            Matcher matcher;
            if(numAssignRegex.matcher(str).matches()){
                matcher = numAssignRegex.matcher(str);
                matcher.find();
                String unit = matcher.group(1);
                String symbol = matcher.group(2);
                con.numberTranslation(unit, symbol);
            }
            else if(unitAssignRegex.matcher(str).matches()){
                matcher = unitAssignRegex.matcher(str);
                matcher.find();
                String units = matcher.group(1);
                String material = matcher.group(2);
                String credits = matcher.group(3);
                con.materialTranslation(units, material, credits);
            }
            else if(numValueRegex.matcher(str).matches()){
                matcher = numValueRegex.matcher(str);
                matcher.find();
                String numerals = matcher.group(1);
                System.out.println(numerals + " is "+ con.numeralToDecimal(numerals));
            }
            else if (creditValueRegex.matcher(str).matches()){
                // find how many credits something is worth
                matcher = creditValueRegex.matcher(str);
                matcher.find();
                String input = matcher.group(1);
                System.out.println(input + " is " + con.mineralValToDecimal(input) + " Credits");
            }
            else{
                System.out.println("I have no idea what you are talking about");
            }
        }
    }

    // Explored the option of making the regex change depending on previous inputs
    // Decided it would be too expensive to make a call and recompile pattern each time
    public static String updatePattern(String curValues, String newValue){
        if(curValues.length() > 0)
            return curValues + "|" +newValue;
        else
            return newValue;
    }
}

