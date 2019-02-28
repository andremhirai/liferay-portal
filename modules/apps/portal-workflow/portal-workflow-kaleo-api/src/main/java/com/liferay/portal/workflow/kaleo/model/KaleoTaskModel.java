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

package com.liferay.portal.workflow.kaleo.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the KaleoTask service. Represents a row in the &quot;KaleoTask&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.workflow.kaleo.model.impl.KaleoTaskImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KaleoTask
 * @generated
 */
@ProviderType
public interface KaleoTaskModel
	extends BaseModel<KaleoTask>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a kaleo task model instance should use the {@link KaleoTask} interface instead.
	 */

	/**
	 * Returns the primary key of this kaleo task.
	 *
	 * @return the primary key of this kaleo task
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this kaleo task.
	 *
	 * @param primaryKey the primary key of this kaleo task
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the kaleo task ID of this kaleo task.
	 *
	 * @return the kaleo task ID of this kaleo task
	 */
	public long getKaleoTaskId();

	/**
	 * Sets the kaleo task ID of this kaleo task.
	 *
	 * @param kaleoTaskId the kaleo task ID of this kaleo task
	 */
	public void setKaleoTaskId(long kaleoTaskId);

	/**
	 * Returns the group ID of this kaleo task.
	 *
	 * @return the group ID of this kaleo task
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this kaleo task.
	 *
	 * @param groupId the group ID of this kaleo task
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this kaleo task.
	 *
	 * @return the company ID of this kaleo task
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this kaleo task.
	 *
	 * @param companyId the company ID of this kaleo task
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this kaleo task.
	 *
	 * @return the user ID of this kaleo task
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this kaleo task.
	 *
	 * @param userId the user ID of this kaleo task
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this kaleo task.
	 *
	 * @return the user uuid of this kaleo task
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this kaleo task.
	 *
	 * @param userUuid the user uuid of this kaleo task
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this kaleo task.
	 *
	 * @return the user name of this kaleo task
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this kaleo task.
	 *
	 * @param userName the user name of this kaleo task
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this kaleo task.
	 *
	 * @return the create date of this kaleo task
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this kaleo task.
	 *
	 * @param createDate the create date of this kaleo task
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this kaleo task.
	 *
	 * @return the modified date of this kaleo task
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this kaleo task.
	 *
	 * @param modifiedDate the modified date of this kaleo task
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the kaleo definition version ID of this kaleo task.
	 *
	 * @return the kaleo definition version ID of this kaleo task
	 */
	public long getKaleoDefinitionVersionId();

	/**
	 * Sets the kaleo definition version ID of this kaleo task.
	 *
	 * @param kaleoDefinitionVersionId the kaleo definition version ID of this kaleo task
	 */
	public void setKaleoDefinitionVersionId(long kaleoDefinitionVersionId);

	/**
	 * Returns the kaleo node ID of this kaleo task.
	 *
	 * @return the kaleo node ID of this kaleo task
	 */
	public long getKaleoNodeId();

	/**
	 * Sets the kaleo node ID of this kaleo task.
	 *
	 * @param kaleoNodeId the kaleo node ID of this kaleo task
	 */
	public void setKaleoNodeId(long kaleoNodeId);

	/**
	 * Returns the name of this kaleo task.
	 *
	 * @return the name of this kaleo task
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this kaleo task.
	 *
	 * @param name the name of this kaleo task
	 */
	public void setName(String name);

	/**
	 * Returns the description of this kaleo task.
	 *
	 * @return the description of this kaleo task
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this kaleo task.
	 *
	 * @param description the description of this kaleo task
	 */
	public void setDescription(String description);

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
	public int compareTo(KaleoTask kaleoTask);

	@Override
	public int hashCode();

	@Override
	public CacheModel<KaleoTask> toCacheModel();

	@Override
	public KaleoTask toEscapedModel();

	@Override
	public KaleoTask toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}