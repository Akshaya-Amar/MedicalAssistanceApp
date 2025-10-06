package com.amar.medicalassistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.amar.medicalassistapp.ui.component.BottomNavigationBar
import com.amar.medicalassistapp.ui.model.NavItem
import com.amar.medicalassistapp.ui.screen.AccountScreen
import com.amar.medicalassistapp.ui.screen.AddScreen
import com.amar.medicalassistapp.ui.screen.HomeScreen
import com.amar.medicalassistapp.ui.screen.MessageScreen
import com.amar.medicalassistapp.ui.screen.TodoScreen
import com.amar.medicalassistapp.ui.theme.MedicalAssistAppTheme

class MainActivity : ComponentActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
          setContent {
               MedicalAssistAppTheme {
                    val navListItems = listOf(
                         NavItem("Home", Icons.Outlined.Home, Icons.Filled.Home),
                         NavItem("Message", Icons.Outlined.Email, Icons.Filled.Email),
                         NavItem("Add", Icons.Outlined.AddCircle, Icons.Filled.AddCircle),
                         NavItem("Todo", Icons.Outlined.DateRange, Icons.Filled.DateRange),
                         NavItem("Account", Icons.Outlined.AccountCircle, Icons.Filled.AccountCircle)
                    )

                    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

                    Scaffold(modifier = Modifier.fillMaxSize(),
                         bottomBar = {
                              BottomNavigationBar(
                                   items = navListItems,
                                   selectedIndex = selectedIndex,
                                   onItemSelected = { selectedIndex = it }
                              )
                         }
                    ) { innerPadding ->
                         ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
                    }
               }
          }
     }

     @Composable
     private fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) {
          when (selectedIndex) {
               0 -> HomeScreen()
               1 -> MessageScreen()
               2 -> AddScreen()
               3 -> TodoScreen()
               4 -> AccountScreen()
          }
     }
}