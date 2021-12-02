package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClassDiscovererLernejoTests {

    @TestMethod
    public void test() {
        final TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        final List<TestClassDescription> testClassDescriptions = testClassDiscoverer.listTestClasses();

        final List<Method> methods = new ArrayList<>();
        for (final TestClassDescription testClassDescription : testClassDescriptions) {
            methods.addAll(testClassDescription.listTestMethods());
        }

        if (methods.stream().noneMatch(method -> method.getName().equals("ok"))) {
            throw new AssertionError("fr.lernejo.tester package must have ok() test method");
        }
        if (methods.stream().noneMatch(method -> method.getName().equals("ko"))) {
            throw new AssertionError("fr.lernejo.tester package must have ko() test method");
        }
    }
}
