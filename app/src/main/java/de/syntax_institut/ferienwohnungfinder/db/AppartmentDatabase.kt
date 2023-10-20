package de.syntax_institut.ferienwohnungfinder.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntax_institut.ferienwohnungfinder.data.dataclasses.AppartmentData

/**
 * Abstrakte Klasse um eine Datenbank zu verwalten
 *
 * Entities = Gibt das Aussehen der Tabelle in der Datenbank an
 * Version = Muss bei Updates eventuell um eins erhöht werden
 */
@Database(entities = [AppartmentData::class], version = 1)
abstract class AppartmentDatabase : RoomDatabase() {

    /** Variable für das Interface aus der AppartmentDao */
    abstract val appartmentDao: AppartmentDao

    companion object {

        /** Speichert die Instance der AppartmentDatabase um mit dieser arbeiten zu können */
        private lateinit var dbInstance: AppartmentDatabase

        /**
         * Liefert die Instance der AppartmentDatabase zurück
         *
         * @param context Kontext von welchem der Aufruf kam
         *
         * @return AppartmentDatabase Context
         */
        fun getDatabase(context: Context): AppartmentDatabase {
            synchronized(this) {
                // Initialisiere Datenbank
                if (!this::dbInstance.isInitialized) {
                    dbInstance = Room.databaseBuilder(
                        context.applicationContext,
                        AppartmentDatabase::class.java,
                        "appartment_database"
                    ).build()
                }
                return dbInstance
            }
        }
    }
}