package Dongguk.Blinking_AI.user.repository;

import Dongguk.Blinking_AI.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
