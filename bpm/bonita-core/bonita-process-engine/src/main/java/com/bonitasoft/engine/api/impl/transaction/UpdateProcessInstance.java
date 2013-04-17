/*******************************************************************************
 * Copyright (C) 2013 BonitaSoft S.A.
 * BonitaSoft is a trademark of BonitaSoft SA.
 * This software file is BONITASOFT CONFIDENTIAL. Not For Distribution.
 * For commercial licensing information, contact:
 * BonitaSoft, 32 rue Gustave Eiffel – 38000 Grenoble
 * or BonitaSoft US, 51 Federal Street, Suite 305, San Francisco, CA 94107
 *******************************************************************************/
package com.bonitasoft.engine.api.impl.transaction;

import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;

import org.bonitasoft.engine.bpm.model.Index;
import org.bonitasoft.engine.commons.exceptions.SBonitaException;
import org.bonitasoft.engine.commons.transaction.TransactionContent;
import org.bonitasoft.engine.core.process.instance.api.ProcessInstanceService;
import org.bonitasoft.engine.core.process.instance.model.SProcessInstance;
import org.bonitasoft.engine.recorder.model.EntityUpdateDescriptor;

import com.bonitasoft.engine.bpm.model.ProcessInstanceUpdateDescriptor;
import com.bonitasoft.engine.bpm.model.ProcessInstanceUpdateDescriptor.ProcessInstanceField;
import com.bonitasoft.engine.core.process.instance.model.builder.SProcessInstanceUpdateBuilder;

/**
 * @author Baptiste Mesta
 */
public class UpdateProcessInstance implements TransactionContent {

    private final ProcessInstanceService instanceService;

    private final ProcessInstanceUpdateDescriptor descriptor;

    private final long processInstanceId;

    private final SProcessInstanceUpdateBuilder updateBuilder;

    private Index index;

    private String value;

    public UpdateProcessInstance(final ProcessInstanceService instanceService, final ProcessInstanceUpdateDescriptor descriptor,
            final SProcessInstanceUpdateBuilder updateBuilder, final long processInstanceId) {
        super();
        this.instanceService = instanceService;
        this.descriptor = descriptor;
        this.processInstanceId = processInstanceId;
        this.updateBuilder = updateBuilder;
    }

    public UpdateProcessInstance(final ProcessInstanceService instanceService, final SProcessInstanceUpdateBuilder updateBuilder, final long processInstanceId,
            final Index index, final String value) {
        super();
        this.instanceService = instanceService;
        this.processInstanceId = processInstanceId;
        this.updateBuilder = updateBuilder;
        descriptor = null;
        this.index = index;
        this.value = value;
    }

    @Override
    public void execute() throws SBonitaException {
        final SProcessInstance processInstance = instanceService.getProcessInstance(processInstanceId);
        final EntityUpdateDescriptor updateDescriptor = getProcessInstanceUpdateDescriptor();
        instanceService.updateProcess(processInstance, updateDescriptor);
    }

    private EntityUpdateDescriptor getProcessInstanceUpdateDescriptor() {
        if (descriptor == null) {
            switch (index) {
                case FIRST:
                    updateBuilder.updateStringIndex1(value);
                    break;
                case SECOND:
                    updateBuilder.updateStringIndex2(value);
                    break;
                case THIRD:
                    updateBuilder.updateStringIndex3(value);
                    break;
                case FOURTH:
                    updateBuilder.updateStringIndex4(value);
                    break;
                case FIFTH:
                    updateBuilder.updateStringIndex5(value);
                    break;
            }
        } else {
            final Map<ProcessInstanceField, Serializable> fields = descriptor.getFields();
            for (final Entry<ProcessInstanceField, Serializable> field : fields.entrySet()) {
                switch (field.getKey()) {
                    case STRING_INDEX_1:
                        updateBuilder.updateStringIndex1((String) field.getValue());
                        break;
                    case STRING_INDEX_2:
                        updateBuilder.updateStringIndex2((String) field.getValue());
                        break;
                    case STRING_INDEX_3:
                        updateBuilder.updateStringIndex3((String) field.getValue());
                        break;
                    case STRING_INDEX_4:
                        updateBuilder.updateStringIndex4((String) field.getValue());
                        break;
                    case STRING_INDEX_5:
                        updateBuilder.updateStringIndex5((String) field.getValue());
                        break;
                }
            }
        }
        updateBuilder.updateLastUpdate(System.currentTimeMillis());
        return updateBuilder.done();
    }

}
