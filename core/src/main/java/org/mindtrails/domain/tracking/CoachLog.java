package org.mindtrails.domain.tracking;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mindtrails.domain.DoNotDelete;
import org.mindtrails.domain.Participant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Stores information about a coaching session.  Typically submitted by a coach.0
 * Created by dan on 3/6/18.
 */
@Entity
@Table(name="coach_log")
@EqualsAndHashCode(exclude = {"coach","participant"})
@Data
@DoNotDelete
public class CoachLog extends MindTrailsLog {

    public static ArrayList<String> contactTypes = new ArrayList<>(Arrays.asList("Email", "Phone","Text"));

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    protected Participant coach;

    protected Date contactDate;
    protected String contactMethod;
    protected Boolean coachingSession = false;
    @Lob
    protected String comments;
    protected Date nextContactDate;

}
