class DFSBinaryTree: Storage() {

    override fun add(user: User) {
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

    override fun search(id: Int): User? {
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

    override fun remove(id: Int) {
        TODO("Not yet implemented")
    }

    override fun print() {
        TODO("Not yet implemented")
    }
}