/*
 * Copyright (c) 2006, 2018 Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;
import jakarta.ejb.embeddable.EJBContainer;
import jakarta.ejb.EJBException;

/**
 * The EJBContainerProvider SPI is used by the embeddable container bootstrap
 * class to initialize a suitable embeddable container.
 *
 * @since EJB 3.1
 */
public interface EJBContainerProvider {

    /**
     * Called by the embeddable container bootstrap process to find a
     * suitable embeddable container implementation.  An embeddable
     * container provider may deem itself as appropriate for the
     * embeddable application if any of the following are true :
     * 
     * <ul>
     * <li>
     *   The <code>javax.ejb.embeddable.provider</code> property was
     *   included in the Map passed to <code>createEJBContainer</code>
     *   and the value of the property is the provider's
     *   implementation class.
     *
     * <li>
     *   No <code>javax.ejb.embeddable.provider</code> property was specified.
     *</ul>
     *
     * If a provider does not qualify as the provider for the
     * embeddable application, it must return null.
     *
     * @param properties Spec-defined and/or vendor-specific
     * properties, that were passed to <code>javax.ejb.embeddable.EJBContainer#createEJBContainer(Map&#60;&#63;,&#63;&#62;)</code> call
     * 
     * @return EJBContainer instance or null
     */
    public EJBContainer createEJBContainer(Map<?,?> properties) throws EJBException;

}
