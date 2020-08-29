package com.tr4n.demoroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.tr4n.demoroom.data.handler.GetStudentsAsync;
import com.tr4n.demoroom.data.handler.InsertStudentAsync;
import com.tr4n.demoroom.data.handler.OnDataLoadedCallback;
import com.tr4n.demoroom.data.model.Student;
import com.tr4n.demoroom.data.source.local.AppDatabase;
import com.tr4n.demoroom.data.source.local.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        insertData();
        getData();
    }

    private void initViews() {

    }

    private void initData() {
        AppDatabase database = AppDatabase.getInstance(this);
        studentDao = database.studentDao();
    }

    private void insertData() {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            new InsertStudentAsync(studentDao).execute(new Student(20173030 + i));
        }
    }

    private void getData() {
        new GetStudentsAsync(studentDao, new OnDataLoadedCallback<List<Student>>() {
            @Override
            public void onSuccess(List<Student> students) {
                Log.d(TAG, "onSuccess: " + students);
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, "onFailure: ", e);
            }
        }).execute();
    }
}