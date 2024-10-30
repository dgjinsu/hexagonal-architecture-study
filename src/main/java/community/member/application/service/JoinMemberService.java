package community.member.application.service;

import community.member.adapter.in.dto.MemberResponse;
import community.member.application.port.in.JoinUseCase;
import community.member.application.port.in.MemberListUseCase;
import community.member.application.port.in.command.JoinCommand;
import community.member.application.port.in.result.MemberResult;
import community.member.application.port.out.GetMemberPort;
import community.member.application.port.out.SaveMemberPort;
import community.member.domain.Member;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class JoinMemberService implements JoinUseCase, MemberListUseCase {

    private final SaveMemberPort saveMemberPort;
    private final GetMemberPort getMemberPort;

    @Override
    public Long joinMember(JoinCommand command) {
        Member member = Member.builder()
            .loginId(command.getLoginId())
            .password(command.getPassword())
            .name(command.getName())
            .build();

        return saveMemberPort.saveMember(member);
    }

    @Override
    public List<MemberResult> getMemberList() {
        List<MemberResult> memberResultList = getMemberPort.getMemberList();
        return memberResultList;
    }
}
