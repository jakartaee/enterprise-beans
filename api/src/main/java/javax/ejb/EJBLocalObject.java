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

/**
 * The EJBLocalObject interface must be extended by all enterprise beans' local
 * interfaces. An enterprise bean's local interface provides the local client 
 * view of an EJB object. An enterprise bean's local interface defines 
 * the business methods callable by local clients.
 *
 * <p> The enterprise bean's local interface is defined by the enterprise
 * bean provider and implemented by the enterprise bean container.
 * 
 * <p>
 * Enterprise beans written to the EJB 3.0 and later APIs do not require
 * a local interface that extends the EJBLocalObject interface.  A local
 * business interface can be used instead.
 *
 * @since EJB 2.0
 */
public interface EJBLocalObject {
    /**
     * Obtain the enterprise bean's local home interface. The local home
     * interface defines the enterprise bean's create, finder, remove,
     * and home business methods that are available to local clients.
     * 
     * @return A reference to the enterprise bean's local home interface.
     *
     * @exception EJBException Thrown when the method failed due to a
     *    system-level failure.
     *
     */
    public EJBLocalHome getEJBLocalHome() throws EJBException; 

    /**
     * Obtain the primary key of the EJB local object. 
     *
     * <p> This method can be called on an entity bean. 
     * An attempt to invoke this method on a session bean will result in
     * an EJBException.
     *
     * <p><b>Note:</b> Support for entity beans is optional as of EJB 3.2.
     *
     * @return The EJB local object's primary key.
     *
     * @exception EJBException Thrown when the method failed due to a
     *    system-level failure or when invoked on a session bean.
     *
     */
    public Object getPrimaryKey() throws EJBException;

    /**
     * Remove the EJB local object.
     *
     * @exception RemoveException The enterprise bean or the container
     *    does not allow destruction of the object.
     *
     * @exception EJBException Thrown when the method failed due to a
     *    system-level failure.
     *
     */ 
    public void remove() throws RemoveException, EJBException;

    /**
     * Test if a given EJB local object is identical to the invoked EJB 
     * local object.
     *
     * @param obj An object to test for identity with the invoked object.
     *
     * @return True if the given EJB local object is identical to the 
     * invoked object, false otherwise.
     *
     *
     * @exception EJBException Thrown when the method failed due to a
     *    system-level failure.
     *
     */
    boolean isIdentical(EJBLocalObject obj) throws EJBException;
} 
