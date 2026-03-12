package com.example.tarea4newsapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.tarea4newsapps.ui.theme.Tarea4NewsAppsTheme
import model.Noticia
import model.newList
import org.jetbrains.annotations.Async

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tarea4NewsAppsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyComplexLayaout(innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyComplexLayaout(innerPadding : PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues = innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 15.dp, vertical = 30.dp)
    ) {
        //Barra de busqueda
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shape = CircleShape,
            color = Color.White
        ) {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Buscar...") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Noticias",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Eventos",
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Clima",
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Ultimas noticias",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        //Tarjetas
        val noticias = listOf("Nueva misión a Marte despega con éxito", "Descubren una nueva especie de orquídea en el Amazonas", "El equipo local gana el campeonato tras 10 años")
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
                //.padding(20.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(noticias){ news ->
                Box(
                    modifier = Modifier
                        .width(280.dp)
                        .height(180.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color(0xFF654cf6)),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        news,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        news,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        news,
                        modifier = Modifier
                            .padding(16.dp),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Text(
            text = "Alredodor del mundo",
            modifier = Modifier
                .padding(top = 10.dp),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        //Cartas
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.height(500.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(newList){ noticia ->
                    NewsCard(noticia = noticia)
                }
            }
        }

    }
}

@Composable
fun NewsCard(noticia: Noticia) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.BottomStart
    ){
        Image(
            painter = painterResource(noticia.imagen),
            contentDescription = noticia.contenido,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Text(
            text = noticia.contenido,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .clip(RoundedCornerShape(16.dp))
                .background(Color.LightGray)
                .padding(12.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Tarea4NewsAppsTheme {
        MyComplexLayaout(innerPadding = PaddingValues(10.dp))
    }
}