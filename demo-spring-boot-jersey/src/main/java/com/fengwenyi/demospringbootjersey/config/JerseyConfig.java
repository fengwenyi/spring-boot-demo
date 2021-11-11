package com.fengwenyi.demospringbootjersey.config;

import com.fengwenyi.demospringbootjersey.resource.DemoResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-12
 */
@Configuration
@ApplicationPath("/jersey")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(DemoResource.class);
    }
}
