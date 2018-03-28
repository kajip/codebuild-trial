package jp.co.biglobe.isp.sample.domain.authentication;

import jp.co.biglobe.isp.sample.domain.Password;

class PlainPasswordAuthenticationAlgorithm implements AuthenticationAlgorithm {

    /**
     * 認証する
     *
     * @param password      自パスワード
     * @param inputPassword 入力されたパスワード
     * @return 認証結果
     */
    @Override
    public boolean authentication(Password password, Password inputPassword) {
        return password.equals(inputPassword);
    }
}
