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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

import java.util.concurrent.TimeUnit;

/**
 * Specifies the amount of time a stateful session bean can be idle (not receive any client invocations) before it is
 * eligible for removal by the container.
 * <p>
 * 
 * The semantics of the <code>value</code> element are as follows:
 * <ul>
 * <li>A value <code>&#062;</code>0 indicates a timeout value in the units specified by the <code>unit</code> element.
 * <li>A value of 0 means the bean is immediately eligible for removal.
 * <li>A value of -1 means the bean will never be removed due to timeout.
 * </ul>
 * Values less than -1 are not valid.
 * 
 * @since EJB 3.1
 */

@Target(TYPE)
@Retention(RUNTIME)
public @interface StatefulTimeout {

    /**
     * The amount of time the stateful session bean can be idle.
     *
     * The semantics of this element are as follows:
     * <ul>
     * <li>A value <code>&#062;</code>0 indicates a timeout value in the units specified by the <code>unit</code> element.
     * <li>A value of 0 means the bean is immediately eligible for removal.
     * <li>A value of -1 means the bean will never be removed due to timeout.
     * </ul>
     * Values less than -1 are not valid.
     * 
     */
    long value();

    /**
     * Units used for the specified value.
     */
    TimeUnit unit() default TimeUnit.MINUTES;

}
