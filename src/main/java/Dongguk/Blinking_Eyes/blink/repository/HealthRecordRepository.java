package Dongguk.Blinking_Eyes.blink.repository;

import Dongguk.Blinking_Eyes.blink.domain.HealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRecordRepository extends JpaRepository<HealthRecord, Long> {
}
