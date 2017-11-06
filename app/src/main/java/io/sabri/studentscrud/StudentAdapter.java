package io.sabri.studentscrud;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sabri on 11/6/17.
 */

public class StudentAdapter extends ArrayAdapter<Student> {

    private Context context;
    private int layout;
    private ArrayList<Student> objects;

    public StudentAdapter(Context context, int layout, ArrayList<Student> objects) {
        super(context, layout, objects);
        this.context = context;
        this.layout = layout;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(layout, null);
        }

        TextView id = convertView.findViewById(R.id.id);
        TextView name = convertView.findViewById(R.id.name);
        TextView grade = convertView.findViewById(R.id.grade);

        Student student = objects.get(position);

        id.setText(String.valueOf(student.getId()));
        name.setText(student.getName());
        grade.setText(String.valueOf(student.getGrade()));

        return convertView;
    }
}
