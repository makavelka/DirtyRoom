package ru.tebloev.room;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "employers")
public class Employer {

    @PrimaryKey(autoGenerate = true)
    long id;
    String firstName;
    @ColumnInfo(name = "last_name")
    String lastName;
    String surname;
    long departmentId;

    @Ignore
    String fullName;

    public Employer(String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        fullName = firstName + " " + lastName;
    }

}
