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
public class MemoryController {

    private RestTemplate template = new RestTemplate();
    private String memoryServiceHost;
    private int memoryServicePort;

    @GetMapping(value = "/memories", produces = "application/json")
    public Memories getMemories() {
        return null;
    }

    @GetMapping(value = "/memories/{mid}", produces = "application/json")
    public Memories findMemories(@PathVariable String mid) {
        MemoriesCommand memoryCommand = new MemoriesCommand(memoryServiceHost, memoryServicePort)
                .withMemoryId(mid)
                .withTemplate(template);
        return memoryCommand.execute();
    }
}
