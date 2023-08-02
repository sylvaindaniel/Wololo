package com.example.mod9room
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LicorneDbTest {
    lateinit var db : LicorneDatabase

    @Before
    fun getDb() {
        db = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            LicorneDatabase::class.java).build()
    }

    @Test
    fun checkInsertDb(){
        db.LicorneDao().insert(Licorne(0,"JeanMichel",10,"Alezan"))
        assert(db.LicorneDao().getById(1).nom == "JeanMichel")
    }

}