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

package jakarta.ejb.spi;

import jakarta.ejb.EJBHome;
import jakarta.ejb.EJBObject;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The <code>HandleDelegate</code> interface is implemented by the enterprise bean container. It is used by portable
 * implementations of <code>jakarta.ejb.Handle</code> and <code>jakarta.ejb.HomeHandle</code>. It is not used by
 * enterprise bean components or by client components. It provides methods to serialize and deserialize EJBObject and
 * EJBHome references to streams.
 *
 * <p>
 * The <code>HandleDelegate</code> object is obtained by JNDI lookup at the reserved name
 * <code>"java:comp/HandleDelegate"</code>.
 *
 * @since EJB 2.0
 */

public interface HandleDelegate {
    /**
     * Serialize the EJBObject reference corresponding to a Handle.
     *
     * <p>
     * This method is called from the <code>writeObject</code> method of portable Handle implementation classes. The
     * <code>ostream</code> object is the same object that was passed in to the Handle class's <code>writeObject</code>
     * method.
     *
     * @param ejbObject The EJBObject reference to be serialized.
     *
     * @param ostream The output stream.
     *
     * @exception IOException The EJBObject could not be serialized because of a system-level failure.
     */
    public void writeEJBObject(EJBObject ejbObject, ObjectOutputStream ostream)
            throws IOException;

    /**
     * Deserialize the EJBObject reference corresponding to a Handle.
     *
     * <p>
     * The <code>readEJBObject</code> method is called from the <code>readObject</code> method of portable
     * <code>Handle</code> implementation classes. The <code>istream</code> object is the same object that was passed in to
     * the Handle class's <code>readObject</code> method. When<code>readEJBObject</code> is called, <code>istream</code>
     * must point to the location in the stream at which the EJBObject reference can be read. The container must ensure that
     * the EJBObject reference is capable of performing invocations immediately after deserialization.
     *
     * @param istream The input stream.
     *
     * @return The deserialized EJBObject reference.
     *
     * @exception IOException The EJBObject could not be deserialized because of a system-level failure.
     * @exception ClassNotFoundException The EJBObject could not be deserialized because some class could not be found.
     */
    public jakarta.ejb.EJBObject readEJBObject(ObjectInputStream istream)
            throws IOException, ClassNotFoundException;

    /**
     * Serialize the EJBHome reference corresponding to a HomeHandle.
     *
     * <p>
     * This method is called from the <code>writeObject</code> method of portable <code>HomeHandle</code> implementation
     * classes. The <code>ostream</code> object is the same object that was passed in to the <code>Handle</code> class's
     * <code>writeObject</code> method.
     *
     * @param ejbHome The EJBHome reference to be serialized.
     *
     * @param ostream The output stream.
     *
     * @exception IOException The EJBObject could not be serialized because of a system-level failure.
     */
    public void writeEJBHome(EJBHome ejbHome, ObjectOutputStream ostream)
            throws IOException;

    /**
     * Deserialize the EJBHome reference corresponding to a HomeHandle.
     *
     * <p>
     * The <code>readEJBHome</code> method is called from the <code>readObject</code> method of portable
     * <code>HomeHandle</code> implementation classes. The <code>istream</code> object is the same object that was passed in
     * to the <code>HomeHandle</code> class's <code>readObject</code> method. When <code>readEJBHome</code> is called,
     * <code>istream</code> must point to the location in the stream at which the EJBHome reference can be read. The
     * container must ensure that the EJBHome reference is capable of performing invocations immediately after
     * deserialization.
     *
     * @param istream The input stream.
     *
     * @return The deserialized EJBHome reference.
     *
     * @exception IOException The EJBHome could not be deserialized because of a system-level failure.
     * @exception ClassNotFoundException The EJBHome could not be deserialized because some class could not be found.
     */
    public jakarta.ejb.EJBHome readEJBHome(ObjectInputStream istream)
            throws IOException, ClassNotFoundException;
}
