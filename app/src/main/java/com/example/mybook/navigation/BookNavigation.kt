package com.example.mybooks.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mybooks.screens.FavScreen
import com.example.mybooks.screens.NewBooksScreen
import com.example.mybooks.viewmodel.AddBookViewModel

@Composable
fun BookNavigation(navController: NavController = rememberNavController()){

    val navController = rememberNavController() // navcontroller von typ rememberNavcontroller

    val bookViewModel: AddBookViewModel = viewModel() //?

    NavHost(navController = navController, startDestination = BookScreeens.FavScreen.name)
    {
        composable(BookScreeens.FavScreen.name ){
            FavScreen(navController= navController, viewModel= bookViewModel)
        }
        composable(BookScreeens.NewBooksScreen.name ){
            NewBooksScreen(navController= navController, viewModel= bookViewModel, isbn = null, selectedBook = null)
        }
        composable(
            route = "NeuesBuchAnlegenBearbeiten/{isbn}",
            arguments = listOf(navArgument("isbn") { type = NavType.StringType })
        ) { backStackEntry ->
            val isbn = backStackEntry.arguments?.getString("isbn")
            val selectedBook = bookViewModel.getBookByIsbn(isbn)

            NewBooksScreen(
                navController = navController,
                viewModel = bookViewModel,
                isbn = isbn,
                selectedBook = selectedBook
            )
        }
    }
}