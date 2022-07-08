package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Subject extends Auditable {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany
    private List<Group> groups;

    @ManyToMany(mappedBy = "subjects")
    private List<Journal> journals;
}