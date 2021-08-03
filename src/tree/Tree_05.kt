package tree

import GetRandomNumbers

fun main() {
    val data = GetRandomNumbers().getNumbers()
    println("Data => $data")

    val tree05 = Tree_05()
    data.forEach {
        tree05.createTree(it)
    }

    tree05.showOrder()
}

private class NodeOfTree05(
    val data: Int = 0,
    var left: NodeOfTree05?,
    var right: NodeOfTree05?
)

private class Tree_05 {
    var root:NodeOfTree05? = null

    fun createTree(data:Int) {
        root = addNode(data, root)
    }

    private fun addNode(data: Int, root: NodeOfTree05?): NodeOfTree05? {
        val newNode = NodeOfTree05(data, null, null)

        if (root == null) {
            return newNode
        }
        else if (root.data < data) {
            root.right = addNode(data, root.right)
            return root
        }
        else if (root.data > data) {
            root.left = addNode(data, root.left)
            return root
        }
        else {
            return root
        }
    }

    fun inOrder(node:NodeOfTree05) {
        node.left?.let { inOrder(it) }
        print("${node.data} ")
        node.right?.let { inOrder(it) }
    }

    fun showOrder() {
        root?.let { inOrder(it) }
    }
}