object NoteService {

    private var notes = mutableMapOf<Int, Note>()
    private var comments = mutableMapOf<Int, Comment>()
    private var unickId = 1
    private var commentUnickId = 1

    fun getUnickId() = unickId
    fun getCommentUnickId() = commentUnickId

    fun getNotes(): MutableMap<Int, Note> {
        return notes
    }

    fun add(note: Note): Note {
        notes[note.noteId] = note
        unickId++
        return note
    }

    //////////////////////////////////////
    fun delete(noteId: Int) {
        if (noteId !in notes){
            throw NoteNotFoundException("Note with id: $noteId is not found")
        } else{
            notes.remove(noteId)
        }
    }

    fun getNotesByOwner(ownerId: Int){
        var isFind = false
        for (note in notes.values) {
            if (note.ownerId == ownerId) {
                println(note)
                isFind = true
            }
        }
        if (!isFind){
            throw NoteNotFoundException("netu")
        }
    }

    //////////////////////////////////////
    fun editNote(noteId: Int, newNote: Note): Boolean {
        if (noteId !in notes) {
            throw NoteNotFoundException("Note with id: $noteId is not found")
        } else {
            notes[noteId] = newNote
            return true
        }
    }

    fun createComment(noteId: Int, comment: Comment): Comment {
        if (noteId !in notes) {
            throw NoteNotFoundException("Note with id: $noteId is not found")
        } else {
            comment.noteId = noteId
            comments[comment.commentId] = comment
            commentUnickId++
            return comment
        }
    }

    fun editComment(commentId: Int,newComment: String): Boolean {
        if (commentId !in notes) {
            throw NoteNotFoundException("Note with id: $commentId is not found")
        } else {
            comments[commentId]?.message = newComment
            return true
        }
    }

    fun deleteOrRestoreComment(commentId: Int){
        if (commentId !in comments) {
            throw NoteNotFoundException("Comment with id: $commentId is not found")
        } else {
            comments[commentId]!!.isAccess = !comments[commentId]!!.isAccess
        }
    }

    fun getCommentByNote(noteId: Int){
        if (noteId !in notes){
            throw NoteNotFoundException("note with id: $noteId is not found")
        }else{
            for (comment in comments.values){
                if (comment.noteId == noteId)
                    println(comment)
            }
        }
    }


    fun getById(noteId: Int){
        if (noteId !in notes) {
            throw NoteNotFoundException("note with id: $noteId is not found")
        }else{
            println(notes[noteId])
        }
    }


    fun printNotes() {
        for (note in notes) {
            println(note)
        }
        for (comment in comments.values) {
            if (comment.isAccess)
            println(comment)
        }
    }
}