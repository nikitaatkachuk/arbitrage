package by.arbitrage.repository;

import by.arbitrage.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Nikita Tkachuk
 */
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	UserEntity findUserByLogin(String login);
	UserEntity findUserByGuid (String guid);
}
