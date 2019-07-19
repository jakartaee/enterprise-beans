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

package javax.ejb;

import java.rmi.RemoteException;

/**
 * The EJBHome interface must be extended by all enterprise beans'
 * remote home interfaces. An enterprise bean's remote home interface
 * defines the methods that allow a remote client to create, find, and
 * remove enterprise bean objects.
 *
 * <p> The remote home interface is defined by the enterprise bean provider and 
 * implemented by the enterprise bean container.
 * <p>
 * Enterprise beans written to the enterprise bean 3.0 and later APIs do not require
 * a home interface.
 *
 * @since EJB 1.0
 */
public interface EJBHome extends java.rmi.Remote {

    /**
     * Remove an enterprise bean object identified by its handle.
     *
     * @param handle the handle of the enterprise bean object to be removed
     *
     * @exception RemoveException Thrown if the enterprise bean or
     *    the container does not allow the client to remove the object.
     *
     * @exception RemoteException Thrown when the method failed due to a
     *    system-level failure.
     */
    void remove(Handle handle) throws RemoteException, RemoveException;

    /**
     * Remove an enterprise bean object identified by its primary key.
     *
     * <p>This method can be used only for an entity bean. An attempt
     * to call this method on a session bean will result in a RemoveException.
     *
     * <p><b>Note:</b> Support for entity beans is optional as of enterprise bean 3.2.
     *
     * @param primaryKey the primary key of the enterprise bean object to be removed
     *
     * @exception RemoveException Thrown if the enterprise bean or
     *    the container does not allow the client to remove the object.
     *
     * @exception RemoteException Thrown when the method failed due to a
     *    system-level failure.
     */
    void remove(Object primaryKey) throws RemoteException, RemoveException;

    /**
     * Obtain the EJBMetaData interface for the enterprise bean. The
     * EJBMetaData interface allows the client to obtain information about
     * the enterprise bean.
     *
     * <p> The information obtainable via the EJBMetaData interface is
     * intended to be used by tools.
     *
     * @return The enterprise Bean's EJBMetaData interface.
     *
     * @exception RemoteException Thrown when the method failed due to a
     *    system-level failure.
     */
    EJBMetaData getEJBMetaData() throws RemoteException;

    /**
     * Obtain a handle for the remote home object. The handle can be used at 
     * later time to re-obtain a reference to the remote home object, possibly 
     * in a different Java Virtual Machine.
     *
     * @return A handle for the remote home object.
     *
     * @exception RemoteException Thrown when the method failed due to a
     *    system-level failure. 
     *
     * @since EJB 1.1    
     */
    HomeHandle getHomeHandle() throws RemoteException;
}
