package ru.tebloev.room;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Department {
    @PrimaryKey(autoGenerate = true)
    long id;
    String name;
}
