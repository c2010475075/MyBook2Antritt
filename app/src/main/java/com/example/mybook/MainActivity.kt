package com.example.mybooks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mybooks.navigation.BookNavigation
import com.example.mybooks.screens.FavScreen
import com.example.mybooks.screens.NewBooksScreen
import com.example.mybook.ui.theme.MyBOOKTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                BookNavigation()
            }


        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    content()

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FavScreen()
    BookNavigation()
    //NewBooksScreen()

}


