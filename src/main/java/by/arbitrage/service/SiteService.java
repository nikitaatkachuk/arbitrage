package by.arbitrage.service;

import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.site.dto.NewSiteDTO;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.user.User;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.html.UserSiteForm;
import by.arbitrage.html.parser.FormParser;
import by.arbitrage.repository.SiteRepository;
import by.arbitrage.service.user.UserService;
import by.arbitrage.utils.GUIDGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nikita Tkachuk
 */
@Service
public class SiteService
{
	private static final Logger LOGGER = Logger.getLogger(SiteService.class);

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
	public SiteEntity saveSiteByDTO(UserEntity user, NewSiteDTO siteDTO)
	{
		return repository.save(convertDtoToEntity(user, siteDTO));
	}

	@Transactional
	public List<SiteEntity> saveSitesByDtoList(UserEntity user, List<NewSiteDTO> siteDTOList)
	{
		List<SiteEntity> entityList = new ArrayList<>();
		for (NewSiteDTO siteDTO : siteDTOList)
		{
			entityList.add(convertDtoToEntity(user, siteDTO));
		}
		repository.save(entityList);
		return entityList;
	}

	public SiteEntity convertDtoToEntity(UserEntity user, NewSiteDTO siteDTO)
	{
		SiteEntity entity = new SiteEntity();
		entity.setUrl(siteDTO.getUrl());
		entity.setGuid(GUIDGenerator.randomGUID());
		entity.setUsers(Collections.singletonList(user));
		entity.setScript(new Script("Empty Script"));
		entity.setSiteForms(buildSiteFormsCollection(siteDTO.getUrl()));
		return entity;
	}

	private Collection<UserSiteForm> buildSiteFormsCollection(String url)
	{
		try
		{
			return FormParser.getSiteFormsByUrl(url);
		}
		catch (IOException e)
		{
			LOGGER.warn("Could not parsed site by url " + url);
		}
		return Collections.emptyList();
	}
}
