/*******************************************************************************
 * Copyright (C) 2009, 2013 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package com.bonitasoft.engine.work;

import java.util.Collection;
import java.util.concurrent.ExecutorService;

import org.bonitasoft.engine.log.technical.TechnicalLoggerService;
import org.bonitasoft.engine.sessionaccessor.SessionAccessor;
import org.bonitasoft.engine.work.AbstractWorkSynchronization;
import org.bonitasoft.engine.work.BonitaWork;
import org.bonitasoft.engine.work.ExecutorWorkService;

/**
 * @author Charles Souillard
 * @author Baptiste Mesta
 */
public class ParallelWorkSynchronization extends AbstractWorkSynchronization {

    public ParallelWorkSynchronization(final ExecutorService executorService, final TechnicalLoggerService loggerService,
            final SessionAccessor sessionAccessor,
            final ExecutorWorkService threadPoolWorkService) {
        super(threadPoolWorkService, executorService, sessionAccessor);
    }

    @Override
    protected void executeRunnables(final Collection<BonitaWork> works) {
        for (final BonitaWork work : works) {
            executorService.submit(work);
        }
    }
}
