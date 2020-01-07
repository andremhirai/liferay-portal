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

package com.liferay.account.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.AuditedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AccountEntry service. Represents a row in the &quot;AccountEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.account.model.impl.AccountEntryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.account.model.impl.AccountEntryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountEntry
 * @generated
 */
@ProviderType
public interface AccountEntryModel
	extends AuditedModel, BaseModel<AccountEntry>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a account entry model instance should use the {@link AccountEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this account entry.
	 *
	 * @return the primary key of this account entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this account entry.
	 *
	 * @param primaryKey the primary key of this account entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this account entry.
	 *
	 * @return the mvcc version of this account entry
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this account entry.
	 *
	 * @param mvccVersion the mvcc version of this account entry
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the account entry ID of this account entry.
	 *
	 * @return the account entry ID of this account entry
	 */
	public long getAccountEntryId();

	/**
	 * Sets the account entry ID of this account entry.
	 *
	 * @param accountEntryId the account entry ID of this account entry
	 */
	public void setAccountEntryId(long accountEntryId);

	/**
	 * Returns the company ID of this account entry.
	 *
	 * @return the company ID of this account entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this account entry.
	 *
	 * @param companyId the company ID of this account entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this account entry.
	 *
	 * @return the user ID of this account entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this account entry.
	 *
	 * @param userId the user ID of this account entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this account entry.
	 *
	 * @return the user uuid of this account entry
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this account entry.
	 *
	 * @param userUuid the user uuid of this account entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this account entry.
	 *
	 * @return the user name of this account entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this account entry.
	 *
	 * @param userName the user name of this account entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this account entry.
	 *
	 * @return the create date of this account entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this account entry.
	 *
	 * @param createDate the create date of this account entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this account entry.
	 *
	 * @return the modified date of this account entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this account entry.
	 *
	 * @param modifiedDate the modified date of this account entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the parent account entry ID of this account entry.
	 *
	 * @return the parent account entry ID of this account entry
	 */
	public long getParentAccountEntryId();

	/**
	 * Sets the parent account entry ID of this account entry.
	 *
	 * @param parentAccountEntryId the parent account entry ID of this account entry
	 */
	public void setParentAccountEntryId(long parentAccountEntryId);

	/**
	 * Returns the name of this account entry.
	 *
	 * @return the name of this account entry
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this account entry.
	 *
	 * @param name the name of this account entry
	 */
	public void setName(String name);

	/**
	 * Returns the description of this account entry.
	 *
	 * @return the description of this account entry
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this account entry.
	 *
	 * @param description the description of this account entry
	 */
	public void setDescription(String description);

	/**
	 * Returns the domains of this account entry.
	 *
	 * @return the domains of this account entry
	 */
	@AutoEscape
	public String getDomains();

	/**
	 * Sets the domains of this account entry.
	 *
	 * @param domains the domains of this account entry
	 */
	public void setDomains(String domains);

	/**
	 * Returns the logo ID of this account entry.
	 *
	 * @return the logo ID of this account entry
	 */
	public long getLogoId();

	/**
	 * Sets the logo ID of this account entry.
	 *
	 * @param logoId the logo ID of this account entry
	 */
	public void setLogoId(long logoId);

	/**
	 * Returns the status of this account entry.
	 *
	 * @return the status of this account entry
	 */
	public int getStatus();

	/**
	 * Sets the status of this account entry.
	 *
	 * @param status the status of this account entry
	 */
	public void setStatus(int status);

}