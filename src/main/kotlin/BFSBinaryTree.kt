class BFSBinaryTree : Storage() {

    override fun add(user: User) {
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

    private fun adduserBFS(user: User) {
//        println("Trying to add: " + user.id)
//        root?.let {
//            println("Root")
//            root = addUserBFSRecursive(user, it)
//        } ?: run {
//            size++
//            root = Node(user)
//            println("add successful: " + user.id + " is the root")
//            println()
//            println()
//        }
        TODO()
    }

    override fun search(id: Int): User? {
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

    override fun remove(id: Int) {
        TODO("Not yet implemented")
    }

    override fun print() {
        TODO("Not yet implemented")
    }
}