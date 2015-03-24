package by.arbitrage.service;

import by.arbitrage.entity.site.dto.NewSiteDTO;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.UserEntity;
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

	public SiteEntity findSiteByGuid(String guid)
	{
		return repository.findSiteByGuid(guid);
	}

	public SiteEntity findUserSiteById(UserEntity user, Long id)
	{
		SiteEntity site = findSiteById(id);
		if(site == null)
		{
			return null;
		}
		return site.getUsers().contains(user) ? site : null;
	}

	@Transactional
	public SiteEntity saveSite(String userName, NewSiteDTO siteDTO)
	{
		return repository.save(convertDTOtoEntity(userName, siteDTO));
	}

	@Transactional
	public List<SiteEntity> saveSites(String userName, List<NewSiteDTO> siteDTOList)
	{
		List<SiteEntity> entityList = new ArrayList<>();
		for (NewSiteDTO siteDTO : siteDTOList)
		{
			entityList.add(convertDTOtoEntity(userName, siteDTO));
		}
		repository.save(entityList);
		return entityList;
	}

	public SiteEntity convertDTOtoEntity(String userName, NewSiteDTO siteDTO)
	{
		SiteEntity entity = new SiteEntity();
		entity.setUrl(siteDTO.getUrl());
		entity.setGuid(GUIDGenerator.randomGUID());
		entity.setUsers(Collections.singletonList(userService.findUserByLogin(userName)));
		return entity;
	}
}
