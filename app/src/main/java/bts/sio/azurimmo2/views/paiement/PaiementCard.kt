package bts.sio.azurimmo.views.paiement

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
import bts.sio.azurimmo2.model.Paiement

@Composable
fun PaiementCard(paiement: Paiement) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Paiement ID: ${paiement.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Contrat ID: ${paiement.contrat.id}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Date: ${paiement.datePaiement}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Montant: ${paiement.montant}€", style = MaterialTheme.typography.bodyMedium)
        }
    }
}