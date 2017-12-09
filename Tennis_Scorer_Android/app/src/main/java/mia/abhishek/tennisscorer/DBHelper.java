package mia.abhishek.tennisscorer;

import android.content.Context;



import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abhishek on 25-07-2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;

    // Database Name
    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        //All necessary tables you like to create will create here

        String CREATE_TABLE_TENNIS = "CREATE TABLE " + Tennis.TABLE + "("
                + Tennis.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Tennis.KEY_name + " TEXT, "
                + Tennis.KEY_sets + " INTEGER, "
                + Tennis.KEY_score + " INTEGER )";

        db.execSQL(CREATE_TABLE_TENNIS);

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + Tennis.TABLE);

        // Create tables again
        onCreate(db);

    }
}