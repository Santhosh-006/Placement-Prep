public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(convertIntegerToRoman(3000));
    }

    static String convertIntegerToRoman(int num){

        int[] arr = {1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1};
        String[] roman = {"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};
        StringBuilder result = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                while(num>=arr[i]){
                    result.append(roman[i]);
                    num -= arr[i];
                }
            }


        return new String(result);

    }
}
