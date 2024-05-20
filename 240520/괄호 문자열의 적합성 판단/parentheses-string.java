import java.io.*;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();
		boolean ans = true;

		for (char c : str.toCharArray()) {
			if(c == '(') stack.push(c);
			if(c == ')'){
				if(stack.isEmpty()) {
					ans = false;
					break;
				}else {
					stack.pop();
				}
			}
		}

		if(!stack.isEmpty()) ans = false;
		System.out.println(ans ? "Yes" : "No");
    }
}