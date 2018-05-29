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

package javax.ejb;

import java.rmi.RemoteException;

/**
 * The Handle interface is implemented by all EJB object handles. A handle
 * is an abstraction of a network reference to an EJB object. A handle is
 * intended to be used as a "robust" persistent reference to an EJB object.
 *
 * @since EJB 1.0
 */
public interface Handle extends java.io.Serializable {
    /**
     * Obtain the EJB object reference represented by this handle.
     *
     * @return the EJB object reference represented by this handle.
     *
     * @exception RemoteException The EJB object could not be obtained
     *    because of a system-level failure.
     */
    public EJBObject getEJBObject() throws RemoteException;
}
