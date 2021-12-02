package fr.chose;

import fr.lernejo.tester.api.TestMethod;

public class StatsTest {

    @TestMethod
    public void min_0() {
        if (Stats.of().min() != 0) {
            throw new AssertionError("Min of no number is 0");
        }
    }

    @TestMethod
    public void min_2() {
        if (Stats.of(1, 3).min() != 1) {
            throw new AssertionError("Min of 1 and 3 is 1");
        }
    }

    @TestMethod
    public void min_3() {
        if (Stats.of(2, -1, 8).min() != -1) {
            throw new AssertionError("Min of 2, -1 and 8 is -1");
        }
    }

    @TestMethod
    public void max_0() {
        if (Stats.of().max() != 0) {
            throw new AssertionError("Max of no number is 0");
        }
    }

    @TestMethod
    public void max_2() {
        if (Stats.of(1, 3).max() != 3) {
            throw new AssertionError("Max of 1 and 3 is 3");
        }
    }

    @TestMethod
    public void max_3() {
        if (Stats.of(2, -1, 8).max() != 8) {
            throw new AssertionError("Max of 2, -1 and 8 is 8");
        }
    }

    @TestMethod
    public void sum_0() {
        if (Stats.of().sum() != 0) {
            throw new AssertionError("Sum of no number is 0");
        }
    }

    @TestMethod
    public void sum_2() {
        if (Stats.of(1, 3).sum() != 4) {
            throw new AssertionError("Sum of 1 and 3 is 4");
        }
    }

    @TestMethod
    public void sum_3() {
        if (Stats.of(2, -1, 8).sum() != 9) {
            throw new AssertionError("Sum of 2, -1 and 8 is 9");
        }
    }

    @TestMethod
    public void avg_0() {
        if (Stats.of().avg() != 0) {
            throw new AssertionError("Avg of no number is 0");
        }
    }

    @TestMethod
    public void avg_2() {
        if (Stats.of(1, 3).avg() != 2) {
            throw new AssertionError("Avg of 1 and 3 is 2");
        }
    }

    @TestMethod
    public void avg_3() {
        if (Stats.of(2, -1, 8).avg() != 3) {
            throw new AssertionError("Avg of 2, -1 and 8 is 3");
        }
    }
}
