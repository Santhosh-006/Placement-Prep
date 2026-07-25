public class HollowPyramid {

    static void hollowTriangle(int n){
// * 
// * * 
// *   * 
// *     * 
// * * * * * 

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){

                if(i==n || j==1 || i==j){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }

    static void hollowPyramid(int n){
//         * 
//       *   * 
//     *       * 
//   *           * 
// * * * * * * * * * 

        for(int i=1;i<=n;i++){

            for(int k=1;k<=(n-i);k++){
                System.out.print("  ");
            }

            for(int j=1;j<=(2*i-1);j++){

                if(i==n || j==1 || j==(2*i-1)){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }


    static void hollowSandGlass(int n){
        for(int i=n;i>=1;i--){

            for(int k=1;k<=(n-i);k++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){

                if(i==n || j==1 || j==i){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        for(int i=2;i<=n;i++){

            for(int k=1;k<=(n-i);k++){
                System.out.print(" ");
            }

            for(int j=1;j<=i;j++){

                if(i==n || j==1 || j==i){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
    }


    static void rightTriangle(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i+j>n){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        // hollowTriangle(5);
        // hollowPyramid(5);
        // hollowSandGlass(5);
        rightTriangle(5);
    }
}
