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

package com.liferay.dynamic.data.mapping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersionModel;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersionSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the DDMFormInstanceRecordVersion service. Represents a row in the &quot;DDMFormInstanceRecordVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>DDMFormInstanceRecordVersionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DDMFormInstanceRecordVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DDMFormInstanceRecordVersionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DDMFormInstanceRecordVersionModelImpl
	extends BaseModelImpl<DDMFormInstanceRecordVersion>
	implements DDMFormInstanceRecordVersionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ddm form instance record version model instance should use the <code>DDMFormInstanceRecordVersion</code> interface instead.
	 */
	public static final String TABLE_NAME = "DDMFormInstanceRecordVersion";

	public static final Object[][] TABLE_COLUMNS = {
		{"formInstanceRecordVersionId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"formInstanceId", Types.BIGINT},
		{"formInstanceVersion", Types.VARCHAR},
		{"formInstanceRecordId", Types.BIGINT}, {"version", Types.VARCHAR},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"storageId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("formInstanceRecordVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("formInstanceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("formInstanceVersion", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("formInstanceRecordId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("version", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("storageId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table DDMFormInstanceRecordVersion (formInstanceRecordVersionId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,formInstanceId LONG,formInstanceVersion VARCHAR(75) null,formInstanceRecordId LONG,version VARCHAR(75) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,storageId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table DDMFormInstanceRecordVersion";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ddmFormInstanceRecordVersion.formInstanceRecordVersionId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY DDMFormInstanceRecordVersion.formInstanceRecordVersionId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion"),
		true);

	public static final long FORMINSTANCEID_COLUMN_BITMASK = 1L;

	public static final long FORMINSTANCERECORDID_COLUMN_BITMASK = 2L;

	public static final long FORMINSTANCEVERSION_COLUMN_BITMASK = 4L;

	public static final long STATUS_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long VERSION_COLUMN_BITMASK = 32L;

	public static final long FORMINSTANCERECORDVERSIONID_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static DDMFormInstanceRecordVersion toModel(
		DDMFormInstanceRecordVersionSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		DDMFormInstanceRecordVersion model =
			new DDMFormInstanceRecordVersionImpl();

		model.setFormInstanceRecordVersionId(
			soapModel.getFormInstanceRecordVersionId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setFormInstanceId(soapModel.getFormInstanceId());
		model.setFormInstanceVersion(soapModel.getFormInstanceVersion());
		model.setFormInstanceRecordId(soapModel.getFormInstanceRecordId());
		model.setVersion(soapModel.getVersion());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setStorageId(soapModel.getStorageId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<DDMFormInstanceRecordVersion> toModels(
		DDMFormInstanceRecordVersionSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<DDMFormInstanceRecordVersion> models =
			new ArrayList<DDMFormInstanceRecordVersion>(soapModels.length);

		for (DDMFormInstanceRecordVersionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.dynamic.data.mapping.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion"));

	public DDMFormInstanceRecordVersionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _formInstanceRecordVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormInstanceRecordVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formInstanceRecordVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return DDMFormInstanceRecordVersion.class;
	}

	@Override
	public String getModelClassName() {
		return DDMFormInstanceRecordVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<DDMFormInstanceRecordVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<DDMFormInstanceRecordVersion, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMFormInstanceRecordVersion, Object>
				attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(DDMFormInstanceRecordVersion)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<DDMFormInstanceRecordVersion, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<DDMFormInstanceRecordVersion, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(DDMFormInstanceRecordVersion)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<DDMFormInstanceRecordVersion, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<DDMFormInstanceRecordVersion, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map
		<String, Function<DDMFormInstanceRecordVersion, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<DDMFormInstanceRecordVersion, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<DDMFormInstanceRecordVersion, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<DDMFormInstanceRecordVersion, Object>>();
		Map<String, BiConsumer<DDMFormInstanceRecordVersion, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<DDMFormInstanceRecordVersion, ?>>();

		attributeGetterFunctions.put(
			"formInstanceRecordVersionId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.
						getFormInstanceRecordVersionId();
				}

			});
		attributeSetterBiConsumers.put(
			"formInstanceRecordVersionId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object formInstanceRecordVersionId) {

					ddmFormInstanceRecordVersion.setFormInstanceRecordVersionId(
						(Long)formInstanceRecordVersionId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object groupId) {

					ddmFormInstanceRecordVersion.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object companyId) {

					ddmFormInstanceRecordVersion.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object userId) {

					ddmFormInstanceRecordVersion.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object userName) {

					ddmFormInstanceRecordVersion.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object createDate) {

					ddmFormInstanceRecordVersion.setCreateDate(
						(Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"formInstanceId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getFormInstanceId();
				}

			});
		attributeSetterBiConsumers.put(
			"formInstanceId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object formInstanceId) {

					ddmFormInstanceRecordVersion.setFormInstanceId(
						(Long)formInstanceId);
				}

			});
		attributeGetterFunctions.put(
			"formInstanceVersion",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.
						getFormInstanceVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"formInstanceVersion",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object formInstanceVersion) {

					ddmFormInstanceRecordVersion.setFormInstanceVersion(
						(String)formInstanceVersion);
				}

			});
		attributeGetterFunctions.put(
			"formInstanceRecordId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.
						getFormInstanceRecordId();
				}

			});
		attributeSetterBiConsumers.put(
			"formInstanceRecordId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object formInstanceRecordId) {

					ddmFormInstanceRecordVersion.setFormInstanceRecordId(
						(Long)formInstanceRecordId);
				}

			});
		attributeGetterFunctions.put(
			"version",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getVersion();
				}

			});
		attributeSetterBiConsumers.put(
			"version",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object version) {

					ddmFormInstanceRecordVersion.setVersion((String)version);
				}

			});
		attributeGetterFunctions.put(
			"status",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"status",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object status) {

					ddmFormInstanceRecordVersion.setStatus((Integer)status);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getStatusByUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object statusByUserId) {

					ddmFormInstanceRecordVersion.setStatusByUserId(
						(Long)statusByUserId);
				}

			});
		attributeGetterFunctions.put(
			"statusByUserName",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getStatusByUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"statusByUserName",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object statusByUserName) {

					ddmFormInstanceRecordVersion.setStatusByUserName(
						(String)statusByUserName);
				}

			});
		attributeGetterFunctions.put(
			"statusDate",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getStatusDate();
				}

			});
		attributeSetterBiConsumers.put(
			"statusDate",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object statusDate) {

					ddmFormInstanceRecordVersion.setStatusDate(
						(Date)statusDate);
				}

			});
		attributeGetterFunctions.put(
			"storageId",
			new Function<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public Object apply(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

					return ddmFormInstanceRecordVersion.getStorageId();
				}

			});
		attributeSetterBiConsumers.put(
			"storageId",
			new BiConsumer<DDMFormInstanceRecordVersion, Object>() {

				@Override
				public void accept(
					DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion,
					Object storageId) {

					ddmFormInstanceRecordVersion.setStorageId((Long)storageId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getFormInstanceRecordVersionId() {
		return _formInstanceRecordVersionId;
	}

	@Override
	public void setFormInstanceRecordVersionId(
		long formInstanceRecordVersionId) {

		_formInstanceRecordVersionId = formInstanceRecordVersionId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

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

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
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

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public long getFormInstanceId() {
		return _formInstanceId;
	}

	@Override
	public void setFormInstanceId(long formInstanceId) {
		_columnBitmask |= FORMINSTANCEID_COLUMN_BITMASK;

		if (!_setOriginalFormInstanceId) {
			_setOriginalFormInstanceId = true;

			_originalFormInstanceId = _formInstanceId;
		}

		_formInstanceId = formInstanceId;
	}

	public long getOriginalFormInstanceId() {
		return _originalFormInstanceId;
	}

	@JSON
	@Override
	public String getFormInstanceVersion() {
		if (_formInstanceVersion == null) {
			return "";
		}
		else {
			return _formInstanceVersion;
		}
	}

	@Override
	public void setFormInstanceVersion(String formInstanceVersion) {
		_columnBitmask |= FORMINSTANCEVERSION_COLUMN_BITMASK;

		if (_originalFormInstanceVersion == null) {
			_originalFormInstanceVersion = _formInstanceVersion;
		}

		_formInstanceVersion = formInstanceVersion;
	}

	public String getOriginalFormInstanceVersion() {
		return GetterUtil.getString(_originalFormInstanceVersion);
	}

	@JSON
	@Override
	public long getFormInstanceRecordId() {
		return _formInstanceRecordId;
	}

	@Override
	public void setFormInstanceRecordId(long formInstanceRecordId) {
		_columnBitmask |= FORMINSTANCERECORDID_COLUMN_BITMASK;

		if (!_setOriginalFormInstanceRecordId) {
			_setOriginalFormInstanceRecordId = true;

			_originalFormInstanceRecordId = _formInstanceRecordId;
		}

		_formInstanceRecordId = formInstanceRecordId;
	}

	public long getOriginalFormInstanceRecordId() {
		return _originalFormInstanceRecordId;
	}

	@JSON
	@Override
	public String getVersion() {
		if (_version == null) {
			return "";
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public long getStorageId() {
		return _storageId;
	}

	@Override
	public void setStorageId(long storageId) {
		_storageId = storageId;
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), DDMFormInstanceRecordVersion.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public DDMFormInstanceRecordVersion toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel =
				(DDMFormInstanceRecordVersion)ProxyUtil.newProxyInstance(
					_classLoader, _escapedModelInterfaces,
					new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DDMFormInstanceRecordVersionImpl ddmFormInstanceRecordVersionImpl =
			new DDMFormInstanceRecordVersionImpl();

		ddmFormInstanceRecordVersionImpl.setFormInstanceRecordVersionId(
			getFormInstanceRecordVersionId());
		ddmFormInstanceRecordVersionImpl.setGroupId(getGroupId());
		ddmFormInstanceRecordVersionImpl.setCompanyId(getCompanyId());
		ddmFormInstanceRecordVersionImpl.setUserId(getUserId());
		ddmFormInstanceRecordVersionImpl.setUserName(getUserName());
		ddmFormInstanceRecordVersionImpl.setCreateDate(getCreateDate());
		ddmFormInstanceRecordVersionImpl.setFormInstanceId(getFormInstanceId());
		ddmFormInstanceRecordVersionImpl.setFormInstanceVersion(
			getFormInstanceVersion());
		ddmFormInstanceRecordVersionImpl.setFormInstanceRecordId(
			getFormInstanceRecordId());
		ddmFormInstanceRecordVersionImpl.setVersion(getVersion());
		ddmFormInstanceRecordVersionImpl.setStatus(getStatus());
		ddmFormInstanceRecordVersionImpl.setStatusByUserId(getStatusByUserId());
		ddmFormInstanceRecordVersionImpl.setStatusByUserName(
			getStatusByUserName());
		ddmFormInstanceRecordVersionImpl.setStatusDate(getStatusDate());
		ddmFormInstanceRecordVersionImpl.setStorageId(getStorageId());

		ddmFormInstanceRecordVersionImpl.resetOriginalValues();

		return ddmFormInstanceRecordVersionImpl;
	}

	@Override
	public int compareTo(
		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion) {

		long primaryKey = ddmFormInstanceRecordVersion.getPrimaryKey();

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

		if (!(obj instanceof DDMFormInstanceRecordVersion)) {
			return false;
		}

		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion =
			(DDMFormInstanceRecordVersion)obj;

		long primaryKey = ddmFormInstanceRecordVersion.getPrimaryKey();

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
		DDMFormInstanceRecordVersionModelImpl
			ddmFormInstanceRecordVersionModelImpl = this;

		ddmFormInstanceRecordVersionModelImpl._originalUserId =
			ddmFormInstanceRecordVersionModelImpl._userId;

		ddmFormInstanceRecordVersionModelImpl._setOriginalUserId = false;

		ddmFormInstanceRecordVersionModelImpl._originalFormInstanceId =
			ddmFormInstanceRecordVersionModelImpl._formInstanceId;

		ddmFormInstanceRecordVersionModelImpl._setOriginalFormInstanceId =
			false;

		ddmFormInstanceRecordVersionModelImpl._originalFormInstanceVersion =
			ddmFormInstanceRecordVersionModelImpl._formInstanceVersion;

		ddmFormInstanceRecordVersionModelImpl._originalFormInstanceRecordId =
			ddmFormInstanceRecordVersionModelImpl._formInstanceRecordId;

		ddmFormInstanceRecordVersionModelImpl._setOriginalFormInstanceRecordId =
			false;

		ddmFormInstanceRecordVersionModelImpl._originalVersion =
			ddmFormInstanceRecordVersionModelImpl._version;

		ddmFormInstanceRecordVersionModelImpl._originalStatus =
			ddmFormInstanceRecordVersionModelImpl._status;

		ddmFormInstanceRecordVersionModelImpl._setOriginalStatus = false;

		ddmFormInstanceRecordVersionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<DDMFormInstanceRecordVersion> toCacheModel() {
		DDMFormInstanceRecordVersionCacheModel
			ddmFormInstanceRecordVersionCacheModel =
				new DDMFormInstanceRecordVersionCacheModel();

		ddmFormInstanceRecordVersionCacheModel.formInstanceRecordVersionId =
			getFormInstanceRecordVersionId();

		ddmFormInstanceRecordVersionCacheModel.groupId = getGroupId();

		ddmFormInstanceRecordVersionCacheModel.companyId = getCompanyId();

		ddmFormInstanceRecordVersionCacheModel.userId = getUserId();

		ddmFormInstanceRecordVersionCacheModel.userName = getUserName();

		String userName = ddmFormInstanceRecordVersionCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ddmFormInstanceRecordVersionCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ddmFormInstanceRecordVersionCacheModel.createDate =
				createDate.getTime();
		}
		else {
			ddmFormInstanceRecordVersionCacheModel.createDate = Long.MIN_VALUE;
		}

		ddmFormInstanceRecordVersionCacheModel.formInstanceId =
			getFormInstanceId();

		ddmFormInstanceRecordVersionCacheModel.formInstanceVersion =
			getFormInstanceVersion();

		String formInstanceVersion =
			ddmFormInstanceRecordVersionCacheModel.formInstanceVersion;

		if ((formInstanceVersion != null) &&
			(formInstanceVersion.length() == 0)) {

			ddmFormInstanceRecordVersionCacheModel.formInstanceVersion = null;
		}

		ddmFormInstanceRecordVersionCacheModel.formInstanceRecordId =
			getFormInstanceRecordId();

		ddmFormInstanceRecordVersionCacheModel.version = getVersion();

		String version = ddmFormInstanceRecordVersionCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			ddmFormInstanceRecordVersionCacheModel.version = null;
		}

		ddmFormInstanceRecordVersionCacheModel.status = getStatus();

		ddmFormInstanceRecordVersionCacheModel.statusByUserId =
			getStatusByUserId();

		ddmFormInstanceRecordVersionCacheModel.statusByUserName =
			getStatusByUserName();

		String statusByUserName =
			ddmFormInstanceRecordVersionCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			ddmFormInstanceRecordVersionCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			ddmFormInstanceRecordVersionCacheModel.statusDate =
				statusDate.getTime();
		}
		else {
			ddmFormInstanceRecordVersionCacheModel.statusDate = Long.MIN_VALUE;
		}

		ddmFormInstanceRecordVersionCacheModel.storageId = getStorageId();

		return ddmFormInstanceRecordVersionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<DDMFormInstanceRecordVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<DDMFormInstanceRecordVersion, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMFormInstanceRecordVersion, Object>
				attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(DDMFormInstanceRecordVersion)this));
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
		Map<String, Function<DDMFormInstanceRecordVersion, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<DDMFormInstanceRecordVersion, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<DDMFormInstanceRecordVersion, Object>
				attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(DDMFormInstanceRecordVersion)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		DDMFormInstanceRecordVersion.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		DDMFormInstanceRecordVersion.class, ModelWrapper.class
	};

	private long _formInstanceRecordVersionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private long _formInstanceId;
	private long _originalFormInstanceId;
	private boolean _setOriginalFormInstanceId;
	private String _formInstanceVersion;
	private String _originalFormInstanceVersion;
	private long _formInstanceRecordId;
	private long _originalFormInstanceRecordId;
	private boolean _setOriginalFormInstanceRecordId;
	private String _version;
	private String _originalVersion;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _storageId;
	private long _columnBitmask;
	private DDMFormInstanceRecordVersion _escapedModel;

}