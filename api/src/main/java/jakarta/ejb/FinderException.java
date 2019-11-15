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
 * The FinderException exception must be included in the throws clause
 * of every finder method of an entity bean's home or local home interface.
 *
 * <p> The exception is used as a standard application-level exception to 
 * report a failure to find the requested enterprise bean object(s).
 *
 * <p><b>Note:</b> Support for entity beans is optional as of EJB 3.2.
 *
 * @since EJB 1.0
 */
public class FinderException extends java.lang.Exception {

    private static final long serialVersionUID = 8785983102057433621L;

    /**
     * Constructs an FinderException with no detail message.
     */  
    public FinderException() {
    }

    /**
     * Constructs an FinderException with the specified
     * detail message.
     */  
    public FinderException(String message) {
        super(message);
    }
}

