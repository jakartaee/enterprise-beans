# Jakarta Enterprise beans

This repository contains the code for Jakarta Enterprise Beans.

[Online JavaDoc](https://javadoc.io/doc/jakarta.ejb/jakarta.ejb-api/)

## About Jakarta Enterprise Beans

Jakarta Enterprise Beans defines a server-side API for implementing component-based business logic.

## Building

Prerequisites:

* JDK8+
* Maven 3.0.3+

Run the build: 

`mvn clean install`

The build runs copyright check and generates the jar, sources-jar and javadoc-jar by default.
The API jar is built in /api/target.

## Checking findbugs

`mvn -DskipTests -Dfindbugs.threshold=Low findbugs:findbugs`

## Licensing

- [Eclipse Public License v. 2.0](http://www.eclipse.org/legal/epl-2.0)
- [GPL2 with Classpath Exception](https://www.gnu.org/software/classpath/license.html)

## Links

- Official web site: https://github.com/eclipse-ee4j/ejb-api



