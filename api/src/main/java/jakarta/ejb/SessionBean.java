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
 * The SessionBean interface defines methods that the enterprise bean container uses
 * to notify a session bean instance of the instance's life cycle events.
 * <p>
 * As of EJB 3.0 it is no longer required that a session bean class
 * implement this interface.
 *
 * @since EJB 1.0
 */
public interface SessionBean extends EnterpriseBean {
    /**
     * Set the associated session context. The container calls this method
     * after the instance creation.
     *
     * <p> The session bean instance should store the reference to the
     * context object in an instance variable.
     *
     * <p> This method is called with no transaction context.
     *
     * @param ctx A SessionContext interface for the instance.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for applications written
     *    for the enterprise bean 1.0 specification. Enterprise beans written for the 
     *    EJB 1.1 specification should throw the
     *    jakarta.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the jakarta.ejb.EJBException instead of this exception.
     */
    void setSessionContext(SessionContext ctx) throws EJBException,
	    RemoteException;

    /**
     * A container invokes this method before it ends the life of the session
     * object. This happens as a result of a client's invoking a remove
     * operation, or when a container decides to terminate the session object
     * after a timeout.
     * 
     * <p> This method is called with no transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    jakarta.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the jakarta.ejb.EJBException instead of this exception.
     */
     void ejbRemove() throws EJBException, RemoteException;    

    /**
     * The activate method is called when a stateful session bean instance is activated
     * from its "passive" state. The instance should acquire any resource
     * that it has released earlier in the <code>ejbPassivate</code> method.
     *
     * <p> This method is called with no transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    jakarta.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the jakarta.ejb.EJBException instead of this exception.
     */
    void ejbActivate() throws EJBException, RemoteException;

    /**
     * The passivate method is called before a stateful session bean instance enters
     * the "passive" state. The instance should release any resources that
     * it can re-acquire later in the <code>ejbActivate</code> method.
     *
     * <p> After the passivate method completes, the instance must be
     * in a state that allows the container to use the Java Serialization
     * protocol to externalize and store away the instance's state.
     *
     * <p> This method is called with no transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    jakarta.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the jakarta.ejb.EJBException instead of this exception.
     */
    void ejbPassivate() throws EJBException, RemoteException;
}
