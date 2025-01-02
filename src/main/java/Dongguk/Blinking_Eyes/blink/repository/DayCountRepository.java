package Dongguk.Blinking_Eyes.blink.repository;

import Dongguk.Blinking_Eyes.blink.domain.DayCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DayCountRepository extends JpaRepository<DayCount, Long> {

    @Query("SELECT d FROM DayCount d WHERE FUNCTION('DATE', d.startTime) = :currentDate")
    List<DayCount> findAllByDayCountDate(LocalDate currentDate);

    @Query("SELECT d FROM DayCount d WHERE FUNCTION('MONTH', d.startTime) = :month AND FUNCTION('YEAR', d.startTime) = :year")
    List<DayCount> findAllByMonthAndYear(@Param("year") int year, @Param("month") int month);

}
