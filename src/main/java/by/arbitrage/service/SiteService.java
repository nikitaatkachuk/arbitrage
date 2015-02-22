package by.arbitrage.service;

import by.arbitrage.context.UserContext;
import by.arbitrage.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.repository.SiteRepository;
import by.arbitrage.service.user.UserService;
import by.arbitrage.utils.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Service
public class SiteService
{
	@Autowired
	private SiteRepository repository;

	@Autowired
	private UserService userService;

	public List<SiteEntity> getAllSites()
	{
		return repository.findAll();
		/*List<String> urlList = new ArrayList<String>();
		for(SiteEntity site : entityList)
		{
			urlList.add(site.getUrl());
		}
		return urlList;*/
	}

	public SiteEntity findSiteById(Long id)
	{
		return repository.findOne(id);
	}

	@Transactional
	public List<SiteEntity> saveSites(String userName, List<SiteDTO> siteDTOList)
	{
		List<SiteEntity> entityList = new ArrayList<>();
		for (SiteDTO siteDTO : siteDTOList)
		{
			SiteEntity entity = new SiteEntity();
			entity.setUrl(siteDTO.getUrl());
			entity.setGuid(GUIDGenerator.GUIDByString(siteDTO.getUrl()));
			entity.setUsers(Collections.singletonList(userService.getUserByLogin(userName)));
		}
		repository.save(entityList);
		return entityList;
	}
}
