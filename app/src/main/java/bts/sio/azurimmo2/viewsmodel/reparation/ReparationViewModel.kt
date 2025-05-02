package bts.sio.azurimmo.viewsmodel.reparation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.api.RetrofitInstance
import bts.sio.azurimmo2.model.Reparation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ReparationViewModel : ViewModel() {

    private val _reparations = MutableStateFlow<List<Reparation>>(emptyList())
    val reparations: StateFlow<List<Reparation>> = _reparations

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getReparations()
    }

    private fun getReparations() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getReparations()
                val reparationsTransformes = response.map { reparation ->
                    reparation.copy(
                        date = LocalDate.parse(
                            reparation.date,
                            DateTimeFormatter.ofPattern("yyyy-MM-dd")
                        ).toString()
                    )
                }
                _reparations.value = reparationsTransformes

            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}