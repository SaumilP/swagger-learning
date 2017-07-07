package org.sandcastle.apps.commands;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public abstract class ApplicationBackendCommand<T, R extends ApplicationBackendCommand> extends HystrixCommand<T> {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private RestTemplate template;
    private String host;
    private int port;

    ApplicationBackendCommand(String host, int port) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("wildflyswarm.backend"))
                .andThreadPoolPropertiesDefaults(
                        HystrixThreadPoolProperties.Setter()
                                .withCoreSize(10)
                                .withMaxQueueSize(-1)
                )
                .andCommandPropertiesDefaults(
                        HystrixCommandProperties.Setter()
                                .withCircuitBreakerEnabled(true)
                                .withCircuitBreakerRequestVolumeThreshold(5)
                                .withMetricsRollingStatisticalWindowInMilliseconds(5000)
                )
        );
        this.host = host;
        this.port = port;
    }

    protected abstract R self();

    public R withTemplate(RestTemplate template) {
        this.template = template;
        return self();
    }

    protected String getHost() {
        return host;
    }

    protected int getPort() {
        return port;
    }

    protected void setTemplate(RestTemplate template) {
        this.template = template;
    }

    protected RestTemplate getTemplate() {
        return template;
    }
}
