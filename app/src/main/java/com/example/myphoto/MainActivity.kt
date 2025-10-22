package com.example.myphoto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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

    val direccion: String
)
var imagenmuestra: String =""
@Composable
fun Greeting( modifier: Modifier = Modifier) {

    val imagenSeleccionada by remember {
        mutableStateOf(listOf(
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiT8XXmitwpb7dUo1lNHDpqB1z9jlbr-LatA&s"
            ),
            imgenes(
                "https://img.freepik.com/foto-gratis/disparo-enfoque-selectivo-garceta-ganadera_181624-44861.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"

            ),
            imgenes(
                "https://img.freepik.com/fotos-premium/fotografia-animal_27525-5846.jpg"
            ),
            imgenes(
                "https://img.freepik.com/foto-gratis/cisne-cygnus-olor-adulto-cerca-hermoso-cisne-blanco_1153-8559.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"
            ),
            imgenes(
                "https://img.freepik.com/fotos-premium/hermosos-dos-cisnes-jovenes-bano-manana_52720-736.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"
            ),
            imgenes(
                "https://img.freepik.com/fotos-premium/fotografia-animal_27525-5846.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"
            ),
            imgenes(
                "https://img.freepik.com/fotos-premium/garceta-ganadera-o-conocido-como-ibis-bubulcus-pie-firmemente-cerca-plantas-insectos-plagas_7954-2268.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"
            ),
            imgenes(
                "https://img.freepik.com/foto-gratis/primer-plano-ganso-gris-muelle_181624-40060.jpg?ga=GA1.1.433433568.1761142123&semt=ais_hybrid&w=740&q=80"
            )
        ))
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
        LazyRow(

        ) {
            items(imagenSeleccionada.size) { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(imagenSeleccionada[index].direccion)
                        .build(),
                    contentDescription = "Imagen",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.size(250.dp).padding(1.dp)
                        .clickable(onClick = {
                            imagenmuestra=imagenSeleccionada[index].direccion
                        }
                        )
                )


            }
        }
        Text(imagenmuestra)

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imagenmuestra)
                .build(),
            contentDescription = "Imagen",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.size(250.dp)
                .padding(1.dp)

        )


    }



}
