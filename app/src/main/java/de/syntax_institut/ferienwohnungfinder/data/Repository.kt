package de.syntax_institut.ferienwohnungfinder.data

import androidx.lifecycle.LiveData
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntax_institut.ferienwohnungfinder.data.local.AppartmentDatabase
import de.syntax_institut.ferienwohnungfinder.data.exampleData.AppartmentsExampleData

class Repository(private val database: AppartmentDatabase) {

    val apartments: LiveData<List<AppartmentData>> = database.appartmentDao.getItems()

    suspend fun prepopulateDB() {
        try {
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment1)
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment2)
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment3)
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment4)
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment5)
            database.appartmentDao.insertItem(AppartmentsExampleData.appartment6)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
