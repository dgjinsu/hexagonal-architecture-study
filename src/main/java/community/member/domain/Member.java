package community.member.domain;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
    private String loginId;
    private String password;
    private String name;
}
