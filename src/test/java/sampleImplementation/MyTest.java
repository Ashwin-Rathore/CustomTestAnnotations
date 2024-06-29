/**
 * Author : Ashwin Rathore
 * Date : 29-06-2024
 * Email - ashwin.rathore001@gmail.com
 */


package sampleImplementation;

import customAnnotations.ExecuteTest;
import org.testng.annotations.Test;

public class MyTest {
    @ExecuteTest(FeaturePackId = {"Test-123"})
    @Test
    public void test1() {
        System.out.println("============ I am Annotation1 with Attributes ->> Feature Pack = TL-123 ============");
    }


    @ExecuteTest(EpicId = {"EPIC-1"})
    @Test
    public void test2() {
        System.out.println("============ I am Annotation4 with Attributes ->> Epic Id = EPIC-1 ============");
    }


    @ExecuteTest(TestType = "Regression",Positive = true,Negative = true,TicketId = {"TL-001"},EpicId = {"EPIC-1"},FeaturePackId = {"TL-234"})
    @Test
    public void test3() {
        System.out.println("============ I am Annotation7 with All the ===========");
    }

}
