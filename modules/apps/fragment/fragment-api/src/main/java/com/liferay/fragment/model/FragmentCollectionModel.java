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

package com.liferay.fragment.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FragmentCollection service. Represents a row in the &quot;FragmentCollection&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.fragment.model.impl.FragmentCollectionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.fragment.model.impl.FragmentCollectionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FragmentCollection
 * @generated
 */
@ProviderType
public interface FragmentCollectionModel
	extends BaseModel<FragmentCollection>, ShardedModel, StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fragment collection model instance should use the {@link FragmentCollection} interface instead.
	 */

	/**
	 * Returns the primary key of this fragment collection.
	 *
	 * @return the primary key of this fragment collection
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fragment collection.
	 *
	 * @param primaryKey the primary key of this fragment collection
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fragment collection.
	 *
	 * @return the uuid of this fragment collection
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this fragment collection.
	 *
	 * @param uuid the uuid of this fragment collection
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the fragment collection ID of this fragment collection.
	 *
	 * @return the fragment collection ID of this fragment collection
	 */
	public long getFragmentCollectionId();

	/**
	 * Sets the fragment collection ID of this fragment collection.
	 *
	 * @param fragmentCollectionId the fragment collection ID of this fragment collection
	 */
	public void setFragmentCollectionId(long fragmentCollectionId);

	/**
	 * Returns the group ID of this fragment collection.
	 *
	 * @return the group ID of this fragment collection
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this fragment collection.
	 *
	 * @param groupId the group ID of this fragment collection
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this fragment collection.
	 *
	 * @return the company ID of this fragment collection
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this fragment collection.
	 *
	 * @param companyId the company ID of this fragment collection
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this fragment collection.
	 *
	 * @return the user ID of this fragment collection
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this fragment collection.
	 *
	 * @param userId the user ID of this fragment collection
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this fragment collection.
	 *
	 * @return the user uuid of this fragment collection
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this fragment collection.
	 *
	 * @param userUuid the user uuid of this fragment collection
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this fragment collection.
	 *
	 * @return the user name of this fragment collection
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this fragment collection.
	 *
	 * @param userName the user name of this fragment collection
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this fragment collection.
	 *
	 * @return the create date of this fragment collection
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this fragment collection.
	 *
	 * @param createDate the create date of this fragment collection
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this fragment collection.
	 *
	 * @return the modified date of this fragment collection
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this fragment collection.
	 *
	 * @param modifiedDate the modified date of this fragment collection
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fragment collection key of this fragment collection.
	 *
	 * @return the fragment collection key of this fragment collection
	 */
	@AutoEscape
	public String getFragmentCollectionKey();

	/**
	 * Sets the fragment collection key of this fragment collection.
	 *
	 * @param fragmentCollectionKey the fragment collection key of this fragment collection
	 */
	public void setFragmentCollectionKey(String fragmentCollectionKey);

	/**
	 * Returns the name of this fragment collection.
	 *
	 * @return the name of this fragment collection
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this fragment collection.
	 *
	 * @param name the name of this fragment collection
	 */
	public void setName(String name);

	/**
	 * Returns the description of this fragment collection.
	 *
	 * @return the description of this fragment collection
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this fragment collection.
	 *
	 * @param description the description of this fragment collection
	 */
	public void setDescription(String description);

	/**
	 * Returns the last publish date of this fragment collection.
	 *
	 * @return the last publish date of this fragment collection
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this fragment collection.
	 *
	 * @param lastPublishDate the last publish date of this fragment collection
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(FragmentCollection fragmentCollection);

	@Override
	public int hashCode();

	@Override
	public CacheModel<FragmentCollection> toCacheModel();

	@Override
	public FragmentCollection toEscapedModel();

	@Override
	public FragmentCollection toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}