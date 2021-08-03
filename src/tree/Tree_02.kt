package tree

import GetRandomNumbers

fun main() {
    val data = GetRandomNumbers().getNumbers()
    val tree02 = Tree02()

    println("Data => ${data.sorted()}")

    data.forEach {
        tree02.createTree(it)
    }

    tree02.showTree()
}

private class NodeOfTree02(
    var data: Int,
    var left: NodeOfTree02? = null,
    var right: NodeOfTree02? = null
)

private class Tree02 {
    var root: NodeOfTree02? = null

    fun createTree(data: Int) {
        root = addNode(root, data)
    }

    private fun addNode(node: NodeOfTree02?, data: Int): NodeOfTree02? {
        val newNode = NodeOfTree02(data)

        if (node == null) {
            return newNode
        } else if (data < node.data) {
            node.left = addNode(node.left, data)
            return node
        } else if (data > node.data) {
            node.right = addNode(node.right, data)
            return node
        } else {
            return node
        }
    }

    fun inOrder(node: NodeOfTree02) {
        node.left?.let { left -> inOrder(left) }
        print("${node.data} ")
        node.right?.let { right -> inOrder(right) }
    }

    fun showTree() {
        root?.let { inOrder(it) }
    }
}