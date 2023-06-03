package com.example.hellocompose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hellocompose.ui.theme.HelloComposeTheme

private val sampleName = listOf(
    "Andre",
    "Desta",
    "Parto",
    "Wendy",
    "Komeng",
    "Raffi Ahmad",
    "Andhika Pratama",
    "Vincent Ryan Rompies"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { // supaya bisa manggil fun @Composable
            HelloComposeTheme {
                HelloJetpackComposeApp()
            }
        }
    }
}

@Composable
fun HelloJetpackComposeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        GreetingList(sampleName)

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HelloJetpackComposeAppPreview() {
    HelloComposeTheme {
        HelloJetpackComposeApp()
    }
}


@Composable // ini macem function biasa
fun GreetingList(names: List<String>) {

    if (names.isNotEmpty()) Column { for (name in names) { Greeting(name) } }
    else Text("No peope to great :(")

}

@Composable
fun Greeting(name: String) {

    var isExpanded = remember { mutableStateOf(false) } // untuk menjaga supaya nilai tersebut tidak terreset ketika update UI.

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "Logo Jetpack Compose",
            modifier = Modifier.size(80.dp)
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Column(Modifier.weight(1f)) {
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Welcome Dicoding")
        }
        
        IconButton(onClick = { isExpanded.value = !isExpanded.value  }) { // for trigger animation
            Icon(
                imageVector = if (isExpanded.value) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = if (isExpanded.value) "Show less" else "Show More"
            )
        }
    }
}

//@Preview(
//    showBackground = true,
//    name = "Single Preview",
//    group = "Greeting",
//    widthDp = 100,
//    heightDp = 200
//)
//@Preview(
//    name = "Full Device Preview",
//    group = "Greeting",
//    device = Devices.PIXEL_3A,
//    showBackground = true
//)
//@Preview(
//    name = "Without Surface",
//    showSystemUi = true,
//    uiMode =  UI_MODE_NIGHT_YES
//)
@Composable
fun DefaultPreview() {
    HelloComposeTheme {
        Greeting("Mantap")
    }
}