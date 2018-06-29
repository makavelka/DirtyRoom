package ru.tebloev.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CompanyDAO {

    @Query("select * from company where id = :id")
    Company getCompanyById(long id);

    @Query("select * from company")
    List<Company> getCompanies();

    @Insert
    void insert(Company company);

    @Update
    void update(Company company);

    @Delete
    void delete(Company company);
}
