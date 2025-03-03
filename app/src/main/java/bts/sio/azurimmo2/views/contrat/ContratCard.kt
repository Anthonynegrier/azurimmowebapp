package bts.sio.azurimmo.views.contrat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo2.model.Contrat

@Composable
fun ContratCard(contrat: Contrat) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Contrat ID: ${contrat.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Locataire: ${contrat.locataire.prenom} ${contrat.locataire.nom}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Appartement N°${contrat.appartement.numero}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Loyer: ${contrat.montantLoyer}€", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Début: ${contrat.dateDebut}", style = MaterialTheme.typography.bodySmall)
            Text(text = "Fin: ${contrat.dateFin ?: "En cours"}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
