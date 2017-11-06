package io.sabri.studentscrud;

import android.provider.BaseColumns;

/**
 * Created by Sabri on 11/6/17.
 */

public class StudentContract {

    public static final class StudentEntry implements BaseColumns {
        public static final String TABLE = "students";

        public static final String ID = BaseColumns._ID;
        public static final String NAME = "name";
        public static final String GRADE = "grade";
    }

}
