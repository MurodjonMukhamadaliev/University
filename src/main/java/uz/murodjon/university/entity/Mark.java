package uz.murodjon.university.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Mark extends Auditable {
    private int mark;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Journal journal;

    @ManyToOne
    private Subject subject;
}
