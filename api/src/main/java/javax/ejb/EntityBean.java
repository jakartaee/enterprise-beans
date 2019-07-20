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
 * The EntityBean interface is implemented by every entity bean 
 * class. The container uses the EntityBean methods to notify the entity
 * bean instances of the instance's life cycle events.
 *
 * <p>
 * Applications written to the EJB 3.0 and later APIs should use the facilities
 * of the Java Persistence API (<code>javax.persistence</code>) to model
 * persistent entities.
 *
 * <p><b>Note:</b> Support for entity beans is optional as of EJB 3.2.
 *
 * @since EJB 1.0
 */
public interface EntityBean extends EnterpriseBean {
    /**
     * Set the associated entity context. The container invokes this method
     * on an instance after the instance has been created.
     *
     * <p> This method is called in an unspecified transaction context.
     *
     * @param ctx An EntityContext interface for the instance. The instance
     *    should store the reference to the context in an instance variable.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error. 
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void setEntityContext(EntityContext ctx) throws EJBException,
            RemoteException;

    /**
     * Unset the associated entity context. The container calls this method
     * before removing the instance.
     *
     * <p> This is the last method that the container invokes on the instance.
     * The Java garbage collector will eventually invoke the finalize() method
     * on the instance.
     *
     * <p> This method is called in an unspecified transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error. 
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void unsetEntityContext() throws EJBException, RemoteException;

    /**
     * A container invokes this method before it removes the enterprise bean object
     * that is currently associated with the instance. This method
     * is invoked when a client invokes a remove operation on the
     * entity bean's home interface or the enterprise bean object's remote interface.
     * This method transitions the instance from the ready state to the pool 
     * of available instances.
     * 
     * <p> This method is called in the transaction context of the remove 
     * operation.
     *
     * @exception RemoveException The enterprise Bean does not allow
     *    destruction of the object.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void ejbRemove() throws RemoveException, EJBException, 
	RemoteException;

    /**
     * A container invokes this method when the instance
     * is taken out of the pool of available instances to become associated
     * with a specific enterprise bean object. This method transitions the instance to 
     * the ready state.
     *
     * <p> This method executes in an unspecified transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void ejbActivate() throws EJBException, RemoteException;

    /**
     * A container invokes this method on an instance before the instance
     * becomes disassociated with a specific enterprise bean object. After this method
     * completes, the container will place the instance into the pool of
     * available instances.
     *
     * <p> This method executes in an unspecified transaction context.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void ejbPassivate() throws EJBException, RemoteException;

    /**
     * A container invokes this method to instruct the
     * instance to synchronize its state by loading it state from the
     * underlying database.
     * 
     * <p> This method always executes in the transaction context determined
     * by the value of the transaction attribute in the deployment descriptor.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void ejbLoad() throws EJBException, RemoteException;

    /**
     * A container invokes this method to instruct the
     * instance to synchronize its state by storing it to the underlying 
     * database.
     *
     * <p> This method always executes in the transaction context determined
     * by the value of the transaction attribute in the deployment descriptor.
     *
     * @exception EJBException Thrown by the method to indicate a failure
     *    caused by a system-level error.
     *
     * @exception RemoteException This exception is defined in the method
     *    signature to provide backward compatibility for enterprise beans 
     *    written for the enterprise bean 1.0 specification. Enterprise beans written 
     *    for the EJB 1.1 specification should throw the
     *    javax.ejb.EJBException instead of this exception.
     *    Enterprise beans written for the EJB2.0 and higher specifications
     *    must throw the javax.ejb.EJBException instead of this exception.
     */
    public void ejbStore() throws EJBException, RemoteException;
}


