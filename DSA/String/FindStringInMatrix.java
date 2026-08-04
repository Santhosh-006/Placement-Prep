import java.util.Arrays;

public class FindStringInMatrix {



    public static void main(String[] args) {
        String str = "WELCOMETOZOHOCORPORATION";
        String key = "TOO";

        int col = 5;
        int row = (str.length() + col - 1) / col;

        char[][] mat = new char[row][col];

        int ptr = 0;

        for(int i=0 ; i<row ; i++){
            int j = 0;

            while(ptr < str.length() && j < col){
                mat[i][j] = str.charAt(ptr++);
                j++;
            }
        }

        System.out.println(Arrays.deepToString(mat));

        findString(mat , key);
    }

    static void findString(char[][] mat , String key){
        int row = mat.length;
        int col = mat[0].length;


        for (int i=0 ; i < row ; i++){
            for(int j=0; j<col ; j++){
                if(mat[i][j] == key.charAt(0)){
                    int k = searchHorizontal(mat , i , j , row , col , key);
                    if(k != -1){
                        System.out.println("Start Index:" + i + "," +j);
                        System.out.println("End Index:" + i + "," +k);
                        return;
                    }
                    int m = searchVertical(mat , i , j , row , col , key);
                    if(m != -1){
                        System.out.println("Start Index:" + i + "," +j);
                        System.out.println("End Index:" + m + "," +j);
                        return;
                    }


                }
            }
        }

    }

    static int searchHorizontal(char[][] mat , int i , int j , int row , int col , String key){
        int endIndex = -1;
        int ptr = 0;
        while(j < col && ptr < key.length()){

            if (mat[i][j] == key.charAt(ptr)){
                j++; ptr++;
            }else{
                break;
            }
        }

        if(ptr == key.length()){
            return j-1;
        }

        return endIndex;
    }

    static int searchVertical(char[][] mat , int i , int j , int row , int col , String key){
        int endIndex = -1;
        int ptr = 0;
        while(i < row && ptr < key.length()){

            if (mat[i][j] == key.charAt(ptr)){
                i++; ptr++;
            }else{
                break;
            }
        }

        if(ptr == key.length()){
            return i-1;
        }

        return endIndex;
    }

}
