package bts.sio.azurimmo.views.appartement

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
import bts.sio.azurimmo2.model.Appartement

@Composable
fun AppartementCard(appartement: Appartement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Appartement N°${appartement.numero}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Surface : ${appartement.surface} m²", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Pièces : ${appartement.nombrePieces}", style = MaterialTheme.typography.bodyMedium)
            Text(text = appartement.description, style = MaterialTheme.typography.bodySmall)
            Text(
                text = "Bâtiment : ${appartement.batiment?.adresse ?: "Non assigné"} - ${appartement.batiment?.ville ?: "N/A"}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
