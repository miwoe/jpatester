package de.miwoe.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by Grauschleier on 19.04.2017.
 */
@Entity
@Data
public class JobStatusBi {
    @Id
    private String id;
    private String statusValue;

    @OneToOne(mappedBy = "jobStatusBi", cascade = CascadeType.ALL)
    Job job;
}
