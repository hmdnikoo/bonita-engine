/*******************************************************************************
 * Copyright (C) 2009, 2012 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package org.bonitasoft.engine.test;

import org.junit.Test;

import com.bonitasoft.engine.api.impl.LogAPIExt;
import com.bonitasoft.engine.api.impl.MigrationAPIImpl;
import com.bonitasoft.engine.api.impl.MonitoringAPIImpl;
import com.bonitasoft.engine.api.impl.PlatformMonitoringAPIImpl;

public class APIMethodSPTest extends APIMethodTest {

    @Test
    public void checkAllMethodsOfLogAPIThrowInvalidSessionException() {
        checkThrowsInvalidSessionException(LogAPIExt.class);
    }

    @Test
    public void checkAllMethodsOfLogAPIContainsSerializableParameters() {
        checkAllParametersAreSerializable(LogAPIExt.class);
    }

    @Test
    public void checkAllMethodsOfMonitoringAPIThrowInvalidSessionException() {
        checkThrowsInvalidSessionException(MonitoringAPIImpl.class);
    }

    @Test
    public void checkAllMethodsOfMonitoringAPIContainsSerializableParameters() {
        checkAllParametersAreSerializable(MonitoringAPIImpl.class);
    }

    @Test
    public void checkAllMethodsOfMigrationAPIThrowInvalidSessionException() {
        checkThrowsInvalidSessionException(MigrationAPIImpl.class);
    }

    @Test
    public void checkAllMethodsOfMigrationAPIContainsSerializableParameters() {
        checkAllParametersAreSerializable(MigrationAPIImpl.class);
    }

    @Test
    public void checkAllMethodsOfPlatformMonitoringAPIThrowInvalidSessionException() {
        checkThrowsInvalidSessionException(PlatformMonitoringAPIImpl.class);
    }

    @Test
    public void checkAllMethodsOfPlatformMonitoringAPIContainsSerializableParameters() {
        checkAllParametersAreSerializable(PlatformMonitoringAPIImpl.class);
    }

}
