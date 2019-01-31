package com.playground.model.Database

import android.arch.persistence.room.*

@Entity
data class Gender (@PrimaryKey(autoGenerate = true)  var uniqueId:Int, var name:String)

@Entity
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    var exerciseId: Int,
    var name: String,
    var repetitions:Int,
    @ColumnInfo(name = "machine_name")
    var machineName: String,
    var liftedWeight: Int)

