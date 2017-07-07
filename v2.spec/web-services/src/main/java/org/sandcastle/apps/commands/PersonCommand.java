package org.sandcastle.apps.commands;

import org.sandcastle.apps.models.Person;

public class PersonCommand extends ApplicationBackendCommand<Person, PersonCommand> {
    private String personId;

    public PersonCommand(String host, int port) {
        super(host, port);
    }

    @Override
    protected PersonCommand self() {
        return this;
    }

    public PersonCommand withPersonId(String personId) {
        this.personId = personId;
        return this;
    }

    @Override
    protected Person run() throws Exception {
        String personBackendServiceUrl = String.format("http://%s:%d/api/backend/person?person={personId}", getHost(), getPort());
        log.info("Sending to : {}", personBackendServiceUrl);
        return getTemplate().getForObject(personBackendServiceUrl, Person.class, personId);
    }

    @Override
    protected Person getFallback() {
        Person person = new Person();
        person.setName("Saumil");
        return person;
    }
}
