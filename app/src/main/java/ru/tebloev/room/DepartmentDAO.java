package ru.tebloev.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DepartmentDAO {

    @Query("select * from department where id = :id")
    Department getDepartmentById(long id);

    @Query("select * from department")
    List<Department> getDepartments();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Department department);

    @Update
    void update(Department department);

    @Update(onConflict = OnConflictStrategy.FAIL)
    int update(List<Department> employee);

    @Delete
    void delete(Department department);

    @Delete
    int delete(List<Department> employee);

    @Transaction
    @Query("SELECT id, name from department")
    List<DepartmentWithEmployers> getDepartmentsWithEmployers();
}
