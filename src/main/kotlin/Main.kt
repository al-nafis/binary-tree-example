import BinaryTree.Algorithm

fun main(args: Array<String>) {
    populateTree().apply {

        println("--------------- DFS TRAVERSAL ---------------")
        searchUserDfs(9)
        searchUserDfs(3)
        searchUserDfs(1)
        searchUserDfs(22)
        println()


        println("--------------- BFS TRAVERSAL ---------------")
        searchUserBfs(9)
        searchUserBfs(3)
        searchUserBfs(1)
        searchUserBfs(22)
        println()


        println("--------------- TREE SIZE ---------------")
        println("Total Size: $size")
    }
}

fun populateTree(): BinaryTree = BinaryTree(Algorithm.DFS).apply {
    println("--------------- ADDING USERS ---------------")
    add(User(10, "John"))
    add(User(5, "Ron"))
    add(User(5, "Ron")) // duplicate not allowed
    add(User(1, "Shawn"))
    add(User(9, "Don"))
    add(User(22, "Pawn"))
    add(User(12, "Vaughn"))
    add(User(30, "Yawn"))

// tree look
//          |------ 10 ------|
//      |-- 5 --|        |-- 22 --|
//      1       9       12        30
}

data class User(val id: Int, val name: String)

data class Node(var value: User, var left: Node? = null, var right: Node? = null)

/**
 * Binary Tree
 * Sorted by UserIds (Left Node < Parent Node < Right Node)
 * Does not allow duplicate Ids
 * Searches by Id
 */
class BinaryTree(private val algorithm: Algorithm, private var root: Node? = null) {

    enum class Algorithm {
        BFS, DFS
    }

    var size: Int = 0

    /**
     * Adding user based on the Algorithm style
     */
    fun add(user: User) {
        if (algorithm == Algorithm.DFS) {
            addUserDFS(user)
        } else {
            adduserBFS(user)
        }
    }

    private fun addUserDFS(user: User) {
        println("Trying to add: " + user.id)
        root?.let {
            println("Root")
            root = addUserDFSRecursive(user, it)
        } ?: run {
            size++
            root = Node(user)
            println("add successful: " + user.id + " is the root")
            println()
            println()
        }
    }

    private fun addUserDFSRecursive(user: User, parent: Node?): Node {
        parent?.let {
            println(it.value.id)
            if (it.value.id == user.id) {
                println("add failed: Duplicate Id")
                println()
                println()
                return it
            } else if (it.value.id > user.id) {
                println("Going Left")
                it.left = addUserDFSRecursive(user, it.left)
            } else {
                println("Going Right")
                it.right = addUserDFSRecursive(user, it.right)
            }
            return it
        } ?: run {
            size++
            println("add successful")
            println()
            println()
            return Node(user)
        }
    }

    private fun adduserBFS(user: User) {
        println("Trying to add: " + user.id)
        root?.let {
            println("Root")
            root = addUserBFSRecursive(user, it)
        } ?: run {
            size++
            root = Node(user)
            println("add successful: " + user.id + " is the root")
            println()
            println()
        }
    }

    private fun addUserBFSRecursive(user: User, parent: Node?): Node {
//        parent?.let {
//        val list = mutableListOf<Node>()
//        it.left?.let { left ->
//            if (left.value.id == user.id) {
//
//            }
//        } ?: run {
//            it.left = addUserBFSRecursive(user, it.left)
//        }
//
//        } ?: run {
//            size++
//            println("add successful")
//            println()
//            println()
//            return Node(user)
//        }
        TODO()
    }

    fun remove(id: Int) {

    }

    fun searchUserBfs(id: Int): User? {
        println("Trying to find User id: $id")
        root?.let {
            return if (it.value.id == id) it.value
            else searchUserBfsRecursive(id, listOf(it))
        } ?: run {
            println("User does not exist")
            println()
            return null
        }
    }

    private fun searchUserBfsRecursive(id: Int, nodes: List<Node?>): User? {
        val list = mutableListOf<Node?>()
        nodes.forEach { node ->
            node?.let {
                if (it.value.id == id) {
                    println("User found: " + it.value.toString())
                    println()
                    return it.value
                } else {
                    it.left?.let { left -> list.add(left) }
                    it.right?.let { right -> list.add(right) }
                }
            }
        }

        return if (list.isEmpty()) {
            println("User does not exist")
            println()
            null
        } else {
            list.forEach {
                print(it?.value?.id)
                print(" ")
            }
            println()
            searchUserBfsRecursive(id, list)
        }
    }

    fun searchUserDfs(id: Int): User? {
        println("Trying to find User id: $id")
        root?.let {
            return searchUserDfsRecursive(id, root)
        } ?: run {
            println("User does not exist")
            println()
            return null
        }
    }

    private fun searchUserDfsRecursive(id: Int, parent: Node?): User? {
        parent?.let {
            println(it.value.id)
            return if (it.value.id == id) {
                println("User found: " + it.value.toString())
                println()
                it.value
            } else if (it.value.id > id) {
                println("Going Left")
                searchUserDfsRecursive(id, it.left)
            } else {
                println("Going Right")
                searchUserDfsRecursive(id, it.right)
            }
        } ?: run {
            println("User does not exist")
            println()
            return null
        }
    }

    fun printNames(style: Algorithm) {

    }
}
