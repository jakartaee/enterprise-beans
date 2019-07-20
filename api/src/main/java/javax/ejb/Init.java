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

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;

/**
 * Designates a method of a session bean that corresponds to a
 * <code>create&#060;METHOD&#062;</code> method of an adapted home or
 * local home interface (an interface that adapts an enterprise bean 2.1 or earlier
 * EJBHome or EJBLocalHome client view respectively).
 *
 * <p> The result type of such an <code>Init</code> method is required
 * to be <code>void</code>, and its parameter types must be exactly the same as
 * those of the referenced <code>create&#060;METHOD&#062;</code>
 * method(s).
 *
 * <p>
 * An <code>Init</code> method is only required to be specified for
 * stateful session beans that provide a <code>RemoteHome</code> or
 * <code>LocalHome</code> interface. 
 *
 * <p> The name of the adapted <code>create&#060;METHOD&#062;</code>
 * method of the home or local home interface must be specified if the
 * adapted interface has more than one
 * <code>create&#060;METHOD&#062;</code> method and the method
 * signatures are not the same.
 *
 * @see LocalHome
 * @see RemoteHome
 *
 * @since EJB 3.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {

    /**
     * The name of the corresponding
     * <code>create&#060;METHOD&#062;</code> method of the adapted
     * home or local home interface.  This value is used to
     * disambiguate the case where there are multiple
     * <code>create&#060;METHOD&#062;</code> methods on an adapted
     * home and/or local home interface.  If there are multiple
     * <code>create&#060;METHOD&#062;</code> methods on the adapted
     * interface(s) and no value is specified, the
     * <code>create&#060;METHOD&#062;</code> matching is based on
     * signature only.
     * <p>
     * Note that this value is not required to be specified if there
     * is only a single <code>create&#060;METHOD&#062;</code> method
     * even if the name of the method to which the <code>Init</code>
     * annotation is applied does not match that of the
     * <code>create&#060;METHOD&#062;</code> method.
     */
    String value() default "";

}
