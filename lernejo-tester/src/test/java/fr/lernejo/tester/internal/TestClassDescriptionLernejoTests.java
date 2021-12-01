package fr.lernejo.tester.internal;

import fr.lernejo.tester.SomeLernejoTests;

import java.lang.reflect.Method;
import java.util.List;

public class TestClassDescriptionLernejoTests {

    public static void main(final String[] args) {
        new TestClassDescriptionLernejoTests().test();
    }

    public void test() {
        final TestClassDescription testClassDescription = new TestClassDescription(SomeLernejoTests.class);
        final List<Method> methods = testClassDescription.listTestMethods();
        for (final Method method : methods) {
            System.out.println(method);
        }
    }
}
