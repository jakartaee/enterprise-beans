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

import java.rmi.RemoteException;

/**
 * The HomeHandle interface is implemented by all home object handles. A handle is an abstraction of a network reference
 * to a home object. A handle is intended to be used as a "robust" persistent reference to a home object.
 *
 * @since EJB 1.1
 */
public interface HomeHandle extends java.io.Serializable {
    /**
     * Obtain the home object represented by this handle.
     *
     * @return the home object represented by this handle.
     * @exception RemoteException The home object could not be obtained because of a system-level failure.
     */
    public EJBHome getEJBHome() throws RemoteException;
}
