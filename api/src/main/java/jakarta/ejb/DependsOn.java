/*
 * Copyright (c) 2006, 2020 Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Used to express an initialization dependency between singleton components.
 * <p>
 * 
 * The container ensures that all singleton beans with which a singleton has a <code>DependsOn</code> relationship have
 * been initialized before the singleton's <code>PostConstruct</code> method is called.
 * <p>
 * During application shutdown the container ensures that all singleton beans on with which the singleton has a
 * <code>DependsOn</code> relationship are still available during the singleton's <code>PreDestroy</code> method.
 *
 * @since EJB 3.1
 */
@Target(TYPE)
@Retention(RUNTIME)
public @interface DependsOn {

    /**
     * The ejb-names of singleton components whose initialization must occur before this singleton. The order in which these
     * names are listed is not significant.
     */
    String[] value();

}
