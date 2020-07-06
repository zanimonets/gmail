package com.unit;

import com.ui.business.model.Email;
import com.ui.core.util.RandomGenerator;
import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

    @Test
    public void compareToLessTest() {
        Email firstEmail = new Email.Builder().subjectField("a").build();
        Email secondEmail = new Email.Builder().subjectField("z").build();

        int result = firstEmail.compareTo(secondEmail);
        Assert.assertTrue("Comparison does not work properly", result < 0);
    }

    @Test
    public void compareToMoreTest() {
        Email firstEmail = new Email.Builder().subjectField("a").build();
        Email secondEmail = new Email.Builder().subjectField("A").build();

        int result = firstEmail.compareTo(secondEmail);
        Assert.assertTrue("Comparison does not work properly", result > 0);
    }

    @Test
    public void compareToEqualTest() {
        Email firstEmail = new Email.Builder().subjectField("a").build();
        Email secondEmail = new Email.Builder().subjectField("a").build();

        int result = firstEmail.compareTo(secondEmail);
        Assert.assertTrue("Comparison does not work properly", result == 0);
    }

    @Test
    public void cloneTest() {
        String emailSubject = "AutoTestSubject" + RandomGenerator.randomString();
        String emailBody = "AutoTestBody" + RandomGenerator.randomString(15);

        Email initialEmail = new Email.Builder().subjectField(emailSubject).emailBody(emailBody).build();
        Email clonedEmail = initialEmail.clone();

        Assert.assertTrue("Cloning does not work properly", initialEmail.equals(clonedEmail));
    }
}
