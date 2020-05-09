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

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * Designates a method to receive a callback after a stateful session
 * bean has been activated.
 * <p>
 * If the method to which this annotation is applied is defined on an interceptor 
 * class, it must have one of the following signatures:
 * <pre>
 * void &#060;METHOD&#062;(InvocationContext)
 *
 * Object &#060;METHOD&#062;(InvocationContext) throws Exception
 * </pre>
 * <p>
 * If the method to which this annotation is applied is defined on a target class, 
 * it must have the following signature:
 * <pre>
 * void &#060;METHOD&#062;()
 * </pre>
 * The method can have public, private, protected, or package level access. 
 * It must not be declared as final or static.
 *
 * @since EJB 3.0
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PostActivate { 
}
