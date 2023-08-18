package com.idrisov.compose.ui.widgets

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idrisov.compose.R

@Composable
fun Toolbar(
    @StringRes title: Int,
    isEnableNavIcon: Boolean = true,
    onBackPressed: (() -> Unit)? = null,
    @DrawableRes actionImage: Int? = null,
    action: (() -> Unit)? = null
) {

    Row(
        modifier = Modifier
            .height(54.dp)
            .fillMaxWidth()
            .background(Color.Gray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (isEnableNavIcon) {
            IconButton(
                onClick = { onBackPressed?.invoke() },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "",
                    modifier = Modifier.weight(1f)
                )
            }
        } else {
            Box(modifier = Modifier.weight(1f))
        }

        Text(
            text = stringResource(id = title),
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(5f)
        )

        if (actionImage != null) {
            IconButton(
                onClick = { action?.invoke() },
            ) {
                Icon(
                    painter = painterResource(id = actionImage),
                    contentDescription = "",
                    modifier = Modifier.weight(1f),
                )
            }
        } else {
            Box(modifier = Modifier.weight(1f))
        }
    }
}

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar(title = R.string.toolbar_title_profile)
}