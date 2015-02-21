package by.arbitrage.repository;

import by.arbitrage.entity.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	UserEntity findUserByLogin(String login);
	UserEntity findUserByGuid (String guid);
}
