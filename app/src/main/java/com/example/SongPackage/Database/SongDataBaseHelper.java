package com.example.SongPackage.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.SongPackage.Entity.Song;

import java.util.ArrayList;
import java.util.List;

public class SongDataBaseHelper extends SQLiteOpenHelper {

    //Database Constants
    private static final String DATABASE_NAME = "song.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Song";

    //Dadabase Queries For the table's column name
    private static final String COL_ID = "ID";
    private static final String COL_NAME = "NAME";
    private static final String COL_IMAGE = "IMAGE";
    //private static final String COL_LINK = "LINK";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NAME + " TEXT NOT NULL,"
            + COL_IMAGE + " TEXT NOT NULL" + ")";

    private static final String DROP_TABLE = "DROP TABLE " + TABLE_NAME;
    private static final String GET_ALL_STATEMENT = "SELECT * FROM " + TABLE_NAME;


    public SongDataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }


    /* @return  a list of all monster from the database table called monster */
    public Cursor getAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(GET_ALL_STATEMENT,null);
    }

    public List<Song> getSongs() {
        List<Song> listSong = new ArrayList<>();

        Cursor cursor = getAll();

        if (cursor.getCount() > 0) {
            Song song;
            while (cursor.moveToNext()) {
                Long id = cursor.getLong(0);
                String name = cursor.getString(1);
                String imageFileName = cursor.getString(2);

                song = new Song(id, name, imageFileName);
                listSong.add(song);
            }
        }
        cursor.close();
        return listSong;
    }
}
