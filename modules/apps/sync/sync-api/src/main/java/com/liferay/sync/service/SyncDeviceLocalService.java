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

package com.liferay.sync.service;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.sync.model.SyncDevice;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SyncDevice. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SyncDeviceLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SyncDeviceLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SyncDeviceLocalServiceUtil} to access the sync device local service. Add custom service methods to <code>com.liferay.sync.service.impl.SyncDeviceLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public SyncDevice addSyncDevice(
			long userId, String type, long buildNumber, String hostname,
			int featureSet)
		throws PortalException;

	/**
	 * Adds the sync device to the database. Also notifies the appropriate model listeners.
	 *
	 * @param syncDevice the sync device
	 * @return the sync device that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SyncDevice addSyncDevice(SyncDevice syncDevice);

	/**
	 * Creates a new sync device with the primary key. Does not add the sync device to the database.
	 *
	 * @param syncDeviceId the primary key for the new sync device
	 * @return the new sync device
	 */
	@Transactional(enabled = false)
	public SyncDevice createSyncDevice(long syncDeviceId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the sync device with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syncDeviceId the primary key of the sync device
	 * @return the sync device that was removed
	 * @throws PortalException if a sync device with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SyncDevice deleteSyncDevice(long syncDeviceId)
		throws PortalException;

	/**
	 * Deletes the sync device from the database. Also notifies the appropriate model listeners.
	 *
	 * @param syncDevice the sync device
	 * @return the sync device that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SyncDevice deleteSyncDevice(SyncDevice syncDevice);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sync.model.impl.SyncDeviceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sync.model.impl.SyncDeviceModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SyncDevice fetchSyncDevice(long syncDeviceId);

	/**
	 * Returns the sync device with the matching UUID and company.
	 *
	 * @param uuid the sync device's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sync device, or <code>null</code> if a matching sync device could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SyncDevice fetchSyncDeviceByUuidAndCompanyId(
		String uuid, long companyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the sync device with the primary key.
	 *
	 * @param syncDeviceId the primary key of the sync device
	 * @return the sync device
	 * @throws PortalException if a sync device with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SyncDevice getSyncDevice(long syncDeviceId) throws PortalException;

	/**
	 * Returns the sync device with the matching UUID and company.
	 *
	 * @param uuid the sync device's UUID
	 * @param companyId the primary key of the company
	 * @return the matching sync device
	 * @throws PortalException if a matching sync device could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SyncDevice getSyncDeviceByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the sync devices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.sync.model.impl.SyncDeviceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of sync devices
	 * @param end the upper bound of the range of sync devices (not inclusive)
	 * @return the range of sync devices
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SyncDevice> getSyncDevices(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SyncDevice> getSyncDevices(
			long userId, int start, int end,
			OrderByComparator orderByComparator)
		throws PortalException;

	/**
	 * Returns the number of sync devices.
	 *
	 * @return the number of sync devices
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSyncDevicesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SyncDevice> search(
		long companyId, String keywords, int start, int end,
		OrderByComparator<SyncDevice> orderByComparator);

	public void updateStatus(long syncDeviceId, int status)
		throws PortalException;

	public SyncDevice updateSyncDevice(
			long syncDeviceId, String type, long buildNumber, int featureSet,
			String hostname, int status)
		throws PortalException;

	/**
	 * Updates the sync device in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param syncDevice the sync device
	 * @return the sync device that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SyncDevice updateSyncDevice(SyncDevice syncDevice);

}