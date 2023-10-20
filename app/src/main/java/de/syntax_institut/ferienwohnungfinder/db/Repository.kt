package de.syntax_institut.ferienwohnungfinder.db

import de.syntax_institut.ferienwohnungfinder.data.exampleData.AppartmentsExampleData

class Repository(private val database: AppartmentDatabase) {

    val apartments = database.appartmentDao.getItems()

    /* -------------------- Öffentliche Funktionen -------------------- */
    /**
     * Liefert alle Items aus der Tabelle
     *
     * @return Alle Items der Tabelle
     */
    fun getAllItems() {
        database.appartmentDao.getItems()
    }

    /**
     * Anzahl der Items in der Tabelle zählen
     *
     * @return Anzahl der Items der Tabelle
     */
    suspend fun getCount(): Int {
        return database.appartmentDao.getCount()
    }

    /**
     * Füllt die Datenbank mit Beispielen, wenn die Datenbank leer ist.
     */
    suspend fun prepopulateDB() {
        try {
            // Add example appartments to database
            if (database.appartmentDao.getCount() == 0) {
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment1)
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment2)
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment3)
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment4)
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment5)
                database.appartmentDao.insertItem(AppartmentsExampleData.appartment6)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
