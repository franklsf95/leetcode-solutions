/**
 * @created Oct 16, 2015
 * @author franklsf95
 * 
 * @problem integer-to-roman
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class IntegerToRoman {
	
	static String intToRoman(int num) {
		String[] romans = {"", "1", "11", "111", "15", "5", "51", "511",
				"5111", "1x"};
        char[] ones = {'I', 'X', 'C', 'M'};
        char[] fives = {'V', 'L', 'D'};
        StringBuilder sb = new StringBuilder();
        int n;
        int place = 0;
        while (num > 0) {
        	n = num % 10;
        	num /= 10;
        	String repr = new String(romans[n]);
        	repr = repr.replace('1', ones[place]);
        	if (place < fives.length) {
            	repr = repr.replace('5', fives[place]);
        	}
        	if (place < ones.length - 1) {
        		repr = repr.replace('x', ones[place + 1]);
        	}
        	sb.insert(0, repr);
        	place += 1;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1) + " = I?");
		System.out.println(intToRoman(5) + " = V?");
		System.out.println(intToRoman(88) + " = LXXXVIII?");
		System.out.println(intToRoman(90) + " = XC?");
		System.out.println(intToRoman(144) + " = CXLIV?");
		System.out.println(intToRoman(999) + " = CMXCIX?");
		System.out.println(intToRoman(1999) + " = MCMXCIX?");
	}

}
