import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.idrisov.compose.R
import com.idrisov.compose.presentations.home.vm.HomeViewModel
import com.idrisov.compose.ui.widgets.Toolbar

@Composable
fun HomeScreen() {

    val viewModel = hiltViewModel<HomeViewModel>()

    Toolbar(
        title = R.string.toolbar_title_home,
        isEnableNavIcon = false
    )
}