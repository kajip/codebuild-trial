package jp.co.biglobe.isp.sample.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Account {

    private final AccountId accountId;

    private final Password password;

    /**
     * ユーザを認証する
     * @param password 入力されたパスワード
     * @return 認証結果
     */
    public boolean authentication(Password password) {
        return password.authentication(password);
    }
}
