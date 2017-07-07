package org.sandcastle.apps.api;

import org.springframework.web.client.RestTemplate;

public abstract class ApiResource {
    private RestTemplate template = new RestTemplate();

    // These property names must match `application.properties`
    private String serviceHost;
    private int servicePort;

    public ApiResource(RestTemplate template) {
        this.template = template;
    }

    public RestTemplate getTemplate() {
        return template;
    }

    public void setTemplate(RestTemplate template) {
        this.template = template;
    }

    public String getServiceHost() {
        return serviceHost;
    }

    public void setServiceHost(String serviceHost) {
        this.serviceHost = serviceHost;
    }

    public int getServicePort() {
        return servicePort;
    }

    public void setServicePort(int servicePort) {
        this.servicePort = servicePort;
    }
}
