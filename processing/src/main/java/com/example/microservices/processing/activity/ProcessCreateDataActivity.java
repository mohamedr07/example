package com.example.microservices.processing.activity;

import com.broadleafcommerce.orchestration.client.ActivityResponse;
import com.broadleafcommerce.orchestration.client.SimpleActivity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class ProcessCreateDataActivity implements SimpleActivity {

    private static final String NAME = "processCreateDataActivity";
    private static final String DESC = "Process Create Data Activity";

    @Override
    public ActivityResponse start(Map<String, Object> context) {
        log.info("ProcessCreateDataActivity started");

        String workflowId = getWorkflowInformation().getWorkflowId();
        log.info("Workflow ID: {}", workflowId);

        // Your business logic here
        // Return "nok" to route to failure activity
        return new ActivityResponse("ok");
    }

    @Override public String getName()        { return NAME; }
    @Override public String getDescription() { return DESC; }
}