import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import io.eqoty.client.SigningCosmWasmClient
import kotlinx.coroutines.launch

fun main() {
    singleWindowApplication(
        title = "secretk sample",
        state = WindowState(size = DpSize(500.dp, 800.dp))
    ) {
        setupAndStartApp()
    }
}


@Preview
@Composable
fun SampleAppPreview() =
    setupAndStartApp()


