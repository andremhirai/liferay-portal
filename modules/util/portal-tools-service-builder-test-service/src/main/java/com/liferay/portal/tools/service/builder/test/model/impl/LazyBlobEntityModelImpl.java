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

package com.liferay.portal.tools.service.builder.test.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntityBlob1BlobModel;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntityBlob2BlobModel;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntityModel;
import com.liferay.portal.tools.service.builder.test.model.LazyBlobEntitySoap;
import com.liferay.portal.tools.service.builder.test.service.LazyBlobEntityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the LazyBlobEntity service. Represents a row in the &quot;LazyBlobEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>LazyBlobEntityModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LazyBlobEntityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LazyBlobEntityImpl
 * @generated
 */
@JSON(strict = true)
public class LazyBlobEntityModelImpl
	extends BaseModelImpl<LazyBlobEntity> implements LazyBlobEntityModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lazy blob entity model instance should use the <code>LazyBlobEntity</code> interface instead.
	 */
	public static final String TABLE_NAME = "LazyBlobEntity";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"lazyBlobEntityId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"blob1", Types.BLOB}, {"blob2", Types.BLOB}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lazyBlobEntityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("blob1", Types.BLOB);
		TABLE_COLUMNS_MAP.put("blob2", Types.BLOB);
	}

	public static final String TABLE_SQL_CREATE =
		"create table LazyBlobEntity (uuid_ VARCHAR(75) null,lazyBlobEntityId LONG not null primary key,groupId LONG,blob1 BLOB,blob2 BLOB)";

	public static final String TABLE_SQL_DROP = "drop table LazyBlobEntity";

	public static final String ORDER_BY_JPQL =
		" ORDER BY lazyBlobEntity.lazyBlobEntityId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY LazyBlobEntity.lazyBlobEntityId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.entity.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.finder.cache.enabled.com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"value.object.column.bitmask.enabled.com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity"),
		true);

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long UUID_COLUMN_BITMASK = 2L;

	public static final long LAZYBLOBENTITYID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static LazyBlobEntity toModel(LazyBlobEntitySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		LazyBlobEntity model = new LazyBlobEntityImpl();

		model.setUuid(soapModel.getUuid());
		model.setLazyBlobEntityId(soapModel.getLazyBlobEntityId());
		model.setGroupId(soapModel.getGroupId());
		model.setBlob1(soapModel.getBlob1());
		model.setBlob2(soapModel.getBlob2());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<LazyBlobEntity> toModels(
		LazyBlobEntitySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<LazyBlobEntity> models = new ArrayList<LazyBlobEntity>(
			soapModels.length);

		for (LazyBlobEntitySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.tools.service.builder.test.service.util.ServiceProps.
			get(
				"lock.expiration.time.com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity"));

	public LazyBlobEntityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _lazyBlobEntityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLazyBlobEntityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lazyBlobEntityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return LazyBlobEntity.class;
	}

	@Override
	public String getModelClassName() {
		return LazyBlobEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<LazyBlobEntity, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<LazyBlobEntity, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<LazyBlobEntity, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((LazyBlobEntity)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<LazyBlobEntity, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<LazyBlobEntity, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(LazyBlobEntity)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<LazyBlobEntity, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<LazyBlobEntity, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, LazyBlobEntity>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			LazyBlobEntity.class.getClassLoader(), LazyBlobEntity.class,
			ModelWrapper.class);

		try {
			Constructor<LazyBlobEntity> constructor =
				(Constructor<LazyBlobEntity>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<LazyBlobEntity, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<LazyBlobEntity, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<LazyBlobEntity, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<LazyBlobEntity, Object>>();
		Map<String, BiConsumer<LazyBlobEntity, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<LazyBlobEntity, ?>>();

		attributeGetterFunctions.put("uuid", LazyBlobEntity::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<LazyBlobEntity, String>)LazyBlobEntity::setUuid);
		attributeGetterFunctions.put(
			"lazyBlobEntityId", LazyBlobEntity::getLazyBlobEntityId);
		attributeSetterBiConsumers.put(
			"lazyBlobEntityId",
			(BiConsumer<LazyBlobEntity, Long>)
				LazyBlobEntity::setLazyBlobEntityId);
		attributeGetterFunctions.put("groupId", LazyBlobEntity::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<LazyBlobEntity, Long>)LazyBlobEntity::setGroupId);
		attributeGetterFunctions.put("blob1", LazyBlobEntity::getBlob1);
		attributeSetterBiConsumers.put(
			"blob1",
			(BiConsumer<LazyBlobEntity, Blob>)LazyBlobEntity::setBlob1);
		attributeGetterFunctions.put("blob2", LazyBlobEntity::getBlob2);
		attributeSetterBiConsumers.put(
			"blob2",
			(BiConsumer<LazyBlobEntity, Blob>)LazyBlobEntity::setBlob2);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
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

	@JSON
	@Override
	public long getLazyBlobEntityId() {
		return _lazyBlobEntityId;
	}

	@Override
	public void setLazyBlobEntityId(long lazyBlobEntityId) {
		_lazyBlobEntityId = lazyBlobEntityId;
	}

	@JSON
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

	@JSON
	@Override
	public Blob getBlob1() {
		if (_blob1BlobModel == null) {
			try {
				_blob1BlobModel =
					LazyBlobEntityLocalServiceUtil.getBlob1BlobModel(
						getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_blob1BlobModel != null) {
			blob = _blob1BlobModel.getBlob1Blob();
		}

		return blob;
	}

	@Override
	public void setBlob1(Blob blob1) {
		if (_blob1BlobModel == null) {
			_blob1BlobModel = new LazyBlobEntityBlob1BlobModel(
				getPrimaryKey(), blob1);
		}
		else {
			_blob1BlobModel.setBlob1Blob(blob1);
		}
	}

	@JSON
	@Override
	public Blob getBlob2() {
		if (_blob2BlobModel == null) {
			try {
				_blob2BlobModel =
					LazyBlobEntityLocalServiceUtil.getBlob2BlobModel(
						getPrimaryKey());
			}
			catch (Exception e) {
			}
		}

		Blob blob = null;

		if (_blob2BlobModel != null) {
			blob = _blob2BlobModel.getBlob2Blob();
		}

		return blob;
	}

	@Override
	public void setBlob2(Blob blob2) {
		if (_blob2BlobModel == null) {
			_blob2BlobModel = new LazyBlobEntityBlob2BlobModel(
				getPrimaryKey(), blob2);
		}
		else {
			_blob2BlobModel.setBlob2Blob(blob2);
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, LazyBlobEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public LazyBlobEntity toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, LazyBlobEntity>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LazyBlobEntityImpl lazyBlobEntityImpl = new LazyBlobEntityImpl();

		lazyBlobEntityImpl.setUuid(getUuid());
		lazyBlobEntityImpl.setLazyBlobEntityId(getLazyBlobEntityId());
		lazyBlobEntityImpl.setGroupId(getGroupId());

		lazyBlobEntityImpl.resetOriginalValues();

		return lazyBlobEntityImpl;
	}

	@Override
	public int compareTo(LazyBlobEntity lazyBlobEntity) {
		long primaryKey = lazyBlobEntity.getPrimaryKey();

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

		if (!(obj instanceof LazyBlobEntity)) {
			return false;
		}

		LazyBlobEntity lazyBlobEntity = (LazyBlobEntity)obj;

		long primaryKey = lazyBlobEntity.getPrimaryKey();

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
		LazyBlobEntityModelImpl lazyBlobEntityModelImpl = this;

		lazyBlobEntityModelImpl._originalUuid = lazyBlobEntityModelImpl._uuid;

		lazyBlobEntityModelImpl._originalGroupId =
			lazyBlobEntityModelImpl._groupId;

		lazyBlobEntityModelImpl._setOriginalGroupId = false;

		lazyBlobEntityModelImpl._blob1BlobModel = null;

		lazyBlobEntityModelImpl._blob2BlobModel = null;

		lazyBlobEntityModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<LazyBlobEntity> toCacheModel() {
		LazyBlobEntityCacheModel lazyBlobEntityCacheModel =
			new LazyBlobEntityCacheModel();

		lazyBlobEntityCacheModel.uuid = getUuid();

		String uuid = lazyBlobEntityCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			lazyBlobEntityCacheModel.uuid = null;
		}

		lazyBlobEntityCacheModel.lazyBlobEntityId = getLazyBlobEntityId();

		lazyBlobEntityCacheModel.groupId = getGroupId();

		return lazyBlobEntityCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", lazyBlobEntityId=");
		sb.append(getLazyBlobEntityId());
		sb.append(", groupId=");
		sb.append(getGroupId());

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append(
			"com.liferay.portal.tools.service.builder.test.model.LazyBlobEntity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lazyBlobEntityId</column-name><column-value><![CDATA[");
		sb.append(getLazyBlobEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, LazyBlobEntity>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _lazyBlobEntityId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private LazyBlobEntityBlob1BlobModel _blob1BlobModel;
	private LazyBlobEntityBlob2BlobModel _blob2BlobModel;
	private long _columnBitmask;
	private LazyBlobEntity _escapedModel;

}