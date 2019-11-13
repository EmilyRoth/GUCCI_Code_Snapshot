import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) throws Exception{
        URL path = main.class.getResource("input.txt");
        File file = new File(path.getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        conversions con = new conversions();

        String str;
        Pattern numAssignRegex = Pattern.compile("(\\w*) means ([IVXLCDM]*)");
        Pattern unitAssignRegex = Pattern.compile("(.*) units of (\\w*) are worth (\\d*) Credits");
        Pattern numValueRegex = Pattern.compile("how much is (.*)( [?])");
        Pattern creditValueRegex = Pattern.compile("how many Credits is (.*)( [?])");

        while ((str = br.readLine()) != null) {
            Matcher matcher;
            try {
                if (numAssignRegex.matcher(str).matches()) {
                    matcher = numAssignRegex.matcher(str);
                    matcher.find();
                    String intergalacticNumeral = matcher.group(1);
                    String romanNumeral = matcher.group(2);
                    con.numberTranslation(intergalacticNumeral, romanNumeral);
                }
                else if (unitAssignRegex.matcher(str).matches()) {
                    matcher = unitAssignRegex.matcher(str);
                    matcher.find();
                    String intergalacticNumerals = matcher.group(1);
                    String material = matcher.group(2);
                    String credits = matcher.group(3);
                    con.materialTranslation(intergalacticNumerals, material, credits);
                }
                else if (numValueRegex.matcher(str).matches()) {
                    matcher = numValueRegex.matcher(str);
                    matcher.find();
                    String intergalacticNumerals = matcher.group(1);
                    System.out.println(intergalacticNumerals + " is " + con.numeralToDecimal(intergalacticNumerals));
                }
                else if (creditValueRegex.matcher(str).matches()) {
                    matcher = creditValueRegex.matcher(str);
                    matcher.find();
                    String input = matcher.group(1);
                    System.out.println(input + " is " + con.mineralValToDecimal(input) + " Credits");
                }
                else {
                    System.out.println("I have no idea what you are talking about");
                }
            } catch (Exception e){
                System.out.println("I have no idea what you are talking about");
            }
        }
    }
}

