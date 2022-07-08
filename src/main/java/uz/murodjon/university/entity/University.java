package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class University extends Auditable {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    private int openYear;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    private List<Faculty> faculty;
}