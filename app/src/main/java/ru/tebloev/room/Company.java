package ru.tebloev.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "company",
        indices = {@Index("company_name"),
                @Index(value = {"company_name", "address"},
                        unique = false)})
public class Company {
    @PrimaryKey
    long id;
    @ColumnInfo(name = "company_name")
    String name;
    String city;
    String address;
}
