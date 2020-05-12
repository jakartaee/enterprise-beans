/*
 * Copyright (c) 2006, 2018 Oracle and/or its affiliates. All rights reserved.
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
 * This exception indicates that an attempt was made to perform an illegal loopback invocation. One possible cause is a
 * loopback call to a singleton bean's container-managed concurrency <code>Lock(WRITE)</code> method where the current
 * thread does not already hold a <code>WRITE</code> lock.
 *
 * @since EJB 3.1
 */
public class IllegalLoopbackException extends ConcurrentAccessException {

    private static final long serialVersionUID = -8854624128500916709L;

    /**
     * <p>Constructor for IllegalLoopbackException.</p>
     */
    public IllegalLoopbackException() {
    }

    /**
     * <p>Constructor for IllegalLoopbackException.</p>
     */
    public IllegalLoopbackException(String message) {
        super(message);
    }

}
