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

package com.liferay.asset.entry.rel.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;

/**
 * The extended model base implementation for the AssetEntryAssetCategoryRel service. Represents a row in the &quot;AssetEntryAssetCategoryRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetEntryAssetCategoryRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntryAssetCategoryRelImpl
 * @see AssetEntryAssetCategoryRel
 * @generated
 */
@ProviderType
public abstract class AssetEntryAssetCategoryRelBaseImpl
	extends AssetEntryAssetCategoryRelModelImpl
	implements AssetEntryAssetCategoryRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset entry asset category rel model instance should use the <code>AssetEntryAssetCategoryRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			AssetEntryAssetCategoryRelLocalServiceUtil.
				addAssetEntryAssetCategoryRel(this);
		}
		else {
			AssetEntryAssetCategoryRelLocalServiceUtil.
				updateAssetEntryAssetCategoryRel(this);
		}
	}

}