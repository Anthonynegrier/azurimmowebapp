package bts.sio.azurimmo2.model

import java.time.LocalDate

data class Contrat(
    val id: Int,
    val locataire: Locataire,
    val appartement: Appartement,
    val dateDebut: Double,
    val dateFin: LocalDate,
    val montantLoyer: Double
)
