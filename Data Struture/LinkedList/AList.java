public class AList<T> {

	public T[] item;
	public int size;

	public AList(){
		item = (T[]) new Object[100];
		size = 0;
	}



    // 用arraycopy来新建一个新的array
	public void resize(int capacity) {
		T[] resized = (T[]) new Object[capacity];
		System.arraycopy(this.item, 0, resized, 0, size);
        item = resized;
	}

	public void addLast(T x) {
		if(size == item.length) {resize(size + 1);}
		item[size] = x;
		size++;
	}

	public T getLast() {
		return item[size - 1];
	}

	public T get(int x) {
		return item[x - 1];
	}

	public T removeLast() {
		T removed = item[size - 1];
        item[size - 1] = null;
		size--;
        return removed;
	}


	public static void main(String[] args) {
		AList<Integer> x = new AList<>();
		x.addLast(3);
		x.addLast(4);
		x.addLast(5);
        x.removeLast();
        x.resize(10);
		System.out.println(x.get(1));

	}

}