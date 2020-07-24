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
 * A ConcurrentAccessException indicates that the client has attempted an invocation on a stateful session bean or
 * singleton bean while another invocation is in progress and such concurrent access is not allowed.
 *
 * @see AccessTimeout
 *
 * @since EJB 3.1
 */
public class ConcurrentAccessException extends EJBException {

    private static final long serialVersionUID = -8980855319866981477L;

    /**
     * Constructs an ConcurrentAccessException with no detail message.
     */
    public ConcurrentAccessException() {
    }

    /**
     * Constructs an ConcurrentAccessException with the specified detailed message.
     */
    public ConcurrentAccessException(String message) {
        super(message);
    }

    /**
     * Constructs an ConcurrentAccessException with the specified detail message and a nested exception.
     */
    public ConcurrentAccessException(String message, Exception ex) {
        super(message, ex);
    }
}
