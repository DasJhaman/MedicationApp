package com.example.medicationapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.medicationapp.data.db.dao.AssociatedDrugDao
import com.example.medicationapp.data.db.entity.AssociatedDrugEntity

@Database(
    entities = [AssociatedDrugEntity::class],
    version = 1
)
abstract class MedicationDatabase : RoomDatabase() {
    abstract fun associatedDrugDao(): AssociatedDrugDao
}