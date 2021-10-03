public class ArrayDeque<T> {

	public T[] item;
	public int front;
	public int back;
	public int size;
	public static double Wasteline = 0.25;

	public ArrayDeque() {
		item = (T[]) new Object[8];
		front = 0;  //初始位置，随机设的，是虚拟值，不占空间
		back = 1;   //初始位置，随机设的，是虚拟值，不占空间
		size = 0;
	}

	public boolean isFull() {
		return size == item.length;
	}

	public boolean isWaste() {
		return item.length >= 16 &&
			   size/item.length <= Wasteline;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	//相对于两个sentinel的增加，占据front位置，front向前移动
	public void addFirst(T x) {
		if(isFull()) {return resize(item.length * 2);}
		item[front] = x;
		front = (front - 1 + item.length) % item.length; //往前缩减一格子，有可能变成负数了，所以要加上长度再除以长度得到余数
		size++; 
	}

	public void addLast(T x) {
		if(isFull()) {return resize(item.length * 2);}
		item[next] = x;
		next = (next + 1) % item.length;
		size++;
	}

	public T RemoveFirst() {
		T removed = item[NextOne(front)];
		front = NextOne(front);
		if(!isEmpty()) {size--;}  //防止已经是空的情况下，front和back重合，size变成负数
		if(isWaste()) {resize(item.length * 2);} // 感觉应该是去掉之后再resize，而添加是在添加之前就需要resize
		return removed;
	}

	public T RemoveLast() {
		T removed = item[PrevOne(back)];
		back = PrevOne(back);
		if(!isEmpty()) {size--;}
		if(isWaste()) {resize(item.length / 2);}
		return removed;
	}

	public int size() {
		return size;
	}

	public T get(int k) {
		if(k > size) {return null;}
		int position = NextOne(k + front - 1);
		return item[position]; 
	}

	// 这个有点难。。。
	public void resize(int capacity) {
		T[] resized = (T[]) new Object[capacity];
		// 不能用arraycopy，因为会到头。
		int oldindex = NextOne(front);
		for(int newindex = 0; newindex < size; newindex++) {
			resized[newindex] = item[oldindex];
			oldindex = NextOne[oldindex];
		}
		item = resized;  //连上新的array
		front = capacity - 1; //这一步非常重要！！新的array要重置sentinel的位置
		back = size; 
	}

	


	// 实在有些繁琐，这里加上NextOne 和 PrevOne 方法
	public int NextOne(int n) {
		int x = (n + 1) % item.lenth;
		return x;
	}
	public int PrevOne(int n) {
		int x = (n - 1 + item.length) % item.lenth;
		return x;
	}

	public void printDeque() {
		// 从第一有效位开始遍历
		int i = NextOne(front);
		while(i < back) {
			System.out.println(item[i] + ' ') {
				i = NextOne(i);
			}
		}
	}


	public static void main(String args[]){
        ArrayDeque<Integer> test = new ArrayDeque<>();

        test.addLast(10);
        test.addLast(20);
        test.addFirst(5);
        test.addFirst(4);
        test.addFirst(3);
        test.addLast(10);
        test.addLast(20);
        test.addFirst(5);
        test.addFirst(4);
        test.addFirst(3);
        test.addLast(10);
        test.addLast(20);
        test.addFirst(5);
        test.addFirst(4);
        test.addFirst(3);
        test.removeFirst();
        test.removeLast();

        System.out.println(test.get(2));
        System.out.println(test.size());

        ArrayDeque<Integer> copy = new ArrayDeque<>(test);

        System.out.println(copy.get(2));
        System.out.println(test.size());
    }

}







