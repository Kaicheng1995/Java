public class DLList {

	// nested class, basic item
	public class IntNode {
		public IntNode prev;
		public int val;
		public IntNode next;
		public IntNode(IntNode p, int v, IntNode n) {
			prev = p;
			val = v;
			next = n;
		}	
	}

	// create DLList and constructor
	IntNode sentinel;
	int size;
	public DLList() {
		sentinel = new IntNode(null, 0, null);
		sentinel.prev = sentinel;
		sentinel.next = sentinel;
		size = 0;
	}


	/* ——————————— Methods ———————————— */
	public void addLast(int x) {
		IntNode n = new IntNode(sentinel.prev, x, sentinel);
		sentinel.prev = n;
		sentinel.prev.prev.next = n;
		size++;
	}

	public void addFirst(int x) {
		IntNode n = new IntNode(sentinel, x, sentinel.next);
		sentinel.next = n;
		sentinel.next.next.prev = n;
		size++;
	}

	public boolean isEmpty() {
		if(size == 0) {return true;}
		return false;
	}

	public int Size() {
		return size;
	}

	public void printDeque() {
		IntNode ptr = this.sentinel.next;
		while(ptr != sentinel) {
			System.out.println(ptr.val);
			ptr = ptr.next;
		}
	}

	// remove and return the removed value
	public int removeFirst() {
		if(Size() == 0) {return sentinel.val;}
		int r = sentinel.next.val;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return r;
	}

	public int removeLast() {
		if(Size() == 0) {return sentinel.val;}
		int r = sentinel.prev.val;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size--;
		return r;
	}

	// get the “index”th value
	public int getIter(int index) {
		IntNode ptr = sentinel;
		for(int i = 0; i < index; i++) {
			ptr = ptr.next;
		}
		return ptr.val;
	}

	// 必须使用一个helper method，因为recur的本体是DLList，不能用Node
	public int getRecur(int index, IntNode ptr) {
		// IntNode ptr = sentinel.next;
		if(index == 1) {return ptr.val;}
		else {
			ptr = ptr.next;
			return getRecur(index - 1, ptr);
		}
	}
	public int getRecur(int index) {
		return getRecur(index, sentinel.next);
	}



	public static void main(String[] args){
		DLList L = new DLList();
        L.addFirst(10);
        L.addFirst(20);
        L.addFirst(30);
        L.addFirst(40);
        L.addLast(5);
        L.addLast(4);
        L.removeFirst();
        L.removeLast();
        L.printDeque();

        System.out.println("get result is: " + L.getIter(2));
        System.out.println("get result is: " + L.getRecur(2));
    }

}