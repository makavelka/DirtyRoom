package ru.tebloev.room;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

@Entity(tableName = "employers_count", indices = {@Index("name"),
        @Index(value = {"order_id", "item_id"})},
        foreignKeys = {@ForeignKey(entity = Company.class, parentColumns = "id", childColumns = "order_id"),
                @ForeignKey(entity = Employer.class, parentColumns = "id", childColumns = "item_id")})
public class EmployerWithCompany {

    public long employerId;

    public long companyId;

    public int employersCount;
}
