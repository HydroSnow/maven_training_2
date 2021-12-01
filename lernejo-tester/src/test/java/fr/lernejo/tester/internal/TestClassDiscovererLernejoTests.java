package fr.lernejo.tester.internal;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDiscovererLernejoTests {

    public static void main(final String[] args) {
        new TestClassDiscovererLernejoTests().test();
    }

    public void test() {
        final TestClassDiscoverer testClassDiscoverer = new TestClassDiscoverer("fr.lernejo.tester");
        final List<TestClassDescription> testClassDescriptions = testClassDiscoverer.listTestClasses();
        for (final TestClassDescription testClassDescription : testClassDescriptions) {
            final List<Method> methods = testClassDescription.listTestMethods();
            for (final Method method : methods) {
                System.out.println(method);
            }
        }
    }
}
