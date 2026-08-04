import java.util.Stack;

public class UnbalancedParenthesis {

    public static void main(String[] args) {

        System.out.println(removeUsingParsing("((abc)((de))"));
        System.out.println(removeUsingStack("((abc)((de))"));
    }

    static String removeUsingStack(String str){

        boolean[] removed = new boolean[str.length()];
        Stack<Integer> stack = new Stack<>();

        for (int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == '('){
                stack.push(i);
            } else if (str.charAt(i) == ')') {
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    removed[i] = true;
                }
            }
        }

        while(!stack.isEmpty()){
            removed[stack.pop()] = true;
        }

        StringBuilder out = new StringBuilder();

        for(int i = 0 ; i<str.length();i++){
            if(!removed[i]){
                out.append(str.charAt(i));
            }
        }

        return new String(out);
    }

    static String removeUsingParsing(String str){

        int open = 0;
        StringBuilder out = new StringBuilder(str);

        for(int i = 0 ; i<str.length();i++){
            if(str.charAt(i) == '('){
                open++;
            } else if (str.charAt(i) == ')') {
                if (open > 0){
                    open--;
                }else{
                    out.deleteCharAt(i);
                }
            }
        }

        for(int j=str.length()-1 ; j>=0 ; j--){
            if (str.charAt(j) == '(' && open > 0){
                out.deleteCharAt(j);
                open--;
            }
        }

        return new String(out);

    }

}
