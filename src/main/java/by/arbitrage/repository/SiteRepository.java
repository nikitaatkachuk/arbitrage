package by.arbitrage.repository;

import by.arbitrage.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

/**
 * Created by Nikita Tkachuk
 */
public interface SiteRepository extends JpaRepository<SiteEntity, Long>
{
	SiteEntity findSiteByUrl(String url);
}
