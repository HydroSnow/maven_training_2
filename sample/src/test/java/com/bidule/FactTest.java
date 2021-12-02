package com.bidule;

import fr.lernejo.tester.api.TestMethod;

public class FactTest {

    @TestMethod
    public void fact_3() {
        final Fact fact = new Fact();
        if (fact.fact(3) != 6) {
            throw new AssertionError("Fact of 3 is 6");
        }
    }

    @TestMethod
    public void fact_5() {
        final Fact fact = new Fact();
        if (fact.fact(5) != 120) {
            throw new AssertionError("Fact of 5 is 120");
        }
    }

    @TestMethod
    public void fact_minus1() {
        final Fact fact = new Fact();
        try {
            fact.fact(-1);
            throw new AssertionError("Fact of -1 must fail");
        } catch (final IllegalArgumentException e) {
            // must throw IllegalArgumentException
        }
    }
}
