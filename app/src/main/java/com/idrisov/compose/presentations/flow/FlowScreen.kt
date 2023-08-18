package com.idrisov.compose.presentations.flow

import HomeScreen
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.idrisov.compose.R
import com.idrisov.compose.presentations.profile.ProfileScreen
import com.idrisov.compose.presentations.responses.ResponsesScreen
import kotlinx.coroutines.delay

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = TabItems.Main.route) {
        composable(route = TabItems.Main.route) { HomeScreen() }
        composable(route = TabItems.Responses.route) { ResponsesScreen() }
        composable(route = TabItems.Profile.route) { ProfileScreen() }
    }
}

@Composable
fun BottomNavigation(navController: NavController) {

    val navTabs = listOf(TabItems.Main, TabItems.Responses, TabItems.Profile)

    androidx.compose.material.BottomNavigation(
        backgroundColor = colorResource(id = R.color.white)
    ) {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navTabs.forEach { navTab ->
            BottomNavigationItem(
                icon = { },
                label = { Text(text = stringResource(id = navTab.resourceId)) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == navTab.route,
                onClick = {
                    navController.navigate(route = navTab.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(route = screen_route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

        OnBackPressed()
    }
}

@Composable
fun OnBackPressed() {

    var backPressedState by remember { mutableStateOf<BackPressed>(BackPressed.Back) }
    var showToast by remember { mutableStateOf(false) }

    if (showToast) {
        Toast.makeText(
            LocalContext.current,
            stringResource(id = R.string.press_twice_to_exit),
            Toast.LENGTH_SHORT
        ).show()
        showToast = false
    }

    LaunchedEffect(key1 = backPressedState) {
        if (backPressedState == BackPressed.CloseApp) {
            delay(2000)
            backPressedState = BackPressed.Back
        }
    }

    BackHandler(backPressedState == BackPressed.Back) {
        backPressedState = BackPressed.CloseApp
        showToast = true
    }
}

sealed class BackPressed {
    object CloseApp: BackPressed()
    object Back: BackPressed()
}