package bts.sio.azurimmo.views.réparation

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
import bts.sio.azurimmo2.model.Reparation

@Composable
fun ReparationCard(reparation: Reparation) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "ID: ${reparation.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Date: ${reparation.date}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Description: ${reparation.description}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Type: ${reparation.type}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Appartement N°${reparation.appartement.numero}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Société: ${reparation.nomSociete}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}