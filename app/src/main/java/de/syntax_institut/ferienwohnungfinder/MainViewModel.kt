package de.syntax_institut.ferienwohnungfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntax_institut.ferienwohnungfinder.data.Repository
import de.syntax_institut.ferienwohnungfinder.data.local.getDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    /** Zugriff auf das Repository um mit der Datenbank arbeiten zu können */
    private val database = getDatabase(application)
    private var repository = Repository(database)

    /** Liste aller Appartments die im RecyclerView abgebildet werden */
    val appartmentsLiveData = repository.apartments

    /** True wenn ein Toast angezeigt werden soll */
    val showToast = MutableLiveData(false)

    /** Anzahl der gefundenen Appartments in der Datenbank */
    val countOfAppartments = MutableLiveData(0)

    init {
        viewModelScope.launch {
            // Lade die Beispieldaten in die Datenbank wenn diese leer ist
            repository.prepopulateDB()

            // Lade die Anzahl an Appartments in der DB
            countOfAppartments.value = repository.getCount()

            // Zeige eine Toast Nachricht für die Anzahl der Appartments
            showToast.value = true
        }
    }

    /**
     * Lädt the Daten von der Datenbank in appartmentsLiveData
     */
    fun loadFromDatabase() {
        viewModelScope.launch {
            // Lade alle Daten aus der DB in die Variable
            repository.getAllItems()
        }
    }

    /**
     * Setzt die Toast Variable zurück
     */
    fun resetToast() {
        showToast.value = false
    }
}
