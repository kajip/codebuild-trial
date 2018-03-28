package jp.co.biglobe.isp.sample.api;

import jp.co.biglobe.isp.sample.domain.Account;
import jp.co.biglobe.isp.sample.domain.AccountId;
import jp.co.biglobe.isp.sample.domain.AccountRepository;
import jp.co.biglobe.isp.sample.domain.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
@RequestMapping(value = "accounts")
public class AccountApi {

    private final AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST)

    @ResponseBody
    public void run(
        @RequestParam("accountId") String accountId,
        @RequestParam("password") String password
    ) {
        accountRepository.registAccount(new Account(
            new AccountId(accountId),
            new Password(password)
        ));
    }
}
