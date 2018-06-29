package ru.tebloev.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmployersDatabase db = Room.databaseBuilder(getApplicationContext(),
                EmployersDatabase.class, "my_database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        EmployersDAO dao = db.getEmployersDAO();
        dao.insert(generateEmployers());
        dao.delete(dao.getEmployers().get(0));
        List<Employer> employers = dao.getEmployers();
        Employer employer = dao.getEmployers().get(0);
        employer.firstName = "new name";
        dao.update(employer);

        db.getDepartmentDAO().insert(generateDepartment());
        List<DepartmentWithEmployers> list = db.getDepartmentDAO().getDepartmentsWithEmployers();
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `City` (`id` INTEGER, "
                    + "`name` TEXT, PRIMARY KEY(`id`))");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE employers_new (id REAL, firstName TEXT, last_name STRING, surname STRING, PRIMARY KEY(id))");
            database.execSQL(
                    "INSERT INTO employers_new (id, firstName, last_name) SELECT id, firstName, last_name FROM employers");
            database.execSQL("DROP TABLE employers");
            database.execSQL("ALTER TABLE employers_new RENAME TO employers");
        }
    };

    static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("DROP TABLE employers");
        }
    };

    private List<Employer> generateEmployers() {
        List<Employer> employers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employer employer = new Employer("name " + i, "lastname " + i);
            employer.departmentId = 2;
            employers.add(employer);
        }
        return employers;
    }

    private Department generateDepartment() {
        Department department = new Department();
        department.id = 2;
        department.name = "depo";
        return department;
    }

    private Company generateCompany() {
        Company company = new Company();
        company.id = 1;
        company.address = "street";
        company.city = "moskowa";
        return company;
    }
}
