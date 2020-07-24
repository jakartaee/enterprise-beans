/*
 * Copyright (c) 2006, 2020 Oracle and/or its affiliates. All rights reserved.
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
 * The SessionContext interface provides access to the runtime session context that the container provides for a session
 * bean instance. The container passes the SessionContext interface to an instance after the instance has been created.
 * The session context remains associated with the instance for the lifetime of the instance.
 *
 * @since EJB 1.0
 */
public interface SessionContext extends EJBContext {
    /**
     * Obtain a reference to the enterprise bean local object that is associated with the instance.
     *
     * <p>
     * An instance of a session bean can call this method at anytime between the <code>PostConstruct</code> or
     * <code>ejbCreate</code> and <code>PreDestroy</code> or <code>ejbRemove</code> methods, including from within these
     * methods.
     *
     * <p>
     * An instance can use this method, for example, when it wants to pass a reference to itself in a method argument or
     * result.
     *
     * @return The enterprise bean local object currently associated with the instance.
     * @exception IllegalStateException Thrown if the instance invokes this method while the instance is in a state that
     * does not allow the instance to invoke this method, or if the instance does not have a local interface.
     * @since EJB 2.0
     */
    EJBLocalObject getEJBLocalObject() throws IllegalStateException;

    /**
     * Obtain a reference to the enterprise bean object that is currently associated with the instance.
     *
     * <p>
     * An instance of a session enterprise Bean can call this method at anytime between the <code>PostConstruct</code> or
     * <code>ejbCreate</code> and the <code>PreDestroy</code> or <code>ejbRemove</code> methods, including from within these
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
     * Obtain an object that can be used to invoke the current bean through a particular business interface view or its
     * no-interface view.
     *
     * @param businessInterface One of the local business interfaces or remote business interfaces for this session bean. In
     * addition, the bean class type can be used to acquire a reference to the bean's no-interface view.
     * @return The business object corresponding to the given business interface or no-interface view.
     * @exception IllegalStateException Thrown if invoked with a parameter that does not correspond to one of the beans'
     * business interfaces or no-interface view.
     * @since EJB 3.0
     * @param <T> a T object.
     */
    <T> T getBusinessObject(Class<T> businessInterface) throws IllegalStateException;

    /**
     * Obtain the business interface or no-interface view type through which the current business method invocation was
     * made.
     *
     * @exception IllegalStateException Thrown if this method is called and the bean has not been invoked through a business
     * interface or no-interface view.
     * @since EJB 3.0
     * @return a {@link java.lang.Class} object.
     */
    Class getInvokedBusinessInterface() throws IllegalStateException;

    /**
     * Check whether a client invoked the <code>cancel</code> method on the client <code>Future</code> object corresponding
     * to the currently executing asynchronous business method.
     *
     * @return true if the client has invoked <code>Future.cancel</code> with a value of true for the
     * <code>mayInterruptIfRunning</code> parameter.
     * @exception IllegalStateException Thrown if not invoked from within an asynchronous business method invocation with
     * return type <code>Future&#060;V&#062;</code>.
     * @since EJB 3.1
     */
    boolean wasCancelCalled() throws IllegalStateException;

}
