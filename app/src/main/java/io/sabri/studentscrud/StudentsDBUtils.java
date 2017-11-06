package io.sabri.studentscrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import static io.sabri.studentscrud.StudentContract.StudentEntry.GRADE;
import static io.sabri.studentscrud.StudentContract.StudentEntry.ID;
import static io.sabri.studentscrud.StudentContract.StudentEntry.NAME;
import static io.sabri.studentscrud.StudentContract.StudentEntry.TABLE;

/**
 * Created by Sabri on 11/6/17.
 */

public class StudentsDBUtils {

    public static void insert(Context context, String name, int grade) {

        SQLiteDatabase db = getDatabase(context, true);

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(GRADE, grade);

        db.insert(TABLE, null, contentValues);

    }

    public static ArrayList<Student> read(Context context) {

        SQLiteDatabase db = getDatabase(context, false);

        String[] fields = {ID, NAME, GRADE};

        Cursor cursor = db.query(TABLE, fields, null, null, null, null, null);

        ArrayList<Student> students = new ArrayList<>();

        while (cursor.moveToNext()) {

            int id = cursor.getInt(cursor.getColumnIndex(ID));
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            int grade = cursor.getInt(cursor.getColumnIndex(GRADE));


            Student student = new Student(id, name, grade);

            students.add(student);

        }

        cursor.close();

        return students;
    }

    public static void update(Context context, int id, String name, int grade) {

        SQLiteDatabase db = getDatabase(context, true);

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(GRADE, grade);

        String[] args = {String.valueOf(id)};

        db.update(TABLE, contentValues, ID + " = ?", args);

    }

    public static void delete(Context context, int id) {

        SQLiteDatabase db = getDatabase(context, true);

        String[] args = {String.valueOf(id)};

        db.delete(TABLE, ID + " = ?", args);
    }

    private static SQLiteDatabase getDatabase(Context context, boolean isWritable) {
        StudentDBHelper helper = new StudentDBHelper(context);
        if (isWritable)
            return helper.getWritableDatabase();
        else
            return helper.getReadableDatabase();
    }

    public static Student findOne(Context context, int id) {
        SQLiteDatabase db = getDatabase(context, false);

        String[] fields = {ID, NAME, GRADE};

        String[] args = {String.valueOf(id)};

        Cursor cursor = db.query(TABLE, fields, ID + " = ?", args, null, null, null);
        // SELECT id, name, grade FROM students WHERE ID = id;

        cursor.moveToNext();

        int studentId = cursor.getInt(cursor.getColumnIndex(ID));
        String name = cursor.getString(cursor.getColumnIndex(NAME));
        int grade = cursor.getInt(cursor.getColumnIndex(GRADE));

        cursor.close();

        Student student = new Student(studentId, name, grade);

        return student;

    }
}
