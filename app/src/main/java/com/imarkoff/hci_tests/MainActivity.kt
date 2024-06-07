package com.imarkoff.hci_tests

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FontDownload
import androidx.compose.material.icons.filled.HistoryEdu
import androidx.compose.material.icons.outlined.FontDownload
import androidx.compose.material.icons.outlined.HistoryEdu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imarkoff.hci_tests.history.HistoryActivity
import com.imarkoff.hci_tests.tests.TestsActivity
import com.imarkoff.hci_tests.ui.theme.HCITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // make navigation bar transparent when 3-button navigation
        val systemBarStyle = when (val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_NO -> SystemBarStyle.light(Color.Transparent.toArgb(), Color.Transparent.toArgb())
            Configuration.UI_MODE_NIGHT_YES -> SystemBarStyle.dark(Color.Transparent.toArgb())
            else -> error("Illegal State, current mode is $currentNightMode")
        }

        enableEdgeToEdge(
            statusBarStyle = systemBarStyle,
            navigationBarStyle = systemBarStyle,
        )

        setContent {
            HCITheme {
                BottomMenu()
            }
        }
    }
}

sealed class Routes(val route: String, @StringRes val resourceId: Int) {
    data object TestsActivity : Routes("tests", R.string.tests)
    data object HistoryActivity : Routes("history", R.string.history)
}

@Composable
fun BottomMenu() {
    val items = listOf(
        Routes.TestsActivity,
        Routes.HistoryActivity
    )

    val iconsOutlined = listOf(
        Icons.Outlined.FontDownload,
        Icons.Outlined.HistoryEdu
    )
    val iconsFilled = listOf(
        Icons.Filled.FontDownload,
        Icons.Filled.HistoryEdu
    )

    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            NavigationBar (
                containerColor = MaterialTheme.colorScheme.surface,
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEachIndexed { index, screen ->

                    NavigationBarItem(
                        icon = {
                            if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                Icon(iconsFilled[index], contentDescription = null) // Icon when selected
                            } else {
                                Icon(iconsOutlined[index], contentDescription = null) // Icon when not selected
                            }
                        },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Routes.TestsActivity.route,
            modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
        ) {
            composable(Routes.TestsActivity.route) { TestsActivity() }
            composable(Routes.HistoryActivity.route) { HistoryActivity() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HCITheme {
        BottomMenu()
    }
}