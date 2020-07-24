/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
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
 * Designates a method on a stateless session bean class, a singleton session bean class, a message driven bean class,
 * or an enterprise bean 2.x entity bean class that should receive enterprise bean timer expirations for that bean.
 * <p>
 * The method to which the <code>Timeout</code> annotation is applied must have one of the following signatures, where
 * <code>&#060;METHOD&#062;</code> designates the method name:
 * <p>
 * 
 * <pre>
 * void &#060;METHOD&#062;()
 * void &#060;METHOD&#062;(Timer timer)
 * </pre>
 *
 * A timeout callback method can have public, private, protected, or package level access. A timeout callback method
 * must not be declared as final or static. Timeout callback methods must not throw application exceptions.
 * <p>
 * If the bean implements the <code>TimedObject</code> interface, the <code>Timeout</code> annotation can only be
 * applied to the <code>ejbTimeout</code> method.
 *
 * @since EJB 3.0
 */

@Target(METHOD)
@Retention(RUNTIME)
public @interface Timeout {
}
