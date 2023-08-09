package de.syntax_institut.ferienwohnungfinder.data.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

// todo: Schreibe hier die Entity rein
@Entity(tableName = "appartment_table")
data class AppartmentData(

//    todo: primary key
    @PrimaryKey
    var id: Int,
    var title: String,
    var address: String,
    var sleepRooms: Int,
    var size: Int,
    var persons: Int,
    var petsAllowed: Boolean,
    var pricePerNight: Int,
    var image: Int
)
