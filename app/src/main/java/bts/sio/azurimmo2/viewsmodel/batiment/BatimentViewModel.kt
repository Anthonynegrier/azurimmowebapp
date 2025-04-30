package bts.sio.azurimmo.viewsmodel.batiment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo2.api.RetrofitInstance
import bts.sio.azurimmo2.model.Batiment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {

    private val _batiments = MutableStateFlow<List<Batiment>>(emptyList())
    val batiments: StateFlow<List<Batiment>> = _batiments

    private val _batiment = MutableStateFlow<Batiment?>(null)
    val batiment: StateFlow<Batiment?> = _batiment

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        getBatiments()
    }

    fun getBatiments() {
        viewModelScope.launch {
            _isLoading.value = true
            _errorMessage.value = null

            try {
                val response = RetrofitInstance.api.getBatiments()
                _batiments.value = response
            } catch (e: Exception) {
                _errorMessage.value =
                    "Erreur test : ${e.localizedMessage ?: "Une erreur s'est produite"}"
            } finally {
                _isLoading.value = false
                println("Chargement terminé")
            }
        }
    }

    fun addBatiment(batiment: Batiment) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.addBatiments(batiment)
                if (response.isSuccessful) {
                    getBatiments()
                } else {
                    _errorMessage.value =
                        "Erreur lors de l'ajout du bâtiment : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}