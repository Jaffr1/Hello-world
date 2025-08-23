import java.util.Stack;

public class StringDecoder {

    public static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // handle multi-digit numbers
            } else if (ch == '[') {
                counts.push(k);
                resultStack.push(current);
                current = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                int repeatTimes = counts.pop();
                StringBuilder temp = resultStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(current);
                }
                current = temp;
            } else {
                current.append(ch);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        String input = "2[ab[c]]";
        System.out.println(decodeString(input)); // Output: abccabcc
    }
}