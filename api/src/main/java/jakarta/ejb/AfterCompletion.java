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
 * Designate a stateful session bean method to receive the after completion
 * session synchronization callback.
 * <p>
 *
 * The after completion callback notifies a stateful session bean
 * instance that a transaction commit protocol has completed.
 * A completion status of true indicates that the transaction has 
 * committed. A status of false indicates that a rollback has occurred.
 * <p>
 *
 * A bean must have at most one <code>AfterCompletion</code> method.  
 * The signature of this method must observe the following rules:
 * <ul>
 * <li> The method must not be declared as <code>final</code> or <code>static</code>.
 * <li> The method may have any access type.
 * <li> The return type must be <code>void</code>.
 * <li> The method must take a single argument of type <code>boolean</code>.
 * </ul>
 *
 * <p> This method executes with no transaction context.
 * <p>
 *  A stateful session bean class may use either the
 *  <code>SessionSynchronization</code> interface or the session
 *  synchronization annotations, but not both.
 *
 * @see SessionSynchronization
 * @see AfterBegin
 * @see BeforeCompletion
 *
 * @since EJB 3.1
 */

@Target(METHOD) 
@Retention(RUNTIME)
public @interface AfterCompletion {}
