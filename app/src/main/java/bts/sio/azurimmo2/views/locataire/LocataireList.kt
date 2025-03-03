package bts.sio.azurimmo.views.locataire

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.azurimmo.viewsmodel.locataire.LocataireViewModel

@Composable
fun LocataireList(viewModel: LocataireViewModel = viewModel()) {
    val locataires by viewModel.locataires.collectAsState()

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(locataires) { locataire ->
            LocataireCard(locataire = locataire)
        }
    }
}
