package com.example.mybooks.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.mybooks.moduls.Book
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AddBookViewModel : ViewModel() {
    private val _bookList = mutableStateListOf<Book>()
    val bookList: List<Book> get() = _bookList
    //var selectedBook by mutableStateOf<Book?>(null)
    var title by mutableStateOf("")
    var autor by mutableStateOf("")
    var isbn by mutableStateOf("")
    var year by mutableStateOf<Int?>(null)
    var gelesen by mutableStateOf<Boolean?>(null)
/*
    private val _sucheingabe = MutableStateFlow("")
    val sucheingabe: StateFlow<String> = _sucheingabe

    fun setSucheingabe(sucheingabe: String) {
        _sucheingabe.value = sucheingabe
    }*/
    //private val bookList = mutableListOf<Book>()
   /* fun editBook(book: Book) {
        val index = _bookList.indexOfFirst { it.isbn == book.isbn }
        if (index != -1) {
            _bookList[index] = book
        }
    }*/

 /*   val selectedBook: Book? by mutableStateOf(null)
        private set

    fun editBook(book: Book) {
        selectedBook = book*/

    fun markAsRead(book: Book) {
        val index = _bookList.indexOfFirst { it.isbn == book.isbn }
        if (index != -1) {
            _bookList[index].gelesen = true
        }
    }
    fun getFilteredBooks(searchQuery: String): List<Book> {
        val lowercaseQuery = searchQuery.lowercase()
        return bookList.filter { book ->
            val lowercaseTitle = book.title.lowercase()
            val lowercaseAuthor = book.autor.lowercase()
            lowercaseTitle.contains(lowercaseQuery) || lowercaseAuthor.contains(lowercaseQuery)
        }
    }
    fun editBook(book: Book) {
        val index = _bookList.indexOfFirst { it.isbn == book.isbn }
        if (index != -1) {
            _bookList[index] = book
        }
    }
    private var _selectedBook: Book? = null
    var selectedBook: Book?
        get() = _selectedBook
        set(value) {
            _selectedBook = value
        }

    fun updateBookStatus(isbn: String, gelesen: Boolean) {
        val book = _bookList.find { it.isbn == isbn }
        book?.gelesen = gelesen
    }

    fun getAllBooks(): List<Book>{
        return _bookList
    }
    fun addBook(book: Book) {
        _bookList.add(book)
    }

    fun getBookByIsbn(isbn: String?): Book? {
        return _bookList.find { it  .isbn == isbn }
    }

    fun deleteBook(book: Book) {
        _bookList.remove(book)
    }

    /*  fun setBuchGelesen(book: Book, gelesen: Boolean) {
          val index = _bookList.indexOfFirst { it == book }
          if (index != -1) {
              _bookList[index].gelesen = gelesen
          }*/


}


//private val _addBooks = mutableListOf<Book>() //val?
// val addBooks: List<Book>
// get() = _addBooks //muss ich?

/*pr    ivate var books = mutableListOf<Book>()
private val _bookList = MutableStateFlow<List<Book>>(emptyList())
val buchListe: StateFlow<List<Book>> = _bookList

fun setBuchGelesen(buch: Book, gelesen: Boolean) {
    // Finde das Buch in der Buchliste
    val index = _bookList.indexOfFirst { it == buch }
    if (index != -1) {
        // Aktualisiere den gelesenen Status des Buches
        _bookList[index].gelesen = gelesen
    }
}

fun addBook(book: Book)
{ //if (validateBuchData(titel, autor, year, isbn)) {
    books.add(book)
}

fun removeBook(book: Book)
{ books.remove(book)}


fun getAllBooks(): List<Book>{
    return books
}
fun sordBook(book: Book)
{ }

fun filterBook(){

}
*/



