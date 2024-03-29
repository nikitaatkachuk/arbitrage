package by.arbitrage.service;

import by.arbitrage.converter.SiteConverter;
import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.user.User;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.entity.visit.Visit;
import by.arbitrage.html.UserSiteForm;
import by.arbitrage.html.parser.FormParser;
import by.arbitrage.repository.SiteRepository;
import by.arbitrage.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Service
@Transactional
@Scope("singleton")
public class SiteService
{
	private static final Logger LOGGER = Logger.getLogger(SiteService.class);

	@Autowired
	private SiteRepository repository;

	@Autowired
	private UserService userService;

	@Autowired
	private SiteConverter converter;

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

//	public void addVisit(SiteEntity siteEntity, Visit visit)
//	{
//		siteEntity.getVisits().add(visit);
//	}

	@Transactional
	public SiteEntity saveSiteByDTO(SiteDTO siteDTO, UserEntity user)
	{
		return repository.saveAndFlush(converter.convertDTOToEntity(siteDTO, user));
	}

	@Transactional
	public SiteEntity updateSite(SiteEntity siteEntity)
	{
		return repository.save(siteEntity);
	}

	@Transactional
	public List<SiteEntity> saveSitesByDtoList(UserEntity user, List<SiteDTO> siteDTOList)
	{
		List<SiteEntity> entityList = new ArrayList<>();
		for (SiteDTO siteDTO : siteDTOList)
		{
			entityList.add(converter.convertDTOToEntity(siteDTO));
		}
		repository.save(entityList);
		return entityList;
	}


}
