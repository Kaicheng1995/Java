/**
* SLList 相比 IntList: 两者都是 Singly List，但是前者多了 sentinel，
* 且把IntNode作为 nested class 融入了 SLList。这样能够避免 nullpointererror
* 然后加了很多 addFrist 之类的 method.
*/




public class SLList {

	// nested class, 起辅助创建Node的作用
	public class IntNode {
		public int first;
		public IntNode next;
		public IntNode(int f, IntNode n) {
			first = f;
			next = n;
		}
	}


	// 每个SLList必有的组成部分
	private IntNode sentinel;
	public int size;
	// 只要是一个SLList，它必有这个东西
	public SLList() {
		sentinel = new IntNode(0, null);
		size = 0;
	}
	public SLList(int x) {
		sentinel = new IntNode(0, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}


     
    /* ————————————以下是各个method——————————— */


	// add x to the first (Constant time)
	public void addFirst(int x) {
		sentinel.next = new IntNode(x, sentinel.next);
		size++;
	}

	// get the first item of the list （Constant time)
	public int getFirst() {
		return sentinel.next.first;
	}

	// add x to the last  (Can not use 'this' for iteration)
	public void addLast(int x) {
		IntNode ptr = this.sentinel;
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = new IntNode(x, null);
		size ++;
	}

	// calculate size iteratively
	public int sizeIter() {
		IntNode ptr = this.sentinel;
		int s = 0;
		while(ptr.next != null) {
			ptr = ptr.next;
			s++;
		}
		return s;
	}

	// calculate size recursively (helper function)
	public int helper(IntNode x) {
		if(x.next == null) {return 0;}
		return 1 + helper(x.next);
	}
	// calculate size recursively
	public int sizeRecur() {
		return helper(sentinel);
	}

	// instant time to return size
	public int size() {
		return size;
	}


	public static void main(String[] args) {
		SLList L = new SLList(10);
        L.addFirst(15);                 
        L.addFirst(20);
        L.addLast(30);
        L.addLast(40);
        System.out.println(L.sizeIter());
        System.out.println(L.sizeRecur());
        System.out.println(L.size());
	}

}







