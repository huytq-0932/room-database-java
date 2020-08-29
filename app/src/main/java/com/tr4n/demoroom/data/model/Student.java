package com.tr4n.demoroom.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = Student.TABLE_NAME)
public class Student {
    public static final String TABLE_NAME = "tbl_student";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CLASS_NAME = "className";

    @PrimaryKey
    @ColumnInfo(name = ID)
    public int id;
    @ColumnInfo(name = NAME)
    public String name;
    @ColumnInfo(name = CLASS_NAME)
    public String className;

    public Student(int id) {
        this.id = id;
        this.name = UUID.randomUUID().toString();
        this.className = "CNTT11-K62";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
