package ru.tebloev.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Transaction;

@Dao
public abstract class EmployerDepartmentDAO {

    @Insert
    public abstract void insertEmployer(Employer employer);

    @Insert
    public abstract void insertDepartment(Department department);

    @Transaction
    public void insertCarAndEmployee(Employer employer, Department department) {
        insertDepartment(department);
        insertEmployer(employer);
    }
}
