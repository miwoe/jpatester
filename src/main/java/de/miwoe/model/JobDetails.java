package de.miwoe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * Created by mwoelm on 27.05.17.
 */
@Entity
@Data
public class JobDetails {

    @Id
    UUID id;

    private String largeDetail;

    @OneToOne(fetch = FetchType.LAZY)
    Job job;


}
