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
 * A NoSuchEJBException is thrown if an attempt is made to invoke
 * a business method on a stateful session or singleton object that no longer exists.
 *
 * @since EJB 3.0
 */
public class NoSuchEJBException extends EJBException {

    private static final long serialVersionUID = -4861625171310593950L;

    /**
     * Constructs a NoSuchEJBException with no detail message.
     */  
    public NoSuchEJBException() {
    }

    /**
     * Constructs a NoSuchEJBException with the specified
     * detail message.
     */  
    public NoSuchEJBException(String message) {
        super(message);
    }

    /**
     * Constructs a NoSuchEJBException with the specified
     * detail message and a nested exception. 
     */  
    public NoSuchEJBException(String message, Exception ex) {
        super(message, ex);
    }
}
