package bts.sio.azurimmo2.views.batiment

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import bts.sio.azurimmo.viewsmodel.batiment.BatimentViewModel
import bts.sio.azurimmo2.model.Batiment


@Composable
fun BatimentAdd(navController: NavController) {
    val viewModel: BatimentViewModel = viewModel()
    var adresse by remember { mutableStateOf("") }
    var ville by remember { mutableStateOf("") }
    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage by viewModel.errorMessage.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Ajouter un bâtiment",
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
            value = adresse,
            onValueChange = { adresse = it },
            label = { Text("Adresse") },
            modifier = Modifier.fillMaxWidth(),
            isError = adresse.isBlank()
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = ville,
            onValueChange = { ville = it },
            label = { Text("Ville") },
            modifier = Modifier.fillMaxWidth(),
            isError = ville.isBlank()
        )
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (adresse.isNotBlank() && ville.isNotBlank()) {
                    Log.d("BatimentAdd", "Création d'un bâtiment: $adresse, $ville")
                    val batiment = Batiment(id = 0, adresse = adresse, ville = ville)
                    viewModel.addBatiment(batiment)
                    Log.d("BatimentAdd", "Retour à la liste des bâtiments")
                    navController.popBackStack()
                }
            },
            modifier = Modifier.align(Alignment.End),
            enabled = adresse.isNotBlank() && ville.isNotBlank() && !isLoading
        ) {
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            } else {
                Text("Ajouter le bâtiment")
            }
        }
    }
}


