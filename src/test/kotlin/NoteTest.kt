import kotlin.test.Test
import kotlin.test.assertEquals

class NoteTest {
    @Test
    fun add(){
        val result = NoteService.add(Note(1,1,"Test","Testing"))

        assertEquals(Note(1,1,"Test","Testing"), result)
    }

//    @Test
//    fun delete(){
//        val result = NoteService.delete(1)
//
//        assertEquals(0.0, result)
//    }

    @Test
    fun editNote(){
        val result = NoteService.editNote(1,Note(2,3,"test","test"))
        assertEquals(true, result)
    }

    @Test
    fun createComment(){
        NoteService.add(Note(1,1,"Test","Testing"))

        val result = NoteService.createComment(1,Comment(1,1,"test"))

        assertEquals(Comment(1,1,"test",noteId = 1), result)
    }

    @Test
    fun editComment(){
        NoteService.add(Note(1,1,"Test","Testing"))
        val result = NoteService.editComment(1,"test")
        assertEquals(true,result)
    }

}