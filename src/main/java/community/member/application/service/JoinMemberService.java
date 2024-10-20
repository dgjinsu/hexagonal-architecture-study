package community.member.application.service;

import community.member.application.port.in.JoinUseCase;
import community.member.application.port.in.command.JoinCommand;
import community.member.application.port.out.SaveMemberPort;
import community.member.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class JoinMemberService implements JoinUseCase {

    private final SaveMemberPort saveMemberPort;

    @Override
    public Long joinMember(JoinCommand command) {
        Member member = Member.builder()
            .loginId(command.getLoginId())
            .password(command.getPassword())
            .name(command.getName())
            .build();

        return saveMemberPort.saveMember(member);
    }
}
