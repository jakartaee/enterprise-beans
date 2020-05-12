/*
 * Copyright (c) 1997, 2018 Oracle and/or its affiliates. All rights reserved.
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
 * The EJBObject interface is extended by all enterprise beans' remote interfaces. An enterprise bean's remote interface
 * provides the remote client view of an enterprise bean object. An enterprise bean's remote interface defines the
 * business methods callable by a remote client.
 *
 * <p>
 * The remote interface must extend the jakarta.ejb.EJBObject interface, and define the enterprise bean specific
 * business methods.
 *
 * <p>
 * The enterprise bean's remote interface is defined by the enterprise bean provider and implemented by the enterprise
 * bean container.
 *
 * <p>
 * Enterprise beans written to the EJB 3.0 and later APIs do not require a remote interface that extends the EJBObject
 * interface. A remote business interface can be used instead.
 *
 * @since EJB 1.0
 */
public interface EJBObject extends java.rmi.Remote {
    /**
     * Obtain the enterprise bean's remote home interface. The remote home interface defines the enterprise bean's create,
     * finder, remove, and home business methods.
     *
     * @return A reference to the enterprise bean's home interface.
     * @exception RemoteException Thrown when the method failed due to a system-level failure.
     */
    public EJBHome getEJBHome() throws RemoteException;

    /**
     * Obtain the primary key of the enterprise bean object.
     *
     * <p>
     * This method can be called on an entity bean. An attempt to invoke this method on a session bean will result in
     * RemoteException.
     *
     * <p>
     * <b>Note:</b> Support for entity beans is optional as of EJB 3.2.
     *
     * @return The enterprise bean object's primary key.
     * @exception RemoteException Thrown when the method failed due to a system-level failure or when invoked on a session
     * bean.
     */
    public Object getPrimaryKey() throws RemoteException;

    /**
     * Remove the enterprise bean object.
     *
     * @exception RemoteException Thrown when the method failed due to a system-level failure.
     * @exception RemoveException The enterprise bean or the container does not allow destruction of the object.
     */
    public void remove() throws RemoteException, RemoveException;

    /**
     * Obtain a handle for the enterprise bean object. The handle can be used at later time to re-obtain a reference to the
     * enterprise bean object, possibly in a different Java Virtual Machine.
     *
     * @return A handle for the enterprise bean object.
     * @exception RemoteException Thrown when the method failed due to a system-level failure.
     */
    public Handle getHandle() throws RemoteException;

    /**
     * Test if a given enterprise bean object is identical to the invoked enterprise bean object.
     *
     * @param obj An object to test for identity with the invoked object.
     * @return True if the given enterprise bean object is identical to the invoked object, false otherwise.
     * @exception RemoteException Thrown when the method failed due to a system-level failure.
     */
    boolean isIdentical(EJBObject obj) throws RemoteException;
}
