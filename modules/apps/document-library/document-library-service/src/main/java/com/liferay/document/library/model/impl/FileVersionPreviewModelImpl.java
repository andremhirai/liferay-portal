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

package com.liferay.document.library.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.model.FileVersionPreview;
import com.liferay.document.library.model.FileVersionPreviewModel;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the FileVersionPreview service. Represents a row in the &quot;FileVersionPreview&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>FileVersionPreviewModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileVersionPreviewImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileVersionPreviewImpl
 * @generated
 */
@ProviderType
public class FileVersionPreviewModelImpl
	extends BaseModelImpl<FileVersionPreview>
	implements FileVersionPreviewModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a file version preview model instance should use the <code>FileVersionPreview</code> interface instead.
	 */
	public static final String TABLE_NAME = "FileVersionPreview";

	public static final Object[][] TABLE_COLUMNS = {
		{"fileVersionPreviewId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"fileEntryId", Types.BIGINT}, {"fileVersionId", Types.BIGINT},
		{"previewStatus", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("fileVersionPreviewId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fileVersionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("previewStatus", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table FileVersionPreview (fileVersionPreviewId LONG not null primary key,groupId LONG,fileEntryId LONG,fileVersionId LONG,previewStatus INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table FileVersionPreview";

	public static final String ORDER_BY_JPQL =
		" ORDER BY fileVersionPreview.fileVersionPreviewId DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY FileVersionPreview.fileVersionPreviewId DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.document.library.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.document.library.model.FileVersionPreview"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.document.library.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.document.library.model.FileVersionPreview"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.document.library.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.document.library.model.FileVersionPreview"),
		true);

	public static final long FILEENTRYID_COLUMN_BITMASK = 1L;

	public static final long FILEVERSIONID_COLUMN_BITMASK = 2L;

	public static final long PREVIEWSTATUS_COLUMN_BITMASK = 4L;

	public static final long FILEVERSIONPREVIEWID_COLUMN_BITMASK = 8L;

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.document.library.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.document.library.model.FileVersionPreview"));

	public FileVersionPreviewModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _fileVersionPreviewId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileVersionPreviewId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileVersionPreviewId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return FileVersionPreview.class;
	}

	@Override
	public String getModelClassName() {
		return FileVersionPreview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<FileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<FileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((FileVersionPreview)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<FileVersionPreview, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<FileVersionPreview, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(FileVersionPreview)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<FileVersionPreview, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<FileVersionPreview, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, FileVersionPreview>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			FileVersionPreview.class.getClassLoader(), FileVersionPreview.class,
			ModelWrapper.class);

		try {
			Constructor<FileVersionPreview> constructor =
				(Constructor<FileVersionPreview>)proxyClass.getConstructor(
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

	private static final Map<String, Function<FileVersionPreview, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<FileVersionPreview, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<FileVersionPreview, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<FileVersionPreview, Object>>();
		Map<String, BiConsumer<FileVersionPreview, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<FileVersionPreview, ?>>();

		attributeGetterFunctions.put(
			"fileVersionPreviewId",
			new Function<FileVersionPreview, Object>() {

				@Override
				public Object apply(FileVersionPreview fileVersionPreview) {
					return fileVersionPreview.getFileVersionPreviewId();
				}

			});
		attributeSetterBiConsumers.put(
			"fileVersionPreviewId",
			new BiConsumer<FileVersionPreview, Object>() {

				@Override
				public void accept(
					FileVersionPreview fileVersionPreview,
					Object fileVersionPreviewId) {

					fileVersionPreview.setFileVersionPreviewId(
						(Long)fileVersionPreviewId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<FileVersionPreview, Object>() {

				@Override
				public Object apply(FileVersionPreview fileVersionPreview) {
					return fileVersionPreview.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<FileVersionPreview, Object>() {

				@Override
				public void accept(
					FileVersionPreview fileVersionPreview, Object groupId) {

					fileVersionPreview.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"fileEntryId",
			new Function<FileVersionPreview, Object>() {

				@Override
				public Object apply(FileVersionPreview fileVersionPreview) {
					return fileVersionPreview.getFileEntryId();
				}

			});
		attributeSetterBiConsumers.put(
			"fileEntryId",
			new BiConsumer<FileVersionPreview, Object>() {

				@Override
				public void accept(
					FileVersionPreview fileVersionPreview, Object fileEntryId) {

					fileVersionPreview.setFileEntryId((Long)fileEntryId);
				}

			});
		attributeGetterFunctions.put(
			"fileVersionId",
			new Function<FileVersionPreview, Object>() {

				@Override
				public Object apply(FileVersionPreview fileVersionPreview) {
					return fileVersionPreview.getFileVersionId();
				}

			});
		attributeSetterBiConsumers.put(
			"fileVersionId",
			new BiConsumer<FileVersionPreview, Object>() {

				@Override
				public void accept(
					FileVersionPreview fileVersionPreview,
					Object fileVersionId) {

					fileVersionPreview.setFileVersionId((Long)fileVersionId);
				}

			});
		attributeGetterFunctions.put(
			"previewStatus",
			new Function<FileVersionPreview, Object>() {

				@Override
				public Object apply(FileVersionPreview fileVersionPreview) {
					return fileVersionPreview.getPreviewStatus();
				}

			});
		attributeSetterBiConsumers.put(
			"previewStatus",
			new BiConsumer<FileVersionPreview, Object>() {

				@Override
				public void accept(
					FileVersionPreview fileVersionPreview,
					Object previewStatus) {

					fileVersionPreview.setPreviewStatus((Integer)previewStatus);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getFileVersionPreviewId() {
		return _fileVersionPreviewId;
	}

	@Override
	public void setFileVersionPreviewId(long fileVersionPreviewId) {
		_columnBitmask = -1L;

		_fileVersionPreviewId = fileVersionPreviewId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		_columnBitmask |= FILEVERSIONID_COLUMN_BITMASK;

		if (!_setOriginalFileVersionId) {
			_setOriginalFileVersionId = true;

			_originalFileVersionId = _fileVersionId;
		}

		_fileVersionId = fileVersionId;
	}

	public long getOriginalFileVersionId() {
		return _originalFileVersionId;
	}

	@Override
	public int getPreviewStatus() {
		return _previewStatus;
	}

	@Override
	public void setPreviewStatus(int previewStatus) {
		_columnBitmask |= PREVIEWSTATUS_COLUMN_BITMASK;

		if (!_setOriginalPreviewStatus) {
			_setOriginalPreviewStatus = true;

			_originalPreviewStatus = _previewStatus;
		}

		_previewStatus = previewStatus;
	}

	public int getOriginalPreviewStatus() {
		return _originalPreviewStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, FileVersionPreview.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public FileVersionPreview toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FileVersionPreviewImpl fileVersionPreviewImpl =
			new FileVersionPreviewImpl();

		fileVersionPreviewImpl.setFileVersionPreviewId(
			getFileVersionPreviewId());
		fileVersionPreviewImpl.setGroupId(getGroupId());
		fileVersionPreviewImpl.setFileEntryId(getFileEntryId());
		fileVersionPreviewImpl.setFileVersionId(getFileVersionId());
		fileVersionPreviewImpl.setPreviewStatus(getPreviewStatus());

		fileVersionPreviewImpl.resetOriginalValues();

		return fileVersionPreviewImpl;
	}

	@Override
	public int compareTo(FileVersionPreview fileVersionPreview) {
		int value = 0;

		if (getFileVersionPreviewId() <
				fileVersionPreview.getFileVersionPreviewId()) {

			value = -1;
		}
		else if (getFileVersionPreviewId() >
					fileVersionPreview.getFileVersionPreviewId()) {

			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

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

		if (!(obj instanceof FileVersionPreview)) {
			return false;
		}

		FileVersionPreview fileVersionPreview = (FileVersionPreview)obj;

		long primaryKey = fileVersionPreview.getPrimaryKey();

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
		FileVersionPreviewModelImpl fileVersionPreviewModelImpl = this;

		fileVersionPreviewModelImpl._originalFileEntryId =
			fileVersionPreviewModelImpl._fileEntryId;

		fileVersionPreviewModelImpl._setOriginalFileEntryId = false;

		fileVersionPreviewModelImpl._originalFileVersionId =
			fileVersionPreviewModelImpl._fileVersionId;

		fileVersionPreviewModelImpl._setOriginalFileVersionId = false;

		fileVersionPreviewModelImpl._originalPreviewStatus =
			fileVersionPreviewModelImpl._previewStatus;

		fileVersionPreviewModelImpl._setOriginalPreviewStatus = false;

		fileVersionPreviewModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<FileVersionPreview> toCacheModel() {
		FileVersionPreviewCacheModel fileVersionPreviewCacheModel =
			new FileVersionPreviewCacheModel();

		fileVersionPreviewCacheModel.fileVersionPreviewId =
			getFileVersionPreviewId();

		fileVersionPreviewCacheModel.groupId = getGroupId();

		fileVersionPreviewCacheModel.fileEntryId = getFileEntryId();

		fileVersionPreviewCacheModel.fileVersionId = getFileVersionId();

		fileVersionPreviewCacheModel.previewStatus = getPreviewStatus();

		return fileVersionPreviewCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<FileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<FileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((FileVersionPreview)this));
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
		Map<String, Function<FileVersionPreview, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<FileVersionPreview, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<FileVersionPreview, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((FileVersionPreview)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, FileVersionPreview>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _fileVersionPreviewId;
	private long _groupId;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private long _fileVersionId;
	private long _originalFileVersionId;
	private boolean _setOriginalFileVersionId;
	private int _previewStatus;
	private int _originalPreviewStatus;
	private boolean _setOriginalPreviewStatus;
	private long _columnBitmask;
	private FileVersionPreview _escapedModel;

}