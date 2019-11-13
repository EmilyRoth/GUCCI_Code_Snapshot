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
        Pattern numValueRegex = Pattern.compile("how much is (.*)([?])");
        Pattern creditValueRegex = Pattern.compile("how many Credits is (.*)([?])");

        while ((str = br.readLine()) != null) {
            Matcher matcher;
            if(numAssignRegex.matcher(str).matches()){
                matcher = numAssignRegex.matcher(str);
                matcher.find();
                con.numberTranslation(matcher.group(1), matcher.group(2));
            }
            else if(unitAssignRegex.matcher(str).matches()){
                // assign words to units to credits
                matcher = unitAssignRegex.matcher(str);
                matcher.find();
                con.materialTranslation(matcher.group(1), matcher.group(2), matcher.group(3));
            }
            else if(numValueRegex.matcher(str).matches()){
                // get the straight value of the roman numerals
                matcher = numValueRegex.matcher(str);
                matcher.find();
                System.out.println(con.numeralToDecimal(matcher.group(1)));
            }
            else if (creditValueRegex.matcher(str).matches()){
                // find how many credits something is worth
                matcher = creditValueRegex.matcher(str);
                matcher.find();
                System.out.println("4" + str);
            }
            else{
                System.out.println("I have no idea what you are talking about" + str);
            }
        }
    }
}

