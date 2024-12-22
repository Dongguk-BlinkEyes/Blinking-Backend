package Dongguk.Blinking_Eyes.user.controller;

import Dongguk.Blinking_Eyes.global.ResponseDto;
import Dongguk.Blinking_Eyes.user.dto.request.MyPageUpdateRequest;
import Dongguk.Blinking_Eyes.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/mypage")
    public ResponseDto<?> getMypage(Long UserId) {
        return ResponseDto.ok(userService.getMyPage(UserId));
    }

    @PatchMapping("/api/mypage")
    public ResponseDto<?> updateMyPage(@RequestBody MyPageUpdateRequest request, Long userId){
        userService.updateMyPage(request,userId);
        return ResponseDto.ok(null);
    }
}
