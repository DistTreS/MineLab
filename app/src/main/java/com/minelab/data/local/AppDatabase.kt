package com.minelab.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.minelab.data.dao.AbsensiDao
import com.minelab.data.dao.KelasDao
import com.minelab.data.dao.PertemuanDao
import com.minelab.data.dao.TugasDao
import com.minelab.data.dao.UserDao
import com.minelab.data.entity.Absensi
import com.minelab.data.entity.KelasPraktikum
import com.minelab.data.entity.PertemuanPraktikum
import com.minelab.data.entity.TugasPraktikum
import com.minelab.data.entity.User

@Database(
    entities = [User::class, KelasPraktikum::class, TugasPraktikum::class, PertemuanPraktikum::class, Absensi::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun kelasDao(): KelasDao
    abstract fun tugasDao(): TugasDao
    abstract fun pertemuanDao(): PertemuanDao
    abstract fun absensiDao(): AbsensiDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "praktikum"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
