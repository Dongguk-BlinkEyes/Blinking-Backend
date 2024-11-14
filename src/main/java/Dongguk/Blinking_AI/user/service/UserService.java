package Dongguk.Blinking_AI.user.service;

import Dongguk.Blinking_AI.exception.CommonException;
import Dongguk.Blinking_AI.exception.ErrorCode;
import Dongguk.Blinking_AI.user.domain.User;
import Dongguk.Blinking_AI.user.dto.request.MyPageUpdateRequest;
import Dongguk.Blinking_AI.user.dto.response.MyPageResponse;
import Dongguk.Blinking_AI.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public MyPageResponse getMyPage(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));
        MyPageResponse myPageResponse = MyPageResponse.builder()
                .nickname(user.getNickname())
                .age(user.getAge())
                .gender(user.isGender())
                .alertType(user.getAlertType())
                .displayType(user.getDisplayType())
                .frequencyAlert(user.getPrequencyAlert())
                .build();
        return myPageResponse;
    }

    @Transactional
    public void updateMyPage(MyPageUpdateRequest request, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_USER));

        user.update(request);
    }
}
