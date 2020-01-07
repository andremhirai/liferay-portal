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

package com.liferay.mobile.device.rules.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the MDRRuleGroupInstance service. Represents a row in the &quot;MDRRuleGroupInstance&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.mobile.device.rules.model.impl.MDRRuleGroupInstanceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.mobile.device.rules.model.impl.MDRRuleGroupInstanceImpl</code>.
 * </p>
 *
 * @author Edward C. Han
 * @see MDRRuleGroupInstance
 * @generated
 */
@ProviderType
public interface MDRRuleGroupInstanceModel
	extends AttachedModel, BaseModel<MDRRuleGroupInstance>, MVCCModel,
			ShardedModel, StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a mdr rule group instance model instance should use the {@link MDRRuleGroupInstance} interface instead.
	 */

	/**
	 * Returns the primary key of this mdr rule group instance.
	 *
	 * @return the primary key of this mdr rule group instance
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this mdr rule group instance.
	 *
	 * @param primaryKey the primary key of this mdr rule group instance
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this mdr rule group instance.
	 *
	 * @return the mvcc version of this mdr rule group instance
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this mdr rule group instance.
	 *
	 * @param mvccVersion the mvcc version of this mdr rule group instance
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the uuid of this mdr rule group instance.
	 *
	 * @return the uuid of this mdr rule group instance
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this mdr rule group instance.
	 *
	 * @param uuid the uuid of this mdr rule group instance
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the rule group instance ID of this mdr rule group instance.
	 *
	 * @return the rule group instance ID of this mdr rule group instance
	 */
	public long getRuleGroupInstanceId();

	/**
	 * Sets the rule group instance ID of this mdr rule group instance.
	 *
	 * @param ruleGroupInstanceId the rule group instance ID of this mdr rule group instance
	 */
	public void setRuleGroupInstanceId(long ruleGroupInstanceId);

	/**
	 * Returns the group ID of this mdr rule group instance.
	 *
	 * @return the group ID of this mdr rule group instance
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this mdr rule group instance.
	 *
	 * @param groupId the group ID of this mdr rule group instance
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this mdr rule group instance.
	 *
	 * @return the company ID of this mdr rule group instance
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this mdr rule group instance.
	 *
	 * @param companyId the company ID of this mdr rule group instance
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this mdr rule group instance.
	 *
	 * @return the user ID of this mdr rule group instance
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this mdr rule group instance.
	 *
	 * @param userId the user ID of this mdr rule group instance
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this mdr rule group instance.
	 *
	 * @return the user uuid of this mdr rule group instance
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this mdr rule group instance.
	 *
	 * @param userUuid the user uuid of this mdr rule group instance
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this mdr rule group instance.
	 *
	 * @return the user name of this mdr rule group instance
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this mdr rule group instance.
	 *
	 * @param userName the user name of this mdr rule group instance
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this mdr rule group instance.
	 *
	 * @return the create date of this mdr rule group instance
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this mdr rule group instance.
	 *
	 * @param createDate the create date of this mdr rule group instance
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this mdr rule group instance.
	 *
	 * @return the modified date of this mdr rule group instance
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this mdr rule group instance.
	 *
	 * @param modifiedDate the modified date of this mdr rule group instance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this mdr rule group instance.
	 *
	 * @return the fully qualified class name of this mdr rule group instance
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this mdr rule group instance.
	 *
	 * @return the class name ID of this mdr rule group instance
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this mdr rule group instance.
	 *
	 * @param classNameId the class name ID of this mdr rule group instance
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this mdr rule group instance.
	 *
	 * @return the class pk of this mdr rule group instance
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this mdr rule group instance.
	 *
	 * @param classPK the class pk of this mdr rule group instance
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the rule group ID of this mdr rule group instance.
	 *
	 * @return the rule group ID of this mdr rule group instance
	 */
	public long getRuleGroupId();

	/**
	 * Sets the rule group ID of this mdr rule group instance.
	 *
	 * @param ruleGroupId the rule group ID of this mdr rule group instance
	 */
	public void setRuleGroupId(long ruleGroupId);

	/**
	 * Returns the priority of this mdr rule group instance.
	 *
	 * @return the priority of this mdr rule group instance
	 */
	public int getPriority();

	/**
	 * Sets the priority of this mdr rule group instance.
	 *
	 * @param priority the priority of this mdr rule group instance
	 */
	public void setPriority(int priority);

	/**
	 * Returns the last publish date of this mdr rule group instance.
	 *
	 * @return the last publish date of this mdr rule group instance
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this mdr rule group instance.
	 *
	 * @param lastPublishDate the last publish date of this mdr rule group instance
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

}