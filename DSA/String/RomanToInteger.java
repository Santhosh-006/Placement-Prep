//Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//        Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
//
//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.
//Given a roman numeral, convert it to an integer.
//
//
//
//Example 1:
//
//Input: s = "III"
//Output: 3
//Explanation: III = 3.
//Example 2:
//
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.


public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInteger2("MCMXCIV"));
    }

    static int romanToInteger(String s){
        int sum = 0;
        int left = 0;
        while(left < s.length()){
            if(left<s.length()-1 &&
                    (((s.charAt(left) == 'I') && (s.charAt(left+1) == 'V' || s.charAt(left+1) == 'X' )) ||
                            ((s.charAt(left) == 'X') && (s.charAt(left+1) == 'L' || s.charAt(left+1) == 'C' ))||
                            ((s.charAt(left) == 'C') && (s.charAt(left+1) == 'D' || s.charAt(left+1) == 'M' )))){

                int v1 = getValue(s.charAt(left));
                int v2 = getValue(s.charAt(left+1));
                sum = sum + (v2-v1);
                left+=2;
            }else{
                sum += getValue(s.charAt(left));
                left++;
            }
        }

        return sum;

    }

    static int romanToInteger2(String s){
        int sum = 0;
        int left = 0;
        while(left < s.length()){
            if(left<s.length()-1 && getValue(s.charAt(left)) < getValue(s.charAt(left+1))){

                int v1 = getValue(s.charAt(left));
                int v2 = getValue(s.charAt(left+1));
                sum = sum + (v2-v1);
                left+=2;
            }else{
                sum += getValue(s.charAt(left));
                left++;
            }
        }

        return sum;
    }

    static int getValue(char c){
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return -1;
    }
}
