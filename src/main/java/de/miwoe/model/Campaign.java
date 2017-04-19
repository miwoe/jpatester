package de.miwoe.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Grauschleier on 19.04.2017.
 */
@Entity
@Data
public class Campaign {

    @Id
    String id;

    String name;
}
