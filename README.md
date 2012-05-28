Grails Golfer
-------------

A test-bed for playing with Groovy & Grails and other related technologies. There's no real functionality here, just some basic domain models for modelling a fictional golf app and a bunch of experiments with different testing frameworks.

Run the app
    grails run-app

Run all tests
    grails -Dserver.port=8090 test-app -echoOut

Run functional tests, force use of chrome
    grails -Dgeb.env=chrome -Dserver.port=8090 test-app -functional -echoOut

Grails Notes
------------

Grails Docs - http://grails.org/doc/latest/guide/ 

Testing
-------

http://grails.org/doc/latest/guide/testing.html
Use '-echoOut' to log messages in test to console i.e. test-app -echoOut

Unit Testing
------------

    test-app unit: com.richardadamdean.Trip - run a single unit test.

http://code.google.com/p/spock/ - BDD Specs

    test-app :spock - run only Spock specs (spock specs will also be picked up as part of the full test-app suite)

Functional Testing
------------------

http://grails.org/doc/latest/guide/testing.html#functionalTesting 
http://seleniumhq.org/docs/03_webdriver.html 

GEB - http://gebish.org - combines webdriver, jquery style selectors, page modelling - basically it’s capybara

Nice simple example grails app with Geb & Spock integration https://github.com/geb/geb-example-grails 

To run func tests on a different port:

    grails -Dgeb.env=chrome -Dserver.port=8090 test-app -functional 

Cucumber
--------

https://github.com/hauner/grails-cucumber 
https://github.com/hauner/grails-cucumber/wiki/Automating-Specification-with-Cucumber-and-Grails 
https://github.com/cucumber/cucumber-jvm 

Run using: 

    test-app :cucumber

https://github.com/hauner/grails-cucumber/wiki/Testing-Grails-with-Cucumber-and-Geb - 

Gradle
------

http://www.gradle.org/docs/current/userguide/userguide_single.html 

Database Migrations
-------------------

http://blog.springsource.com/2011/08/17/countdown-to-grails-2-0-database-migrations/ 

Legacy Databases
----------------

https://www.ibm.com/developerworks/java/library/j-grails07158/ - old but interesting

REST & Grails
-------------

https://www.ibm.com/developerworks/java/library/j-grails09168/ 

Cheatsheet
----------

Create a new Grails app
  
    grails create-app my-project

List a classes persistent properties: 

import com.richardadamdean.golfer.*
import org.codehaus.groovy.grails.commons.DefaultGrailsDomainClass
def d = new DefaultGrailsDomainClass(User.class)
d.persistentProperties

Add “grails.gorm.failOnError = true” to Config.groovy to force validation fails to fail noisily (by default validaton fails will do so quietly)
