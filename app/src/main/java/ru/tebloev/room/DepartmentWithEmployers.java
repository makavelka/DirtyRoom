package ru.tebloev.room;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class DepartmentWithEmployers {

    @Embedded
    Department department;

    @Relation(parentColumn = "id", entityColumn = "departmentId")
    public List<Employer> employers;

    @Relation(parentColumn = "id", entityColumn = "departmentId", entity = Employer.class)
    public List<EmployerNotFullName> employerName;
}
