package bts.sio.azurimmo.viewsmodel.paiement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.model.Paiement
import bts.sio.azurimmo2.model.Contrat
import bts.sio.azurimmo2.model.Locataire
import bts.sio.azurimmo2.model.Appartement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class PaiementViewModel : ViewModel() {

    private val _paiements = MutableStateFlow<List<Paiement>>(emptyList())
    val paiements: StateFlow<List<Paiement>> = _paiements

    init {
        getPaiements()
    }

    private fun getPaiements() {
        viewModelScope.launch {
            val locataire = Locataire(1, "Dupont", "Jean", LocalDate.of(1990, 5, 20), emptyList())
            val appartement = Appartement(1, 101, 50.0f, 2, "Bel appartement lumineux", null)
            val contrat = Contrat(1, locataire, appartement, 750.0, LocalDate.of(2023, 1, 1), 53.5)

            _paiements.value = listOf(
                Paiement(1, contrat, LocalDate.of(2024, 1, 5), 750.0),
                Paiement(2, contrat, LocalDate.of(2024, 2, 5), 750.0),
                Paiement(3, contrat, LocalDate.of(2024, 3, 5), 750.0)
            )
        }
    }
}
