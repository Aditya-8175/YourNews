package com.example.breakingnewsapp.NewsScreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.R


@Composable
fun BottomReal(
    navController: NavController
) {
    var selected by remember {
        mutableStateOf(0)
    }

//    var category = listOf("business", "sports", "entertainment")

    BottomAppBar(
        Modifier
            .padding(bottom = 15.dp, start = 5.dp, end = 5.dp, top = 5.dp)
            .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
    ) {
        NavigationBar {
            bottomNavItem.forEachIndexed { index, bottomNavItem ->
                NavigationBarItem(
                    selected = index == selected,
                    onClick = {
                        selected = index
//                        navController.navigate(bottomNavItem.route.name+"/${category[index]}")
//                        bottomNavItem.route.name+"/${category[index]}"
                        navController.navigate(
                            when (bottomNavItem.title) {
                                "Home" -> NewsNavigation.HomeScreen.name + "/everything"
                                "Headlines" -> NewsNavigation.Headline.name
                                "Sport" -> NewsNavigation.SportsScreen.name
                                else -> NewsNavigation.Entertaintment.name
                            }
                        )
//                        MainNewsContent(navController = navController, newList = bottomdata )

                    },
                    icon = {
                        BadgedBox(badge = {
                            if (bottomNavItem.badges != 0) {
                                Badge {
                                    Text(text = bottomNavItem.badges.toString())
                                }
                            } else if (bottomNavItem.hasNews) Badge()
                        }) {
                            Icon(
                                painter = if (index == selected) {
                                    painterResource(id = bottomNavItem.selectedIcon)
                                } else {
                                    painterResource(id = bottomNavItem.unselectedIcon)
                                },
                                contentDescription = bottomNavItem.title,
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    },
                    label = {
                        Text(text = bottomNavItem.title)
                    },

                    )
            }
        }

    }
}

val bottomNavItem = listOf(
    BottomNavItem(
        title = "Home",
        selectedIcon = R.drawable.worldicon,
        unselectedIcon = R.drawable.worldicon,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Headlines",
        selectedIcon = R.drawable.newspaper,
        unselectedIcon = R.drawable.newspaper,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Sport",
        selectedIcon = R.drawable.stretchingexercises,
        unselectedIcon = R.drawable.stretchingexercises,
        hasNews = false,
        badges = 0
    ),
    BottomNavItem(
        title = "Entertainment",
        selectedIcon = R.drawable.cinema,
        unselectedIcon = R.drawable.cinema,
        hasNews = true,
        badges = 0
    )

)

data class BottomNavItem(
    val title: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val hasNews: Boolean,
    val badges: Int
)