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

package com.liferay.portal.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LayoutFriendlyURL;
import com.liferay.portal.kernel.model.LayoutFriendlyURLModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LayoutFriendlyURL service. Represents a row in the &quot;LayoutFriendlyURL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LayoutFriendlyURLModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LayoutFriendlyURLImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutFriendlyURLImpl
 * @generated
 */
@ProviderType
public class LayoutFriendlyURLModelImpl
	extends BaseModelImpl<LayoutFriendlyURL> implements LayoutFriendlyURLModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a layout friendly url model instance should use the <code>LayoutFriendlyURL</code> interface instead.
	 */
	public static final String TABLE_NAME = "LayoutFriendlyURL";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"uuid_", Types.VARCHAR},
		{"layoutFriendlyURLId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"plid", Types.BIGINT},
		{"privateLayout", Types.BOOLEAN}, {"friendlyURL", Types.VARCHAR},
		{"languageId", Types.VARCHAR}, {"lastPublishDate", Types.TIMESTAMP}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("layoutFriendlyURLId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("plid", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("privateLayout", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("friendlyURL", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lastPublishDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LayoutFriendlyURL (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,layoutFriendlyURLId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,plid LONG,privateLayout BOOLEAN,friendlyURL VARCHAR(255) null,languageId VARCHAR(75) null,lastPublishDate DATE null)";

	public static final String TABLE_SQL_DROP = "drop table LayoutFriendlyURL";

	public static final String ORDER_BY_JPQL =
		" ORDER BY layoutFriendlyURL.layoutFriendlyURLId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LayoutFriendlyURL.layoutFriendlyURLId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.portal.kernel.model.LayoutFriendlyURL"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.portal.kernel.model.LayoutFriendlyURL"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.portal.kernel.model.LayoutFriendlyURL"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long FRIENDLYURL_COLUMN_BITMASK = 2L;

	public static final long GROUPID_COLUMN_BITMASK = 4L;

	public static final long LANGUAGEID_COLUMN_BITMASK = 8L;

	public static final long PLID_COLUMN_BITMASK = 16L;

	public static final long PRIVATELAYOUT_COLUMN_BITMASK = 32L;

	public static final long UUID_COLUMN_BITMASK = 64L;

	public static final long LAYOUTFRIENDLYURLID_COLUMN_BITMASK = 128L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.portal.kernel.model.LayoutFriendlyURL"));

	public LayoutFriendlyURLModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _layoutFriendlyURLId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLayoutFriendlyURLId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _layoutFriendlyURLId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LayoutFriendlyURL.class;
	}

	@Override
	public String getModelClassName() {
		return LayoutFriendlyURL.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LayoutFriendlyURL, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LayoutFriendlyURL, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutFriendlyURL, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LayoutFriendlyURL)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LayoutFriendlyURL, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LayoutFriendlyURL, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LayoutFriendlyURL)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LayoutFriendlyURL, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LayoutFriendlyURL, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<LayoutFriendlyURL, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LayoutFriendlyURL, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LayoutFriendlyURL, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<LayoutFriendlyURL, Object>>();
		Map<String, BiConsumer<LayoutFriendlyURL, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<LayoutFriendlyURL, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getMvccVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"mvccVersion",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object mvccVersion) {

					layoutFriendlyURL.setMvccVersion((Long)mvccVersion);
				}

			});
		attributeGetterFunctions.put(
			"uuid",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object uuid) {

					layoutFriendlyURL.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"layoutFriendlyURLId",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getLayoutFriendlyURLId();
				}

			});
		attributeSetterBiConsumers.put(
			"layoutFriendlyURLId",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL,
					Object layoutFriendlyURLId) {

					layoutFriendlyURL.setLayoutFriendlyURLId(
						(Long)layoutFriendlyURLId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object groupId) {

					layoutFriendlyURL.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object companyId) {

					layoutFriendlyURL.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object userId) {

					layoutFriendlyURL.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object userName) {

					layoutFriendlyURL.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object createDate) {

					layoutFriendlyURL.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object modifiedDate) {

					layoutFriendlyURL.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"plid",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getPlid();
				}

			});
		attributeSetterBiConsumers.put(
			"plid",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object plid) {

					layoutFriendlyURL.setPlid((Long)plid);
				}

			});
		attributeGetterFunctions.put(
			"privateLayout",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getPrivateLayout();
				}

			});
		attributeSetterBiConsumers.put(
			"privateLayout",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object privateLayout) {

					layoutFriendlyURL.setPrivateLayout((Boolean)privateLayout);
				}

			});
		attributeGetterFunctions.put(
			"friendlyURL",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getFriendlyURL();
				}

			});
		attributeSetterBiConsumers.put(
			"friendlyURL",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object friendlyURL) {

					layoutFriendlyURL.setFriendlyURL((String)friendlyURL);
				}

			});
		attributeGetterFunctions.put(
			"languageId",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getLanguageId();
				}

			});
		attributeSetterBiConsumers.put(
			"languageId",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL, Object languageId) {

					layoutFriendlyURL.setLanguageId((String)languageId);
				}

			});
		attributeGetterFunctions.put(
			"lastPublishDate",
			new Function<LayoutFriendlyURL, Object>() {

				@Override
				public Object apply(LayoutFriendlyURL layoutFriendlyURL) {
					return layoutFriendlyURL.getLastPublishDate();
				}

			});
		attributeSetterBiConsumers.put(
			"lastPublishDate",
			new BiConsumer<LayoutFriendlyURL, Object>() {

				@Override
				public void accept(
					LayoutFriendlyURL layoutFriendlyURL,
					Object lastPublishDate) {

					layoutFriendlyURL.setLastPublishDate((Date)lastPublishDate);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getLayoutFriendlyURLId() {
		return _layoutFriendlyURLId;
	}

	@Override
	public void setLayoutFriendlyURLId(long layoutFriendlyURLId) {
		_layoutFriendlyURLId = layoutFriendlyURLId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getPlid() {
		return _plid;
	}

	@Override
	public void setPlid(long plid) {
		_columnBitmask |= PLID_COLUMN_BITMASK;

		if (!_setOriginalPlid) {
			_setOriginalPlid = true;

			_originalPlid = _plid;
		}

		_plid = plid;
	}

	public long getOriginalPlid() {
		return _originalPlid;
	}

	@Override
	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	@Override
	public void setPrivateLayout(boolean privateLayout) {
		_columnBitmask |= PRIVATELAYOUT_COLUMN_BITMASK;

		if (!_setOriginalPrivateLayout) {
			_setOriginalPrivateLayout = true;

			_originalPrivateLayout = _privateLayout;
		}

		_privateLayout = privateLayout;
	}

	public boolean getOriginalPrivateLayout() {
		return _originalPrivateLayout;
	}

	@Override
	public String getFriendlyURL() {
		if (_friendlyURL == null) {
			return "";
		}
		else {
			return _friendlyURL;
		}
	}

	@Override
	public void setFriendlyURL(String friendlyURL) {
		_columnBitmask |= FRIENDLYURL_COLUMN_BITMASK;

		if (_originalFriendlyURL == null) {
			_originalFriendlyURL = _friendlyURL;
		}

		_friendlyURL = friendlyURL;
	}

	public String getOriginalFriendlyURL() {
		return GetterUtil.getString(_originalFriendlyURL);
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return "";
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_columnBitmask |= LANGUAGEID_COLUMN_BITMASK;

		if (_originalLanguageId == null) {
			_originalLanguageId = _languageId;
		}

		_languageId = languageId;
	}

	public String getOriginalLanguageId() {
		return GetterUtil.getString(_originalLanguageId);
	}

	@Override
	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	@Override
	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(LayoutFriendlyURL.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), LayoutFriendlyURL.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LayoutFriendlyURL toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (LayoutFriendlyURL)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LayoutFriendlyURLImpl layoutFriendlyURLImpl =
			new LayoutFriendlyURLImpl();

		layoutFriendlyURLImpl.setMvccVersion(getMvccVersion());
		layoutFriendlyURLImpl.setUuid(getUuid());
		layoutFriendlyURLImpl.setLayoutFriendlyURLId(getLayoutFriendlyURLId());
		layoutFriendlyURLImpl.setGroupId(getGroupId());
		layoutFriendlyURLImpl.setCompanyId(getCompanyId());
		layoutFriendlyURLImpl.setUserId(getUserId());
		layoutFriendlyURLImpl.setUserName(getUserName());
		layoutFriendlyURLImpl.setCreateDate(getCreateDate());
		layoutFriendlyURLImpl.setModifiedDate(getModifiedDate());
		layoutFriendlyURLImpl.setPlid(getPlid());
		layoutFriendlyURLImpl.setPrivateLayout(isPrivateLayout());
		layoutFriendlyURLImpl.setFriendlyURL(getFriendlyURL());
		layoutFriendlyURLImpl.setLanguageId(getLanguageId());
		layoutFriendlyURLImpl.setLastPublishDate(getLastPublishDate());

		layoutFriendlyURLImpl.resetOriginalValues();

		return layoutFriendlyURLImpl;
	}

	@Override
	public int compareTo(LayoutFriendlyURL layoutFriendlyURL) {
		long primaryKey = layoutFriendlyURL.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LayoutFriendlyURL)) {
			return false;
		}

		LayoutFriendlyURL layoutFriendlyURL = (LayoutFriendlyURL)obj;

		long primaryKey = layoutFriendlyURL.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		LayoutFriendlyURLModelImpl layoutFriendlyURLModelImpl = this;

		layoutFriendlyURLModelImpl._originalUuid =
			layoutFriendlyURLModelImpl._uuid;

		layoutFriendlyURLModelImpl._originalGroupId =
			layoutFriendlyURLModelImpl._groupId;

		layoutFriendlyURLModelImpl._setOriginalGroupId = false;

		layoutFriendlyURLModelImpl._originalCompanyId =
			layoutFriendlyURLModelImpl._companyId;

		layoutFriendlyURLModelImpl._setOriginalCompanyId = false;

		layoutFriendlyURLModelImpl._setModifiedDate = false;

		layoutFriendlyURLModelImpl._originalPlid =
			layoutFriendlyURLModelImpl._plid;

		layoutFriendlyURLModelImpl._setOriginalPlid = false;

		layoutFriendlyURLModelImpl._originalPrivateLayout =
			layoutFriendlyURLModelImpl._privateLayout;

		layoutFriendlyURLModelImpl._setOriginalPrivateLayout = false;

		layoutFriendlyURLModelImpl._originalFriendlyURL =
			layoutFriendlyURLModelImpl._friendlyURL;

		layoutFriendlyURLModelImpl._originalLanguageId =
			layoutFriendlyURLModelImpl._languageId;

		layoutFriendlyURLModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LayoutFriendlyURL> toCacheModel() {
		LayoutFriendlyURLCacheModel layoutFriendlyURLCacheModel =
			new LayoutFriendlyURLCacheModel();

		layoutFriendlyURLCacheModel.mvccVersion = getMvccVersion();

		layoutFriendlyURLCacheModel.uuid = getUuid();

		String uuid = layoutFriendlyURLCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			layoutFriendlyURLCacheModel.uuid = null;
		}

		layoutFriendlyURLCacheModel.layoutFriendlyURLId =
			getLayoutFriendlyURLId();

		layoutFriendlyURLCacheModel.groupId = getGroupId();

		layoutFriendlyURLCacheModel.companyId = getCompanyId();

		layoutFriendlyURLCacheModel.userId = getUserId();

		layoutFriendlyURLCacheModel.userName = getUserName();

		String userName = layoutFriendlyURLCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			layoutFriendlyURLCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			layoutFriendlyURLCacheModel.createDate = createDate.getTime();
		}
		else {
			layoutFriendlyURLCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			layoutFriendlyURLCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			layoutFriendlyURLCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		layoutFriendlyURLCacheModel.plid = getPlid();

		layoutFriendlyURLCacheModel.privateLayout = isPrivateLayout();

		layoutFriendlyURLCacheModel.friendlyURL = getFriendlyURL();

		String friendlyURL = layoutFriendlyURLCacheModel.friendlyURL;

		if ((friendlyURL != null) && (friendlyURL.length() == 0)) {
			layoutFriendlyURLCacheModel.friendlyURL = null;
		}

		layoutFriendlyURLCacheModel.languageId = getLanguageId();

		String languageId = layoutFriendlyURLCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			layoutFriendlyURLCacheModel.languageId = null;
		}

		Date lastPublishDate = getLastPublishDate();

		if (lastPublishDate != null) {
			layoutFriendlyURLCacheModel.lastPublishDate =
				lastPublishDate.getTime();
		}
		else {
			layoutFriendlyURLCacheModel.lastPublishDate = Long.MIN_VALUE;
		}

		return layoutFriendlyURLCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<LayoutFriendlyURL, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<LayoutFriendlyURL, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutFriendlyURL, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((LayoutFriendlyURL)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<LayoutFriendlyURL, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<LayoutFriendlyURL, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LayoutFriendlyURL, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((LayoutFriendlyURL)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		LayoutFriendlyURL.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		LayoutFriendlyURL.class, ModelWrapper.class
	};

	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _layoutFriendlyURLId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _plid;
	private long _originalPlid;
	private boolean _setOriginalPlid;
	private boolean _privateLayout;
	private boolean _originalPrivateLayout;
	private boolean _setOriginalPrivateLayout;
	private String _friendlyURL;
	private String _originalFriendlyURL;
	private String _languageId;
	private String _originalLanguageId;
	private Date _lastPublishDate;
	private long _columnBitmask;
	private LayoutFriendlyURL _escapedModel;

}