package Dongguk.Blinking_Eyes.user.controller;

import Dongguk.Blinking_Eyes.global.ResponseDto;
import Dongguk.Blinking_Eyes.user.dto.request.MyPageUpdateRequest;
import Dongguk.Blinking_Eyes.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/mypage/{userId}")
    public ResponseDto<?> getMypage(@PathVariable Long userId) {
        return ResponseDto.ok(userService.getMyPage(userId));
    }


    @PatchMapping("/api/mypage")
    public ResponseDto<?> updateMyPage(@RequestBody MyPageUpdateRequest request, Long userId){
        userService.updateMyPage(request,userId);
        return ResponseDto.ok(null);
    }
}
