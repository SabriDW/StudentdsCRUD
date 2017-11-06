package io.sabri.studentscrud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditStudentActivity extends AppCompatActivity {

    EditText name;
    EditText grade;
    Button editButton;
    Button deleteStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        name = findViewById(R.id.name);
        grade = findViewById(R.id.grade);
        editButton = findViewById(R.id.edit_button);
        deleteStudent = findViewById(R.id.delete_student);


        final Student student = (Student) getIntent().getSerializableExtra("STUDENT");

        name.setText(student.getName());
        grade.setText(String.valueOf(student.getGrade()));


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentsDBUtils.update(EditStudentActivity.this, student.getId(),
                        name.getText().toString(),
                        Integer.parseInt(grade.getText().toString()));
                finish();
            }
        });

        deleteStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentsDBUtils.delete(EditStudentActivity.this, student.getId());
                finish();
            }
        });
    }
}
