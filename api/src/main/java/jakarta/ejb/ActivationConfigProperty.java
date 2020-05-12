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

package jakarta.ejb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to provide information to the deployer about the configuration of a message driven bean in its operational
 * environment.
 * <p>
 * The following standard properties are recognized for JMS message driven beans:
 * <ul>
 * <li><code>acknowledgeMode</code>. This property is used to specify the JMS acknowledgement mode for the message
 * delivery when bean-managed transaction demarcation is used. Its values are <code>Auto_acknowledge</code> or
 * <code>Dups_ok_acknowledge</code>. If this property is not specified, JMS <code>AUTO_ACKNOWLEDGE</code> semantics are
 * assumed.
 *
 * <li><code>messageSelector</code>. This property is used to specify the JMS message selector to be used in determining
 * which messages a JMS message driven bean is to receive.
 *
 * <li><code>destinationType</code>. This property is used to specify whether the message driven bean is intended to be
 * used with a queue or a topic. The value must be either <code>javax.jms.Queue</code> or <code>javax.jms.Topic</code>.
 *
 * <li><code>destinationLookup</code>. This property is used to specify the JMS queue or topic from which a JMS
 * message-driven bean is to receive messages.
 *
 * <li><code>connectionFactoryLookup</code>. This property is used to specify the JMS connection factory that will be
 * used to connect to the JMS provider from which a JMS message-driven bean is to receive messages.
 *
 * <li><code>subscriptionDurability</code>. If the message driven bean is intended to be used with a topic, this
 * property may be used to indicate whether a durable or non-durable subscription should be used. The value of this
 * property must be either <code>Durable</code> or <code>NonDurable</code>
 *
 * <li><code>subscriptionName</code>. This property is used to specify the name of the durable subscription if the
 * message-driven bean is intended to be used with a Topic, and the bean provider has indicated that a durable
 * subscription should be used.
 *
 * <li><code>clientId</code>. This property is used to specify the JMS client identifier that will be used when
 * connecting to the JMS provider from which a JMS message-driven bean is to receive messages. If this property is not
 * specified then the client identifier will be left unset.
 *
 * </ul>
 *
 * @since EJB 3.0
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivationConfigProperty {
    /**
     * <p>propertyName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String propertyName();

    /**
     * <p>propertyValue.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    String propertyValue();
}
