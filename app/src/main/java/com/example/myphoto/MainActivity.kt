package com.example.myphoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myphoto.ui.theme.MYPHOTOTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MYPHOTOTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

data class imgenes(
    val nombre: String,
    val puntuacion: Int,
    val direccion: Int
)

@Composable
fun Greeting( modifier: Modifier = Modifier) {

    val imagenSeleccionada by remember {
        mutableStateOf(listOf(
            imgenes(
                "María Mata",
                2014,
                R.drawable.image1
            ),
            imgenes(
                "Antonio Sanz",
                2056,
                R.drawable.image2
            ),
            imgenes(
                "Carlos Perez",
                5231,
                R.drawable.image3
            ),
            imgenes(
                "Beatriz Martos",
                1892,
                R.drawable.image4
            ),
            imgenes(
                "Sandra Alegre",
                3400,
                R.drawable.image5
            ),
            imgenes(
                "Alex Serrat",
                5874,
                R.drawable.image6
            ),
            imgenes(
                "Ana Peris",
                2238,
                R.drawable.image7
            ),
            imgenes(
                "Pablo Morralla",
                6969,
                R.drawable.image8
            )
        ))
    }
    LazyRow(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(imagenSeleccionada.size) { index ->
            val idimagen=imagenSeleccionada[index].direccion
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = idimagen),
                contentDescription = "Imagen por defecto",
                modifier = Modifier
                    .size(250.dp)
                    .padding(1.dp)
            )
        }
    }

}