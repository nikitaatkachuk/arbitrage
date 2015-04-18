package by.arbitrage.html.render;

import by.arbitrage.entity.site.SiteEntity;
import org.apache.log4j.Logger;
import org.fit.cssbox.demo.ImageRenderer;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Nikita Tkachuk
 */
public class PreviewBuilder
{
	private static final Logger LOGGER = Logger.getLogger(PreviewBuilder.class);
	private static final String ROOT_PREVIEW_FOLDER = "E:\\ee\\images\\previews\\";

	public static String buildPreview(String url, String guid)
	{
		FileOutputStream os = null;
		try
		{
			String imagePath = guid + ".png";
			String webPath = "/previews/" + guid + ".png";
			String absolutePath = ROOT_PREVIEW_FOLDER + imagePath;
			os = new FileOutputStream(absolutePath);
			String media = "screen";
			Dimension windowSize = new Dimension(1200, 600);
			ImageRenderer r = new ImageRenderer();
			r.setMediaType(media);
			r.setWindowSize(windowSize, false);
			if (r.renderURL(url, os, ImageRenderer.Type.PNG))
			{
				return webPath;
			}
		}
		catch (SAXException | IOException e)
		{
			LOGGER.warn("Could not build preview for site " + url, e);
		}
		return "";
	}

}
