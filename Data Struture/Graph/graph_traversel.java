/** Graph
* 1. 一个包含nodes的集合
* 2. 去掉了两个node仅一条路径的限制
* 3. 一个node存在大于、等于0条数量的边
* 4. 所有 Tree 都属于 Gragh。（如果有cycle 或者有 disconnected nodes，都不是tree）
* 
* Graph Traversals: DFS PreOrder, DFS PostOrder, BFS (LevelOrder)
* Graph Implementation: Adjacency List（最优）
* Graph with adjacency list's printing Runtime: theta(V+E)  V是顶点数，E是edge数
*
*/


顶点 vertices (nodes)
边 edges
权重 lables （weight）
路径 path
相连 connected （两点之间存在一个path）
圆圈 cycle （存在首位相同的一条路径）


// 常见问题
1. st-connectivity： 是否s-t之间存在一条路径？
// 方法：依次往下找，标记找过的vertices，避免回溯导致infinite loop
isconnected(s, t) {
    mark s;
    if (s == t) return true
    for (child : unmarked_neighbors(s)) {
        if isconnected(child, t) {
            return true
        }
    }
    return false
}

2.1. DepthFitstPaths（DFS):  找到顶点 s 到其它每个 vertice 的路径
// 方法一： DFS - PreOrder
dfs(v):
    mark v;
    for each unmarked adjacent vertice w
        // [核心！！！！]：DFS PreOrder: Action is before DFS calls to neighbors
        set edgeTo[w] = v
        dfs(w)

// 方法二： DFS - PostOrder
dfs(v):
    mark v;
    for each unmarked adjacent vertice w
        dfs(w)
        // [核心！！！！]：DFS PostOrder: Action is after DFS calls to neighbors
        set edgeTo[w] = v


2.2. BreadthFirstPaths(BFS): 找到顶点 s 到其他每个 vertice 的最短路径
initialize a queue with a starting vertex S and mark S
REPEAT: (until queue is empty)
    remove vertex V from the front of the queue
    For each unmarked neighbor N of V：
        mark N
        // distTo 是用来计算最短距离的（！！！btw这里没有算edge权重）
        set edgeTo[N] = V and distTo[N] = distTo[V] + 1
        add N to end of queue












/** Tree
* 1. 一个包含nodes的集合
* 2. nodes之间相互连接，且两个nodes之间只能有一条路径
*
* Tree Traversals: LevelOrder, PreOrder, InOrder, PostOrder

/** RootedTree
* 1. 第一个node是root, 除它之外每个node都有一个parent
* 2. 没有孩子的node成为leaf，叶子
*/


/**************  Tree Traversals **************/
// Level Order : 一层一层地，从左往右数
LevelOrder, aka BFS Order
Breadth First Search


// Depth First Traversals

// 1. Preorder 先左后右 （应用：例如文件夹的自然排序）
PreOrder(BSTNode x) {
    if (x == null) return;
    // [核心！！！！]：DFS PreOrder: Action is before DFS calls to neighbors
    System.out.println(x.key);
    PreOrder(x.left);
    PreOrder(x.right);
}

// 2. Inorder 先到左底，再回溯，再到右底
InOrder(BSTNode x) {
    if (x == null) return;
    InOrder(x.left);
    System.out.println(x.key);
    InOrder(x.right)
}

// 3. PostOrder 先到左底，再回溯，再到右底，最后root （应用：例如计算文件夹大小）
PostOrder(BSTNode x) {
    if (x == null) return;
    PostOrder(x.left);
    PostOrder(x.right);
    // [核心！！！！]：DFS PostOrder: Action is after DFS calls to neighbors
    System.out.println(x.key);
} 