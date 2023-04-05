package de.syntaxinstitut.ferienwohnungfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData


class MainViewModel(application: Application) : AndroidViewModel(application) {

    /** Zugriff auf das Repository um mit der Datenbank arbeiten zu können */


    /** Liste aller Appartments die im RecyclerView abgebildet werden */
    val appartmentsLiveData = MutableLiveData<List<AppartmentData>>()

    /** True wenn ein Toast angezeigt werden soll */
    val showToast = MutableLiveData(false)

    /** Anzahl der gefundenen Appartments in der Datenbank */
    val countOfAppartments = MutableLiveData(0)

    init {
        // Lade die Beispieldaten in die Datenbank wenn diese leer ist




        // Zeige eine Toast Nachricht für die Anzahl der Appartments
        showToast.value = true
    }

    /**
     * Lädt the Daten von der Datenbank in appartmentsLiveData
     */
    fun loadFromDatabase() {

    }

    /**
     * Setzt die Toast Variable zurück
     */
    fun resetToast() {
        showToast.value = false
    }
}
