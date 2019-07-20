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
 * A NoSuchObjectLocalException is thrown if an attempt is made to invoke
 * a method on a local object (local enterprise bean object or timer) that no longer exists.
 *
 * @since EJB 2.0
 */
public class NoSuchObjectLocalException extends EJBException {

    private static final long serialVersionUID = 9151491108833037318L;

    /**
     * Constructs a NoSuchObjectLocalException with no detail message.
     */  
    public NoSuchObjectLocalException() {
    }

    /**
     * Constructs a NoSuchObjectLocalException with the specified
     * detail message.
     */  
    public NoSuchObjectLocalException(String message) {
        super(message);
    }

    /**
     * Constructs a NoSuchObjectLocalException with the specified
     * detail message and a nested exception. 
     */  
    public NoSuchObjectLocalException(String message, Exception ex) {
        super(message, ex);
    }
}
