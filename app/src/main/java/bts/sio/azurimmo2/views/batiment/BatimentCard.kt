package bts.sio.azurimmo.views.batiment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import bts.sio.azurimmo2.model.Batiment

@Composable
fun BatimentCard(batiment: Batiment, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                // Navigation vers la liste des appartements de ce bâtiment
                // (une amélioration future pourrait être d'ajouter cette fonctionnalité)
            },
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(text = batiment.adresse, style = MaterialTheme.typography.bodyLarge)
                Text(text = batiment.ville, style = MaterialTheme.typography.bodyMedium)
            }

            IconButton(
                onClick = {
                    // Navigation vers l'ajout d'un appartement pour ce bâtiment
                    navController.navigate("add_appartement/${batiment.id}")
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Ajouter un appartement à ce bâtiment",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}


