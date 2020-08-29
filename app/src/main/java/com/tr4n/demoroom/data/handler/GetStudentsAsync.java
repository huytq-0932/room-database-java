package com.tr4n.demoroom.data.handler;

import android.os.AsyncTask;

import com.tr4n.demoroom.data.model.Student;
import com.tr4n.demoroom.data.source.local.StudentDao;

import java.util.List;

public class GetStudentsAsync extends AsyncTask<Void, Void, List<Student>> {

    private StudentDao studentDao;
    private OnDataLoadedCallback<List<Student>> listener;

    public GetStudentsAsync(StudentDao studentDao, OnDataLoadedCallback<List<Student>> listener) {
        this.studentDao = studentDao;
        this.listener = listener;
    }

    @Override
    protected List<Student> doInBackground(Void... voids) {
        return studentDao.getAll();
    }

    @Override
    protected void onPostExecute(List<Student> students) {
        if(students == null || students.isEmpty()){
            listener.onFailure(new Exception("Load data failure"));
            return;
        }
        listener.onSuccess(students);
    }
}
