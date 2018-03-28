package jp.co.biglobe.isp.sample.datasource

import jp.co.biglobe.isp.BootApplication
import jp.co.biglobe.isp.sample.domain.Account
import jp.co.biglobe.isp.sample.domain.AccountId
import jp.co.biglobe.isp.sample.domain.AccountRepository
import jp.co.biglobe.isp.sample.domain.Password
import org.dbunit.DataSourceDatabaseTester
import org.dbunit.IDatabaseTester
import org.dbunit.dataset.IDataSet
import org.dbunit.util.fileloader.DataFileLoader
import org.dbunit.util.fileloader.FlatXmlDataFileLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.sql.DataSource

@SpringBootTest(classes=[
        BootApplication
])
class AccountRepositorySpec extends Specification {

    @Autowired
    DataSource dataSource

    IDatabaseTester databaseTester

    def setup() {
        DataFileLoader dataFileLoader = new FlatXmlDataFileLoader()
        IDataSet dataSet = dataFileLoader.load("/dataset/test.xml")

        databaseTester = new DataSourceDatabaseTester(dataSource)
        databaseTester.setDataSet(dataSet)
        databaseTester.onSetup()
    }

    def cleanup() {
        databaseTester.onTearDown()
    }

    @Autowired
    AccountRepository accountsRepository

    @Unroll
    def "アカウント取得"() {
        expect:
        accountsRepository.searchAccount(accountId) == expectedValue

        where:
        expectedValue || accountId
        Optional.empty() || new AccountId("unknown")
        Optional.of(new Account(new AccountId("sample"), new Password("password"))) || new AccountId("sample")
    }

    def "アカウント登録"() {
        when:
        def accountId = new AccountId("test1")
        def password  = new Password("passw0rd")
        def account = new Account(accountId, password)
        accountsRepository.registAccount(account)

        then:
        accountsRepository.searchAccount(accountId) == Optional.of(account)
    }
}
