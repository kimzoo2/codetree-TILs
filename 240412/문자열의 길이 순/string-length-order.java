import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for (int i = 0; i <n; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int len = o1.length();
				int len2 = o2.length();
				if(len == len2){
					for (int i = 0; i < len; i++) {
						if(o1.charAt(i) < o2.charAt(i)) return -1;
						else if(o1.charAt(i) > o2.charAt(i)) return 1;
					}
				}
				return len - len2;
			}
		});
		for (String word : arr) {
			System.out.println(word);
		}
	}
}