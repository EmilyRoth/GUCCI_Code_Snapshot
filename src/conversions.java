import java.util.HashMap;

public class conversions {
    HashMap<String, Integer> symbols;
    HashMap<String, Integer> minerals;

    conversions(){
        symbols = new HashMap<>();
        minerals = new HashMap<>();
    }

    public void numberTranslation(String num, String romanNumeral){
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
        symbols.put(num, decimalVal);
    }

    public void materialTranslation(String unit, String mineral, String credits){
        int creditVal = Integer.parseInt(credits);
        int unitVal = numeralToDecimal(unit);
        int mineralValue = creditVal/unitVal;
        minerals.put(mineral, mineralValue);
    }

    public int numeralToDecimal(String units){
        int total = 0;
        int prev = 1001;
        String[] values = units.split(" ");
        for(String unit : values){
            int val = symbols.get(unit);
            total += val;
            if (val > prev){
                total = total - (2*prev);
            }
            prev = val;
        }
        return total;
    }

    public int mineralValToDecimal(String input){
        String units = input.substring(0, input.lastIndexOf(" "));
        String mineral = input.substring(input.lastIndexOf(" ") + 1);

        int numberOfMineral = numeralToDecimal(units);
        int valueOfMineral = minerals.get(mineral);
        return numberOfMineral*valueOfMineral;
    }

}
