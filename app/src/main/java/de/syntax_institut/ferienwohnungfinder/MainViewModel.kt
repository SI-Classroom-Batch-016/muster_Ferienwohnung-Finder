package de.syntax_institut.ferienwohnungfinder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import de.syntax_institut.ferienwohnungfinder.data.Repository
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntax_institut.ferienwohnungfinder.data.local.getDatabase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private var repository = Repository(database)

    val appartments = repository.apartments

    private fun removeObserver() {
        appartments.removeObserver(observer)
    }

    private val observer = Observer<List<AppartmentData>?> { appartmentList ->
        if (appartmentList != null) {
            if (appartmentList.isEmpty()) {
                viewModelScope.launch {
                    repository.prepopulateDB()
                }
            }
            removeObserver()
        }
    }

    init {
        appartments.observeForever(observer)
    }
}
