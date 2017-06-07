package de.miwoe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.UUID;

/**
 * Created by mwoelm on 21.05.17.
 */
@Entity
@Data
public class ERPReference {

    @Id
    private UUID id;

    @OneToOne
    private Job job;

    private String erpReferenceNumber;

    private String erpDerivedDisplayName;

    private int erpDerivedPriority;



}
