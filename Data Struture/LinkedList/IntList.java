public class IntList {
	public int first;
	public IntList next;

	public IntList(int f, IntList n) {
		first = f;
		next = n;
	}

	public int sizeRecur() {
		if(next == null) {return 1;}   
		else {return 1 + next.size();}
	}

	public int sizeIter() {
		IntList ptr = this;
		int s = 0;
		while(ptr != null) {
			ptr = ptr.next;
			s++;
		}
		return s;
	}

	public int getIter(int i) {
		IntList ptr = this;
		int count = 1;
		while(count < i) {
			ptr = ptr.next;
			count++;
		}
		return ptr.first;
	}

	public int getRecur(int i) {
		if(i == 1) {return first;}
		return next.getRecur(i - 1);
	}


	// 在原链表上修改
	public static void dSqareList(IntList l) {
		while(l != null) {
			l.first = l.first * l.first;
			l = l.next;
		}
	}

	// 迭代返回一个新链表, 因为有return值，所以需要checknull, 这里需要给square一个pointer，因为要保持它始终指向第一个
	public static IntList Iter(IntList l) {
		if(l == null) {return null;}

		IntList squared = new IntList(l.first * l.first, null);
		IntList ptr = squared;

		while(l.next != null) {
			ptr.next = new IntList(l.next.first * l.next.first, null);
			l = l.next;
			ptr = ptr.next;
		}
		return squared;
	}

	// 递归返回一个新链表，一个初始值和一个方法引用循环
	public static IntList Recur(IntList l) {
		if(l == null) {return null;}
		else{
			return new IntList(l.first * l.first, Recur(l.next));
		}
	}

	public static IntList Dcatenate(IntList A, IntList B) { 
		if(A == null) {return B;}
		IntList ptr = A;
		while(ptr.next != null) {
			ptr = ptr.next;
		}
		ptr.next = B;
		return A;
	}

	// 这样是可以的，return B的值会返还到next上将B连起来。
	public static IntList Catenate(IntList A, IntList B) {
		if(A == null) {return B;}
		else {
			return new IntList(A.first, Catenate(A.next, B));
		}
	}



	public static void main(String[] args) {
		IntList test1 = new IntList(1, null);
		test1 = new IntList(2, test1);
		test1 = new IntList(3, test1);
		test1 = new IntList(4, test1);
		test1 = new IntList(5, test1);
      
        IntList test2 = new IntList(5, null);
		test2 = new IntList(6, test2);
		test2 = new IntList(7, test2);
		test2 = new IntList(9, test2);
		test2 = new IntList(10, test2);
      
		IntList k = Iter(test1);
        IntList t = Recur(test2);
      
        IntList z = Catenate(k, t);     
        IntList o = Dcatenate(k, t);

        int size1 = k.sizeRecur();
        int size2 = k.sizeIter(); 

        System.out.println(test1.getIter[1]);
        System.out.println(test2.getRecur[3]);
	}
}