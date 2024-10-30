package community.member.adapter.out.persistence;

import community.member.adapter.out.entity.MemberEntity;
import community.member.application.port.in.result.MemberResult;
import community.member.application.port.out.GetMemberPort;
import community.member.application.port.out.SaveMemberPort;
import community.member.domain.Member;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements SaveMemberPort, GetMemberPort {

    private final MemberRepository memberRepository;

    @Override
    public Long saveMember(Member member) {
        MemberEntity memberEntity = MemberEntity.createEntity(member);
        return memberRepository.save(memberEntity).getId();
    }

    @Override
    public List<MemberResult> getMemberList() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberResult> memberResultList = memberEntityList.stream()
            .map(MemberResult::from)
            .collect(Collectors.toList());
        return memberResultList;
    }
}
