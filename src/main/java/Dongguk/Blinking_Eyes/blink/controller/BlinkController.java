package Dongguk.Blinking_Eyes.blink.controller;

import Dongguk.Blinking_Eyes.blink.service.BlinkService;
import Dongguk.Blinking_Eyes.global.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
public class BlinkController {
    private final BlinkService blinkService;

    @GetMapping("/api/blink/today/record")
    public ResponseDto<?> getTodayRecord(@RequestParam Long userId){
        return ResponseDto.ok(blinkService.getTodayRecord(userId));
    }

    @GetMapping("/api/blink/monthly/record")
    public ResponseDto<?> getMonthlyRecord(@RequestParam Long userId, @RequestParam(required = false) LocalDate date){
        LocalDate targetDay = (date != null) ? date : LocalDate.now();
        return ResponseDto.ok(blinkService.getMonthlyStatics(userId, targetDay));
    }
}
