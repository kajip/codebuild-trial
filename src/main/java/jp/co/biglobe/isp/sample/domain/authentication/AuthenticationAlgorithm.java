package jp.co.biglobe.isp.sample.domain.authentication;

import jp.co.biglobe.isp.sample.domain.Password;

interface AuthenticationAlgorithm {

    /**
     * 認証する
     * @param password 自パスワード
     * @param inputPassword 入力されたパスワード
     * @return 認証結果
     */
    boolean authentication(Password password, Password inputPassword);
}
