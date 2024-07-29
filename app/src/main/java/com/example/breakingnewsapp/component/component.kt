package com.example.breakingnewsapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBAr(navController: NavController, modifier: Modifier = Modifier) {
    Column {
        TopAppBar(
            title = { Text(text = "News App", style = MaterialTheme.typography.headlineLarge) },
            modifier
                .fillMaxWidth()
//                    .padding(14.dp)
                .background(color = Color.White)
//                .background(Color.Blue)
            ,
            actions = {
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notification"
                )

                Spacer(modifier = Modifier.width(10.dp))

                Icon(imageVector = Icons.Sharp.Search, contentDescription = "Search",
                    modifier = Modifier.clickable {
                        navController.navigate(NewsNavigation.SearchScreen.name)

                    })
            }, navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.bolt),
                    contentDescription = "Electic",
                    modifier = Modifier
                        .clip(shape = RectangleShape)
                        .size(50.dp),
                    tint = Color.Red
                )
            }

        )

    }
}
