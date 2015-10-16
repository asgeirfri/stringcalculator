package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.startsWith("//", 0))
		{
			String delimiter = text.substring(text.indexOf("//") + 2, text.indexOf("\n"));
			delimiter = delimiter.replace(' ', '|');
			String numbers = text.substring(text.lastIndexOf("\n") + 1);
			return sum(splitNumbers(numbers, delimiter));
		}
		else if(text.contains(",")||text.contains("\n")){
			return sum(splitNumbers(text, ",|\n"));
		}
		else
			return 1;
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
        		negativeNumbers += number + ", ";
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
			return -1;
			//throw MyExeption("Negatives not allowed: " + negativeNumbers);
		}
    }
    /*public class MyException(String error) extends Exception {
 		
	}*/



}