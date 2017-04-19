package de.miwoe.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Grauschleier on 19.04.2017.
 */
@Entity
@Data
public class Job {

    @Id
    String id;

    String name;

    @OneToOne(cascade = CascadeType.ALL)
    JobStatus jobStatus;

    @OneToOne(cascade = CascadeType.ALL)
    JobStatusBi jobStatusBi;

    @ManyToOne(cascade = CascadeType.PERSIST)
    Campaign campaign;
}
