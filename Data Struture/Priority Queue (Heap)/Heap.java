

heap 的本质
————————————
1、是一个 完全二叉树（complete binary tree)
2、父节点比子节点大/小
[完全二叉树]: 
除了最后一排，其余节点都有2个孩子。
且添加时最后一排单必须往左往右填满，
删除时从右往左删除


heap  .add()
————————————
从左往右填，minheap把小的往上置换，maxheap反之


heap Delete min/max  .removeSmallest()
————————————
从右往左选中，与root置换，删掉root，再把新的root往下置换



PQ和heap的关系？
————————————
heap是一种 实现 priority queue的方式.
它还有其他方式可以实现，例如 orderedArray, 但是复杂太高 O(N)
纯排序的array在删除和添加新元素时，需要重新创建全新的array
而使用heap（用array实现比较简单），复杂度就很低 O(logN)，只是偶尔index满了之后需要新建
一般情况下只需要在元素之间swap，移动位置就行了。


什么是PQ？
————————————
有 MinPQ 和 MaxPQ
A priority queue is a special type of queue in which each element is associated with a priority value. 
And, elements are served on the basis of their priority.


今天：minheap 代码写了，做priority queue的题
明天: TreeMap复习, 今天：HashMap 做起来，做下Tree的题
next：图，BFS, DFS搞起来
