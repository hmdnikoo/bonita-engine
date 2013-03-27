/**
 * Copyright (C) 2011-2013 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
package com.bonitasoft.engine.api.impl;

import java.util.Map;

import org.bonitasoft.engine.exception.InvalidSessionException;
import org.bonitasoft.engine.exception.MonitoringException;
import org.bonitasoft.engine.exception.UnavailableInformationException;
import org.bonitasoft.engine.management.GcInfo;
import org.bonitasoft.engine.monitoring.PlatformMonitoringService;
import org.bonitasoft.engine.service.ModelConvertor;
import org.bonitasoft.engine.service.PlatformServiceAccessor;
import org.bonitasoft.engine.service.impl.ServiceAccessorFactory;

import com.bonitasoft.engine.api.PlatformMonitoringAPI;

/**
 * @author Elias Ricken de Medeiros
 * @author Feng Hui
 * @author Matthieu Chaffotte
 */
public class PlatformMonitoringAPIImpl implements PlatformMonitoringAPI {

    @Override
    public long getCurrentMemoryUsage() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getCurrentMemoryUsage();
    }

    private PlatformMonitoringService getPlatformMonitoring() throws MonitoringException {
        PlatformServiceAccessor platformServiceAccessor = null;
        try {
            platformServiceAccessor = ServiceAccessorFactory.getInstance().createPlatformServiceAccessor();
        } catch (final Exception e) {
            throw new MonitoringException("Impossible to get platform service accessor", e);
        }

        return platformServiceAccessor.getPlatformMonitoringService();
    }

    @Override
    public float getMemoryUsagePercentage() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getMemoryUsagePercentage();
    }

    @Override
    public double getSystemLoadAverage() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getSystemLoadAverage();
    }

    @Override
    public long getUpTime() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getUpTime();
    }

    @Override
    public long getStartTime() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getStartTime();
    }

    @Override
    public long getTotalThreadsCpuTime() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getTotalThreadsCpuTime();
    }

    @Override
    public int getThreadCount() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getThreadCount();
    }

    @Override
    public int getAvailableProcessors() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getAvailableProcessors();
    }

    @Override
    public String getOSArch() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getOSArch();
    }

    @Override
    public String getOSName() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getOSName();
    }

    @Override
    public String getOSVersion() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getOSVersion();
    }

    @Override
    public String getJvmName() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getJvmName();
    }

    @Override
    public String getJvmVendor() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getJvmVendor();
    }

    @Override
    public String getJvmVersion() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getJvmVersion();
    }

    @Override
    public Map<String, String> getJvmSystemProperties() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getJvmSystemProperties();
    }

    @Override
    public boolean isSchedulerStarted() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.isSchedulerStarted();
    }

    @Override
    public long getNumberOfActiveTransactions() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.getNumberOfActiveTransactions();
    }

    @Override
    public long getProcessCpuTime() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Process Cpu Time.");
        }
        return platformMonitoringService.getProcessCpuTime();
    }

    @Override
    public long getCommittedVirtualMemorySize() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Committed Virtual Memory Size.");
        }
        return platformMonitoringService.getCommittedVirtualMemorySize();
    }

    @Override
    public long getTotalSwapSpaceSize() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Total Swap Space Size.");
        }
        return platformMonitoringService.getTotalSwapSpaceSize();
    }

    @Override
    public long getFreeSwapSpaceSize() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Free Swap Space Size.");
        }
        return platformMonitoringService.getFreeSwapSpaceSize();
    }

    @Override
    public long getFreePhysicalMemorySize() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Free Physical Memory Size.");
        }
        return platformMonitoringService.getFreePhysicalMemorySize();
    }

    @Override
    public long getTotalPhysicalMemorySize() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get Total Physical Memory Size.");
        }
        return platformMonitoringService.getTotalPhysicalMemorySize();
    }

    @Override
    public boolean isOptionalMonitoringInformationAvailable() throws InvalidSessionException, MonitoringException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        return platformMonitoringService.isOptionalMonitoringInformationAvailable();
    }

    @Override
    public Map<String, GcInfo> getLastGcInfo() throws InvalidSessionException, MonitoringException, UnavailableInformationException {
        final PlatformMonitoringService platformMonitoringService = getPlatformMonitoring();
        if (!platformMonitoringService.isOptionalMonitoringInformationAvailable()) {
            throw new UnavailableInformationException("Impossible to get the last GC info.");
        }
        return ModelConvertor.toGcInfos(platformMonitoringService.getLastGcInfo());
    }

}
