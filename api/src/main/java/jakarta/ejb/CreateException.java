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
 * The CreateException exception must be included in the throws clauses of
 * all create methods defined in an enterprise bean's home or local home
 * interface. 
 *
 * <p> This exception is used as a standard application-level exception to
 * report a failure to create an enterprise bean object or local object.
 *
 * @since EJB 1.0
 */
public class CreateException extends java.lang.Exception {

    private static final long serialVersionUID = 6295951740865457514L;

    /**
     * Constructs a CreateException with no detail message.
     */  
    public CreateException() {
    }

    /**
     * Constructs a CreateException with the specified
     * detail message.
     */  
    public CreateException(String message) {
        super(message);
    }
}

