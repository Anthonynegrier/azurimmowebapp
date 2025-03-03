package bts.sio.azurimmo.viewsmodel.contrat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.model.Contrat
import bts.sio.azurimmo2.model.Locataire
import bts.sio.azurimmo2.model.Appartement
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class ContratViewModel : ViewModel() {

    private val _contrats = MutableStateFlow<List<Contrat>>(emptyList())
    val contrats: StateFlow<List<Contrat>> = _contrats

    init {
        getContrats()
    }

    private fun getContrats() {
        viewModelScope.launch {
            val locataire1 = Locataire(1, "Dupont", "Jean", LocalDate.of(1990, 5, 20), emptyList())
            val locataire2 = Locataire(2, "Martin", "Sophie", LocalDate.of(1985, 8, 14), emptyList())

            val appartement1 = Appartement(1, 101, 50.0f, 2, "Bel appartement lumineux", null)
            val appartement2 = Appartement(2, 202, 75.0f, 3, "Appartement spacieux", null)

            _contrats.value = listOf(
                Contrat(1, locataire1, appartement1, 750.0, LocalDate.of(2023, 1, 1), 23.2),
                Contrat(2, locataire2, appartement2, 950.0, LocalDate.of(2022, 6, 15), 24.3)
            )
        }
    }
}
