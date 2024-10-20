package community.member.application.port.in.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
public class JoinCommand {

    /**
     * command 를 사용하는 이유
     * 요청하는 외부 시스템에 따라 객체의 형태가 달라질 수 있기 때문
     * ex) responseBody 로 넘어오던 id값이 pathvariable로 넘어올 경우, usecase 코드도 함께 수정해야 함
     * alidation Check를 Command에서만 하면 된다
     */
    private String loginId;
    private String password;
    private String name;
}
