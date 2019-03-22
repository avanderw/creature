package net.avdw.creature;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.api.java8.En;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;
import org.pmw.tinylog.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CreatureStepdefs implements En {
    private List<Creature> creatures = new ArrayList<>();
    private List<Describer> describers = new ArrayList<>();
    private List<String> descriptions = new ArrayList<>();

    private Exception exception;
    private Injector injector;

    public CreatureStepdefs() {
        Configurator.currentConfig()
                .formatPattern("{date:yyyy-MM-dd HH:mm:ss} [{thread}] {class}.{method}() {level}: {message}")
                .level(Level.TRACE)
                .activate();

        Given("^I create a creature injector$", () -> {
            injector = Guice.createInjector(new CreatureModule());
        });
        Given("^I create a creature$", () -> {
            creatures.add(injector.getInstance(Creature.class));
        });
        And("^I create a  describer$", () -> {
            describers.add(injector.getInstance(Describer.class));
        });
        When("^I describe creature (\\d+) using  describer (\\d+)$", (Integer creatureIdx, Integer describerIdx) -> {
            descriptions.add(describers.get(describerIdx).describe());
        });
        Then("^description (\\d+) for the heart will represent creature (\\d+) heart$", (Integer descriptionIdx, Integer creatureIdx) -> {
            Heart heart = creatures.get(creatureIdx).body.heart;
            assertThat(heart, is(notNullValue()));
            assertThat(descriptions.get(descriptionIdx), is(notNullValue()));
            assertThat(descriptions.get(descriptionIdx), containsString(heart.description));
        });
        Then("^description (\\d+) and description (\\d+) will be equal$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
        Then("^description (\\d+) and description (\\d+) will not be equal$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
        And("^description (\\d+) will not have the same structure to description (\\d+)$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
        And("^description (\\d+) will have the same structure to description (\\d+)$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
    }
}
