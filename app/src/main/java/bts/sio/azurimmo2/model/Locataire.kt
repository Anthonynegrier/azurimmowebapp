package bts.sio.azurimmo2.model

import java.time.LocalDate

data class Locataire(
    val id: Int,
    val prenom: String,
    val nom: String,
    val dateNaissance: LocalDate,
    val contrats: List<Contrat> = emptyList()
)
