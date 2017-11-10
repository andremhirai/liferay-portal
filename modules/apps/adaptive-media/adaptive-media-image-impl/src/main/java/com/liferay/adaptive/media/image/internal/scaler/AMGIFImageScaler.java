/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.adaptive.media.image.internal.scaler;

import com.liferay.adaptive.media.exception.AMRuntimeException;
import com.liferay.adaptive.media.image.configuration.AMImageConfigurationEntry;
import com.liferay.adaptive.media.image.internal.util.RenderedImageUtil;
import com.liferay.adaptive.media.image.internal.util.Tuple;
import com.liferay.adaptive.media.image.scaler.AMImageScaled;
import com.liferay.adaptive.media.image.scaler.AMImageScaler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.process.CollectorOutputProcessor;
import com.liferay.portal.kernel.process.ProcessException;
import com.liferay.portal.kernel.process.ProcessUtil;
import com.liferay.portal.kernel.repository.model.FileVersion;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.repository.liferayrepository.model.LiferayFileVersion;

import java.awt.image.RenderedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.osgi.service.component.annotations.Component;

/**
 * @author Sergio González
 */
@Component(
	immediate = true, property = {"mime.type=image/gif"},
	service = AMImageScaler.class
)
public class AMGIFImageScaler implements AMImageScaler {

	@Override
	public AMImageScaled scaleImage(
		FileVersion fileVersion,
		AMImageConfigurationEntry amImageConfigurationEntry) {

		LiferayFileVersion liferayFileVersion = (LiferayFileVersion)fileVersion;

		try {
			File file = liferayFileVersion.getFile(false);

			Future<ObjectValuePair<byte[], byte[]>> future =
				ProcessUtil.execute(
					new CollectorOutputProcessor(), "gifsicle", "--resize-fit",
					_getResizeFitValues(amImageConfigurationEntry), "--output",
					"-", file.getAbsolutePath());

			ObjectValuePair<byte[], byte[]> objectValuePair = future.get();

			byte[] bytes = objectValuePair.getKey();

			File tempFile = FileUtil.createTempFile(bytes);

			Tuple<Integer, Integer> dimension = _getDimension(tempFile);

			return new AMImageScaledImpl(
				bytes, dimension.second, dimension.first);
		}
		catch (ExecutionException | InterruptedException | IOException |
			   PortalException | ProcessException e) {

			throw new AMRuntimeException.IOException(e);
		}
	}

	private Tuple<Integer, Integer> _getDimension(File file)
		throws IOException {

		try (InputStream inputStream = new FileInputStream(file)) {
			RenderedImage renderedImage = RenderedImageUtil.readImage(
				inputStream);

			return Tuple.of(
				renderedImage.getWidth(), renderedImage.getHeight());
		}
	}

	private String _getResizeFitValues(
		AMImageConfigurationEntry amImageConfigurationEntry) {

		Map<String, String> properties =
			amImageConfigurationEntry.getProperties();

		int maxHeight = GetterUtil.getInteger(properties.get("max-height"));

		String maxHeightString = StringPool.UNDERLINE;

		if (maxHeight != 0) {
			maxHeightString = String.valueOf(maxHeight);
		}

		int maxWidth = GetterUtil.getInteger(properties.get("max-width"));

		String maxWidthString = StringPool.UNDERLINE;

		if (maxWidth != 0) {
			maxWidthString = String.valueOf(maxWidth);
		}

		return maxWidthString.concat("x").concat(maxHeightString);
	}

}