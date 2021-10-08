// 任务是创造一个连接和确认连接的借口：

public interface DisjointSets {
	void connect(int p, int q);

	boolean isConnected(int p, int q);
}



/**
* 方法五：Path Compression
* 在方法四的基础上，把需要判断isConnected()两点的其线上的所有点都与root相连
*
*/


/**
* 方法四：Weighted QuickUnionDS: (List of Integers)
* 在方法三的基础上，把List中的每一个元素改成上一级元素的值, 连接时找根部之间连接，顺序重要
* 
* 注意：Track tree size， always link root of smaller tree to larger tree
* （这里的大小是指树的weight，不是height！！）
* QuickUnion's runtimes are O(H), and WeightedQuickUnionDS height is given by H=O(logN)
* 
* 代码实现：
* 1.仅改动connect(), 需要track size 来判断连接顺序
* 2.可以把root的-1值改成储存实时计算size的值，或者单独创建一个 size array
* 3.connect()和isConnected()都是 O(logN).
*
*/



_______________________________
方法对比： QuickFindDS vs QuickUnionDS

QuickFindDS 很慢，连接需要 theta(n)，确认是否连接为 theta(1)
QuickUnionDS 综合表现更快，连接和确认连接都是 O(n)，但在树很长，左右不均的时候可能表现更差
_______________________________

/**
* 方法三：QuickUnionDS: (List of Integers)
* 把List中的每一个元素改成上一级元素的值, 连接时找根部之间连接，顺序不重要
*/

public class QuickUnionDS implements DisjointSets {
	private int[] parent;  //每个parent就代表上一位，或者叫上一级元素

	public QuickFindDS(int N) { //构造器
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = -1;   // 每个集合的root的上一级，都用 -1 来表示
		}
	}

	public int Root(int p) {   //找到某个元素的根部元素
		int r = p;
		while (parent[r] > 0) {
			r = parent[r];
		}
		return r;
	}

	public boolean isConnected(int p, int q) { //O(n)
		return Root(p) == Root(q);
	}

	public void connect(int p, int q) { //O(n)
		parent[Root(p)] = Root(q); //quickFindDS 并不在乎顺序
	}
}


/**
* 方法二：QuickFindDS: (List of Integers)
* only record the sets that each item belongs to, much easier!
* 注意：item之间具体是怎么关联的无法知道，但我们知道他们是否关键（即使间接关联）
*/

public class QuickFindDS implements DisjointSets {
	private int[] id;  //每个id就代表属于哪个集合

	public QuickFindDS(int N) { //构造器
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public boolean isConnected(int p, int q) { //theta(1)
		return id[p] == id[q];
	}

	public void connect(int p, int q) { //theta(n)
		int pid = id[p];
		int qid = id[q];
		for (i = 0; i < id.length; i++) {
			if (id[i] = pid) {
				id[i] = qid;
			}
		}
	}
}


/**
* 方法一：Naive Approach: (ListOfSetsDS) 也就是 List<Set<Integers>>
* Connecting 2 things and record the correctedness in * some data * structure, and do some iteration to check it
*/


