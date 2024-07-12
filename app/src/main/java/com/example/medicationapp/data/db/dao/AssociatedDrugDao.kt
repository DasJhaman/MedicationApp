package com.example.medicationapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.medicationapp.data.db.entity.AssociatedDrugEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AssociatedDrugDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(studentEntity: AssociatedDrugEntity)

    @Delete
    suspend fun delete(studentEntity: AssociatedDrugEntity)

    @Update
    suspend fun update(studentEntity: AssociatedDrugEntity)

    @Query("DELETE FROM AssociatedDrugEntity")
    suspend fun clearAll()

    @Query("SELECT * FROM AssociatedDrugEntity")
    suspend fun getAllAssociatedDrug(): Flow<List<AssociatedDrugEntity>>

}