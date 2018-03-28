package jp.co.biglobe.isp.sample.domain;

import jp.co.biglobe.isp.sample.domain.authentication.AuthenticationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode(of="value")
public class Password {

    @Getter
    private final String value;

    private final AuthenticationType authenticationType;

    public Password(String value) {
        this(value, AuthenticationType.PLAIN);
    }

    /**
     * 認証する
     * @param inputPassword 入力されたパスワード
     * @return 認証結果
     */
    boolean authentication(Password inputPassword) {
        return authenticationType.authentication(this, inputPassword);
    }

    @Override
    public String toString() {
        return "Password(****)";
    }
}
