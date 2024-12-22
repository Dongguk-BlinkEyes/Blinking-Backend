package Dongguk.Blinking_Eyes.user.repository;

import Dongguk.Blinking_Eyes.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
