package de.syntaxinstitut.ferienwohnungfinder.data.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey


// todo: Schreibe hier die Entity rein
@Entity
data class AppartmentData(
//    todo: primary key
    @PrimaryKey
    var id: Int = 0
)
