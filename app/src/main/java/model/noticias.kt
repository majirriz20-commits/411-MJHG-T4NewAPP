package model

import com.example.tarea4newsapps.R

class Noticia(
    val id: Int,
    val contenido: String,
    val imagen: Int,
)

val newList = listOf(
    Noticia(1, "Japón inaugura el tren bala más rápido del mundo", R.drawable.trenbala),
    Noticia(2, "Festival de Luces en Lyon atrae a millones", R.drawable.festivaldeluces),
    Noticia(3, "Nuevos hallazgos arqueológicos en Egipto", R.drawable.egipto),
    Noticia(4, "Islandia registra una nueva erupción volcánica", R.drawable.islandiaerupcionvolcanica)
)

