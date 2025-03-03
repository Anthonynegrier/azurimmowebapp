package bts.sio.azurimmo2.viewsmodel.appartement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.model.Appartement
import bts.sio.azurimmo2.model.Batiment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// ViewModel pour gérer les données des appartements
class AppartementViewModel : ViewModel() {

    // Liste mutable des appartements
    private val _appartements = MutableStateFlow<List<Appartement>>(emptyList())
    val appartements: StateFlow<List<Appartement>> = _appartements

    init {
        // Simuler un chargement de données initiales
        getAppartements()
    }

    // Fonction pour simuler le chargement des appartements
    private fun getAppartements() {
        viewModelScope.launch {
            val batiment1 = Batiment(1, "123 Rue Principale", "Nice")
            val batiment2 = Batiment(2, "456 Avenue des Champs", "Marseille")

            _appartements.value = listOf(
                Appartement(1, 101, 45.5f, 2, "Charmant T2 avec balcon", batiment1),
                Appartement(2, 202, 60.0f, 3, "Appartement lumineux avec vue", batiment2),
                Appartement(3, 303, 75.0f, 4, "Grand duplex au dernier étage", batiment1)
            )
        }
    }
}
