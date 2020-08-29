package com.tr4n.demoroom.data.handler;

import android.os.AsyncTask;

import com.tr4n.demoroom.data.model.Student;
import com.tr4n.demoroom.data.source.local.StudentDao;

public class InsertStudentAsync extends AsyncTask<Student, Void, Void> {

    private StudentDao studentDao;

    public InsertStudentAsync(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    protected Void doInBackground(Student... students) {
        for(Student student: students){
            studentDao.create(student);
        }
        return null;
    }
}
