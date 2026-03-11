package com.example.microservices.processing.activity;

import com.broadleafcommerce.orchestration.client.ActivityResponse;
import com.broadleafcommerce.orchestration.client.SimpleActivity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class ProcessApproveDataActivity implements SimpleActivity {

    private static final String NAME = "processApproveDataActivity";
    private static final String DESC = "Process Approve Data Activity";

    @Override
    public ActivityResponse start(Map<String, Object> context) {
        log.info("ProcessApproveDataActivity started");
        // e.g. send confirmation email, update status, etc.
        return new ActivityResponse("ok");
    }

    @Override public String getName()        { return NAME; }
    @Override public String getDescription() { return DESC; }
}