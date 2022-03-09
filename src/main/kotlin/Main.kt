/**
 * change the enum value of algorithm to see different algorithm logs
 */
fun main(args: Array<String>) {

    val algorithm: Algorithm = Algorithm.DFS

    val tree = if (algorithm == Algorithm.DFS) DFSBinaryTree()
    else BFSBinaryTree()

    tree.apply {
        tree.populateTree()

        println("--------------- TRAVERSAL ---------------")
        search(9)
        search(3)
        search(1)
        search(22)
        println()

        println("--------------- TREE SIZE ---------------")
        println("Total Size: $size")
    }
}

enum class Algorithm {
    DFS, BFS
}