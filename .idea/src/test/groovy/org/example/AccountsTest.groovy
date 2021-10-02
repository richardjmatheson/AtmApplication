package org.example

import spock.lang.Specification

class AccountsTest extends Specification {
    def "InitializeAccountData"() {
        given: "An instance of AtmRunner"
        Accounts accounts = new Accounts();

        when: "call to initialize accounts"
        accounts.initializeAccountData()

        then: "check accounts list"
        accounts.size() == 5
    }
}