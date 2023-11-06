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
import java.util.Date;
import java.util.Collection;

/**
 * The TimerService interface provides enterprise bean components with access to the container-provided Timer Service.
 * The enterprise bean Timer Service allows stateless session beans, singleton session beans, message-driven beans, and
 * enterprise bean 2.x entity beans to be registered for timer callback events at a specified time, after a specified
 * elapsed time, after a specified interval, or according to a calendar-based schedule.
 *
 * @since EJB 2.1
 */
public interface TimerService {

    /**
     * Create a single-action timer that expires after a specified duration.
     *
     * @param duration the number of milliseconds that must elapse before the timer expires.
     * @param info application information to be delivered along with the timer expiration notification. This can be null.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If duration is negative
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method fails due to a system-level failure.
     */
    public Timer createTimer(long duration, Serializable info) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create a single-action timer that expires after a specified duration.
     *
     * @param duration the number of milliseconds that must elapse before the timer expires.
     * @param timerConfig timer configuration.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If duration is negative
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method fails due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createSingleActionTimer(long duration, TimerConfig timerConfig) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create an interval timer whose first expiration occurs after a specified duration, and whose subsequent expirations
     * occur after a specified interval.
     *
     * @param initialDuration The number of milliseconds that must elapse before the first timer expiration notification.
     * @param intervalDuration The number of milliseconds that must elapse between timer expiration notifications.
     * Expiration notifications are scheduled relative to the time of the first expiration. If expiration is delayed (e.g.
     * due to the interleaving of other method calls on the bean), two or more expiration notifications may occur in close
     * succession to "catch up".
     * @param info application information to be delivered along with the timer expiration. This can be null.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If initialDuration is negative or intervalDuration is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Timer createTimer(long initialDuration, long intervalDuration,
            Serializable info) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create an interval timer whose first expiration occurs after a specified duration, and whose subsequent expirations
     * occur after a specified interval.
     *
     * @param initialDuration The number of milliseconds that must elapse before the first timer expiration notification.
     * @param intervalDuration The number of milliseconds that must elapse between timer expiration notifications.
     * Expiration notifications are scheduled relative to the time of the first expiration. If expiration is delayed (e.g.
     * due to the interleaving of other method calls on the bean), two or more expiration notifications may occur in close
     * succession to "catch up".
     * @param timerConfig timer configuration
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If initialDuration is negative or intervalDuration is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createIntervalTimer(long initialDuration, long intervalDuration,
            TimerConfig timerConfig) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create a single-action timer that expires at a given point in time.
     *
     * @param expiration The point in time at which the timer must expire.
     * @param info application information to be delivered along with the timer expiration notification. This can be null.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If expiration is null or expiration.getTime() is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Timer createTimer(Date expiration, Serializable info) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create a single-action timer that expires at a given point in time.
     *
     * @param expiration the point in time at which the timer must expire.
     * @param timerConfig timer configuration.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If expiration is null or expiration.getTime() is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createSingleActionTimer(Date expiration, TimerConfig timerConfig) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create an interval timer whose first expiration occurs at a given point in time and whose subsequent expirations
     * occur after a specified interval.
     *
     * @param initialExpiration the point in time at which the first timer expiration must occur.
     * @param intervalDuration the number of milliseconds that must elapse between timer expiration notifications.
     * Expiration notifications are scheduled relative to the time of the first expiration. If expiration is delayed (e.g.
     * due to the interleaving of other method calls on the bean), two or more expiration notifications may occur in close
     * succession to "catch up".
     * @param info application information to be delivered along with the timer expiration. This can be null.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If initialExpiration is null, if initialExpiration.getTime() is
     * negative, or if intervalDuration is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Timer createTimer(Date initialExpiration, long intervalDuration,
            Serializable info) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create an interval timer whose first expiration occurs at a given point in time and whose subsequent expirations
     * occur after a specified interval.
     *
     * @param initialExpiration the point in time at which the first timer expiration must occur.
     * @param intervalDuration the number of milliseconds that must elapse between timer expiration notifications.
     * Expiration notifications are scheduled relative to the time of the first expiration. If expiration is delayed (e.g.
     * due to the interleaving of other method calls on the bean), two or more expiration notifications may occur in close
     * succession to "catch up".
     * @param timerConfig timer configuration.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If initialExpiration is null, if initialExpiration.getTime() is
     * negative, or if intervalDuration is negative.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createIntervalTimer(Date initialExpiration, long intervalDuration,
            TimerConfig timerConfig) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Create a calendar-based timer based on the input schedule expression.
     *
     * @param schedule a schedule expression describing the timeouts for this timer.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If Schedule represents an invalid schedule expression.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createCalendarTimer(ScheduleExpression schedule)
            throws java.lang.IllegalArgumentException,
            java.lang.IllegalStateException, jakarta.ejb.EJBException;

    /**
     * Create a calendar-based timer based on the input schedule expression.
     *
     * @param schedule a schedule expression describing the timeouts for this timer.
     * @param timerConfig timer configuration.
     * @return the newly created Timer.
     * @exception java.lang.IllegalArgumentException If Schedule represents an invalid schedule expression.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.1
     */
    public Timer createCalendarTimer(ScheduleExpression schedule, TimerConfig timerConfig)
            throws java.lang.IllegalArgumentException,
            java.lang.IllegalStateException, jakarta.ejb.EJBException;

    /**
     * Returns all active timers associated with this bean. These include both the programmatically-created timers and the
     * automatically-created timers.
     *
     * @return a collection of <code>jakarta.ejb.Timer</code> objects.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Collection<Timer> getTimers() throws java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Returns all active timers associated with this bean matching externalId. These include both the programmatically-created timers and the
     * automatically-created timers.
     *
     * @param externalId external id to look for.
     * @return a collection of <code>jakarta.ejb.Timer</code> objects.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     */
    public Collection<Timer> getTimersbyExternalId(String externalId) throws java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

    /**
     * Returns all active timers associated with the beans in the same module in which the caller bean is packaged. These
     * include both the programmatically-created timers and the automatically-created timers.
     *
     * @return a collection of <code>jakarta.ejb.Timer</code> objects.
     * @exception java.lang.IllegalStateException If this method is invoked while the instance is in a state that does not
     * allow access to this method.
     * @throws jakarta.ejb.EJBException If this method could not complete due to a system-level failure.
     * @since EJB 3.2
     */
    public Collection<Timer> getAllTimers() throws java.lang.IllegalStateException,
            jakarta.ejb.EJBException;

}
