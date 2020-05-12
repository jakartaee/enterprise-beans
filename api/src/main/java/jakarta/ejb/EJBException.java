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
 * The EJBException is thrown to report that the invoked business method or callback method could not be completed
 * because of an unexpected error (e.g. the instance failed to open a database connection).
 *
 * @since EJB 1.1
 */
public class EJBException extends java.lang.RuntimeException {

    private static final long serialVersionUID = 796770993296843510L;

    /**
     * Constructs an EJBException with no detail message.
     */
    public EJBException() {
    }

    /**
     * Constructs an EJBException with the specified detailed message.
     *
     * @param message a {@link java.lang.String} object.
     */
    public EJBException(String message) {
        super(message);
    }

    /**
     * Constructs an EJBException that embeds the originally thrown exception.
     *
     * @param ex a {@link java.lang.Exception} object.
     */
    public EJBException(Exception ex) {
        super(ex);
    }

    /**
     * Constructs an EJBException that embeds the originally thrown exception with the specified detail message.
     *
     * @param message a {@link java.lang.String} object.
     * @param ex a {@link java.lang.Exception} object.
     */
    public EJBException(String message, Exception ex) {
        super(message, ex);
    }

    /**
     * Obtain the exception that caused the EJBException to be thrown. It is recommended that the inherited
     * Throwable.getCause() method be used to retrieve the cause instead of this method.
     */
    public Exception getCausedByException() {
        return (Exception) getCause();
    }

}
