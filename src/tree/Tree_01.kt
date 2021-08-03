/**
 * 트리 구현_01
 */
fun main() {
    val data = GetRandomNumbers().getNumbers()

    println("정렬 전 => $data")

    val tree01 = Tree01()
    var mid = data.size / 2
    tree01.createTree(data[mid])

    for (v in data) {
//        if (v == data[mid]) {
//            continue
//        }
        tree01.createTree(v)
    }

    print("정렬 후 => ")
    tree01.showTree(2)  //중위 순회
    println()
    tree01.showTree(1)  //전위 순회
    println()
    tree01.showTree(3)  //후위 순회

}

private class NodeOfTree01(
    val data: Int,
    var leftNode: NodeOfTree01? = null,
    var rightNode: NodeOfTree01? = null
)

private class Tree01 {
    var root: NodeOfTree01? = null

    fun insertNodeInTree(data: Int, node: NodeOfTree01?): NodeOfTree01 {
        val newNode = NodeOfTree01(data)

        if (node == null) {
            return newNode
        } else if (newNode.data < node.data) {
            node.leftNode = insertNodeInTree(data, node.leftNode)
            return node
        } else if (newNode.data > node.data) {
            node.rightNode = insertNodeInTree(data, node.rightNode)
            return node
        } else {
            //값이 같은 경우
            return node
        }
    }

    fun createTree(data: Int) {
        root = insertNodeInTree(data, root)
    }

    private fun inOrder(node: NodeOfTree01) {
        node.leftNode?.let { left -> inOrder(left) }
        print("${node.data} ")
        node.rightNode?.let { right -> inOrder(right) }
    }

    private fun preOrder(node: NodeOfTree01) {
        print("${node.data} ")
        node.leftNode?.let { preOrder(it) }
        node.rightNode?.let { preOrder(it) }
    }

    private fun postOrder(node: NodeOfTree01) {
        node.leftNode?.let { postOrder(it) }
        node.rightNode?.let { postOrder(it) }
        print("${node.data} ")
    }

    fun showTree(typeOfOrder: Int) {
        when (typeOfOrder) {
            1 -> {
                root?.let {
                    preOrder(it)
                }
            }
            2 -> {
                root?.let {
                    inOrder(it)
                }
            }
            3 -> {
                root?.let {
                    postOrder(it)
                }
            }
        }
    }
}