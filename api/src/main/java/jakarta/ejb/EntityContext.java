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

/**
 * The EntityContext interface provides an instance with access to the container-provided runtime context of an entity
 * bean instance. The container passes the EntityContext interface to an entity bean instance after the instance has
 * been created.
 *
 * <p>
 * The EntityContext interface remains associated with the instance for the lifetime of the instance. Note that the
 * information that the instance obtains using the EntityContext interface (such as the result of the getPrimaryKey()
 * method) may change, as the container assigns the instance to different enterprise bean objects during the instance's
 * life cycle.
 *
 * <p>
 * <b>Note:</b> Support for entity beans is optional as of EJB 3.2.
 *
 * @since EJB 2.0
 */
public interface EntityContext extends EJBContext {
    /**
     * Obtain a reference to the enterprise bean local object that is currently associated with the instance.
     *
     * <p>
     * An instance of an entity bean can call this method only when the instance is associated with an enterprise bean local
     * object identity, i.e. in the ejbActivate, ejbPassivate, ejbPostCreate, ejbRemove, ejbLoad, ejbStore, and business
     * methods.
     *
     * <p>
     * An instance can use this method, for example, when it wants to pass a reference to itself in a method argument or
     * result.
     *
     * @return The enterprise bean local object currently associated with the instance.
     * @exception IllegalStateException if the instance invokes this method while the instance is in a state that does not
     * allow the instance to invoke this method, or if the instance does not have a local interface.
     * @since EJB 2.0
     */
    EJBLocalObject getEJBLocalObject() throws IllegalStateException;

    /**
     * Obtain a reference to the enterprise bean object that is currently associated with the instance.
     *
     * <p>
     * An instance of an entity bean can call this method only when the instance is associated with an enterprise bean
     * object identity, i.e. in the ejbActivate, ejbPassivate, ejbPostCreate, ejbRemove, ejbLoad, ejbStore, and business
     * methods.
     *
     * <p>
     * An instance can use this method, for example, when it wants to pass a reference to itself in a method argument or
     * result.
     *
     * @return The enterprise bean object currently associated with the instance.
     * @exception IllegalStateException Thrown if the instance invokes this method while the instance is in a state that
     * does not allow the instance to invoke this method, or if the instance does not have a remote interface.
     */
    EJBObject getEJBObject() throws IllegalStateException;

    /**
     * Obtain the primary key of the enterprise bean object that is currently associated with this instance.
     *
     * <p>
     * An instance of an entity bean can call this method only when the instance is associated with an enterprise bean
     * object identity, i.e. in the ejbActivate, ejbPassivate, ejbPostCreate, ejbRemove, ejbLoad, ejbStore, and business
     * methods.
     *
     * <p>
     * <b>Note</b>: The result of this method is that same as the result of getEJBObject().getPrimaryKey().
     *
     * @return The primary key currently associated with the instance.
     * @exception IllegalStateException Thrown if the instance invokes this method while the instance is in a state that
     * does not allow the instance to invoke this method.
     */
    Object getPrimaryKey() throws IllegalStateException;
}
