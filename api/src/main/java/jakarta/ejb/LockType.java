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

/**
 * Concurrency lock type for singleton beans with container-managed concurrency.
 *
 * @since EJB 3.1
 */
public enum LockType {

    /**
     * For read-only operations.  Allows simultaneous access to methods
     * designated as <code>READ</code>, as long as no <code>WRITE</code> lock is held.  
     */
    READ,

    /**
     * For exclusive access to the bean instance.  A <code>WRITE</code> lock can only
     * be acquired when no other method with either a <code>READ</code> or 
     * <code>WRITE</code> lock is currently held.
     */
    WRITE
}

