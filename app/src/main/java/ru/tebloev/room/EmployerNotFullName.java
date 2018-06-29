package ru.tebloev.room;

import android.arch.persistence.room.ColumnInfo;

/**
 * @author Tebloev Vladimir
 */
public class EmployerNotFullName {

    public String firstName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}
