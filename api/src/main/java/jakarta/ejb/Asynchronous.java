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
 * Used to mark a session bean method as an asynchronous method or to designate all business methods of a session bean
 * class as asynchronous.
 * <p>
 * An asychronous method must have return type <code>void</code> or <code>Future&#060;V&#062;</code>, where
 * <code>V</code> is the result value type.
 * <p>
 * Asynchronous method invocation semantics only apply to the no-interface, local business, and remote business client
 * views. Methods exposed through the enterprise bean 2.x local, enterprise bean 2.x remote, and web service client
 * views must not be designated as asynchronous.
 *
 * @see AsyncResult
 * @since EJB 3.1
 */

@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface Asynchronous {
}
