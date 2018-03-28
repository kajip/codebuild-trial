package jp.co.biglobe.isp.sample.api;

import jp.co.biglobe.isp.sample.domain.Account;
import jp.co.biglobe.isp.sample.domain.AccountId;
import jp.co.biglobe.isp.sample.domain.AccountRepository;
import jp.co.biglobe.isp.sample.domain.Password;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@RestController
@RequestMapping(value = "authentication")
public class AuthenticationApi {

    private final AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String authentication(
        @RequestParam("accountId") String accountId,
        @RequestParam("password") String password
    ) throws Exception {
        Optional<Account> account = accountRepository.searchAccount(new AccountId(accountId));
        return account
            .filter(a -> a.authentication(new Password(password)))
            .map(a -> "O.K.").orElse("N.G.");
    }
}
