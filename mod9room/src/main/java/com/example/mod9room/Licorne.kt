package com.example.mod9room

import androidx.room.Entity
import androidx.room.PrimaryKey

//permet d'être utilisé dans une DAO
@Entity
data class Licorne(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    var nom : String,
    var tailleCorne : Int,
    var robe: String

)
