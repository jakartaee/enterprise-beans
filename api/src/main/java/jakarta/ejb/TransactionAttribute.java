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
 * The <code>TransactionAttribute</code> annotation specifies whether
 * the container is to invoke a business method within a transaction
 * context.  
 *
 * The <code>TransactionAttribute</code> annotation can be used for
 * session beans and message driven beans.  It can only be specified
 * if container managed transaction demarcation is used. 
 * <p>
 *
 * The annotation can be specified on the bean class and/or it can be
 * specified on methods of the class that are methods of the business
 * interface or no-interface view. 
 * <p>
 * Specifying the <code>TransactionAttribute</code> annotation on the
 * bean class  means that it applies to all applicable business 
 * methods of the class. Specifying the annotation on a 
 * method applies it to that method only. If the annotation is applied 
 * at both the class and the method level, the method value overrides 
 * if the two disagree.  
 *
 * <p>
 * The values of the <code>TransactionAttribute</code> annotation are
 * defined by the enum <code>TransactionAttributeType</code>.  If 
 * the <code>TransactionAttribute</code> annotation is not specified, and 
 * the bean uses container managed transaction demarcation, the semantics of 
 * the <code>REQUIRED</code>  transaction attribute are assumed.
 *
 * @see TransactionAttributeType
 *
 * @since EJB 3.0
 */

@Target({METHOD, TYPE})
@Retention(RUNTIME)
public @interface TransactionAttribute {
    TransactionAttributeType value() default TransactionAttributeType.REQUIRED;
}
