package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Faculty extends Auditable{
    @Column(nullable = false)
    private String name;

    @ManyToOne
    private University university;

    @OneToMany(mappedBy = "faculty")
    private List<Group> groups;

    private int openYear;
}
