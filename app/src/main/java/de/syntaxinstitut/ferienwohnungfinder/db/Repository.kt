package de.syntaxinstitut.ferienwohnungfinder.db

import de.syntaxinstitut.ferienwohnungfinder.data.dataclasses.AppartmentData
import de.syntaxinstitut.ferienwohnungfinder.data.exampleData.AppartmentsExampleData

class Repository(private val database: AppartmentDatabase) {

    /* -------------------- Öffentliche Funktionen -------------------- */

    /**
     * Liefert alle Items aus der Tabelle
     *
     * @return Alle Items der Tabelle
     */
    // todo: getAllItems(), schreibe hier eine Funktion, welche alle Datensätze zurück liefert
    fun getAllItems(): List<AppartmentData> {
        return database.appartmentDao.getItems()
    }


    /**
     * Anzahl der Items in der Tabelle zählen
     *
     * @return Anzahl der Items der Tabelle
     */
    // todo: getCount(), schreibe hier eine Funktion, welche die Anzahl der Datensätze zurück liefert
    fun getCount(): Int {
        return database.appartmentDao.getCount()
    }


    /**
     * Füllt die Datenbank mit Beispielen, wenn die Datenbank leer ist.
     */
    fun prepopulateDB() {
        // todo: Schreibe eine Funktion prepopulateDB() welche die Datenbank mit den
        //  Beispieldatensätzen befüllt, wenn diese leer ist

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
