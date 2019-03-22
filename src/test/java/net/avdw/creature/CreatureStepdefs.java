package net.avdw.creature;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import cucumber.api.java8.En;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreatureStepdefs implements En {
    private static Creature creature;
    private static String description;

    private Exception exception;
    private Injector injector;

    public CreatureStepdefs() {
        Configurator.currentConfig()
                .formatPattern("{date:yyyy-MM-dd HH:mm:ss} [{thread}] {class}.{method}() {level}: {message}")
                .level(Level.TRACE)
                .activate();

        When("^I describe the creature$", () -> {
            description = injector.getInstance(CreatureDescriber.class).describe();
        });
        Then("^there must be no template code$", () -> {
            assertThat(description, not(matchesPattern(".*<.*>.*")));
        });
        Given("^I create a creature injector$", () -> {
            try {
                injector = Guice.createInjector(new CreatureModule());
            } catch (Exception e) {
                Logger.error(e);
                exception = e;
            }
        });
        When("^I inject a creature$", () -> {
            try {
                injector.getInstance(Creature.class);
            } catch (Exception e) {
                Logger.error(e);
                exception = e;
            }
        });
        Then("^there are no exceptions$", () -> {
            assertThat(exception, is(nullValue()));
        });
    }
}
