package com.example.school.test.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
public class ClassRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "year")
    private String year;
    @Column(name = "code")
    private String code;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacherId;
    @OneToMany(mappedBy = "classRoomId")
    private Set<Student> studentSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassRoom classRoom = (ClassRoom) o;
        return id != null && Objects.equals(id,classRoom.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
