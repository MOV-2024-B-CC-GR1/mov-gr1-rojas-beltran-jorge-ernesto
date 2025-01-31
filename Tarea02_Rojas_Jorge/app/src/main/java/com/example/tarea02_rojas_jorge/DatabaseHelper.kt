package com.example.tarea02_rojas_jorge

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_EQUIPOS)
        db.execSQL(CREATE_TABLE_JUGADORES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS jugadores")
        db.execSQL("DROP TABLE IF EXISTS equipos")
        onCreate(db)
    }

    companion object {
        private const val DATABASE_NAME = "ecuavoley.db"
        private const val DATABASE_VERSION = 1

        private const val CREATE_TABLE_EQUIPOS = """
            CREATE TABLE equipos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL
            )
        """

        private const val CREATE_TABLE_JUGADORES = """
            CREATE TABLE jugadores (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                edad INTEGER,
                equipo_id INTEGER,
                FOREIGN KEY(equipo_id) REFERENCES equipos(id)
            )
        """
    }
}


