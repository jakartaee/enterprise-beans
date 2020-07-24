/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

package jakarta.ejb;

/**
 * The MessageDrivenBean interface defines methods that the enterprise bean container uses to notify a message driven
 * bean instance of the instance's life cycle events.
 * <p>
 * As of EJB 3.0 it is no longer required that a message driven bean class implement this interface.
 *
 * @since EJB 2.0
 */
public interface MessageDrivenBean extends EnterpriseBean {
    /**
     * Set the associated message-driven context. The container calls this method after the instance creation.
     *
     * <p>
     * The message driven bean instance should store the reference to the context object in an instance variable.
     *
     * <p>
     * This method is called with no transaction context.
     *
     * @param ctx A MessageDrivenContext interface for the instance.
     * @exception EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    void setMessageDrivenContext(MessageDrivenContext ctx) throws EJBException;

    /**
     * A container invokes this method before it ends the life of the message-driven object. This happens when a container
     * decides to terminate the message-driven object.
     *
     * <p>
     * This method is called with no transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure caused by a system-level error.
     */
    void ejbRemove() throws EJBException;

}
