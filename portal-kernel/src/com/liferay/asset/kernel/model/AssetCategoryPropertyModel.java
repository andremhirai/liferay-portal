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

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AssetCategoryProperty service. Represents a row in the &quot;AssetCategoryProperty&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portlet.asset.model.impl.AssetCategoryPropertyModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portlet.asset.model.impl.AssetCategoryPropertyImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryProperty
 * @deprecated
 * @generated
 */
@Deprecated
@ProviderType
public interface AssetCategoryPropertyModel
	extends AuditedModel, BaseModel<AssetCategoryProperty>,
			CTModel<AssetCategoryProperty>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a asset category property model instance should use the {@link AssetCategoryProperty} interface instead.
	 */

	/**
	 * Returns the primary key of this asset category property.
	 *
	 * @return the primary key of this asset category property
	 */
	@Override
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset category property.
	 *
	 * @param primaryKey the primary key of this asset category property
	 */
	@Override
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this asset category property.
	 *
	 * @return the mvcc version of this asset category property
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this asset category property.
	 *
	 * @param mvccVersion the mvcc version of this asset category property
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the ct collection ID of this asset category property.
	 *
	 * @return the ct collection ID of this asset category property
	 */
	@Override
	public long getCtCollectionId();

	/**
	 * Sets the ct collection ID of this asset category property.
	 *
	 * @param ctCollectionId the ct collection ID of this asset category property
	 */
	@Override
	public void setCtCollectionId(long ctCollectionId);

	/**
	 * Returns the category property ID of this asset category property.
	 *
	 * @return the category property ID of this asset category property
	 */
	public long getCategoryPropertyId();

	/**
	 * Sets the category property ID of this asset category property.
	 *
	 * @param categoryPropertyId the category property ID of this asset category property
	 */
	public void setCategoryPropertyId(long categoryPropertyId);

	/**
	 * Returns the company ID of this asset category property.
	 *
	 * @return the company ID of this asset category property
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this asset category property.
	 *
	 * @param companyId the company ID of this asset category property
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this asset category property.
	 *
	 * @return the user ID of this asset category property
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this asset category property.
	 *
	 * @param userId the user ID of this asset category property
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this asset category property.
	 *
	 * @return the user uuid of this asset category property
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this asset category property.
	 *
	 * @param userUuid the user uuid of this asset category property
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this asset category property.
	 *
	 * @return the user name of this asset category property
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this asset category property.
	 *
	 * @param userName the user name of this asset category property
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this asset category property.
	 *
	 * @return the create date of this asset category property
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset category property.
	 *
	 * @param createDate the create date of this asset category property
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this asset category property.
	 *
	 * @return the modified date of this asset category property
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this asset category property.
	 *
	 * @param modifiedDate the modified date of this asset category property
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the category ID of this asset category property.
	 *
	 * @return the category ID of this asset category property
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this asset category property.
	 *
	 * @param categoryId the category ID of this asset category property
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the key of this asset category property.
	 *
	 * @return the key of this asset category property
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this asset category property.
	 *
	 * @param key the key of this asset category property
	 */
	public void setKey(String key);

	/**
	 * Returns the value of this asset category property.
	 *
	 * @return the value of this asset category property
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this asset category property.
	 *
	 * @param value the value of this asset category property
	 */
	public void setValue(String value);

}