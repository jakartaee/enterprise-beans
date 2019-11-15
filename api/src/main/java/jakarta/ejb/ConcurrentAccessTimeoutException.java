/*
 * Copyright (c) 2006, 2018 Oracle and/or its affiliates. All rights reserved.
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
 * This exception indicates that an attempt to concurrently access
 * a stateful session or singleton bean method resulted in a timeout.
 *
 * @see AccessTimeout
 *
 * @since EJB 3.1
 */
public class ConcurrentAccessTimeoutException extends ConcurrentAccessException {

    private static final long serialVersionUID = 7899534274371798660L;

    public ConcurrentAccessTimeoutException() {}

    public ConcurrentAccessTimeoutException(String message) {
        super(message);
    }

}
