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

        if (methods.size() != 2) {
            throw new AssertionError("SomeLernejoTests class must have 2 test methods");
        }
        if (methods.stream().noneMatch(method -> method.getName().equals("ok"))) {
            throw new AssertionError("SomeLernejoTests class must have ok() test method");
        }
        if (methods.stream().noneMatch(method -> method.getName().equals("ko"))) {
            throw new AssertionError("SomeLernejoTests class must have ko() test method");
        }
    }
}
