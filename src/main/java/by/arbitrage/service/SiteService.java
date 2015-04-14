package by.arbitrage.service;

import by.arbitrage.converter.SiteConverter;
import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.site.dto.SiteDTO;
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

	@Transactional
	public SiteEntity saveSiteByDTO(SiteDTO siteDTO, UserEntity user)
	{
		return repository.save(converter.convertDTOToEntity(siteDTO, user));
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
