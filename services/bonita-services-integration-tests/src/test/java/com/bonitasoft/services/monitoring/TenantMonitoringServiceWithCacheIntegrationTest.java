package com.bonitasoft.services.monitoring;

import com.bonitasoft.engine.monitoring.TenantMonitoringService;

public class TenantMonitoringServiceWithCacheIntegrationTest extends TenantMonitoringServiceTest {

    private static TenantMonitoringService monitoringService;

    static {
        monitoringService = getServicesBuilder().buildTenantMonitoringService(true);
    }

    public TenantMonitoringServiceWithCacheIntegrationTest() throws Exception {
        super();
    }

    @Override
    protected TenantMonitoringService getMonitoringService() throws Exception {
        return monitoringService;
    }

}
