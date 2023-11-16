package umc.spring.domain;

import lombok.*;
import umc.spring.domain.base.BaseEntity;
import umc.spring.domain.enums.QuestionStatus;
import umc.spring.domain.mapping.MemberAgree;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionStatus status;

    private String type; // 문의 유형

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<QuestionImage> questionImageList = new ArrayList<>();
}
