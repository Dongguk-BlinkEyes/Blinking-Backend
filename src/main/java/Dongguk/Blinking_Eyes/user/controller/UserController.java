package Dongguk.Blinking_Eyes.user.controller;

import Dongguk.Blinking_Eyes.global.ResponseDto;
import Dongguk.Blinking_Eyes.user.dto.request.MyPageUpdateRequest;
import Dongguk.Blinking_Eyes.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/api/mypage")
    public ResponseDto<?> getMypage(@RequestParam Long userId) {
        return ResponseDto.ok(userService.getMyPage(userId));
    }


    @PatchMapping("/api/mypage")
    public ResponseDto<?> updateMyPage(@RequestBody MyPageUpdateRequest request, Long userId){
        userService.updateMyPage(request,userId);
        return ResponseDto.ok(null);
    }
}
