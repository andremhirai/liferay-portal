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
import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the WebDAVProps service. Represents a row in the &quot;WebDAVProps&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portal.model.impl.WebDAVPropsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portal.model.impl.WebDAVPropsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebDAVProps
 * @generated
 */
@ProviderType
public interface WebDAVPropsModel
	extends AttachedModel, BaseModel<WebDAVProps>, MVCCModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a web dav props model instance should use the {@link WebDAVProps} interface instead.
	 */

	/**
	 * Returns the primary key of this web dav props.
	 *
	 * @return the primary key of this web dav props
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this web dav props.
	 *
	 * @param primaryKey the primary key of this web dav props
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this web dav props.
	 *
	 * @return the mvcc version of this web dav props
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this web dav props.
	 *
	 * @param mvccVersion the mvcc version of this web dav props
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the web dav props ID of this web dav props.
	 *
	 * @return the web dav props ID of this web dav props
	 */
	public long getWebDavPropsId();

	/**
	 * Sets the web dav props ID of this web dav props.
	 *
	 * @param webDavPropsId the web dav props ID of this web dav props
	 */
	public void setWebDavPropsId(long webDavPropsId);

	/**
	 * Returns the company ID of this web dav props.
	 *
	 * @return the company ID of this web dav props
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this web dav props.
	 *
	 * @param companyId the company ID of this web dav props
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this web dav props.
	 *
	 * @return the create date of this web dav props
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this web dav props.
	 *
	 * @param createDate the create date of this web dav props
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this web dav props.
	 *
	 * @return the modified date of this web dav props
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this web dav props.
	 *
	 * @param modifiedDate the modified date of this web dav props
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the fully qualified class name of this web dav props.
	 *
	 * @return the fully qualified class name of this web dav props
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this web dav props.
	 *
	 * @return the class name ID of this web dav props
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this web dav props.
	 *
	 * @param classNameId the class name ID of this web dav props
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class pk of this web dav props.
	 *
	 * @return the class pk of this web dav props
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class pk of this web dav props.
	 *
	 * @param classPK the class pk of this web dav props
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the props of this web dav props.
	 *
	 * @return the props of this web dav props
	 */
	@AutoEscape
	public String getProps();

	/**
	 * Sets the props of this web dav props.
	 *
	 * @param props the props of this web dav props
	 */
	public void setProps(String props);

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
	public int compareTo(WebDAVProps webDAVProps);

	@Override
	public int hashCode();

	@Override
	public CacheModel<WebDAVProps> toCacheModel();

	@Override
	public WebDAVProps toEscapedModel();

	@Override
	public WebDAVProps toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();

}