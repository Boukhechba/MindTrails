package org.mindtrails.persistence;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.mindtrails.domain.DoNotDelete;
import org.mindtrails.domain.questionnaire.LinkedQuestionnaireData;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Stores information about a coaching session.  Typically submitted by a coach.0
 * Created by dan on 3/6/18.
 */
@Entity
@Table(name="CoachReport")
@EqualsAndHashCode(callSuper = true)
@Data
@DoNotDelete
public class CoachReport extends LinkedQuestionnaireData {

    public static ArrayList<String> contactTypes = new ArrayList<>(Arrays.asList("Email", "Phone","Text"));

    protected long coacheeId;
    protected Date contactDate;
    protected String contactMethod;
    @Lob
    protected String comments;
    protected Date nextContactDate;
}
