package community.member.adapter.out.persistence;

import community.member.adapter.out.entity.MemberEntity;
import community.member.application.dto.JoinResponse;
import community.member.application.port.out.SaveMemberPort;
import community.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements SaveMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Long saveMember(Member member) {
        MemberEntity memberEntity = MemberEntity.createEntity(member);
        return memberRepository.save(memberEntity).getId();
    }
}
