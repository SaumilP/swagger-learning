package org.sandcastle.apps.commands;

import org.sandcastle.apps.models.Memories;

public class MemoriesCommand extends ApplicationBackendCommand<Memories, MemoriesCommand> {
    private String memoryId;

    public MemoriesCommand(String host, int port) {
        super(host, port);
    }

    @Override
    protected MemoriesCommand self() {
        return this;
    }

    public MemoriesCommand withMemoryId(String memoryId) {
        this.memoryId = memoryId;
        return this;
    }

    @Override
    protected Memories run() throws Exception {
        String memoryBackendServiceUrl = String.format("http://%s:%d/api/backend/memory?memory={memoryId}", getHost(), getPort());
        log.info("Sending to : {}", memoryBackendServiceUrl);
        return getTemplate().getForObject(memoryBackendServiceUrl, Memories.class, memoryId);
    }

    @Override
    protected Memories getFallback() {
        Memories memories = new Memories();
        return memories;
    }
}
