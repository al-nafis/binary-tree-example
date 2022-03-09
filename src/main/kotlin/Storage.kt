/**
 * Binary Tree
 * Sorted by UserIds (Left Node < Parent Node < Right Node)
 * Does not allow duplicate Ids
 * Searches by Id
 */
abstract class Storage {
    var size: Int = 0
    var root: Node? = null

    abstract fun add(user: User)
    abstract fun search(id: Int) : User?
    abstract fun remove(id: Int)
    abstract fun print()
}

/**
 * Data population
 *
 * DFS tree look
 *          |------ 10 ------|
 *      |-- 5 --|        |-- 22 --|
 *      1       9       12        30
 *
 *
 * BFS tree look
 *          |------ 10 ------|
 *      |-- 5 --|        |-- 1 --|
 *      9       22      12       30
 */
fun Storage.populateTree(): Storage = this.apply {
    println("--------------- ADDING USERS ---------------")
    add(User(10, "John"))
    add(User(5, "Ron"))
    add(User(5, "Ron")) // duplicate not allowed
    add(User(1, "Shawn"))
    add(User(9, "Don"))
    add(User(22, "Pawn"))
    add(User(12, "Vaughn"))
    add(User(30, "Yawn"))
}

// DFS tree look
//          |------ 10 ------|
//      |-- 5 --|        |-- 22 --|
//      1       9       12        30
//
// BFS tree look
//          |------ 10 ------|
//      |-- 5 --|        |-- 1 --|
//      9       22       12        30