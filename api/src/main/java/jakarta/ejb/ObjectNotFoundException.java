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
 * The ObjectNotFoundException exception is thrown by a finder or select method to indicate that the specified
 * enterprise bean object or local object does not exist.
 *
 * <p>
 * Only the finder and select methods that are declared to return a single object use this exception. This exception
 * should not be thrown by finder or select methods that return a collection of objects (they should return an empty
 * collection instead).
 *
 * @since EJB 1.0
 */
public class ObjectNotFoundException extends FinderException {

    private static final long serialVersionUID = 4624364141026778L;

    /**
     * Constructs an ObjectNotFoundException with no detail message.
     */
    public ObjectNotFoundException() {
    }

    /**
     * Constructs an ObjectNotFoundException with the specified detail message.
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
