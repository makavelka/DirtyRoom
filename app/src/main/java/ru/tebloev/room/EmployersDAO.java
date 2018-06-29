package ru.tebloev.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface EmployersDAO {

    @Query("select * from employers")
    List<Employer> getEmployers();

    @Query("select * from employers where id = :id")
    Employer getEmployerById(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employer employer);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Employer> employer);

    @Update
    void update(Employer employer);

    @Delete
    void delete(Employer employer);

    @Query("select * from employers where departmentId =:departmentId")
    List<Employer> findEmployersByDepartmentId(long departmentId);
}
