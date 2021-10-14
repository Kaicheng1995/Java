import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;



public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
	private Node<K, V> root;
	private int size;


	// Map二叉树的成分，每一个Node都是一个Map，和左右Node
	private class Node<K, V> {
		K key;
		V value;
		Node<K, V> left;  //这里是有pointer指向memory box的
		Node<K, V> right;

		Node(K k, V v) {
			key = k;
			value = v;
		}
	}

	/** Removes all of the mappings from this map. */
	@Override
	public void clear() {
		root = null;
		size = 0;
	}


	/* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key. */
	@Override
    public V get(K key) {
    	if (key == null) {throw new IllegalArgumentException();}
    	return get(key, root);
    }

    // 在给定的一个TreeMap中找到对应key的值, 这是一个 helper fuction, 不会主动使用
    private V get(K key, Node<K, V> node) {
    	if (node == null) {return null;}
    	if (key.compareTo(node.key) == 0) {return node.value;}
    	else if (key.compareTo(node.key) < 0) {return get(key, node.left);}
    	else {return get(key, node.right);}
    }


	/* Returns true if this map contains a mapping for the specified key. */
	@Override
    public boolean containsKey(K key) {
    	if (key == null) {throw new IllegalArgumentException();}
    	return get(key) != null;
    }


    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size() {
    	return size;
    }


    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value) {
    	if (key == null) {throw new IllegalArgumentException();}
    	if (value == null) {remove(key);}   // 设置其值为null，大概就是把node删掉的意思了
    	root = put(key, value, root);
    }


    // 在给定的一个TreeMap中找到对应的key, 并将值设定为value。
    // 如果没有找到key，就在增加一个新的Node。这里的recursion就是依次在往下寻找。这是一个 helper fuction, 不会主动使用
    private Node<K, V> put(K key, V value, Node<K, V> node) {
    	if (node == null) {
    		return new Node<>(key, value);
    		size++;
    	}
    	if (key.compareTo(node.key) == 0) {
    		node.value = value;
    	} else if (key.compareTo(node.key) < 0) {
    		node.left = put(key, value, node.left);     //从左边往下去寻找key，并修改其值
    	} else {
    		node.right = put(key, value, node.right);   //从右边往下去寻找key，并修改其值
    	}
    	return node;     //return出已经修改过值的node
    }



    /* Returns a Set view of the keys contained in this map. */
    public Set<K> keySet() {
		return keySet(root, new HashSet<>());
    }

    /** Recursively add all keys in subtree Node to keySet. */
    private Set<K> keySet(Node<K, V> node, Set<K> s) {
    	if (node == null) {
    		return s;
    	}
    	s = keySet(node.left, s);
    	s.add(node.key);
    	s = keySet(node.right, s);
    	return s;    //这个方法还挺有疑问的，tree的遍历有问题
    }


    /* Removes the mapping for the specified key from this map if present.
    * 不会
    */
    @Override
    public V remove(K key) {
    	throw new UnsupportedOperationException();
    }
    @Override
    public V remove(K key, V value) {
    	throw new UnsupportedOperationException();
    }

















}