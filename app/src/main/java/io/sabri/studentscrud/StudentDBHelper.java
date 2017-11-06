package io.sabri.studentscrud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import static io.sabri.studentscrud.StudentContract.StudentEntry.*;
/**
 * Created by Sabri on 11/6/17.
 */

public class StudentDBHelper extends SQLiteOpenHelper {


    public StudentDBHelper(Context context) {
        // sqlite3 students.db
        super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "(" + ID +" INTEGER PRIMARY KEY, " + NAME +" TEXT, " + GRADE +" INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
