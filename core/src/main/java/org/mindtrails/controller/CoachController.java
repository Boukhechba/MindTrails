package org.mindtrails.controller;

import org.mindtrails.service.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Pages restricted to Coaches and Administrators
 */
@Controller
@RequestMapping("/coach")
public class CoachController {

    private static final Logger LOG = LoggerFactory.getLogger(CoachController.class);

    @Autowired
    private ParticipantService participantService;

    @RequestMapping(method = RequestMethod.GET)
    public String coachOverview() {
        return "coach/overview";
    }


}
