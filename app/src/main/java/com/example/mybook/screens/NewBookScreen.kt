package com.example.mybooks.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mybooks.moduls.Book
import com.example.mybooks.viewmodel.AddBookViewModel
import java.time.LocalDate
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mybooks.validateBuchData



@Composable
fun NewBooksScreen(navController: NavController = rememberNavController(), viewModel: AddBookViewModel,isbn: String?, selectedBook: Book?) {
    val context = LocalContext.current

    val newTitle by remember { mutableStateOf(selectedBook?.title ?: "") }
    val newAuthor by remember { mutableStateOf(selectedBook?.autor ?: "") }
    // ...

    // Verwende newTitle und newAuthor in den Eingabefeldern und führe die Validierung durch

    Button(
        onClick = {
            selectedBook?.let { editedBook ->
                val updatedBook = editedBook.copy(
                    title = newTitle,
                    autor = newAuthor
                )
                viewModel.editBook(updatedBook)
                navController.navigate("FavScreen")
            }
        }
    ) {
        Text(text = "Buch speichern")
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(
                contentColor = Color.White,
                backgroundColor = MaterialTheme.colors.primary
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "home") },
                    selected = currentRoute == "FavScreen",
                    onClick = {
                        navController.navigate("FavScreen")
                    },
                )
                BottomNavigationItem(
                    icon = { Icon(imageVector = Icons.Default.Add, contentDescription = "add") },
                    selected = currentRoute == "NewBooksScreen",
                    onClick = {
                        navController.navigate("NewBooksScreen")
                    },
                )
            }
        }
        /*        topBar = {
                   TopAppBar(backgroundColor = Color.Green, elevation = 3.dp){
                       Row{
                           Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                               modifier = Modifier.clickable{
                                   navController.popBackStack() // geh zuruck zu favscreen

                               })
                           Spacer(modifier = Modifier.width(20.dp))
                           Text(text = "Neues Buch anlegen")
                       }
                   }
               }
           )*/) {
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
        var showErrorSnackbar by remember { mutableStateOf(false) }

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

            /*OutlinedTextField(value = text, onValueChange = {value -> text= value },
        label = { Text(text = "Name")})*/

            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    val errors = validateBuchData(title, autor, isbn, year.toInt())
                    if (errors.isEmpty() && title.isNotEmpty() && autor.isNotEmpty() &&isbn.isNotEmpty() &&year.isNotEmpty() ) {

                        val newBook = Book(title,autor,isbn, year.toInt())

                        viewModel.addBook(newBook)
                        //onSaveBuch(newBook)
                       navController.popBackStack()
                    } else {
                        for (error in errors) {
                            Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            {  Text(text = "Save")}}
        if (showErrorSnackbar) {
            Snackbar(
                modifier = Modifier.padding(16.dp),
                action = {
                    Button(
                        onClick = { showErrorSnackbar = false }
                    ) {
                        Text("OK")
                    }
                }
            ) {
                Text("Bitte überprüfe die eingegebenen Daten.")
            }
        }

    }}



/*@Composable
fun AddBookWidget(
   onSaveBuch: (Book) -> Unit = {}
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
   var releaseDate by remember {
       mutableStateOf(LocalDate.now())
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
           onValueChange = {title = it},
           label = { Text(text = "autor")},
           isError = false)
       OutlinedTextField(
           value = isbn,
           singleLine = true,
           modifier = Modifier.fillMaxWidth(),
           onValueChange = {title = it},
           label = { Text(text = "isbn")},
           isError = false)
       *//*OutlinedTextField(value = text, onValueChange = {value -> text= value },
   label = { Text(text = "Name")})*//*

       Button(
           modifier = Modifier.padding(16.dp),
           onClick = {
               if(title.isNotEmpty()){
                   val newBook = Book(title,autor,isbn,releaseDate,images)

                   onSaveBuch(newBook)
               }
           })
       {  Text(text = "Save")}}}*/





// if(text.isNotEmpty())
//onSaveClick(text)
/* }) {val errors = validateBookData(titel)
    val buch = Book(titel, autor, isbn,releaseDate,images)

    if (errors.isEmpty()){
        for (error in errors){
            Text(text = error, color= Color.Red)
        }
    }
    Text(text = "Save")

}
}}*/


