package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        Integer birthYear = request.getBirthYear();
        Integer birthMonth = request.getBirthMonth();
        Integer birthDay = request.getBirthDay();
        LocalDate birth = LocalDate.of(birthYear, birthMonth, birthDay);

        return Member.builder()
                .address(request.getAddress())
                .addressSpec(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .birth(birth)
                .phoneNum(request.getPhoneNum())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission memberMission){
        Mission mission = memberMission.getMission();
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .title(mission.getTitle())
                .point(mission.getPoint())
                .deadline(mission.getDeadline())
                .content(mission.getContent())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MemberResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<MemberMission> missionList) {
        List<MemberResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
