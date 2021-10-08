// stores a set of value with no duplicates
// has no sense of order
// 不能取数，只能判断数是否存在其中

import java.util.Set;
import java.util.HashSet;

public class RealSet {
	public static void main(String[] args) {
		Set<String> S = new HashSet<>();
		S.add("Tokyo");
		S.add("Beijing");
		S.add("Lagos");
		S.add("New York");
		System.out.println(S.contains("Tokyo"));
		System.out.println(S);
	}
}
