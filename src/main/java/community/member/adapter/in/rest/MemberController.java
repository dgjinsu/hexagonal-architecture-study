package community.member.adapter.in.rest;

import community.member.adapter.common.Response;
import community.member.adapter.in.dto.JoinRequest;
import community.member.application.port.in.JoinUseCase;
import community.member.application.port.in.command.JoinCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final JoinUseCase joinUseCase;

    @PostMapping("/api/member")
    public ResponseEntity<Response<Long>> joinMember(@RequestBody JoinRequest request) {
        JoinCommand joinCommand = new JoinCommand(request.getLoginId(), request.getPassword(), request.getPassword());
        return ResponseEntity.ok(new Response<>(joinUseCase.joinMember(joinCommand), "회원가입 완료"));
    }
}
