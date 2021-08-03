package tree

import GetRandomNumbers
import org.w3c.dom.Node

fun main() {
    val PRE_ORDER = 0
    val IN_ORDER = 1
    val POST_ORDER = 2
    val data = GetRandomNumbers().getNumbers()

    println("Data => $data")

    val tree03 = Tree_03()
    data.forEach {
        tree03.createTree03(it)
    }

    tree03.showTree(PRE_ORDER)      //전위 순회
    println()
    tree03.showTree(IN_ORDER)       //중위 순회
    println()
    tree03.showTree(POST_ORDER)     //후위 순회
    println()

    println("찾는 데이터 : 77")
    var result = tree03.search(77)
    if (result) {
        println("77이 Tree에 있습니다.")
    }
    else {
        println("Tree에 찾는 데이터가 없습니다.")
    }
}

private class NodeOfTree03(
    val data: Int,
    var left: NodeOfTree03? = null,
    var right: NodeOfTree03? = null
)

private class Tree_03 {
    var root: NodeOfTree03? = null

    fun createTree03(data: Int) {
        root = addNode(root, data)
    }

    private fun addNode(root: NodeOfTree03?, data: Int): NodeOfTree03? {
        val newNode = NodeOfTree03(data)

        if (root == null) {
            return newNode
        } else if (newNode.data < root.data) {
            root.left = addNode(root.left, data)
            return root
        } else if (newNode.data > root.data) {
            root.right = addNode(root.right, data)
            return root
        } else {
            return root
        }
    }

    fun preOrder(node: NodeOfTree03) {
        print("${node.data} ")
        node.left?.let { preOrder(it) }
        node.right?.let { preOrder(it) }
    }

    fun inOrder(node: NodeOfTree03) {
        node.left?.let { inOrder(it) }
        print("${node.data} ")
        node.right?.let { inOrder(it) }
    }

    fun postOrder(node: NodeOfTree03) {
        node.left?.let { postOrder(it) }
        node.right?.let { postOrder(it) }
        print("${node.data} ")
    }

    fun showTree(typeOfOrder: Int) {
        when (typeOfOrder) {
            PRE_ORDER -> {
                root?.let { preOrder(it) }
            }
            IN_ORDER -> {
                root?.let { inOrder(it) }
            }
            POST_ORDER -> {
                root?.let { postOrder(it) }
            }
        }
    }

    fun search(data: Int): Boolean {
        while (root != null) {
            if (root?.data == data) {
                return true
            }
            else if (data < root?.data!!) {
                root = root?.left
            }
            else {
                root = root?.right
            }
        }

        return false
    }

    companion object {
        val PRE_ORDER = 0
        val IN_ORDER = 1
        val POST_ORDER = 2
    }
}