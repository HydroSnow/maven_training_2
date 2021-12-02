package fr.lernejo.tester;

import fr.lernejo.tester.internal.TestClassDescription;
import fr.lernejo.tester.internal.TestClassDiscoverer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    public static void main(final String[] args) {
        final List<TestClassDescription> testClassDescriptions = new ArrayList<>();
        for (final String packageName : args) {
            testClassDescriptions.addAll(new TestClassDiscoverer(packageName).listTestClasses());
        }

        final List<Method> methods = new ArrayList<>();
        for (final TestClassDescription testClassDescription : testClassDescriptions) {
            methods.addAll(testClassDescription.listTestMethods());
        }

        long okTests = 0;
        long koTests = 0;
        final long allStart = System.currentTimeMillis();
        for (final Method method : methods) {
            final Class<?> clazz = method.getDeclaringClass();
            System.out.print(clazz.getName() + "#" + method.getName());

            final long methodStart = System.currentTimeMillis();
            try {
                final Object testInstance = clazz.getDeclaredConstructor().newInstance();
                method.invoke(testInstance);
                okTests++;
                System.out.print(" OK");
            } catch (final InvocationTargetException e) {
                koTests++;
                System.out.print(" KO");
            } catch (final NoSuchMethodException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
                System.out.print(" ERROR");
            }
            final long methodTime = System.currentTimeMillis() - methodStart;
            System.out.println(" " + methodTime + " ms");
        }
        final long allTime = System.currentTimeMillis() - allStart;
        System.out.println();
        System.out.println("Tests: " + (okTests + koTests) + ", Failed: " + koTests + ", Elapsed: " + allTime + " ms");
    }
}
