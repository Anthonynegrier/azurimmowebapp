package bts.sio.azurimmo.views.locataire

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
import bts.sio.azurimmo2.model.Locataire

@Composable
fun LocataireCard(locataire: Locataire) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "${locataire.prenom} ${locataire.nom}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Date de naissance: ${locataire.dateNaissance}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Nombre de contrats: ${locataire.contrats.size}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
