package com.tr4n.demoroom.data.source.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.tr4n.demoroom.data.model.Student;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void create(Student student);

    @Query("SELECT * FROM " + Student.TABLE_NAME)
    List<Student> getAll();

    @Query("SELECT * FROM " + Student.TABLE_NAME + " where " + Student.ID + " = :studentId")
    Student getById(int studentId);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);
}
