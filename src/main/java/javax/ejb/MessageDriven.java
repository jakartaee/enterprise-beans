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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Component-defining annotation for a message driven bean.  
 * <p>
 * The message driven bean must implement the appropriate message
 * listener interface for the messaging type that the message-driven
 * bean supports or specify the message listener interface using the
 * <code>messageListenerInterface</code> element of this annotation.
 *
 * @see ActivationConfigProperty
 *
 * @since EJB 3.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MessageDriven {

    /**
     * The ejb-name for this bean.  Defaults to the unqualified name of
     * the message driven bean class.
     */
    String name() default "";

    /**
     * Message-listener interface.  If the message-driven bean class
     * implements more than one interface other than <code>java.io.Serializable</code>,
     * <code>java.io.Externalizable</code>, or any of the interfaces defined by the
     * <code>javax.ejb</code> package, the message listener interface must be 
     * specified.
     */
    Class messageListenerInterface() default Object.class;

    /**
     * Activation config properties.
     */
    ActivationConfigProperty[] activationConfig() default {}; 

    /**
      * A product specific name(e.g. global JNDI name of a queue) 
      * that this message-driven bean should be mapped to.  
      * 
      * Application servers are not required to support any particular 
      * form or type of mapped name, nor the ability to use mapped names. 
      * The mapped name is product-dependent and often installation-dependent. 
      * No use of a mapped name is portable. 
      */ 
    String mappedName() default "";

    /**
     * A string describing the message driven bean.
     */ 
    String description() default "";
}

