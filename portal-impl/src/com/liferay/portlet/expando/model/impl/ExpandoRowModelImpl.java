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

package com.liferay.portlet.expando.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoRow;
import com.liferay.expando.kernel.model.ExpandoRowModel;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the ExpandoRow service. Represents a row in the &quot;ExpandoRow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>ExpandoRowModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpandoRowImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoRowImpl
 * @generated
 */
@ProviderType
public class ExpandoRowModelImpl
	extends BaseModelImpl<ExpandoRow> implements ExpandoRowModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expando row model instance should use the <code>ExpandoRow</code> interface instead.
	 */
	public static final String TABLE_NAME = "ExpandoRow";

	public static final Object[][] TABLE_COLUMNS = {
		{"rowId_", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"tableId", Types.BIGINT},
		{"classPK", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("rowId_", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("tableId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ExpandoRow (rowId_ LONG not null primary key,companyId LONG,modifiedDate DATE null,tableId LONG,classPK LONG)";

	public static final String TABLE_SQL_DROP = "drop table ExpandoRow";

	public static final String ORDER_BY_JPQL = " ORDER BY expandoRow.rowId ASC";

	public static final String ORDER_BY_SQL = " ORDER BY ExpandoRow.rowId_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.entity.cache.enabled.com.liferay.expando.kernel.model.ExpandoRow"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.finder.cache.enabled.com.liferay.expando.kernel.model.ExpandoRow"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.portal.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.com.liferay.expando.kernel.model.ExpandoRow"),
		true);

	public static final long CLASSPK_COLUMN_BITMASK = 1L;

	public static final long TABLEID_COLUMN_BITMASK = 2L;

	public static final long ROWID_COLUMN_BITMASK = 4L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.portal.util.PropsUtil.get(
			"lock.expiration.time.com.liferay.expando.kernel.model.ExpandoRow"));

	public ExpandoRowModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _rowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ExpandoRow.class;
	}

	@Override
	public String getModelClassName() {
		return ExpandoRow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((ExpandoRow)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ExpandoRow, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ExpandoRow, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ExpandoRow)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ExpandoRow, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ExpandoRow, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<ExpandoRow, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ExpandoRow, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ExpandoRow, Object>>();
		Map<String, BiConsumer<ExpandoRow, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ExpandoRow, ?>>();

		attributeGetterFunctions.put(
			"rowId",
			new Function<ExpandoRow, Object>() {

				@Override
				public Object apply(ExpandoRow expandoRow) {
					return expandoRow.getRowId();
				}

			});
		attributeSetterBiConsumers.put(
			"rowId",
			new BiConsumer<ExpandoRow, Object>() {

				@Override
				public void accept(ExpandoRow expandoRow, Object rowId) {
					expandoRow.setRowId((Long)rowId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<ExpandoRow, Object>() {

				@Override
				public Object apply(ExpandoRow expandoRow) {
					return expandoRow.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<ExpandoRow, Object>() {

				@Override
				public void accept(ExpandoRow expandoRow, Object companyId) {
					expandoRow.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<ExpandoRow, Object>() {

				@Override
				public Object apply(ExpandoRow expandoRow) {
					return expandoRow.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<ExpandoRow, Object>() {

				@Override
				public void accept(ExpandoRow expandoRow, Object modifiedDate) {
					expandoRow.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"tableId",
			new Function<ExpandoRow, Object>() {

				@Override
				public Object apply(ExpandoRow expandoRow) {
					return expandoRow.getTableId();
				}

			});
		attributeSetterBiConsumers.put(
			"tableId",
			new BiConsumer<ExpandoRow, Object>() {

				@Override
				public void accept(ExpandoRow expandoRow, Object tableId) {
					expandoRow.setTableId((Long)tableId);
				}

			});
		attributeGetterFunctions.put(
			"classPK",
			new Function<ExpandoRow, Object>() {

				@Override
				public Object apply(ExpandoRow expandoRow) {
					return expandoRow.getClassPK();
				}

			});
		attributeSetterBiConsumers.put(
			"classPK",
			new BiConsumer<ExpandoRow, Object>() {

				@Override
				public void accept(ExpandoRow expandoRow, Object classPK) {
					expandoRow.setClassPK((Long)classPK);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getRowId() {
		return _rowId;
	}

	@Override
	public void setRowId(long rowId) {
		_rowId = rowId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getTableId() {
		return _tableId;
	}

	@Override
	public void setTableId(long tableId) {
		_columnBitmask |= TABLEID_COLUMN_BITMASK;

		if (!_setOriginalTableId) {
			_setOriginalTableId = true;

			_originalTableId = _tableId;
		}

		_tableId = tableId;
	}

	public long getOriginalTableId() {
		return _originalTableId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoRow toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ExpandoRow)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExpandoRowImpl expandoRowImpl = new ExpandoRowImpl();

		expandoRowImpl.setRowId(getRowId());
		expandoRowImpl.setCompanyId(getCompanyId());
		expandoRowImpl.setModifiedDate(getModifiedDate());
		expandoRowImpl.setTableId(getTableId());
		expandoRowImpl.setClassPK(getClassPK());

		expandoRowImpl.resetOriginalValues();

		return expandoRowImpl;
	}

	@Override
	public int compareTo(ExpandoRow expandoRow) {
		long primaryKey = expandoRow.getPrimaryKey();

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

		if (!(obj instanceof ExpandoRow)) {
			return false;
		}

		ExpandoRow expandoRow = (ExpandoRow)obj;

		long primaryKey = expandoRow.getPrimaryKey();

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
		ExpandoRowModelImpl expandoRowModelImpl = this;

		expandoRowModelImpl._originalTableId = expandoRowModelImpl._tableId;

		expandoRowModelImpl._setOriginalTableId = false;

		expandoRowModelImpl._originalClassPK = expandoRowModelImpl._classPK;

		expandoRowModelImpl._setOriginalClassPK = false;

		expandoRowModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ExpandoRow> toCacheModel() {
		ExpandoRowCacheModel expandoRowCacheModel = new ExpandoRowCacheModel();

		expandoRowCacheModel.rowId = getRowId();

		expandoRowCacheModel.companyId = getCompanyId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			expandoRowCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			expandoRowCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		expandoRowCacheModel.tableId = getTableId();

		expandoRowCacheModel.classPK = getClassPK();

		return expandoRowCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ExpandoRow)this));
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
		Map<String, Function<ExpandoRow, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ExpandoRow, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ExpandoRow, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ExpandoRow)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		ExpandoRow.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		ExpandoRow.class, ModelWrapper.class
	};

	private long _rowId;
	private long _companyId;
	private Date _modifiedDate;
	private long _tableId;
	private long _originalTableId;
	private boolean _setOriginalTableId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _columnBitmask;
	private ExpandoRow _escapedModel;

}