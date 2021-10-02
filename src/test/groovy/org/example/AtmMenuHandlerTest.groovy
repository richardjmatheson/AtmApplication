package org.example

import spock.lang.Specification

class AtmMenuHandlerTest extends Specification {
    def "InitializeAccountData"() {
        given: "An AtmRunner object"
        AtmMenuHandler atmRunner = new AtmMenuHandler()

        when: "initialize account data"
        atmRunner.initializeAccountData()

        then:
        noExceptionThrown()
    }

}
