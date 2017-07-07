package org.sandcastle.apps.api;

import org.sandcastle.apps.commands.PersonCommand;
import org.sandcastle.apps.models.Person;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "person")
public class PersonResource extends ApiResource {

    public PersonResource(RestTemplate template) {
        super(template);
    }

    @GetMapping(value = "/person/{personId}", produces = "application/json")
    public Person findPerson(@PathVariable String personId) {
        PersonCommand personCommand = new PersonCommand(getServiceHost(), getServicePort())
                .withPersonId(personId)
                .withTemplate(getTemplate());
        return personCommand.execute();
    }
}
