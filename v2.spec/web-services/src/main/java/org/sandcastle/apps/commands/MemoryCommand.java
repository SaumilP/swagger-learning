package org.sandcastle.apps.commands;

import org.sandcastle.apps.models.Memory;

public class MemoryCommand extends ApplicationBackendCommand<Memory, MemoryCommand> {
    private String memoryId;

    public MemoryCommand(String host, int port) {
        super(host, port);
    }

    @Override
    protected MemoryCommand self() {
        return this;
    }

    public MemoryCommand withMemoryId(String memoryId) {
        this.memoryId = memoryId;
        return this;
    }

    @Override
    protected Memory run() throws Exception {
        String memoryBackendServiceUrl = String.format("http://%s:%d/api/backend/memory?memory={memoryId}", getHost(), getPort());
        log.info("Sending to : {}", memoryBackendServiceUrl);
        return getTemplate().getForObject(memoryBackendServiceUrl, Memory.class, memoryId);
    }

    @Override
    protected Memory getFallback() {
        Memory memory = new Memory();
        return memory;
    }
}
