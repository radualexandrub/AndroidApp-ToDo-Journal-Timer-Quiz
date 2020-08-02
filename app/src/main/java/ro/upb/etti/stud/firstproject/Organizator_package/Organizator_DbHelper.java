package ro.upb.etti.stud.firstproject.Organizator_package;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Organizator_DbHelper extends SQLiteOpenHelper {

    public Organizator_DbHelper(Context context) {
        super(context, Organizator_Task.DB_NAME, null, Organizator_Task.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "Create Table " + Organizator_Task.TaskEntry.TABLE + " ( " +
                Organizator_Task.TaskEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Organizator_Task.TaskEntry.COL_TASK_TITLE + " TEXT NOT NULL);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + Organizator_Task.TaskEntry.TABLE);
            onCreate(db);
    }
}
