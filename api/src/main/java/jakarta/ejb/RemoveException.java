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
 * The RemoveException is thrown at an attempt to remove an enterprise bean object or local enterprise bean object when
 * the enterprise bean or the container does not allow the enterprise bean object to be removed.
 *
 * @since EJB 1.0
 */
public class RemoveException extends java.lang.Exception {

    private static final long serialVersionUID = -4581849053220157910L;

    /**
     * Constructs an RemoveException with no detail message.
     */
    public RemoveException() {
    }

    /**
     * Constructs an RemoveException with the specified detail message.
     */
    public RemoveException(String message) {
        super(message);
    }
}
