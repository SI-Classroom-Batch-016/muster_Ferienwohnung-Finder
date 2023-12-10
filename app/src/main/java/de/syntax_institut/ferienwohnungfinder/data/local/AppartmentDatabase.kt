package de.syntax_institut.ferienwohnungfinder.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData

@Database(entities = [AppartmentData::class], version = 1)
abstract class AppartmentDatabase : RoomDatabase() {

    abstract val appartmentDao: AppartmentDao
}

private lateinit var INSTANCE: AppartmentDatabase

fun getDatabase(context: Context): AppartmentDatabase {

    synchronized(AppartmentDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {

            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppartmentDatabase::class.java,
                "appartment_database"
            ).build()
        }
        return INSTANCE
    }
}