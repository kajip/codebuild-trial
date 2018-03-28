package jp.co.biglobe.isp.sample.datasource;

import jp.co.biglobe.isp.sample.domain.Account;
import jp.co.biglobe.isp.sample.domain.AccountId;
import jp.co.biglobe.isp.sample.domain.AccountRepository;
import jp.co.biglobe.isp.sample.domain.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
@Slf4j
public class AccountRepositoryDb implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Account> searchAccount(AccountId accountId) {
        return jdbcTemplate.query(
            "SELECT account_id, password FROM accounts WHERE account_id = ?",
            new Object[] {accountId.getValue()},
            (rs, rowNum) -> new Account(new AccountId(rs.getString(1)), new Password(rs.getString(2))))
            .stream()
            .findFirst();
    }

    @Override
    public void registAccount(Account account) {
        jdbcTemplate.update("INSERT INTO accounts VALUES(?, ?)",
            account.getAccountId().getValue(), account.getPassword().getValue());
    }
}
