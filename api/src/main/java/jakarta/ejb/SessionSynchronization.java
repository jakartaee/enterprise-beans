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

import java.rmi.RemoteException;

/**
 * <p> The SessionSynchronization interface allows a stateful session
 * bean instance to be notified by its container of transaction
 * boundaries.
 *
 * <p> Only a stateful session bean with container-managed transaction 
 * demarcation can receive session synchronization notifications. Other bean
 * types must not implement the SessionSynchronization interface or use 
 * the session synchronization annotations.
 *
 * <p>  A stateful session bean class is not required to implement this interface.
 *
 * @since EJB 1.0
 */
public interface SessionSynchronization {
    /**
     * The <code>afterBegin</code> method notifies a stateful session bean instance that a new
     * transaction has started, and that the subsequent business methods on the
     * instance will be invoked in the context of the transaction.
     *
     * <p> The instance can use this method, for example, to read data
     * from a database and cache the data in the instance fields.
     *
     * <p> This method executes in the proper transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 and later specifications should throw the
     *    jakarta.ejb.EJBException instead of this exception. 
     *    Enterprise beans written for the EJB 2.0 and later specifications
     *    must not throw the java.rmi.RemoteException.
     *
     * @see AfterBegin
     */
    public void afterBegin() throws EJBException, RemoteException;

    /**
     * The <code>beforeCompletion</code> method notifies a stateful session bean instance that
     * a transaction is about to be committed. The instance can use this
     * method, for example, to write any cached data to a database.
     *
     * <p> This method executes in the proper transaction context.
     *
     * <p><b>Note:</b> The instance may still cause the container to
     * rollback the transaction by invoking the <code>setRollbackOnly</code> method
     * on the session context, or by throwing an exception.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 and later specification should throw the
     *    jakarta.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB 2.0 and later specifications
     *    must not throw the java.rmi.RemoteException.
     *
     * @see BeforeCompletion
     */
    public void beforeCompletion() throws EJBException, RemoteException;

    /**
     * The <code>afterCompletion</code> method notifies a stateful session bean instance that a
     * transaction commit protocol has completed, and tells the instance
     * whether the transaction has been committed or rolled back.
     *
     * <p> This method executes with no transaction context.
     *
     * @param committed True if the transaction has been committed, false
     *    if is has been rolled back.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 and later specification should throw the
     *    jakarta.ejb.EJBException instead of this exception. 
     *    Enterprise beans written for the EJB 2.0 and later specifications
     *    must not throw the java.rmi.RemoteException.
     *
     * @see AfterCompletion
     */
    public void afterCompletion(boolean committed) throws EJBException,
	    RemoteException;
}
