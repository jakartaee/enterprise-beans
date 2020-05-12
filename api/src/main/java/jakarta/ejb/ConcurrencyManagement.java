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

/**
 * Declares a singleton session bean's concurrency management type.
 *
 * <p>
 * If this annotation is not specified, the singleton bean is assumed to have container managed concurrency.
 *
 * <p>
 * This annotation may be applied to stateful session beans, but doing so has no impact on the semantics of concurrency
 * management for such beans. The concurrency management type for bean-managed concurrency (<code>BEAN</code>) does not
 * apply to stateful session beans.
 *
 * @see ConcurrencyManagementType
 * @see Lock
 * 
 * @since EJB 3.1
 */

@Target({ TYPE })
@Retention(RUNTIME)
public @interface ConcurrencyManagement {

    ConcurrencyManagementType value() default ConcurrencyManagementType.CONTAINER;

}
