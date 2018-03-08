package org.mindtrails.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.mindtrails.domain.tracking.CoachLog;

import javax.persistence.*;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by dan on 3/8/18.
 */
@Entity
@Data
@DiscriminatorValue("coach")
public class Coach extends Participant {

    @OneToMany(mappedBy="coachedBy", fetch = FetchType.EAGER)
    protected List<Participant> coaching;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "participant", fetch = FetchType.EAGER)
    @JsonIgnore
    @OrderBy(value = "contactDate")
    protected SortedSet<CoachLog> reports = new TreeSet<>();




}
