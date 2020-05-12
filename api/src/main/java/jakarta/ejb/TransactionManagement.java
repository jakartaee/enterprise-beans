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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Specifies whether a session bean or message driven bean has container managed transactions or bean managed
 * transactions.
 *
 * If this annotation is not used, the bean is assumed to have container-managed transaction management.
 *
 * @see TransactionManagementType
 * @since EJB 3.0
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface TransactionManagement {
    TransactionManagementType value() default TransactionManagementType.CONTAINER;
}
