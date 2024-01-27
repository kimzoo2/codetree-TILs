import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);

		int ans = 0;
		for (int i = x; i <= y; i++) {
			int num = i;
			int len = String.valueOf(num).length();
			Map<Integer, Integer> map = new HashMap<>();

			for (int j = 0; j < len; j++) {
				int key = num % 10;
				map.put(key, map.getOrDefault(key, 0)+1);
				num /= 10;
			}
			int size = map.size();
			if(size != 2) continue;

			for (Integer key : map.keySet())
				if (map.get(key) == 1) ans++;
		}

		System.out.println(ans);
    }
}