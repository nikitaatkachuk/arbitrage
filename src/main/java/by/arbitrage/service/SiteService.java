package by.arbitrage.service;

import by.arbitrage.entity.SiteEntity;
import by.arbitrage.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
