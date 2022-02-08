package com.fengwenyi.demospringbootactiviti;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-13
 */
@SpringBootTest
public class DemoSpringBootActivitiApplicationTests {

    private static final String PROCESS_DEFINITION_KEY = "categorizeProcess";

    @Autowired
    private ProcessRuntime processRuntime;

    @Autowired
    private SecurityUtil securityUtil;

    @Test
    public void contextLoads() {
        securityUtil.logInAs("system");

        ProcessDefinition processDefinition = processRuntime.processDefinition(PROCESS_DEFINITION_KEY);

        assertThat(processDefinition).isNotNull();
        assertThat(processDefinition.getKey()).isEqualTo(PROCESS_DEFINITION_KEY);
        assertThat(processDefinition.getAppVersion()).isNull();
    }

}
