
import java.util.Stack;

public class EncodeString {

    public static void main(String[] args) {
        String s = "3[a2[c]]";

        Stack<String> stack = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder();
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else if (ch == ']') {
                while (!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))) {
                    str.append(stack.pop());
                }
                str.reverse();
                int k = Integer.parseInt(stack.pop());
                while (k > 0) {
                    output.append(str);
                    k--;
                }
            }
        }

        System.out.println(output);
    }
}
