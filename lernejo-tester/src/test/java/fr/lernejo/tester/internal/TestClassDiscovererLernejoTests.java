package fr.lernejo.tester.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestClassDiscovererLernejoTests {

    public static void main(final String[] args) {
        new TestClassDiscovererLernejoTests().test();
    }

    public void test() {
        final TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        final List<TestClassDescription> testClassDescriptions = testClassDiscoverer.listTestClasses();

        final List<Method> methods = new ArrayList<>();
        for (final TestClassDescription testClassDescription : testClassDescriptions) {
            methods.addAll(testClassDescription.listTestMethods());
        }

        if (methods.size() != 2) {
            throw new AssertionError("fr.lernejo.tester package must have 2 test methods");
        }
        if (methods.stream().noneMatch(method -> method.getName().equals("ok"))) {
            throw new AssertionError("fr.lernejo.tester package must have ok() test method");
        }
        if (methods.stream().noneMatch(method -> method.getName().equals("ko"))) {
            throw new AssertionError("fr.lernejo.tester package must have ko() test method");
        }
    }
}
