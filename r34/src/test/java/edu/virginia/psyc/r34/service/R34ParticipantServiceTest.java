package edu.virginia.psyc.r34.service;

import edu.virginia.psyc.r34.Application;
import edu.virginia.psyc.r34.domain.R34NeutralStudy;
import edu.virginia.psyc.r34.domain.R34Study;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mindtrails.domain.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class R34ParticipantServiceTest {

    @Autowired
    R34ParticipantService service;


    @Test
    public void testNewParticipantGetsRandomCBMCondition() {

        Participant p;
        R34Study s;

        boolean is50 = false;
        boolean isPos = false;
        boolean isNeutral = false;

        p = service.create();
        assertTrue(p.getStudy() instanceof R34Study);
        s = (R34Study)p.getStudy();
        assertNotNull(s.getConditioning());

        for(int i = 0; i< 100; i++)  {
            p = service.create();
            s = (R34Study)p.getStudy();
            if(s.getConditioning().equals(R34Study.CONDITION.FIFTY_FIFTY.toString())) is50 = true;
            if(s.getConditioning().equals(R34Study.CONDITION.POSITIVE.toString())) isPos = true;
            if(s.getConditioning().equals(R34Study.CONDITION.NEUTRAL.toString())) isNeutral = true;
        }

        assertTrue("after 100 iterations, 50/50 should have occurred at least once", is50);
        assertTrue("after 100 iterations, Positive should have occurred at least once", isPos);
        assertTrue("after 100 iterations, Neutral should have occurred at least once", isNeutral);

    }

    @Test
    public void atestNewParticipantGetsRandomPrime() {

        Participant p;
        R34Study s;

        boolean isAnxious = false;
        boolean isNeutral = false;

        p = service.create();
        assertTrue(p.getStudy() instanceof R34Study);
        s = (R34Study)p.getStudy();

        assertNotNull(s.getPrime());

        for(int i = 0; i< 100; i++)  {
            p = service.create();
            s = (R34Study)p.getStudy();
            if(s.getPrime().equals(R34Study.PRIME.ANXIETY)) isAnxious = true;
            if(s.getPrime().equals(R34Study.PRIME.NEUTRAL)) isNeutral = true;
        }

        assertTrue("after 100 iterations, ANXIETY should have occurred at least once", isAnxious);
        assertTrue("after 100 iterations, Neutral should have occurred at least once", isNeutral);

    }

    @Test
    public void testNeutralParticipantInNeutralStudy() {

        Participant p;
        R34Study s;

        boolean isNeutral = false;

        for(int i = 0; i< 100; i++)  {
            p = service.create();
            s = (R34Study) p.getStudy();
            if(s.getConditioning().equals(R34Study.CONDITION.NEUTRAL.toString())) {
                isNeutral = true;
                assertTrue(p.getStudy() instanceof R34NeutralStudy);
            }
        }

        assertTrue("after 100 iterations, Neutral should have occurred at least once", isNeutral);
    }


}
