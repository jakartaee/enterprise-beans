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
 * The EJBLocalHome interface must be extended by all enterprise beans' local home interfaces. An enterprise bean's
 * local home interface defines the methods that allow local clients to create, find, and remove enterprise bean
 * objects.
 *
 * <p>
 * The local home interface is defined by the enterprise bean provider and implemented by the enterprise bean container.
 * <p>
 * Enterprise beans written to the EJB 3.0 and later APIs do not require a local home interface.
 *
 * @since EJB 2.0
 */
public interface EJBLocalHome {

    /**
     * Remove an enterprise bean object identified by its primary key.
     *
     * <p>
     * This method can only be used by local clients of an entity bean. An attempt to call this method on a session bean
     * will result in a RemoveException.
     *
     * <p>
     * <b>Note:</b> Support for entity beans is optional as of EJB 3.2.
     *
     * @param primaryKey the primary key of the enterprise bean object to be removed
     *
     * @exception RemoveException Thrown if the enterprise bean or the container does not allow the client to remove the
     * object.
     *
     * @exception EJBException Thrown when the method failed due to a system-level failure.
     *
     */
    void remove(Object primaryKey) throws RemoveException, EJBException;

}
