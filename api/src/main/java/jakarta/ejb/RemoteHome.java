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

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * Declares the remote home interface or adapted remote home interface for a session bean. The value is never a 2.x
 * remote component interface.
 * <p>
 * Clients written to the enterprise bean 2.1 and earlier client view depend upon the existence of a home and component
 * interface. A session bean written to the enterprise bean 3.x API may be adapted to such earlier preexisting client
 * view interfaces.
 * <p>
 * The session bean designates the home interface to be adapted by using the <code>RemoteHome</code> annotation on the
 * bean class. The corresponding remote component interface need not be explicitly specified, as it is derived from the
 * return type of remote home interface's create method signature.
 * <p>
 * Session beans written to the EJB 3.0 and later APIs do not otherwise make use of remote home interfaces.
 *
 * @see Init
 * @see LocalHome
 * @since EJB 3.0
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface RemoteHome {

    /**
     * The remote home interface
     *
     * @return a {@link java.lang.Class} object.
     */
    Class value();
}
