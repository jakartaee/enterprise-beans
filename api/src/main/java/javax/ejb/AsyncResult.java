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

package javax.ejb;

import java.io.Serializable;
import java.util.concurrent.*;

/**
  * Wraps the result of an asynchronous method call as a <code>Future</code>
  * object, preserving compatability with the business interface signature.
  * <p>
  * The value specified in the constructor will be retrieved by the container
  * and made available to the client.
  * <p>
  * Note that this object is not passed to the client.  It is
  * merely a convenience for providing the result value to the container.
  * Therefore, none of its instance methods should be called by the 
  * application.
  *
  * @since EJB 3.1
  */

public final class AsyncResult<V> implements Future<V> {

    private final V resultValue;

    /**
     * Creates a <code>AsyncResult</code> instance to wrap the result of an
     * asynchronous method call
     *
     * @param result the result of an asynchronous method call to be made
     * available to the client
     */
    public AsyncResult(V result) {
        resultValue = result;
    }

    /**
     * This method should not be called.  See Class-level comments.
     */
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    /**
     * This method should not be called.  See Class-level comments.
     */
    @Override
    public boolean isCancelled() {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    /**
     * This method should not be called.  See Class-level comments.
     */
    @Override
    public boolean isDone() {
        throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

    /**
     * This method should not be called.  See Class-level comments.
     */
    @Override
    public V get() throws InterruptedException, ExecutionException {
	    return resultValue;
    }

    /**
     * This method should not be called.  See Class-level comments.
     */
    @Override
    public V get(long timeout, TimeUnit unit) 
	throws InterruptedException, ExecutionException, TimeoutException {
	throw new java.lang.IllegalStateException
	    ("Object does not represent an acutal Future");
    }

}
