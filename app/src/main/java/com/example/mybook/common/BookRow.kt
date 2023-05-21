package com.example.mybooks.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mybooks.moduls.Book
import com.example.mybooks.viewmodel.AddBookViewModel
import java.time.LocalDate
//
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybooks.navigation.BookScreeens


@Composable
fun BookRow(
    navController: NavController,
    book: Book,
    onEditClick: (Book) -> Unit ={},
    onDeleteClick: (Book)-> Unit ={},
    onMarkAsRead: (Book) -> Unit
            /*onItemClick: (String) -> Unit = {}*/
) {
    var showDetails by remember {
        mutableStateOf(false)
    }
    Card( modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
        //.clickable { onItemClick(book.isbn) },
        shape= RoundedCornerShape(corner= CornerSize(16.dp)),
        elevation = 6.dp
    ) {


        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {

            Column(modifier = Modifier
                .padding(14.dp)
                .clickable { showDetails = !showDetails }){
                Text(text = book.title, style= MaterialTheme.typography.caption)
                Text(text = "Autor: ${book.autor}", style = MaterialTheme.typography.caption)



                /* IconButton(modifier = Modifier.weight(1f) *//*onClick = { showDetails = !showDetails }*//*
               ) {*/
                Icon(imageVector =
                if (showDetails) Icons.Default.KeyboardArrowDown
                else Icons.Default.KeyboardArrowUp,
                    contentDescription = "expand",
                    modifier = Modifier
                        .clickable { showDetails = !showDetails }
                )

                if (showDetails){
                    Card(modifier = Modifier.padding(14.dp)){
                        Column {
                            Text(text = "ISBN: ${book.isbn}", style = MaterialTheme.typography.caption)
                            Text(text = "Year: ${book.year}", style = MaterialTheme.typography.caption)}
                    }}
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                IconButton(onClick = { navController.navigate("NeuesBuchAnlegenBearbeiten/${book.isbn}")}) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "edit book")
                }

                IconButton(onClick = { onDeleteClick(book) }) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "delete book")
                }

                Checkbox(
                    checked = book.gelesen ,
                    onCheckedChange = { newStatus -> onMarkAsRead(book) },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = "Gelesen")
            }
            }
        }
    }
/*
@Composable
fun EditBook(navController: NavController){
    IconButton(onClick = {
        navController.navigate("NewBooksScreen") }) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = "edit book")
    }


}}*/
/* @Composable
fun MainContent( bookList: List<Book> = listOf(),
onDeleteClick: (Book) -> Unit, viewModel: AddBookViewModel){
    val bookList = viewModel.getAllBooks()
    if (bookList.isEmpty()){
        Text(text = "Es wurden noch keine Bücher angelegt")}
    else{
        LazyColumn{
            items(items = bookList) { bookname ->
                BookRow( bookname){
                    onDeleteClick(it)

                }
                  //  navController.navigate(route = BookScreeens.NewBooksScreen.name)
                }
            }
        }}*/

/*@Composable
fun AddBookWidget(viewModel: AddBookViewModel =viewModel(), navController: NavController
    //onSaveBuch: (Book) -> Unit = {}
){
    var title by remember {
        mutableStateOf("")
    }
    var autor by remember {
        mutableStateOf("")
    }

    var isbn by remember {
        mutableStateOf("")
    }
    var year by remember {
        mutableStateOf("")
    }

    var images by remember{
        mutableStateOf(emptyList<String>())
    }

    Column(modifier = Modifier.padding(16.dp)){
        Text(text = "Add a Book",
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.secondaryVariant)

        OutlinedTextField(
            value = title,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {title = it},
            label = { Text(text = "titel")},
            isError = false)
        OutlinedTextField(
            value = autor,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {autor = it},
            label = { Text(text = "autor")},
            isError = false)
        OutlinedTextField(
            value = isbn,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {isbn = it},
            label = { Text(text = "isbn")},
            isError = false)


        OutlinedTextField(
            value = year,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = {year = it },
            label = { Text("year")},
            isError = false)

        *//*OutlinedTextField(value = text, onValueChange = {value -> text= value },
    label = { Text(text = "Name")})*//*

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = {

                    val newBook = Book(title,autor,isbn,year.toInt())

                viewModel.addBook(newBook)
                    //onSaveBuch(newBook)
            })
        {  Text(text = "Save")}}}*/



