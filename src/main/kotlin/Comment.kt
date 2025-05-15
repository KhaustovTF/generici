data class Comment(
    val commentId: Int,
    val ownerId: Int,
    var message:String?,
    var noteId: Int? = null,
    var isAccess: Boolean = true
)
