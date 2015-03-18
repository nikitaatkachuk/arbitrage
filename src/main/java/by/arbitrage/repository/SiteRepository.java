package by.arbitrage.repository;

import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by Nikita Tkachuk
 */
public interface SiteRepository extends JpaRepository<SiteEntity, Long>
{
	SiteEntity findSiteByUrl(String url);

	SiteEntity findSiteByGuid(String guid);
}
