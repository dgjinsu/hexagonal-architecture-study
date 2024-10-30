package community.member.application.port.in;

import community.member.application.port.in.result.MemberResult;
import java.util.List;

public interface MemberListUseCase {
    List<MemberResult> getMemberList();
}
