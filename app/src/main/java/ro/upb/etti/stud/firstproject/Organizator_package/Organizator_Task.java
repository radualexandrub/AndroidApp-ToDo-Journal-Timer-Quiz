package ro.upb.etti.stud.firstproject.Organizator_package;

import android.provider.BaseColumns;

public class Organizator_Task {

    public static final String DB_NAME = "ro.upb.etti.stud.firstproject"; //Stringul DB_Name va contine numele bazei de date
    public static final int DB_VERSION = 1;

    public class TaskEntry implements BaseColumns {
        public static final String TABLE = "tasks"; //tasks va fi numele singurei tabele din baza de date
        public static final String COL_TASK_TITLE = "title";
    }
}
