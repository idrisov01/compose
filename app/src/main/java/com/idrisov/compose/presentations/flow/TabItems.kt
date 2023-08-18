package com.idrisov.compose.presentations.flow

import androidx.annotation.StringRes
import com.idrisov.compose.R

sealed class TabItems(val route: String, @StringRes val resourceId: Int) {
    object Main: TabItems("Main", R.string.bottom_nav_tab_main)
    object Responses: TabItems("Responses", R.string.bottom_nav_tab_responses)
    object Profile: TabItems("Profile", R.string.bottom_nav_tab_profile)
}