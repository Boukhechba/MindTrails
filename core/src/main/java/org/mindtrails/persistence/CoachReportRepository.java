package org.mindtrails.persistence;

import java.util.List;

/**
 * Created by dan on 3/6/18.
 */
public interface CoachReportRepository extends QuestionnaireRepository<CoachReport> {
    List<CoachReport> findByCoachId(Long id);
}
