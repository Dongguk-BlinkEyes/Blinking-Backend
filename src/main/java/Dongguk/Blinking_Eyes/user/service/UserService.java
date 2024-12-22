package Dongguk.Blinking_Eyes.user.service;

import Dongguk.Blinking_Eyes.exception.CommonException;
import Dongguk.Blinking_Eyes.exception.ErrorCode;
import Dongguk.Blinking_Eyes.user.domain.User;
import Dongguk.Blinking_Eyes.user.dto.request.MyPageUpdateRequest;
import Dongguk.Blinking_Eyes.user.dto.response.MyPageResponse;
import Dongguk.Blinking_Eyes.user.repository.UserRepository;
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
                .name(user.getName())
                .eyeSensitivity(user.getEyeSensitivity())
                .alarmPeriod(user.getAlarmPeriod())
                .isSound(user.isSound())
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
