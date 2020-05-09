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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Applied to an exception to denote that it is an application exception
 * and should be reported to the client directly (i.e., unwrapped).
 *
 * @since EJB 3.0
 */

@Target(TYPE) 
@Retention(RUNTIME)
public @interface ApplicationException {

    /**
     * Indicates whether the container should cause the transaction to 
     * rollback when the exception is thrown.
     */
    boolean rollback() default false;

    /**
     * Indicates whether the application exception designation should
     * apply to subclasses of the annotated exception class.
     *
     * @since EJB 3.1
     */
    boolean inherited() default true;


}
