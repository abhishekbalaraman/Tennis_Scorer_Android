package mia.abhishek.tennisscorer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek on 24-07-2016.
 */
public class TennisRepo {
   /* private DBHelper dbHelper;

    public TennisRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Tennis tennis) {

        //Open connection to write data
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
      values.put(Tennis.KEY_score, tennis.score);
        values.put(Tennis.KEY_sets,tennis.sets);
        values.put(Tennis.KEY_name, tennis.name);

        // Inserting Row
        long tennis_Id = db.insert(Tennis.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) tennis_Id;
    }

    public void delete(int tennis_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        // It's a good practice to use parameter ?, instead of concatenate string
        db.delete(Tennis.TABLE, Tennis.KEY_ID + "= ?", new String[] { String.valueOf(tennis_Id) });
        db.close(); // Closing database connection
    }

    public void update(Tennis tennis) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Tennis.KEY_score, tennis.score);
        values.put(Tennis.KEY_sets,tennis.sets);
        values.put(Tennis.KEY_name, tennis.name);

        // It's a good practice to use parameter ?, instead of concatenate string
        db.update(Tennis.TABLE, values, Tennis.KEY_ID + "= ?", new String[] { String.valueOf(tennis.tennis_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getTennisList() {
        //Open connection to read only
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tennis.KEY_ID + "," +
                Tennis.KEY_name + "," +
                Tennis.KEY_sets + "," +
                Tennis.KEY_score +
                " FROM " + Tennis.TABLE;

        //Tennis tennis = new Tennis();
        ArrayList<HashMap<String, String>> tennisList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> tennis = new HashMap<String, String>();
                tennis.put("id", cursor.getString(cursor.getColumnIndex(Tennis.KEY_ID)));
                tennis.put("name", cursor.getString(cursor.getColumnIndex(Tennis.KEY_name)));
                tennisList.add(tennis);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tennisList;

    }

    public Tennis getTennisById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Tennis.KEY_ID + "," +
                Tennis.KEY_name + "," +
                Tennis.KEY_sets + "," +
                Tennis.KEY_score +
                " FROM " + Tennis.TABLE
                + " WHERE " +
                Tennis.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Tennis tennis = new Tennis();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                tennis.tennis_ID =cursor.getInt(cursor.getColumnIndex(Tennis.KEY_ID));
                tennis.name =cursor.getString(cursor.getColumnIndex(Tennis.KEY_name));
                tennis.sets  =cursor.getString(cursor.getColumnIndex(Tennis.KEY_score));
                tennis.score =cursor.getInt(cursor.getColumnIndex(Tennis.KEY_sets));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return tennis;
    }
*/
}