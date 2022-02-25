package pl.codent.todolist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //given
            Doctor docTest = new Doctor();
            docTest.setName("Nowak");
            docTest.setDone(true);



        //when
        boolean resultDone = docTest.getDone();
        String  resultName = docTest.getName();

        //then shouldSayresultDoneIsTrue & shouldPrintResultNameIsNowak
        Assert.assertTrue("true", resultDone);
        Assert.assertEquals("Nowak",resultName);

    }
}