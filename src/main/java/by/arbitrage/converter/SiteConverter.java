package by.arbitrage.converter;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import by.arbitrage.html.render.PreviewBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import by.arbitrage.context.UserContext;
import by.arbitrage.entity.script.Script;
import by.arbitrage.entity.site.SiteEntity;
import by.arbitrage.entity.site.dto.SiteDTO;
import by.arbitrage.entity.user.UserEntity;
import by.arbitrage.html.UserSiteForm;
import by.arbitrage.html.parser.FormParser;
import by.arbitrage.utils.GUIDGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: nikita tkachuk
 * Date: 4/14/2015
 * Time: 6:30 AM
 */
@Scope(value = "singleton")
public class SiteConverter implements GenericConverter<SiteEntity, SiteDTO>
{
	private static final Logger LOGGER = Logger.getLogger(SiteConverter.class);

	@Autowired
	private UserContext userContext;

	@Override
	public SiteDTO convertEntityToDTO(SiteEntity entity)
	{
		SiteDTO siteDTO = new SiteDTO(entity.getIdentity(), entity.getUrl());
		siteDTO.setScript(entity.getScript().getUserScript());
		siteDTO.setForms((List<UserSiteForm>) entity.getSiteForms());
		siteDTO.setPreviewPath(entity.getPreviewPath());
		return siteDTO;
	}

	@Override
	public SiteEntity convertDTOToEntity(SiteDTO siteDTO)
	{
		return convertDTOToEntity(siteDTO, userContext.getCurrentUser());
	}

	public SiteEntity convertDTOToEntity(SiteDTO siteDTO, UserEntity user)
	{
		SiteEntity entity = new SiteEntity();
		String url = siteDTO.getUrl();
		String guid = GUIDGenerator.randomGUID();
		entity.setUrl(url);
		entity.setGuid(guid);
		if(siteDTO.getPreviewPath() == null)
		{
			entity.setPreviewPath(PreviewBuilder.buildPreview(url, guid));
		}
		else
		{
			entity.setPreviewPath(siteDTO.getPreviewPath());
		}
		entity.setUsers(Collections.singletonList(user));
		entity.setScript(new Script("Empty Script"));
		entity.setSiteForms(buildSiteFormsCollection(url));
		return entity;
	}



	private Collection<UserSiteForm> buildSiteFormsCollection(String url)
	{
//		try
//		{
//			return FormParser.getSiteFormsByUrl(url);
//		}
//		catch (IOException e)
//		{
//			LOGGER.warn("Could not parsed site by url " + url);
//		}
		return Collections.emptyList();
	}
}
