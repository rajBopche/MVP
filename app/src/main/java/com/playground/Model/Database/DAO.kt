package com.playground.Model.Database

import android.arch.persistence.room.*

@Dao
interface GenderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGender(gender: Gender)

    @Update
    fun updateGender(gender:Gender)

    @Delete
    fun deleteGender(gender: Gender)

    @Query("SELECT * FROM Gender WHERE name == :name")
    fun getGenderByName(name: String): List<Gender>

    @Query("SELECT * FROM Gender")
    fun getGenders(): List<Gender>

}