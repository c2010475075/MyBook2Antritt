package com.example.mybooks.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.mybooks.common.BookRow
import com.example.mybooks.moduls.Book

import com.example.mybooks.navigation.BookScreeens
import com.example.mybook.ui.theme.MyBOOKTheme
import com.example.mybooks.viewmodel.AddBookViewModel

@Preview
@Composable
fun FavScreen(
    navController: NavController = rememberNavController(), viewModel: AddBookViewModel = viewModel()
) {
  /* var buch : Book? by remember {
        mutableStateOf(null)}*/


    /*    AddBookWidget(){
            buchh -> buch2.add(buchh)
        }
        MainContent( bookList = buch2)*/

    //NoteCards(notes = notes)
    var showMenu by remember {
        mutableStateOf(false)
    }



    Scaffold(
        bottomBar = {
            BottomNavigation (
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary
            ){
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                BottomNavigationItem(
                    icon = {Icon(imageVector = Icons.Default.Home , contentDescription ="home" )},
                    selected = currentRoute == "FavScreen",
                    onClick = {
                        navController.navigate("FavScreen")},
                )
                BottomNavigationItem(
                    icon = {Icon(imageVector = Icons.Default.Add , contentDescription ="add" )},
                    selected = currentRoute == "NewBooksScreen",
                    onClick = {
                        navController.navigate("NewBooksScreen")},
                )
            }
        },
        topBar = {
            TopAppBar(title = { Text(text = "Meine Lieblingsbücher") },
                actions = {
                    IconButton(onClick = { showMenu = !showMenu }) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more")

                    }
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Row {
                                Icon(
                                    imageVector = Icons.Default.AddCircle,
                                    contentDescription = "new book",
                                    modifier = Modifier.padding(4.dp)
                                )
                                Text(
                                    text = "Neues Buch anlegen/bearbeiten",
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .width(90.dp)
                                )
                            }

                        }
                    }
                })
        }
    ) {
    val bookList = viewModel.getAllBooks()

        if (bookList.isEmpty()){
            Text(text = "Es wurden noch keine Bücher angelegt")}
        else{
            LazyColumn{
                items(items = bookList) { book ->
                    BookRow(
                        book = book,
                        onEditClick = {/* editedBook ->
                            viewModel.editBook(editedBook)*/
                                selectedBook ->
                            navController.navigate("NeuesBuchAnlegenBearbeiten/${selectedBook.isbn}")
                        },
                        onDeleteClick = { clickedBook ->
                            viewModel.deleteBook(clickedBook)
                        },
                        onMarkAsRead = { book ->
                            viewModel.markAsRead(book)
                        })

                    }}}}}
/**@Composable
fun MainContent(navController: NavController, bookList: List<Book> = listOf()){
if (bookList.isEmpty()){
Text(text = "Es wurden noch keine Bücher angelegt")}
else{
LazyColumn{
items(items = bookList) { bookname ->
BookRow(navController = navController, book= bookname){
navController.navigate(route = BookScreeens.NewBooksScreen.name)
}
}
}
}}*/



