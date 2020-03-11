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

package jakarta.ejb;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * The <code>Timer</code> interface contains information about a timer
 * that was created through the enterprise bean Timer Service.
 *
 * @since EJB 2.1
 */
public interface Timer {

    /**
     * Cause the timer and all its associated expiration notifications to
     * be cancelled.
     *
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     */
    public void cancel() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;
    
    /**
     * Get the number of milliseconds that will elapse before the next
     * scheduled timer expiration. 
     *
     * @return the number of milliseconds that will elapse before the next
     * scheduled timer expiration.
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     *
     * @exception jakarta.ejb.NoMoreTimeoutsException Indicates that the 
     * timer has no future timeouts
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     */
    public long getTimeRemaining() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.NoMoreTimeoutsException, jakarta.ejb.EJBException;

    /**
     * Get the point in time at which the next timer expiration is scheduled 
     * to occur.
     *
     * @return the point in time at which the next timer expiration is 
     * scheduled to occur.
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * 
     * @exception jakarta.ejb.NoMoreTimeoutsException Indicates that the 
     * timer has no future timeouts
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     */
    public Date getNextTimeout() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.NoMoreTimeoutsException, jakarta.ejb.EJBException;

    /**
     * Get the schedule expression corresponding to this timer.  The timer
     * must be a calendar-based timer.  It may have been created automatically
     * or programmatically.
     *
     * @return schedule expression for the timer.
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.  Also thrown if invoked on a timer that is not a
     * calendar-based timer.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     *
     * @since EJB 3.1
     */
    public ScheduleExpression getSchedule() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;

    /**
     * Return whether this timer has persistent semantics.
     *
     * @return boolean indicating whether the timer is persistent.

     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     *
     * @since EJB 3.1
     */
    public boolean isPersistent() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;    

    /**
     * Return whether this timer is a calendar-based timer.  
     *
     * @return boolean indicating whether the timer is calendar-based.
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method. 
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     *
     * @since EJB 3.1
     */
    public boolean isCalendarTimer() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;    


    /**
     * Get the information associated with the timer at the time of
     * creation.  This may be the <code>info</code> string that was
     * passed to the timer creation method or the <code>info</code>
     * element of the <code>Schedule</code> annotaiton.
     *
     * @return The Serializable object that was passed in at timer creation, or
     * null if the info argument passed in at timer creation was null.
     *
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     */
    public Serializable getInfo() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;


    /**
     * Get a serializable handle to the timer.  This handle can
     * be used at a later time to re-obtain the timer reference.
     *
     * @return a serializable handle to the timer.
     * 
     * @exception java.lang.IllegalStateException If this method is
     * invoked while the instance is in a state that does not allow access 
     * to this method.  Also thrown if invoked on a non-persistent timer.
     * @throws jakarta.ejb.NoSuchObjectLocalException If invoked on a timer
 that has expired or has been cancelled.
     * @throws jakarta.ejb.EJBException If this method could not complete due
 to a system-level failure.
     */
    public TimerHandle getHandle() throws java.lang.IllegalStateException, jakarta.ejb.NoSuchObjectLocalException, jakarta.ejb.EJBException;



} 
