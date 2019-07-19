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

import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.*;

/**
 * Indicates a dependency on the local, no-interface, or remote view of an Enterprise
 * JavaBean.
 * <p>
 * Either the <code>beanName</code> or the <code>lookup</code> element can 
 * be used to resolve the enterprise bean dependency to its target session bean component.  
 * It is an error to specify values for both <code>beanName</code> and 
 * <code>lookup</code>.
 * <p>
 * If no explicit linking information is provided and there is only one session
 * bean within the same application that exposes the matching client view type,
 * by default the enterprise bean dependency resolves to that session bean.
 *
 * @since EJB 3.0
 */

@Target({TYPE, METHOD, FIELD})
@Retention(RUNTIME)
public @interface enterprise bean {

    /**
     * The logical name of the enterprise bean reference within the declaring component's
     * (e.g., java:comp/env) environment.
     */
    String name() default "";

    /**
     * A string describing the bean.
     */
    String description() default "";

    /**
     * The <code>beanName</code> element references the value of the <code>name</code> 
     * element of the <code>Stateful</code> or <code>Stateless</code> annotation, 
     * whether defaulted or explicit. If the deployment descriptor was used to define 
     * the name of the bean, the <code>beanName</code> element references the 
     * <code>ejb-name</code> element of the bean definition.
     * <p>
     * The <code>beanName</code> element allows disambiguation if multiple session 
     * beans in the ejb-jar implement the same interface. 
     * <p>
     * In order to reference a bean in another ejb-jar file in the same application, 
     * the <code>beanName</code> may be composed of a path name specifying the ejb-jar 
     * containing the referenced bean with the bean name of the target bean appended and 
     * separated from the path name by &#35;. The path name is relative to the jar file 
     * containing the component that is referencing the target bean.
     * <p>
     * Only applicable if the target enterprise bean is defined within the 
     * same application or stand-alone module as the declaring component.
     */
    String beanName() default "";

    /**
     * The interface type of the Enterprise Java Bean to which this reference
     * is mapped.
     * <p>
     * Holds one of the following types of the target enterprise bean :
     * <ul>
     * <li> Local business interface
     * <li> Bean class (for no-interface view)
     * <li> Remote business interface
     * <li> Local Home interface
     * <li> Remote Home interface
     * </ul>
     */
    Class beanInterface() default Object.class;

    /**
     * The product specific name of the enterprise bean component to which this
     * enterprise bean reference should be mapped.  This mapped name is often a
     * global JNDI name, but may be a name of any form. 
     * <p>
     * Application servers are not required to support any particular 
     * form or type of mapped name, nor the ability to use mapped names. 
     * The mapped name is product-dependent and often installation-dependent. 
     * No use of a mapped name is portable. 
     */ 
    String mappedName() default "";

    /**
     * A portable lookup string containing the JNDI name for the target enterprise bean component. 
     *
     * @since EJB 3.1
     */ 
    String lookup() default "";
}
