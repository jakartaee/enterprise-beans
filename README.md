# Jakarta Enterprise Beans

This repository contains the code for Jakarta Enterprise Beans.

[Online JavaDoc](https://javadoc.io/doc/jakarta.ejb/jakarta.ejb-api/)

## About Jakarta Enterprise Beans

Jakarta Enterprise Beans defines a server-side API for implementing component-based business logic.

## Building

Prerequisites:

* JDK8+
* Maven 3.5.4+

Run the build: 

`mvn clean install`

The build runs copyright check and generates the jar, sources-jar and javadoc-jar by default.
The API jar is built in /api/target.

## Checking findbugs

`mvn -pl api spotbugs:spotbugs`

## Licensing

- [Eclipse Public License v. 2.0](http://www.eclipse.org/legal/epl-2.0)
- [GPL2 with Classpath Exception](https://www.gnu.org/software/classpath/license.html)

## Links

- Official web site: https://github.com/eclipse-ee4j/ejb-api



