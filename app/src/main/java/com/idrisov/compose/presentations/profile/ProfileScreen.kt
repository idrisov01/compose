package com.idrisov.compose.presentations.profile

import androidx.compose.runtime.Composable
import com.idrisov.compose.R
import com.idrisov.compose.ui.widgets.Toolbar

@Composable
fun ProfileScreen() {

    Toolbar(
        title = R.string.toolbar_title_profile,
        isEnableNavIcon = false
    )
}