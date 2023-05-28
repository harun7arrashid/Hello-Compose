package com.example.hellocompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.hellocompose.ui.theme.HelloComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { // supaya bisa manggil fun @Composable
            HelloComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Harun Ar-Rashid")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(
    showBackground = true,
    name = "Single Preview",
    group = "Greeting",
    widthDp = 100,
    heightDp = 200
)
@Preview(
    name = "Full Device Preview",
    group = "Greeting",
    device = Devices.PIXEL_3A,
    showBackground = true
)
@Preview(
    name = "Without Surface",
    showSystemUi = true,
    uiMode =  UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    HelloComposeTheme {
        Greeting("Mantap")
    }
}