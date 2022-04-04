package com.example.school.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "birth")
    private LocalDate birth;
    @Column(name = "sex")
    private String sex;
    @Column(name = "present")
    private Boolean present;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_room_id", referencedColumnName = "id")
    private ClassRoom classRoomId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return id != null && Objects.equals(id,student.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
