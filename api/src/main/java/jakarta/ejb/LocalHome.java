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
 * Declares the local home or adapted local home interface for a session bean.
 * <p>
 * Clients written to the enterprise bean 2.1 and earlier client view depend upon the existence of a home and component
 * interface. A session bean written to the enterprise bean 3.x API may be adapted to such earlier preexisting client
 * view interfaces.
 * <p>
 * The session bean designates the local home interface to be adapted by using the <code>LocalHome</code> annotation on
 * the bean class. The corresponding local component interface need not be explicitly specified, as it is derived from
 * the return type of local home interface's create method signature.
 *
 * <p>
 * Session beans written to the EJB 3.0 and later APIs do not otherwise make use of local home interfaces.
 *
 * @see Init
 * @see RemoteHome
 * @since EJB 3.0
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalHome {

    /**
     * The local home interface.
     */
    Class value();
}
