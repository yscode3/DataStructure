package tree

import GetRandomNumbers

fun main() {
    val data = GetRandomNumbers().getNumbers()
    val tree04 = Tree_04()

    println("Data => $data")

    data.forEach {
        tree04.createTree(it)
    }

    tree04.showOrder(0)
    println()
    tree04.showOrder(1)
    println()
    tree04.showOrder(2)
    println()
}

private class NodeOfTree04(
    val data: Int = 0,
    var left: NodeOfTree04? = null,
    var right: NodeOfTree04? = null
)

private class Tree_04 {
    var root: NodeOfTree04? = null

    fun createTree(data: Int) {
        root = addNode(data, root)
    }

    private fun addNode(data: Int, root: NodeOfTree04?): NodeOfTree04? {
        val newNode = NodeOfTree04(data)

        if (root == null) {
            return newNode
        } else if (root.data < newNode.data) {
            root.right = addNode(data, root.right)
            return root
        } else if (root.data > newNode.data) {
            root.left = addNode(data, root.left)
            return root
        } else {
            return root
        }
    }

    fun preOrder(node: NodeOfTree04) {
        print("${node.data} ")
        node.left?.let { preOrder(it) }
        node.right?.let { preOrder(it) }
    }

    fun inOrder(node: NodeOfTree04) {
        node.left?.let { inOrder(it) }
        print("${node.data} ")
        node.right?.let { inOrder(it) }
    }

    fun postOrder(node: NodeOfTree04) {
        node.left?.let { postOrder(it) }
        node.right?.let { postOrder(it) }
        print("${node.data} ")
    }

    fun showOrder(type: Int) {
        when (type) {
            0 -> {
                root?.let { preOrder(it) }
            }
            1 -> {
                root?.let { inOrder(it) }
            }
            2 -> {
                root?.let { postOrder(it) }
            }
        }
    }
}