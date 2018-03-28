package jp.co.biglobe.isp.sample.domain;

import java.util.Optional;

public interface AccountRepository {

    Optional<Account> searchAccount(AccountId accountId);

    void registAccount(Account account);
}
