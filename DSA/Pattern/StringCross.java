public class StringCross {

    static void Xpattern(String s) {

// P               E 
//   R           M   
//     O       M     
//       G   A       
//         R         
//       G   A       
//     O       M     
//   R           M   
// P               E 


        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j || j == s.length() - i - 1) {
                    System.out.print(s.charAt(j) + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "PROGRAMME";
        Xpattern(s);
    }
}
