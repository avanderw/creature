package net.avdw.creature;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.api.java8.En;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.not;

public class DescribeStepdefs implements En {
    private static Creature creature;
    private static String description;
    public DescribeStepdefs() {
        Injector injector = Guice.createInjector(new CreatureModule());
        Given("^a creature$", () -> {
            creature = injector.getInstance(Creature.class);
        });
        When("^I describe the creature$", () -> {
            description = injector.getInstance(CreatureDescriber.class).describe();
        });
        Then("^there must be no template code$", () -> {
            assertThat(description, not(matchesPattern(".*<.*>.*")));
        });
    }
}
