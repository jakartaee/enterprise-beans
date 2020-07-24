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
import java.util.concurrent.TimeUnit;

/**
 * Specifies the amount of time in a given time unit that a concurrent access attempt should block before timing out.
 * <p>
 * This annotation may be applied to a stateful session bean or to a singleton session bean that uses container managed
 * concurrency.
 * <p>
 * By default, clients are allowed to make concurrent calls to a stateful session object and the container is required
 * to serialize such concurrent requests. The <code>AccessTimeout</code> annotation is used to specify the amount of
 * time a stateful session bean request should block in the case that the bean instance is already processing a
 * different request. Use of the <code>AccessTimeout</code> annotation with a value of 0 specifies to the container that
 * concurrent client requests to a stateful session bean are prohibited.
 * <p>
 * The <code>AccessTimeout</code> annotation can be specified on a business method or a bean class. If it is specified
 * on a class, it applies to all business methods of that class. If it is specified on both a class and on a business
 * method of the class, the method-level annotation takes precedence for the given method.
 * <p>
 * Access timeouts for a singleton session bean only apply to methods eligible for concurrency locks. The
 * <code>AccessTimeout</code> annotation can be specified on the singleton session bean class or on an eligible method
 * of the class. If <code>AccessTimeout</code> is specified on both a class and on a method of that class, the
 * method-level annotation takes precedence for the given method.
 * <p>
 * The semantics of the <code>value</code> element are as follows:
 * <ul>
 * <li>A value <code>&#062;</code> 0 indicates a timeout value in the units specified by the <code>unit</code> element.
 * <li>A value of 0 means concurrent access is not permitted.
 * <li>A value of -1 indicates that the client request will block indefinitely until forward progress it can proceed.
 * </ul>
 * Values less than -1 are not valid.
 *
 * @since EJB 3.1
 */
@Target({ METHOD, TYPE })
@Retention(RUNTIME)
public @interface AccessTimeout {

    /**
     * The semantics of the <code>value</code> element are as follows:
     * <ul>
     * <li>A value <code>&#062;</code> 0 indicates a timeout value in the units specified by the <code>unit</code> element.
     * <li>A value of 0 means concurrent access is not permitted.
     * <li>A value of -1 indicates that the client request will block indefinitely until forward progress it can proceed.
     * </ul>
     * Values less than -1 are not valid.
     */
    long value();

    /**
     * Units used for the specified value.
     */
    TimeUnit unit() default TimeUnit.MILLISECONDS;

}
