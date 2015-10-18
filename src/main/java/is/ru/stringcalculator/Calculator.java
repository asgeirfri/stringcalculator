package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//[", 0)){
			String delimiter = text.substring(text.indexOf("//") + 3, text.indexOf("\n") - 1);
			String numbers = text.substring(text.lastIndexOf("\n") + 1);
			delimiter = fixDelimiter(delimiter);
			return sum(splitNumbers(numbers, delimiter));
		}
		else if(text.startsWith("//", 0)){
			String delimiter = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
			String numbers = text.substring(text.lastIndexOf("\n") + 1);
			return sum(splitNumbers(numbers, delimiter));
		}
			
		else if(text.contains(",")||text.contains("\n")){
			return sum(splitNumbers(text, ",|\n"));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String delimiters){
	    return numbers.split(delimiters);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String negativeNumbers = "";
        for(String number : numbers){
        	if (toInt(number) < 0)
        	{
        		if (negativeNumbers.isEmpty())
        		{
        			negativeNumbers += number;
        		}
        		else
        		{
        			negativeNumbers += "," + number;
        		}
        	}
        	if (toInt(number) < 1001)
        	{
		    	total += toInt(number);
		    }
		}
		if (negativeNumbers.isEmpty())
		{
			return total;
		}
		else
		{
			throw new RuntimeException("Negatives not allowed:" + negativeNumbers);
		}
    }
    
    private static String fixDelimiter(String str){
    	String del = "";
    	for( char c : str.toCharArray())
    	{
    		if (c == '[')
    		{
    			del = del + "|";
    		}
    		else if (c != ']')
    		{
    			del = del + c;
    		}
    	}
    	return del;
    }



}