import NoteService.getNotes

fun main() {
    NoteService.add(Note(NoteService.getUnickId(), 1, "How to cook for noobs", "blabalbalbalbalablablablabal"))
    NoteService.add(Note(NoteService.getUnickId(), 1, "How to cook for pros", "lalalalalalalalalal"))
    NoteService.add(Note(NoteService.getUnickId(), 2, "How to cook for pros", "lalalalalalalalalal"))
    NoteService.add(Note(NoteService.getUnickId(), 2, "asdasdasdasdas", "qweqweqweqweqweqwe"))

    try {
        NoteService.editNote(1, Note(1, 1, "no longer how to cook", "__________"))
    } catch (e: NoteNotFoundException) {
        println(e.message)
    }

    try {
        NoteService.delete(2)
    } catch (e: NoteNotFoundException) {
        println(e.message)
    }


    try {
        NoteService.createComment(3, Comment(NoteService.getCommentUnickId(), 1, "How to cook"))
    } catch (e: NoteNotFoundException) {
        println(e.message)
    }
    try {
        NoteService.editComment(1, "sorry ill change my comment")
    } catch (e: NoteNotFoundException) {
        println(e.message)
    }


    try {
        NoteService.createComment(1, Comment(NoteService.getCommentUnickId(), 1, "asdasdasdsadasd"))
    } catch (e: NoteNotFoundException) {
        println(e.message)
    }

    NoteService.createComment(3, Comment(5, 2, "blablabalbal"))

    NoteService.deleteOrRestoreComment(5)


    NoteService.printNotes()


    println("////////////////////////////////////////////////////////////////////////////////////////////////////////")
    NoteService.getById(1)


    val storageComment = Storage<Comment>()

    val storageNote = Storage<Note>()

    storageNote.setAllData(getNotes())
    storageNote.get(1)
    println("////////////////////////////////////////////////////////////////////////////////////////////////////////")
    NoteService.getNotesByOwner(2)
    NoteService.getCommentByNote(1)
}

