package fr.lernejo.tester.internal;

import fr.lernejo.tester.api.TestMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class TestClassDescription {

    private final Class<?> clazz;

    public TestClassDescription(final Class<?> clazz) {
        this.clazz = clazz;
    }

    public List<Method> listTestMethods() {
        final List<Method> methods = new ArrayList<>();
        for (final Method method : clazz.getDeclaredMethods()) {
            // on ignore si la méthode n'est pas publique
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            // on ignore si la méthode renvoie quelque chose
            if (!method.getReturnType().equals(void.class)) {
                continue;
            }
            // on ignore si la méthode comporte des paramètres
            if (method.getParameterCount() > 0) {
                continue;
            }
            // on ignore si ce n'est pas une méthode annotée
            if (!method.isAnnotationPresent(TestMethod.class)) {
                continue;
            }
            methods.add(method);
        }
        return methods;
    }
}
