package org.example.model

import spock.lang.Specification

class AccountTest extends Specification {

    def "success - getBalanceAsString Test"() {
        given: "an instance of an Account object"
        def account = new Account(444, 1234, "Sam", "Spade", 123.45)

        and: "an expected result string based on Account data"
        def expected = "\$\t123.45"

        when: "get balance"
        def result = account.getBalanceAsString()

        then: "result is as expected"
        result
        result == expected
    }

    def "success - depositFunds unit test"() {
        given: "an initial balance"
        def balance = new BigDecimal(123.45)

        and: "an instance of an Account object"
        def account = new Account(444, 1234, "Sam", "Spade", balance)

        and: "a positive deposit amount"
        def depositAmount = new BigDecimal(44.22)

        when: "deposit funds"
        def result = account.depositFunds(depositAmount)

        then: "result is as expected"
        result
        result.doubleValue() == depositAmount.doubleValue() + balance.doubleValue()

    }

    def "failure - depositFunds negative value unit test"() {
        given: "an initial balance"
        def balance = new BigDecimal(123.45)

        and: "an instance of an Account object"
        def account = new Account(444, 1234, "Sam", "Spade", balance)

        and: "a positive deposit amount"
        def depositAmount = new BigDecimal(-44.22)

        when: "deposit funds"
        account.depositFunds(depositAmount)

        then: "result is as expected"
        thrown(IllegalArgumentException)

    }

    def "success - withdrawFunds unit test"() {
        given: "an initial balance"
        def balance = new BigDecimal(123.45)

        and: "an instance of an Account object"
        def account = new Account(444, 1234, "Sam", "Spade", balance)

        and: "a positive deposit amount"
        def withdrawalAmount = new BigDecimal(44.22)

        when: "withdraw funds"
        def result = account.withdrawFunds(withdrawalAmount)

        then: "result is as expected"
        result
        result.doubleValue() == balance.doubleValue() - withdrawalAmount.doubleValue()

    }

    def "failure - withdrawFunds negative value unit test"() {
        given: "an initial balance"
        def balance = new BigDecimal(123.45)

        and: "an instance of an Account object"
        def account = new Account(444, 1234, "Sam", "Spade", balance)

        and: "a positive deposit amount"
        def withdrawalAmount = new BigDecimal(-44.22)

        when: "withdraw funds"
        account.depositFunds(withdrawalAmount)

        then: "result is as expected"
        thrown(IllegalArgumentException)

    }

}
