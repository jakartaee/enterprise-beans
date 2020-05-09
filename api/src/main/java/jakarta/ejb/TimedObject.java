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
 * The <code>TimedObject</code> interface contains a callback method
 * that is used to deliver timer expiration notifications.  It can be
 * implemented by a stateless session bean class, a singleton session
 * bean class, a message-driven bean class, or an enterprise bean 2.x entity bean class.
 * <p>
 * If the bean implements the <code>TimedObject</code> interface, the
 * <code>Timeout</code> annotation, if used, can only be applied to 
 * the <code>ejbTimeout</code> method.
 *
 * @see Timeout
 *
 * @since EJB 2.1
 */
public interface TimedObject {

    /**
     * Invoked by the enterprise bean container upon timer expiration.
     *
     * @param timer timer whose expiration caused this notification.
     *
     */
    public void ejbTimeout(Timer timer);

} 
