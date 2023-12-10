package de.syntax_institut.ferienwohnungfinder.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData

@Dao
interface AppartmentDao {

    @Insert
    suspend fun insertItem(ItemData: AppartmentData)

    @Query("SELECT * FROM appartment_table")
    fun getItems(): LiveData<List<AppartmentData>>
}
