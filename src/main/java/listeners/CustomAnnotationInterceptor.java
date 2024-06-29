/**
 * Author : Ashwin Rathore
 * Date : 29-06-2024
 * Email - ashwin.rathore001@gmail.com
 */


package listeners;
import customAnnotations.ExecuteTest;
import org.testng.*;
import org.testng.IMethodInstance;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CustomAnnotationInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<>();
        String testType = context.getCurrentXmlTest().getParameter("TestType");
        String priority = context.getCurrentXmlTest().getParameter("Priority");
        String positive = context.getCurrentXmlTest().getParameter("Positive");
        String negative = context.getCurrentXmlTest().getParameter("Negative");
        String ticketId = context.getCurrentXmlTest().getParameter("TicketId");
        String epicId = context.getCurrentXmlTest().getParameter("EpicId");
        String featurePackId = context.getCurrentXmlTest().getParameter("FeaturePackId");

        for (IMethodInstance methodInstance : methods) {
            Method method = methodInstance.getMethod().getConstructorOrMethod().getMethod();
            ExecuteTest executeTest = method.getAnnotation(ExecuteTest.class);

            if (executeTest != null) {
                boolean match = true;

                if (testType != null && !testType.isEmpty() && !containsIgnoreCase(executeTest.TestType(), testType)) {
                    match = false;
                }

                if (priority != null && !priority.isEmpty() && executeTest.Priority() != Integer.parseInt(priority)) {
                    match = false;
                }

                if (positive != null && !positive.isEmpty() && executeTest.Positive() != Boolean.parseBoolean(positive)) {
                    match = false;
                }

                if (negative != null && !negative.isEmpty() && executeTest.Negative() != Boolean.parseBoolean(negative)) {
                    match = false;
                }
                if (ticketId != null && !ticketId.isEmpty() && !containsIgnoreCase(executeTest.TicketId(), ticketId)) {
                    match = false;
                }
                if (epicId != null && !epicId.isEmpty() && !containsIgnoreCase(executeTest.EpicId(), epicId)) {
                    match = false;
                }
                if (featurePackId != null && !featurePackId.isEmpty() && !containsIgnoreCase(executeTest.FeaturePackId(), featurePackId)) {
                    match = false;
                }
                if (match) {
                    result.add(methodInstance);
                }
            }
        }
        return result;
    }

    private boolean containsIgnoreCase(String[] array, String value) {
        for (String str : array) {
            if (str.equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
