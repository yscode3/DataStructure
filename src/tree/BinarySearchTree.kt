import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.util.*

/**
 * 이진 탐색 트리
 * '왼쪽 값 < 루트 < 오른쪽 값' 의 형태로 트리를 구성
 * 데이터 탐색 / 삽입 / 수정 / 삭제 구현
 */
fun main() {
//    var arrNums = arrayListOf(8, 3, 2, 5, 10, 14, 11, 17)

    val bst = BST()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val case = br.readLine().toInt()

//    for (c in 0 until 2) {
        var num = br.readLine().split(" ").map { it.toInt() }

        for (n in num) {
            bst.root?.let { bst.createTree(n) }
        }
//    }

    bst.root?.let { bst.preOrder(it) }
}

private class BSTNode(
    var data:Int = 0,
    var left:BSTNode? = null,
    var right:BSTNode? = null
)

private class BST {
    var root:BSTNode? = null

    fun createTree(data: Int) {
        root = insertNode(data, root)
    }

    private fun insertNode(data: Int, root: BSTNode?): BSTNode? {
        val r = root
        val newNode = BSTNode(data)

        if (r == null) {
            return newNode
        }
        else if (r.data < data) {
            r.right = insertNode(data, r.right)
            return r
        }
        else if (r.data > data) {
            r.left = insertNode(data, r.left)
            return r
        }
        else {
            return r
        }
    }

    fun preOrder(node: BSTNode) {
        if (node != null) {
            println(node.data)
            node?.left?.let { preOrder(it) }
            node?.right?.let { preOrder(it) }
        }
    }
}