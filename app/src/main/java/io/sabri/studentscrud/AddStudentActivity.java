package io.sabri.studentscrud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddStudentActivity extends AppCompatActivity {

    EditText name;
    EditText grade;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        name = findViewById(R.id.name);
        grade = findViewById(R.id.grade);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentsDBUtils.insert(AddStudentActivity.this, name.getText().toString(), Integer.parseInt(grade.getText().toString()));
                finish();
            }
        });
    }
}
