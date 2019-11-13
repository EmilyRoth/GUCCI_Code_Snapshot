import java.util.HashMap;

public class conversions {
    HashMap<String, Integer> intergalacticNumerals;
    HashMap<String, Float> minerals;

    conversions(){
        intergalacticNumerals = new HashMap<>();
        minerals = new HashMap<>();
    }

    public void numberTranslation(String intergalacticNumeral, String romanNumeral){
        Integer decimalVal;
        switch (romanNumeral){
            case "I":
                decimalVal = 1;
                break;
            case "V":
                decimalVal = 5;
                break;
            case "X":
                decimalVal = 10;
                break;
            case "L":
                decimalVal = 50;
                break;
            case "C":
                decimalVal = 100;
                break;
            case "D":
                decimalVal = 500;
                break;
            case "M":
                decimalVal = 1000;
                break;
            default:
                decimalVal = 0;
        }
        intergalacticNumerals.put(intergalacticNumeral, decimalVal);
    }

    public void materialTranslation(String intergalacticNumerals, String mineral, String credits){
        int creditVal = Integer.parseInt(credits);
        int intergalacticNumeralsVal = numeralToDecimal(intergalacticNumerals);
        float mineralValue =(float) creditVal/intergalacticNumeralsVal;
        minerals.put(mineral, mineralValue);
    }

    public int numeralToDecimal(String intergalacticNumeralInput){
        int total = 0;
        int prev = 1001;
        String[] values = intergalacticNumeralInput.split(" ");
        for(String unit : values){
            int val = intergalacticNumerals.get(unit);
            total += val;
            if (val > prev){
                total = total - (2*prev);
            }
            prev = val;
        }
        return total;
    }

    public int mineralValToDecimal(String input){
        String intergalacticNumeralInput = input.substring(0, input.lastIndexOf(" "));
        String mineral = input.substring(input.lastIndexOf(" ") + 1);

        int numberOfMineral = numeralToDecimal(intergalacticNumeralInput);
        float valueOfMineral = minerals.get(mineral);
        int mineralValue = (int) (numberOfMineral*valueOfMineral);
        return mineralValue;
    }

}
