package by.arbitrage.repository;

import by.arbitrage.entity.site.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nikita Tkachuk
 */
public interface SiteRepository extends JpaRepository<SiteEntity, Long>
{
	SiteEntity findSiteByUrl(String url);
}
