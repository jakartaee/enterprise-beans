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

import java.io.Serializable;

/**
 * <p>
 * TimerConfig is used to specify additional timer configuration settings during timer creation.
 * </p>
 *
 * <p>
 * The <code>info</code> object represents a serializable object made available to corresponding timer callbacks. It is
 * optional and defaults to <code>null</code>.
 * </p>
 *
 * <p>
 * The <code>persistent</code> property determines whether the corresponding timer has a lifetime that spans the JVM in
 * which it was created. It is optional and defaults to <code>true</code>.
 * </p>
 *
 * @since EJB 3.1
 */
public class TimerConfig {

    /**
     * <p>Constructor for TimerConfig.</p>
     */
    public TimerConfig() {
    }

    /**
     * <p>Constructor for TimerConfig.</p>
     *
     * @param info a {@link java.io.Serializable} object.
     * @param persistent a boolean.
     */
    public TimerConfig(Serializable info, boolean persistent) {
        info_ = info;
        persistent_ = persistent;
    }

    /**
     * Set the <code>info</code> object made available to timer callbacks.
     *
     * @param i the info object
     */
    public void setInfo(Serializable i) {
        info_ = i;
    }

    /**
     * Return the <code>info</code> object made available to timer callbacks.
     *
     * @return info object
     */
    public Serializable getInfo() {
        return info_;
    }

    /**
     * Specify whether the timer is persistent.
     *
     * @param p boolean indicating whether the timer is to be persistent.
     */
    public void setPersistent(boolean p) {
        persistent_ = p;
    }

    /**
     * Return whether the timer is persistent.
     *
     * @return boolean indicating whether the timer is persistent
     */
    public boolean isPersistent() {
        return persistent_;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "TimerConfig [persistent=" + persistent_ + ";info=" + info_ + "]";
    }

    private Serializable info_ = null;

    private boolean persistent_ = true;

}
