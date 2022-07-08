package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Journal extends Auditable {
    @Column(nullable = false, unique = true)
    private String name;

    @OneToOne
    private Group group;

    @ManyToMany
    private List<Subject> subjects;

    @OneToMany(mappedBy = "journal")
    private List<Mark> marks;
}
