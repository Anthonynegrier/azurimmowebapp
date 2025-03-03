package bts.sio.azurimmo.viewsmodel.locataire

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.model.Locataire
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class LocataireViewModel : ViewModel() {

    private val _locataires = MutableStateFlow<List<Locataire>>(emptyList())
    val locataires: StateFlow<List<Locataire>> = _locataires

    init {
        getLocataires()
    }

    private fun getLocataires() {
        viewModelScope.launch {
            _locataires.value = listOf(
                Locataire(1, "Dupont", "Jean", LocalDate.of(1990, 5, 20), emptyList()),
                Locataire(2, "Martin", "Sophie", LocalDate.of(1985, 8, 14), emptyList()),
                Locataire(3, "Bernard", "Luc", LocalDate.of(1992, 3, 10), emptyList())
            )
        }
    }
}
