package jp.co.biglobe.isp.sample.domain

import spock.lang.Specification
import spock.lang.Unroll

class PasswordSpec extends Specification {

    @Unroll
    def "パスワード認証のテスト"() {
        expect:
        def password = new Password("Passw0rd")
        expectedValue == password.authentication(inputPassword)

        where:
        expectedValue || inputPassword
        true          || new Password("Passw0rd")
        false         || new Password("Password")
    }
}
