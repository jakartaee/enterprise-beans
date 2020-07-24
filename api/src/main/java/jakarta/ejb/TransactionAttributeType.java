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
 * The enum <code>TransactionAttributeType</code> is used with the <code>TransactionAttribute</code> annotation to
 * specify whether the methods of a session bean or message driven bean are called with a valid transaction context.
 * 
 * <p>
 * For a message-driven bean's message listener methods (or interface), only the <code>REQUIRED</code> and
 * <code>NOT_SUPPORTED</code> values may be used.
 * <p>
 *
 * For an enterprise bean's timeout callback methods, only the <code>REQUIRED</code>, <code>REQUIRES_NEW</code> and
 * <code>NOT_SUPPORTED</code> values may be used.
 * <p>
 *
 * For a session bean's asynchronous business methods, only the <code>REQUIRED</code>, <code>REQUIRES_NEW</code>, and
 * <code>NOT_SUPPORTED</code> values may be used.
 *
 * <p>
 * For a singleton session bean's <code>PostConstruct</code> and <code>PreDestroy</code> lifecycle callback interceptor
 * methods, only the <code>REQUIRED</code>, <code>REQUIRES_NEW</code>, and <code>NOT_SUPPORTED</code> values may be
 * used.
 *
 * <p>
 * If an enterprise bean implements the <code>SessionSynchronization</code> interface or uses any of the session
 * synchronization annotations, only the following values may be used for the transaction attributes of the bean's
 * methods: <code>REQUIRED</code>, <code>REQUIRES_NEW</code>, <code>MANDATORY</code>.
 *
 * @see TransactionAttribute
 *
 * @since EJB 3.0
 */
public enum TransactionAttributeType {

    /**
     * If a client invokes the enterprise bean's method while the client is associated with a transaction context, the
     * container invokes the enterprise bean's method in the client's transaction context.
     *
     * <p>
     * If there is no existing transaction, an exception is thrown.
     */
    MANDATORY,

    /**
     * If a client invokes the enterprise bean's method while the client is associated with a transaction context, the
     * container invokes the enterprise bean's method in the client's transaction context.
     *
     * <p>
     * If the client invokes the enterprise bean's method while the client is not associated with a transaction context, the
     * container automatically starts a new transaction before delegating a method call to the enterprise bean method.
     */
    REQUIRED,

    /**
     * The container must invoke an enterprise bean method whose transaction attribute is set to <code>REQUIRES_NEW</code>
     * with a new transaction context.
     *
     * <p>
     * If the client invokes the enterprise bean's method while the client is not associated with a transaction context, the
     * container automatically starts a new transaction before delegating a method call to the enterprise bean business
     * method.
     * 
     * <p>
     * If a client calls with a transaction context, the container suspends the association of the transaction context with
     * the current thread before starting the new transaction and invoking the method. The container resumes the suspended
     * transaction association after the method and the new transaction have been completed.
     */
    REQUIRES_NEW,

    /**
     * If the client calls with a transaction context, the container performs the same steps as described in the
     * <code>REQUIRED</code> case.
     *
     * <p>
     * If the client calls without a transaction context, the container performs the same steps as described in the
     * <code>NOT_SUPPORTED</code> case.
     * 
     * <p>
     * The <code>SUPPORTS</code> transaction attribute must be used with caution. This is because of the different
     * transactional semantics provided by the two possible modes of execution. Only enterprise beans that will execute
     * correctly in both modes should use the <code>SUPPORTS</code> transaction attribute.
     */
    SUPPORTS,

    /**
     * The container invokes an enterprise bean method whose transaction attribute <code>NOT_SUPPORTED</code> with an
     * unspecified transaction context.
     *
     * <p>
     * If a client calls with a transaction context, the container suspends the association of the transaction context with
     * the current thread before invoking the enterprise bean's business method. The container resumes the suspended
     * association when the business method has completed.
     */
    NOT_SUPPORTED,

    /**
     * The client is required to call without a transaction context, otherwise an exception is thrown.
     */
    NEVER
}
