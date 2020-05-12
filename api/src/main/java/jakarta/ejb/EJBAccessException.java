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
 * This exception indicates that client access to a business method was denied.
 *
 * @since EJB 3.0
 */
public class EJBAccessException extends EJBException {

    private static final long serialVersionUID = 4923220329322198628L;

    /**
     * Constructs an EJBAccessException with no detail message.
     */

    public EJBAccessException() {
    }

    /**
     * Constructs an EJBAccessException with the specified detailed message.
     */
    public EJBAccessException(String message) {
        super(message);
    }

}
