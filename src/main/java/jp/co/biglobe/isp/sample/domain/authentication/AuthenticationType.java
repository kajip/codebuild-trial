package jp.co.biglobe.isp.sample.domain.authentication;

import jp.co.biglobe.isp.sample.domain.Password;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AuthenticationType {

    PLAIN(new PlainPasswordAuthenticationAlgorithm());


    private final AuthenticationAlgorithm algorithm;

    /**
     * 認証する
     * @param inputPassword 入力されたパスワード
     * @return 認証結果
     */
    public boolean authentication(Password password, Password inputPassword) {
        return algorithm.authentication(password, inputPassword);
    }
}
