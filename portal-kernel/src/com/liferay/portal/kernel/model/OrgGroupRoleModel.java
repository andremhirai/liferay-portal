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

package com.liferay.portal.kernel.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.persistence.OrgGroupRolePK;

import java.io.Serializable;

/**
 * The base model interface for the OrgGroupRole service. Represents a row in the &quot;OrgGroupRole&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.OrgGroupRoleModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.OrgGroupRoleImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OrgGroupRole
 * @generated
 */
@ProviderType
public interface OrgGroupRoleModel
	extends BaseModel<OrgGroupRole>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a org group role model instance should use the {@link OrgGroupRole} interface instead.
	 */

	/**
	 * Returns the primary key of this org group role.
	 *
	 * @return the primary key of this org group role
	 */
	public OrgGroupRolePK getPrimaryKey();

	/**
	 * Sets the primary key of this org group role.
	 *
	 * @param primaryKey the primary key of this org group role
	 */
	public void setPrimaryKey(OrgGroupRolePK primaryKey);

	/**
	 * Returns the mvcc version of this org group role.
	 *
	 * @return the mvcc version of this org group role
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this org group role.
	 *
	 * @param mvccVersion the mvcc version of this org group role
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the organization ID of this org group role.
	 *
	 * @return the organization ID of this org group role
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this org group role.
	 *
	 * @param organizationId the organization ID of this org group role
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the group ID of this org group role.
	 *
	 * @return the group ID of this org group role
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this org group role.
	 *
	 * @param groupId the group ID of this org group role
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the role ID of this org group role.
	 *
	 * @return the role ID of this org group role
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this org group role.
	 *
	 * @param roleId the role ID of this org group role
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the company ID of this org group role.
	 *
	 * @return the company ID of this org group role
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this org group role.
	 *
	 * @param companyId the company ID of this org group role
	 */
	@Override
	public void setCompanyId(long companyId);

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
	public int compareTo(OrgGroupRole orgGroupRole);

	@Override
	public int hashCode();

	@Override
	public CacheModel<OrgGroupRole> toCacheModel();

	@Override
	public OrgGroupRole toEscapedModel();

	@Override
	public OrgGroupRole toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}