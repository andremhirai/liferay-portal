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

package com.liferay.portlet.asset.model.impl;

import com.liferay.asset.kernel.model.AssetCategoryProperty;
import com.liferay.asset.kernel.model.AssetCategoryPropertyModel;
import com.liferay.asset.kernel.model.AssetCategoryPropertySoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
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

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

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
 * The base model implementation for the AssetCategoryProperty service. Represents a row in the &quot;AssetCategoryProperty&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AssetCategoryPropertyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AssetCategoryPropertyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategoryPropertyImpl
 * @deprecated
 * @generated
 */
@Deprecated
@JSON(strict = true)
public class AssetCategoryPropertyModelImpl
	extends BaseModelImpl<AssetCategoryProperty>
	implements AssetCategoryPropertyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a asset category property model instance should use the <code>AssetCategoryProperty</code> interface instead.
	 */
	public static final String TABLE_NAME = "AssetCategoryProperty";

	public static final Object[][] TABLE_COLUMNS = {
		{"mvccVersion", Types.BIGINT}, {"ctCollectionId", Types.BIGINT},
		{"categoryPropertyId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"categoryId", Types.BIGINT}, {"key_", Types.VARCHAR},
		{"value", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ctCollectionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("categoryPropertyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("value", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table AssetCategoryProperty (mvccVersion LONG default 0 not null,ctCollectionId LONG default 0 not null,categoryPropertyId LONG not null,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,categoryId LONG,key_ VARCHAR(75) null,value VARCHAR(75) null,primary key (categoryPropertyId, ctCollectionId))";

	public static final String TABLE_SQL_DROP =
		"drop table AssetCategoryProperty";

	public static final String ORDER_BY_JPQL =
		" ORDER BY assetCategoryProperty.key ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY AssetCategoryProperty.key_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.asset.kernel.model.AssetCategoryProperty"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.asset.kernel.model.AssetCategoryProperty"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.asset.kernel.model.AssetCategoryProperty"),
		true);

	public static final long CATEGORYID_COLUMN_BITMASK = 1L;

	public static final long COMPANYID_COLUMN_BITMASK = 2L;

	public static final long KEY_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AssetCategoryProperty toModel(
		AssetCategoryPropertySoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		AssetCategoryProperty model = new AssetCategoryPropertyImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setCtCollectionId(soapModel.getCtCollectionId());
		model.setCategoryPropertyId(soapModel.getCategoryPropertyId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCategoryId(soapModel.getCategoryId());
		model.setKey(soapModel.getKey());
		model.setValue(soapModel.getValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AssetCategoryProperty> toModels(
		AssetCategoryPropertySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<AssetCategoryProperty> models =
			new ArrayList<AssetCategoryProperty>(soapModels.length);

		for (AssetCategoryPropertySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.asset.kernel.model.AssetCategoryProperty"));

	public AssetCategoryPropertyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _categoryPropertyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryPropertyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryPropertyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AssetCategoryProperty.class;
	}

	@Override
	public String getModelClassName() {
		return AssetCategoryProperty.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AssetCategoryProperty, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AssetCategoryProperty, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetCategoryProperty, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AssetCategoryProperty)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AssetCategoryProperty, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AssetCategoryProperty, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AssetCategoryProperty)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AssetCategoryProperty, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AssetCategoryProperty, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AssetCategoryProperty>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AssetCategoryProperty.class.getClassLoader(),
			AssetCategoryProperty.class, ModelWrapper.class);

		try {
			Constructor<AssetCategoryProperty> constructor =
				(Constructor<AssetCategoryProperty>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AssetCategoryProperty, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AssetCategoryProperty, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AssetCategoryProperty, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<AssetCategoryProperty, Object>>();
		Map<String, BiConsumer<AssetCategoryProperty, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<AssetCategoryProperty, ?>>();

		attributeGetterFunctions.put(
			"mvccVersion", AssetCategoryProperty::getMvccVersion);
		attributeSetterBiConsumers.put(
			"mvccVersion",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setMvccVersion);
		attributeGetterFunctions.put(
			"ctCollectionId", AssetCategoryProperty::getCtCollectionId);
		attributeSetterBiConsumers.put(
			"ctCollectionId",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setCtCollectionId);
		attributeGetterFunctions.put(
			"categoryPropertyId", AssetCategoryProperty::getCategoryPropertyId);
		attributeSetterBiConsumers.put(
			"categoryPropertyId",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setCategoryPropertyId);
		attributeGetterFunctions.put(
			"companyId", AssetCategoryProperty::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setCompanyId);
		attributeGetterFunctions.put(
			"userId", AssetCategoryProperty::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setUserId);
		attributeGetterFunctions.put(
			"userName", AssetCategoryProperty::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AssetCategoryProperty, String>)
				AssetCategoryProperty::setUserName);
		attributeGetterFunctions.put(
			"createDate", AssetCategoryProperty::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AssetCategoryProperty, Date>)
				AssetCategoryProperty::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AssetCategoryProperty::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AssetCategoryProperty, Date>)
				AssetCategoryProperty::setModifiedDate);
		attributeGetterFunctions.put(
			"categoryId", AssetCategoryProperty::getCategoryId);
		attributeSetterBiConsumers.put(
			"categoryId",
			(BiConsumer<AssetCategoryProperty, Long>)
				AssetCategoryProperty::setCategoryId);
		attributeGetterFunctions.put("key", AssetCategoryProperty::getKey);
		attributeSetterBiConsumers.put(
			"key",
			(BiConsumer<AssetCategoryProperty, String>)
				AssetCategoryProperty::setKey);
		attributeGetterFunctions.put("value", AssetCategoryProperty::getValue);
		attributeSetterBiConsumers.put(
			"value",
			(BiConsumer<AssetCategoryProperty, String>)
				AssetCategoryProperty::setValue);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	@Override
	public void setCtCollectionId(long ctCollectionId) {
		_ctCollectionId = ctCollectionId;
	}

	@JSON
	@Override
	public long getCategoryPropertyId() {
		return _categoryPropertyId;
	}

	@Override
	public void setCategoryPropertyId(long categoryPropertyId) {
		_categoryPropertyId = categoryPropertyId;
	}

	@JSON
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

	@JSON
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

	@JSON
	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask |= CATEGORYID_COLUMN_BITMASK;

		if (!_setOriginalCategoryId) {
			_setOriginalCategoryId = true;

			_originalCategoryId = _categoryId;
		}

		_categoryId = categoryId;
	}

	public long getOriginalCategoryId() {
		return _originalCategoryId;
	}

	@JSON
	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_columnBitmask = -1L;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
	}

	@JSON
	@Override
	public String getValue() {
		if (_value == null) {
			return "";
		}
		else {
			return _value;
		}
	}

	@Override
	public void setValue(String value) {
		_value = value;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AssetCategoryProperty.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AssetCategoryProperty toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AssetCategoryProperty>
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
		AssetCategoryPropertyImpl assetCategoryPropertyImpl =
			new AssetCategoryPropertyImpl();

		assetCategoryPropertyImpl.setMvccVersion(getMvccVersion());
		assetCategoryPropertyImpl.setCtCollectionId(getCtCollectionId());
		assetCategoryPropertyImpl.setCategoryPropertyId(
			getCategoryPropertyId());
		assetCategoryPropertyImpl.setCompanyId(getCompanyId());
		assetCategoryPropertyImpl.setUserId(getUserId());
		assetCategoryPropertyImpl.setUserName(getUserName());
		assetCategoryPropertyImpl.setCreateDate(getCreateDate());
		assetCategoryPropertyImpl.setModifiedDate(getModifiedDate());
		assetCategoryPropertyImpl.setCategoryId(getCategoryId());
		assetCategoryPropertyImpl.setKey(getKey());
		assetCategoryPropertyImpl.setValue(getValue());

		assetCategoryPropertyImpl.resetOriginalValues();

		return assetCategoryPropertyImpl;
	}

	@Override
	public int compareTo(AssetCategoryProperty assetCategoryProperty) {
		int value = 0;

		value = getKey().compareTo(assetCategoryProperty.getKey());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssetCategoryProperty)) {
			return false;
		}

		AssetCategoryProperty assetCategoryProperty =
			(AssetCategoryProperty)obj;

		long primaryKey = assetCategoryProperty.getPrimaryKey();

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
		AssetCategoryPropertyModelImpl assetCategoryPropertyModelImpl = this;

		assetCategoryPropertyModelImpl._originalCompanyId =
			assetCategoryPropertyModelImpl._companyId;

		assetCategoryPropertyModelImpl._setOriginalCompanyId = false;

		assetCategoryPropertyModelImpl._setModifiedDate = false;

		assetCategoryPropertyModelImpl._originalCategoryId =
			assetCategoryPropertyModelImpl._categoryId;

		assetCategoryPropertyModelImpl._setOriginalCategoryId = false;

		assetCategoryPropertyModelImpl._originalKey =
			assetCategoryPropertyModelImpl._key;

		assetCategoryPropertyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AssetCategoryProperty> toCacheModel() {
		AssetCategoryPropertyCacheModel assetCategoryPropertyCacheModel =
			new AssetCategoryPropertyCacheModel();

		assetCategoryPropertyCacheModel.mvccVersion = getMvccVersion();

		assetCategoryPropertyCacheModel.ctCollectionId = getCtCollectionId();

		assetCategoryPropertyCacheModel.categoryPropertyId =
			getCategoryPropertyId();

		assetCategoryPropertyCacheModel.companyId = getCompanyId();

		assetCategoryPropertyCacheModel.userId = getUserId();

		assetCategoryPropertyCacheModel.userName = getUserName();

		String userName = assetCategoryPropertyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			assetCategoryPropertyCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			assetCategoryPropertyCacheModel.createDate = createDate.getTime();
		}
		else {
			assetCategoryPropertyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			assetCategoryPropertyCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			assetCategoryPropertyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		assetCategoryPropertyCacheModel.categoryId = getCategoryId();

		assetCategoryPropertyCacheModel.key = getKey();

		String key = assetCategoryPropertyCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			assetCategoryPropertyCacheModel.key = null;
		}

		assetCategoryPropertyCacheModel.value = getValue();

		String value = assetCategoryPropertyCacheModel.value;

		if ((value != null) && (value.length() == 0)) {
			assetCategoryPropertyCacheModel.value = null;
		}

		return assetCategoryPropertyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AssetCategoryProperty, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AssetCategoryProperty, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetCategoryProperty, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((AssetCategoryProperty)this));
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
		Map<String, Function<AssetCategoryProperty, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AssetCategoryProperty, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AssetCategoryProperty, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((AssetCategoryProperty)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AssetCategoryProperty>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _mvccVersion;
	private long _ctCollectionId;
	private long _categoryPropertyId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _categoryId;
	private long _originalCategoryId;
	private boolean _setOriginalCategoryId;
	private String _key;
	private String _originalKey;
	private String _value;
	private long _columnBitmask;
	private AssetCategoryProperty _escapedModel;

}