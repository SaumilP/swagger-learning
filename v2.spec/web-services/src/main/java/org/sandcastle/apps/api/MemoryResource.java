package org.sandcastle.apps.api;

import org.sandcastle.apps.commands.MemoriesCommand;
import org.sandcastle.apps.models.Memories;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@ConfigurationProperties(prefix = "memories")
public class MemoryResource extends ApiResource {

    public MemoryResource(RestTemplate template) {
        super(template);
    }

    @GetMapping(value = "/memories", produces = "application/json")
    public Memories getMemories() {
        return null;
    }

    @GetMapping(value = "/memory/{mid}", produces = "application/json")
    public Memories findMemories(@PathVariable String mid) {
        MemoriesCommand memoryCommand = new MemoriesCommand(getServiceHost(), getServicePort())
                .withMemoryId(mid)
                .withTemplate(getTemplate());
        return memoryCommand.execute();
    }
}
