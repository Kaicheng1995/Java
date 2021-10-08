// List in real java code
// similar to python list



import java.util.List;
import java.util.ArrayList;

public class RealList {
	public static void main(String[] args) {
		List<Integer> L = new ArrayList<>();
		L.add(5);
		L.add(10);
		L.add(15);
		System.out.println(L);
		// 类似于python里的list.append
		System.out.println(L.get(0));
	}
}

/** 这样写的话就是print出memory box的地址
*public class RealList {
*	public static void main(String[] args) {
*		SLList x = new SLList(2);
*		x.addFirst(2);
*		System.out.println(x);
*	}
*}
*/