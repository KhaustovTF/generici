fun main() {
    NoteService.add(Note(NoteService.getUnickId(),1, "How to cook for noobs", "blabalbalbalbalablablablabal"))
    NoteService.add(Note(2,1, "How to cook for pros", "lalalalalalalalalal"))
    NoteService.add(Note(3,2, "How to cook for pros", "lalalalalalalalalal"))

    try {
        NoteService.editNote(1,Note(2,1,"no longer how to cook", "__________"))
    }catch (e:NoteNotFoundException){
        println(e.message)
    }

    try {
        NoteService.delete(2)
    }catch (e:NoteNotFoundException){
        println(e.message)
    }


try {
    NoteService.createComment(3,Comment(NoteService.getCommentUnickId(),1,"How to cook"))
}catch (e:NoteNotFoundException){
    println(e.message)
}
    try {
        NoteService.editComment(1,"sorry ill change my comment")
    }catch (e:NoteNotFoundException){
        println(e.message)
    }


    try {
        NoteService.createComment(1,Comment(NoteService.getCommentUnickId(),1,"asdasdasdsadasd"))
    }catch (e:NoteNotFoundException){
        println(e.message)
    }

    NoteService.createComment(3,Comment(5, 2,"blablabalbal"))

    NoteService.deleteComment(5)


    NoteService.printNotes()


    println("////////////////////////////////////////////////////////////////////////////////////////////////////////")
    NoteService.getById(1)


}

