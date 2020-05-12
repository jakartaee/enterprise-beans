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

import java.io.Serializable;

/**
 *
 * The TimerHandle interface allows the bean provider to obtain a serializable timer handle that may be persisted.
 * <p>
 * Since timers are local objects, a timer handle must not be passed through a bean's remote business interface, remote
 * interface or web service interface.
 *
 * @since EJB 2.1
 */
public interface TimerHandle extends Serializable {

    /**
     * Obtain a reference to the timer represented by this handle.
     *
     * @return a reference to the timer represented by this handle.
     *
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a handle whose associated timer has expired or has been
     * cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Timer getTimer() throws java.lang.IllegalStateException,
            jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;

}
