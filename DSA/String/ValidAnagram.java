public class ValidAnagram {
    public static void main(String[] args) {
        boolean out = isValidAnagram("silent" , "lisaen");

        System.out.println(out);
    }


    static boolean isValidAnagram(String s1 , String s2){

        if(s1.length() != s2.length()){
            return false;
        }

        int[] freq = new int[26];
        s1 = s1.toUpperCase();
        s2 = s2.toUpperCase();

        for (int i = 0; i < s1.length(); i++) {
            int ch1 = s1.charAt(i) - 'A';
            int ch2 = s2.charAt(i) - 'A';
            freq[ch1]++;
            freq[ch2]--;
        }
        for(int num : freq){
            if(num != 0){
                return false;
            }
        }

        return true;
    }
}
