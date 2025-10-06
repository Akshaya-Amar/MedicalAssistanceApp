package com.amar.medicalassistapp.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amar.medicalassistapp.ui.model.NavItem

@Composable
fun BottomNavigationBar(
     modifier: Modifier = Modifier,
     items: List<NavItem>,
     selectedIndex: Int,
     onItemSelected: (Int) -> Unit
) {
     NavigationBar(
          containerColor = Color.White
     ) {
          items.forEachIndexed { index, navItem ->
               val selected = selectedIndex == index
               val icon = if (selected) navItem.filledIcon else navItem.outlinedIcon
               val iconSize = if (navItem.label == "Add") 54.dp else 28.dp
               val iconTint = when {
                    navItem.label == "Add" -> if (selected) Color(0xFFFFC107) else Color.Black
                    selected -> Color(0xFFFFC107)
                    else -> Color.Gray
               }

               NavigationBarItem(
                    selected = selected,
                    onClick = { onItemSelected(index) },
                    icon = {
                         Icon(
                              imageVector = icon,
                              contentDescription = navItem.label,
                              modifier = Modifier.size(iconSize),
                              tint = iconTint,
                         )
                    },
                    colors = NavigationBarItemDefaults.colors(
                         indicatorColor = Color.Transparent
                    )
               )
          }
     }
}