package fr.lernejo.tester.internal;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestClassDiscoverer {

    private final String packageName;

    public TestClassDiscoverer(final String packageName) {
        this.packageName = packageName;
    }

    public List<TestClassDescription> listTestClasses() {
        // load classes in package
        final Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));
        Set<Class<?>> allTypes = reflections.getSubTypesOf(Object.class);

        // creating TestClassDescriptions
        final List<TestClassDescription> testClassDescriptions = new ArrayList<>();
        for (final Class<?> clazz : allTypes) {
            final TestClassDescription testClassDescription = new TestClassDescription(clazz);
            testClassDescriptions.add(testClassDescription);
        }
        return testClassDescriptions;
    }
}
