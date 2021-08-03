/**
 * Tree 구현하기
 * 탐색 / 삽입 / 수정 / 삭제
 */
fun main() {
    var nums = arrayListOf(10, 5, 2, 8, 1, 4, 3, 9, 6, 7)

    //기본 Tree 생성
    val tree = Tree()
    nums.forEach {
        tree.createTree(it)
    }

    //전위 순회
    println("전위 순회")
    tree.root?.let { tree.preOrder(it) }

    //후위 순회
    println("\n후위 순회")
    tree.root?.let { tree.postOrder(it) }

    //이진 트리 순회
    println("\n트리 순회(InOrder)")
    tree.printTree()

    //데이터 삽입

    //데이터 수정

    //데이터 삭제
}

private class Node(var data:Int = 0,
                   var left:Node? = null,
                   var right:Node? = null)

private class Tree {
    var root:Node? = null

    private fun insertNode(root: Node?, data: Int): Node? {
        val r = root
        val newNode = Node()
        newNode.data = data

        if (r == null) {
            return newNode
        }
        else if (newNode.data < r.data) {
            r.left = insertNode(r.left, data)
            return r
        }
        else if (newNode.data > r.data) {
            r.right = insertNode(r.right, data)
            return r
        }
        else {
            return r
        }
    }

    fun createTree(data:Int) {
        root = insertNode(root, data)
    }

    //전위 순회
    fun preOrder(node: Node) {
        if (root != null) {
            print(" ${node.data}")
            node.left?.let { preOrder(it) }
            node?.right?.let { preOrder(it) }
        }
    }

    //중위 순회
    fun inOrder(node: Node) {
        root?.let {
            node.left?.let { inOrder(it) }
            print(" ${node.data}")
            node.right?.let { inOrder(it) }
        }
    }

    //후위 순회
    fun postOrder(node: Node) {
        root?.let {
            node?.left?.let { postOrder(it) }
            node?.right?.let { postOrder(it) }
            print(" ${node.data}")
        }
    }

    fun searchTree(data: Int): Node? {
        var r = root
        while (r != null) {
            if (data < r.data) r = r.left
            else if (data > r.data) r = r.right
            else return r
        }

        return r
    }

    fun printTree() {
        root?.let { inOrder(it) }
    }
}