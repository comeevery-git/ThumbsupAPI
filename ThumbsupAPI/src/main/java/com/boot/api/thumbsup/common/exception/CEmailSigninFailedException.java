package com.boot.api.thumbsup.common.exception;

/*
 * Class명의 prefix C는 Custom을 의미합니다.
 * Exception 이름은 알아보기 쉽고 의미가 명확하게 전달될 수 있는 한 자유롭게 지으면 됩니다.
 * 예외 발생 시 이미 구현되어있는 Exception Class를 사용할 수 있지만 매번 정의된 Exception을 사용하는 것은 여러 가지 예외 상황을 구분하는데 적합하지 않을 수 있습니다.
 * 그래서 Custom Exception을 정의하여 사용해 보겠습니다.
 * 로그인 예외처리
 */

public class CEmailSigninFailedException extends RuntimeException {
    public CEmailSigninFailedException(String msg, Throwable t) {
        super(msg, t);
    }
    public CEmailSigninFailedException(String msg) {
        super(msg);
    }
    public CEmailSigninFailedException() {
        super();
    }
}