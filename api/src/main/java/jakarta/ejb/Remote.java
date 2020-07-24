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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares the remote business interface(s) for a session bean.
 * <p>
 * The <code>Remote</code> annotation is applied to the session bean class or remote business interface to designate a
 * remote business interface of the bean.
 * <p>
 * When used on an interface, designates that interface as a remote business interface. In this case, no
 * <code>value</code> element should be provided.
 * <p>
 * The <code>Remote</code> annotation applies only to session beans and their interfaces.
 *
 * @since EJB 3.0
 */

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Remote {

    /**
     * Specifies the remote business interface(s) of the bean. The <code>value</code> element is specified only when the
     * annotation is applied to the bean class. It is only required to be specified if any of the following is true:
     * <ul>
     * <li>the bean class does not implement its remote business interface
     * <li>at least one of the implemented interfaces is designated as a local interface
     * <li>the bean class implements two or more interfaces and at least one of the implemented interfaces is designated as
     * a remote business interface using <code>Remote</code> annotation on the interface, and at least one other interface
     * (excluding <code>java.io.Serializable</code>, <code>java.io.Externalizable</code>, and any of the interfaces defined
     * by the <code>jakarta.ejb</code> package) has no designation.
     * </ul>
     *
     * @return an array of {@link java.lang.Class} objects.
     */
    Class[] value() default {};
}
