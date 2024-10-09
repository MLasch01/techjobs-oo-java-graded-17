package org.launchcode.techjobs.oo;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static java.lang.System.lineSeparator;
import static junit.runner.Version.id;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

//        String jobString = lineSeparator() +
//                job +
//                lineSeparator();

        assertTrue(job.toString().startsWith(lineSeparator()));
        assertTrue(job.toString().endsWith(lineSeparator()));

//        assertEquals(jobString,job.toString());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        String jobString = lineSeparator() +
                job.getId() +
                "Product tester" +
                "ACME" + "Desert" +
                "Quality control" +
                "Persistence" +
                lineSeparator();

        assertEquals(jobString,job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("",
                new Employer(""),
                new Location(""),
                new PositionType(""),
                new CoreCompetency(""));

        String emptyJobString = lineSeparator() +
                "ID: " + job.getId() +
                lineSeparator() +
                "Name: Data not available" +
                lineSeparator() +
                "Employer: Data not available" +
                lineSeparator() +
                "Location: Data not available" +
                lineSeparator() +
                "Position Type: Data not available" +
                lineSeparator() +
                "Core Competency: Data not available" +
                lineSeparator();

        assertEquals(emptyJobString,job.toString());
    }


}
