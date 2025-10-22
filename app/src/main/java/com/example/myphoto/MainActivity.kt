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
import androidx.compose.runtime.setValue
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
@Composable
fun Greeting( modifier: Modifier = Modifier) {

    var imagenselect by remember { mutableStateOf<imgenes?>(null)}
    val imagenSeleccionada by remember {
        mutableStateOf(listOf(
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiT8XXmitwpb7dUo1lNHDpqB1z9jlbr-LatA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3HTgKkm-tBcNbiLG5eCL12nOngY_fEta2BA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiT8XXmitwpb7dUo1lNHDpqB1z9jlbr-LatA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3HTgKkm-tBcNbiLG5eCL12nOngY_fEta2BA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiT8XXmitwpb7dUo1lNHDpqB1z9jlbr-LatA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3HTgKkm-tBcNbiLG5eCL12nOngY_fEta2BA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTiT8XXmitwpb7dUo1lNHDpqB1z9jlbr-LatA&s"
            ),
            imgenes(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3HTgKkm-tBcNbiLG5eCL12nOngY_fEta2BA&s"
            )
        ))
    }
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
        lazy(imagenSeleccionada,{it->imagenselect=it})
        imagenselect?.let {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it.direccion)
                    .build(),
                contentDescription = "Imagen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(250.dp).padding(1.dp)
            )
        }



    }
}
@Composable
fun lazy(imagenSeleccionada: List<imgenes>, onImageSelected: (imgenes) -> Unit){
    LazyRow {
        items(imagenSeleccionada.size) { index ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imagenSeleccionada[index].direccion)
                    .build(),
                contentDescription = "Imagen",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(250.dp).padding(1.dp)
                    .clickable(onClick = {
                        onImageSelected(imagenSeleccionada[index])
                    }
                    )
            )


        }
    }
}
