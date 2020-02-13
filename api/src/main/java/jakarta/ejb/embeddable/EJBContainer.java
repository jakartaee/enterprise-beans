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

package jakarta.ejb.embeddable;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.ServiceLoader;

import javax.naming.Context;
import jakarta.ejb.EJBException;
import jakarta.ejb.spi.EJBContainerProvider;

/** 
  * Used to execute an enterprise bean application in an embeddable container.  
  *
  * @since EJB 3.1
  */
public abstract class EJBContainer implements AutoCloseable {

    /**
     * Standard property name for specifying the embeddable container implementation bootstrap
     * class.  Property value is a fully-qualified class name.
     */
    public static final String PROVIDER = "jakarta.ejb.embeddable.provider";

    /**
     * Standard property name for specifying the set of modules to be
     * initialized.  Property value is one of the following :
     * <ul>
     *  <li> a single module name String from the JVM classpath
     *  <li> a String[] array of module names from the JVM classpath
     *  <li>  a java.io.File representing an ejb-jar or exploded ejb-jar directory
     *  <li> a java.io.File array, each element of which represents an ejb-jar 
     *        or exploded ejb-jar directory
     * </ul>
     */
    public static final String MODULES = "jakarta.ejb.embeddable.modules";

    /**
     * Standard property name for specifying the application name of
     * the enterprise bean modules executing within the embeddable container. If
     * specified, the property value applies to the
     * <code>&#060;app-name&#062;</code> portion of the portable
     * global JNDI name syntax. If this property is not specified, the
     * <code>&#060;app-name&#062;</code> portion of the portable
     * global JNDI name syntax does not apply.
     */
    public static final String APP_NAME = "jakarta.ejb.embeddable.appName";

    /**
     * Create and initialize an embeddable enterprise bean container.  JVM classpath is 
     * searched for all ejb-jars or exploded ejb-jars in directory format.
     *
     * @return EJBContainer instance
     * @throws jakarta.ejb.EJBException Thrown if the container or application
 could not be successfully initialized.
     */
    public static EJBContainer createEJBContainer() { 
        return createEJBContainer(null);
    }

    /**
     * Create and initialize an embeddable enterprise bean container with a
     * set of configuration properties.
     *
     * @param properties Spec-defined and/or vendor-specific
     * properties.  The spec reserves the prefix
     * <code>"jakarta.ejb."</code> for spec-defined properties.
     *
     * @return EJBContainer instance
     * @throws jakarta.ejb.EJBException Thrown if the container or application
 could not be successfully initialized.
     */
    public static EJBContainer createEJBContainer(Map<?,?> properties) {
        EJBContainer container = null;

        Map<String, String> errors = new HashMap<String, String>();
        Set<String> returnedNull = new HashSet<String>();

        providers.reload();
        for (EJBContainerProvider provider : providers) {
            try {
                container = provider.createEJBContainer(properties);
                if (container != null) {
                    break;
                } else {
                    returnedNull.add(provider.getClass().getName());
                }
            } catch (EJBException e) {
                // The provider is eligible but encountered problems
                throw e;
            } catch (Throwable t) {
                // ignore but remember the message in case all fail: 
                // according to Spec the provider must return null from
                // createEJBContainer(), if not the right provider.
                // But non-compliant provider may throw exception
                errors.put(provider.getClass().getName(), createErrorMessage(t));
            }
        }

        if (container == null) {
            reportError(properties, errors, returnedNull);
        }
        return container;
    }

    /**
     * Retrieve a naming context for looking up references to session beans
     * executing in the embeddable container.
     *
     * @return naming context
     */
    abstract public Context getContext();

    /**
     * Shutdown an embeddable EJBContainer instance.  Embeddable applications
     * should always call <code>close()</code> in order to free up the resources
     * associated with the embeddable container.   
     */
    abstract public void close(); 

    //Private variables
    private static final String newLine = "\r\n";
    private static final ServiceLoader<EJBContainerProvider> providers = 
            ServiceLoader.load(EJBContainerProvider.class);

    /**
     * Create a meaningful EJBException in case no EJBContainer provider had
     * been found.
     *
     * @param properties the properties passed as an argument to the
     * createEJBContainer() method
     *
     * @param errors the Map of errors encountered during the createEJBContainer() call
     *
     * @param returnedNull the Set of providers that returned null on
     * createEJBContainer() call
     *
     * @throws EJBException
     */
    private static void reportError(Map<?,?> properties, Map<String, String> errors, 
            Set<String> returnedNull) throws EJBException {
        StringBuffer message = new StringBuffer(
                "No EJBContainer provider available");

        if (properties != null) {
            Object specifiedProvider = properties.get(PROVIDER);
            if (specifiedProvider != null) {
                message.append(" for requested provider: " + specifiedProvider);
            }
        }

        if (errors.isEmpty() && returnedNull.isEmpty()) {
            message.append(": no provider names had been found.");
        } else {
            message.append("\n");
        }

        for (Map.Entry me: errors.entrySet()) {
            message.append("Provider named ");
            message.append(me.getKey());
            message.append(" threw unexpected exception at create EJBContainer: \n");
            message.append(me.getValue()).append("\n");
        }
        if (!returnedNull.isEmpty()) {
            message.append("The following providers:\n");
            for (String n: returnedNull) {
                message.append(n).append("\n");
            }
            message.append("Returned null from createEJBContainer call.\n");
        }
        throw new EJBException(message.toString());
    }

    private static String createErrorMessage(Throwable t) {
        StringWriter errorMessage = new StringWriter();
        errorMessage.append(t.getClass().getName()).append(newLine);
        t.printStackTrace(new PrintWriter(errorMessage));
        errorMessage.append(newLine);
        return errorMessage.toString();
    }

}

