package de.syntax_institut.ferienwohnungfinder.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData

/**
 * Interface das die Methoden der Datenbank anbietet
 */
@Dao
interface AppartmentDao {

    /* -------------------- Hinzufügen Funktionen -------------------- *

     */
    /**
     * Methode zum Einfügen eines Elementes in die appartment_table
     *
     * @param ItemData        Das Item das eingefügt werden soll
     */
    @Insert
    suspend fun insertItem(ItemData: AppartmentData)

    /* -------------------- Get Funktionen -------------------- */

    /**
     * Methode die alle Daten aus der appartment_table zurück liefert
     *
     * @return Alle Items der Tabelle listItem_table
     */
    @Query("SELECT * FROM appartment_table")
    fun getItems(): LiveData<List<AppartmentData>>

    /**
     * Methode um sich die Anzahl der Elemente der appartment_table auszugeben
     *
     * @return Anzahl der Datensätze
     */
    @Query("SELECT COUNT(*) FROM appartment_table")
    suspend fun getCount(): Int

    /* -------------------- Update Funktionen -------------------- */

    /**
     * Methode um ein Item in der appartment_table zu aktualisieren
     *
     * @param itemData        Das zu aktualisierende Item mit seinen neuen Daten
     */
    @Update
    suspend fun updateItem(itemData: AppartmentData)

    /* -------------------- Löschen Funktionen -------------------- */
    /**
     * Methode um ein Item zu löschen
     *
     * @param ItemData        Das zu löschende Item
     */
    @Delete
    suspend fun deleteItem(ItemData: AppartmentData)
}
