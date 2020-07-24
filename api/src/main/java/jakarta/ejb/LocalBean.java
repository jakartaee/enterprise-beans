/*
 * Copyright (c) 2006, 2020 Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Designates that a session bean exposes a no-interface view.
 * <p>
 * This annotation is required if a session bean exposes any other client views (local, remote, no-interface, 2.x Remote
 * Home, 2.x Local Home, Web Service) in addition to the no-interface view or its implements clause contains an
 * interface other than <code>java.io.Serializable</code>; <code>java.io.Externalizable</code>; or any of the interfaces
 * defined by the <code>jakarta.ejb</code> package.
 * <p>
 * This annotation is optional if a session bean exposes only a no-interface view.
 *
 * @since EJB 3.1
 */

@Target({ TYPE })
@Retention(RUNTIME)
public @interface LocalBean {
}
