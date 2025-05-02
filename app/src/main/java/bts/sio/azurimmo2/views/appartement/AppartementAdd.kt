package bts.sio.azurimmo2.views.appartement

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import bts.sio.azurimmo.viewsmodel.appartement.AppartementViewModel
import bts.sio.azurimmo2.model.Appartement
import bts.sio.azurimmo2.model.Batiment


@Composable
fun AppartementAdd(batimentId: Int, navController: NavController) {

    val viewModel: AppartementViewModel = viewModel()
    var description by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var surface by remember { mutableStateOf("") }
    var nbPiece by remember { mutableStateOf("") }
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ajouter un appartement",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        if (errorMessage != null) {
            Text(
                text = errorMessage ?: "",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        OutlinedTextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text("Numéro") },
            modifier = Modifier.fillMaxWidth(),
            isError = numero.isBlank()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = surface,
            onValueChange = {
                // Ne permet que les entrées numériques
                if (it.isEmpty() || it.matches(Regex("^\\d*\\.?\\d*$"))) {
                    surface = it
                }
            },
            label = { Text("Surface (m²)") },
            modifier = Modifier.fillMaxWidth(),
            isError = surface.isBlank() || surface.toFloatOrNull() == null,
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nbPiece,
            onValueChange = {
                // Ne permet que les entrées numériques entières
                if (it.isEmpty() || it.matches(Regex("^\\d+$"))) {
                    nbPiece = it
                }
            },
            label = { Text("Nombre de pièces") },
            modifier = Modifier.fillMaxWidth(),
            isError = nbPiece.isBlank() || nbPiece.toIntOrNull() == null
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
            isError = description.isBlank()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val surfaceValue = surface.toFloatOrNull() ?: 0f
                val nbPieceValue = nbPiece.toIntOrNull() ?: 0

                val batiment = Batiment(id = batimentId, adresse = "", ville = "")
                val appartement = Appartement(
                    id = 0,
                    numero = numero,
                    description = description,
                    surface = surfaceValue,
                    nombrePieces = nbPieceValue,
                    batiment = batiment
                )

                viewModel.addAppartement(appartement)
                navController.popBackStack()
            },
            modifier = Modifier.align(Alignment.End),
            enabled = numero.isNotBlank() && description.isNotBlank()
                    && surface.isNotBlank() && nbPiece.isNotBlank() && !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Ajouter l'appartement")
            }
        }
    }
}


