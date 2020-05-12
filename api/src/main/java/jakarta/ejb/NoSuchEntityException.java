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
 * The NoSuchEntityException exception is thrown by an entity bean instance to its container to report that the invoked
 * business method or callback method could not be completed because of the underlying entity was removed from the
 * database.
 *
 * <p>
 * This exception may be thrown by the bean class methods that implement the business methods defined in the bean's
 * component interface and by the <code>ejbLoad</code> and <code>ejbStore</code> methods.
 *
 * <p>
 * <b>Note:</b> Support for entity beans is optional as of EJB 3.2.
 *
 * @since EJB 1.1
 */
public class NoSuchEntityException extends EJBException {

    private static final long serialVersionUID = -4815730078295420703L;

    /**
     * @serial
     */

    /**
     * Constructs a NoSuchEntityException with no detail message.
     */
    public NoSuchEntityException() {
    }

    /**
     * Constructs a NoSuchEntityException with the specified detailed message.
     */
    public NoSuchEntityException(String message) {
        super(message);
    }

    /**
     * Constructs a NoSuchEntityException that embeds the originally thrown exception.
     */
    public NoSuchEntityException(Exception ex) {
        super(ex);
    }
}
