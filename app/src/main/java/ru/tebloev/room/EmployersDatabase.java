package ru.tebloev.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * @author Tebloev Vladimir
 */
@Database(entities = {Employer.class, Department.class, Company.class}, version = 1)
public abstract class EmployersDatabase extends RoomDatabase {

    public abstract EmployersDAO getEmployersDAO();

    public abstract DepartmentDAO getDepartmentDAO();

    public abstract CompanyDAO getCompaniesDAO();
}