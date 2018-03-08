package org.mindtrails.persistence;

import org.mindtrails.domain.tracking.CoachLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dan on 3/6/18.
 */
public interface CoachLogRepository extends JpaRepository<CoachLog, Long> {
    List<CoachLog> findByCoachId(Long id);
}
