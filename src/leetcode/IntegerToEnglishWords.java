/**
 * @created Sep 7, 2015
 * @author franklsf95
 * 
 * @problem integer-to-english-words
 * @difficulty medium
 */

package leetcode;

import java.util.*;

public class IntegerToEnglishWords {
	
	static String digitToWord(int n) {
		switch (n) {
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		}
		return "";
	}
	
	static String tensToWord(int n) {
		switch (n) {
		case 1:
			return "Ten";
		case 2:
			return "Twenty";
		case 3:
			return "Thirty";
		case 4:
			return "Forty";
		case 5:
			return "Fifty";
		case 6:
			return "Sixty";
		case 7:
			return "Seventy";
		case 8:
			return "Eighty";
		case 9:
			return "Ninety";
		}
		return "";
	}
	
	static ArrayList<String> shortToWord(int n) {
        ArrayList<String> comps = new ArrayList<String>();
		int h = n / 100;
		n -= h * 100;
		if (h > 0) {
        	comps.add(digitToWord(h));
        	comps.add("Hundred");
		}
		if (n >= 20) {
			int tens = n / 10;
			n -= tens * 10;
			comps.add(tensToWord(tens));
		}
		if (n > 0) {
			comps.add(digitToWord(n));
		}
		return comps;
	}
	
	static String numberToWords(int num) {
        ArrayList<String> comps = new ArrayList<String>();
        int b = num / 1000000000;
        num -= b * 1000000000;
        if (b > 0) {
        	comps.add(digitToWord(b));
        	comps.add("Billion");
        }
        int m = num / 1000000;
        num -= m * 1000000;
        if (m > 0) {
        	comps.addAll(shortToWord(m));
        	comps.add("Million");
        }
        int k = num / 1000;
        num -= k * 1000;
        if (k > 0) {
        	comps.addAll(shortToWord(k));
        	comps.add("Thousand");
        }
        // Thousand remainder
        comps.addAll(shortToWord(num));
        // Zero
        if (comps.isEmpty()) {
        	comps.add("Zero");
        }
        // Render
        StringBuilder sb = new StringBuilder(comps.size() * 2);
        for (int i = 0; i < comps.size() - 1; i++) {
        	sb.append(comps.get(i));
        	sb.append(" ");
        }
        sb.append(comps.get(comps.size() - 1));
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(numberToWords(0));
		System.out.println(numberToWords(1));
		System.out.println(numberToWords(12));
		System.out.println(numberToWords(20));
		System.out.println(numberToWords(25));
		System.out.println(numberToWords(123));
		System.out.println(numberToWords(10001));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1002003));
		System.out.println(numberToWords(1234567));
	}

}
