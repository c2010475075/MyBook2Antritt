package com.example.mybooks.moduls

import java.time.LocalDate

data class Book(
    val title: String,
    val autor: String,
    val isbn: String,
    val year: Int,
    var gelesen: Boolean = false
)

/*fun getBooks(): List<Book> {
   return listOf(
       Book(
           title = "Harry Potter ",
           autor = "J.K. Rowling",
           isbn = "9780590353427",
           year = 1999
       ),
       Book(
           title = "To Kill a Mockingbird",
           autor = "Harper Lee",
           isbn = "9780061120084",
           year = 1980

       ),
       Book(
           title = "1984",
           autor = "George Orwell",
           isbn = "9780451524935",
           year = 1949

       ),
       // Weitere Bücher hier hinzufügen...
   )
}*/

