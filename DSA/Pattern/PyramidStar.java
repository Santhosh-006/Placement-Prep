public class PyramidStar {
    public static void main(String[] args) {
        int n=7;
        int s;
        int sp;
        for(int i=0 ;i<(n/2)+1 ;i++){
            sp = n-i-1;
            s=(2*i)+1;
            while(sp>0){
                System.out.print(" ");
                sp--;
            }
            while(s>0){
                System.out.print("*");
                s--;
            }
            System.out.println("");
        }
        // int k=0;
        for (int j = n/2 -1; j >= 0; j--) {
            sp = n-j-1;
            // k++;
            s = (2*j) + 1;
            while(sp>0){
                System.out.print(" ");
                sp--;
            }
            while(s>0){
                System.out.print("*");
                s--;
            }
            System.out.println("");

        }
    }
}
