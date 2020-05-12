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
 * The DuplicateKeyException exception is thrown if an entity EJB object or enterprise bean local object cannot be
 * created because an object with the same key already exists. This exception is thrown by the create methods defined in
 * an entity bean's home or local home interface.
 *
 * <p>
 * <b>Note:</b> Support for entity beans is optional as of EJB 3.2
 *
 * @since EJB 1.0
 */
public class DuplicateKeyException extends CreateException {

    private static final long serialVersionUID = -7287399994705270076L;

    /**
     * Constructs a DuplicateKeyException with no detail message.
     */
    public DuplicateKeyException() {
    }

    /**
     * Constructs a DuplicateKeyException with the specified detail message.
     */
    public DuplicateKeyException(String message) {
        super(message);
    }
}
