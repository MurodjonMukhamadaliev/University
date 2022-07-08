package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groups")
public class Group extends Auditable {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Faculty faculty;
    @OneToOne(mappedBy = "group")
    private Journal journal;

    @OneToMany(mappedBy = "group")
    private List<Student> students;

    private int year;
}
