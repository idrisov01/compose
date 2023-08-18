package com.idrisov.compose.presentations.responses

import androidx.compose.runtime.Composable
import com.idrisov.compose.R
import com.idrisov.compose.ui.widgets.Toolbar

@Composable
fun ResponsesScreen() {

    Toolbar(
        title = R.string.toolbar_title_responses,
        isEnableNavIcon = false
    )

}
