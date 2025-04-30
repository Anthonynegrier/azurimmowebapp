package bts.sio.azurimmo2.model

data class Reparation(
    val id: Int,
    val date: String,
    val description: String,
    val type: String,
    val appartement: Appartement,
    val nomSociete: String?,
)
