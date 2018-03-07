package org.mindtrails.controller;

import org.mindtrails.domain.Participant;
import org.mindtrails.domain.questionnaire.QuestionnaireData;
import org.mindtrails.persistence.CoachReport;
import org.mindtrails.persistence.CoachReportRepository;
import org.mindtrails.service.ParticipantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Date;

/**
 * Pages restricted to Coaches and Administrators
 */
@Controller
@RequestMapping("/coach")
public class CoachController {

    private static final Logger LOG = LoggerFactory.getLogger(CoachController.class);

    @Autowired
    private ParticipantService participantService;

    @Autowired
    private CoachReportRepository reportRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String coachOverview() {
        return "coach/overview";
    }

    @RequestMapping(value = "report/{id}", method = RequestMethod.GET)
    public String showForm(ModelMap model, Principal principal, @PathVariable("id") Long participant_id) {

        // Participant coach = participantService.get(principal);
        Participant participant = participantService.find(participant_id);
        CoachReport report = new CoachReport();
        report.setContactDate(new Date());


        model.addAttribute("participant", participant);
        model.addAttribute("coachReport", new CoachReport());
        model.addAttribute("contactTypes", CoachReport.contactTypes);
        return ("questions/CoachReport");

    }

    @RequestMapping(value="report/{id}", method=RequestMethod.POST)
    public String submitReport(CoachReport report, Principal principal,
                               @PathVariable("id") Long participant_id) {

        Participant coach = participantService.get(principal);
        Participant participant = participantService.find(participant_id);
        report.setId(null);  // This should always create a new report.
        report.setCoachId(coach.getId());
        report.setParticipant(participant);
        reportRepository.save(report);
        return("redirect:/coach");
    }


}
