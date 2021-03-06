package net.avdw.creature;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.api.java8.En;
import org.pmw.tinylog.Configurator;
import org.pmw.tinylog.Level;

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
            creatures.add(injector.getProvider(Creature.class).get());
        });
        When("^I describe creature (\\d+)$", (Integer creatureIdx) -> {
            descriptions.add(creatures.get(creatureIdx).description);
        });
        Then("^description (\\d+) for the heart will represent creature (\\d+) heart$", (Integer descriptionIdx, Integer creatureIdx) -> {
            Heart heart = creatures.get(creatureIdx).body.heart;
            assertThat(heart, is(notNullValue()));
            assertThat(descriptions.get(descriptionIdx), is(notNullValue()));
            assertThat(descriptions.get(descriptionIdx), containsString(heart.adjective));
        });
        Then("^description (\\d+) and description (\\d+) will be equal$", (Integer descIdx1, Integer descIdx2) -> {
            assertThat(descriptions.get(descIdx1), is(equalTo(descriptions.get(descIdx2))));
        });
        Then("^description (\\d+) and description (\\d+) will not be equal$", (Integer descIdx1, Integer descIdx2) -> {
            assertThat(descriptions.get(descIdx1), is(not(equalTo(descriptions.get(descIdx2)))));
        });
        And("^description (\\d+) will not have the same structure to description (\\d+)$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
        And("^description (\\d+) will have the same structure to description (\\d+)$", (Integer arg0, Integer arg1) -> {
            throw new UnsupportedOperationException();
        });
    }
}
