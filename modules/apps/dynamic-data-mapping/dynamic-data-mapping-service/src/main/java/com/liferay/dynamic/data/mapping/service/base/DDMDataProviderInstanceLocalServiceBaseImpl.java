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

package com.liferay.dynamic.data.mapping.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance;
import com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalService;
import com.liferay.dynamic.data.mapping.service.persistence.DDMDataProviderInstanceFinder;
import com.liferay.dynamic.data.mapping.service.persistence.DDMDataProviderInstanceLinkPersistence;
import com.liferay.dynamic.data.mapping.service.persistence.DDMDataProviderInstancePersistence;
import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ddm data provider instance local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.dynamic.data.mapping.service.impl.DDMDataProviderInstanceLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class DDMDataProviderInstanceLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements DDMDataProviderInstanceLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>DDMDataProviderInstanceLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLocalServiceUtil</code>.
	 */

	/**
	 * Adds the ddm data provider instance to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmDataProviderInstance the ddm data provider instance
	 * @return the ddm data provider instance that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DDMDataProviderInstance addDDMDataProviderInstance(
		DDMDataProviderInstance ddmDataProviderInstance) {

		ddmDataProviderInstance.setNew(true);

		return ddmDataProviderInstancePersistence.update(
			ddmDataProviderInstance);
	}

	/**
	 * Creates a new ddm data provider instance with the primary key. Does not add the ddm data provider instance to the database.
	 *
	 * @param dataProviderInstanceId the primary key for the new ddm data provider instance
	 * @return the new ddm data provider instance
	 */
	@Override
	@Transactional(enabled = false)
	public DDMDataProviderInstance createDDMDataProviderInstance(
		long dataProviderInstanceId) {

		return ddmDataProviderInstancePersistence.create(
			dataProviderInstanceId);
	}

	/**
	 * Deletes the ddm data provider instance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataProviderInstanceId the primary key of the ddm data provider instance
	 * @return the ddm data provider instance that was removed
	 * @throws PortalException if a ddm data provider instance with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DDMDataProviderInstance deleteDDMDataProviderInstance(
			long dataProviderInstanceId)
		throws PortalException {

		return ddmDataProviderInstancePersistence.remove(
			dataProviderInstanceId);
	}

	/**
	 * Deletes the ddm data provider instance from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ddmDataProviderInstance the ddm data provider instance
	 * @return the ddm data provider instance that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public DDMDataProviderInstance deleteDDMDataProviderInstance(
		DDMDataProviderInstance ddmDataProviderInstance) {

		return ddmDataProviderInstancePersistence.remove(
			ddmDataProviderInstance);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			DDMDataProviderInstance.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ddmDataProviderInstancePersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.dynamic.data.mapping.model.impl.DDMDataProviderInstanceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return ddmDataProviderInstancePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.dynamic.data.mapping.model.impl.DDMDataProviderInstanceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return ddmDataProviderInstancePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return ddmDataProviderInstancePersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return ddmDataProviderInstancePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public DDMDataProviderInstance fetchDDMDataProviderInstance(
		long dataProviderInstanceId) {

		return ddmDataProviderInstancePersistence.fetchByPrimaryKey(
			dataProviderInstanceId);
	}

	/**
	 * Returns the ddm data provider instance matching the UUID and group.
	 *
	 * @param uuid the ddm data provider instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ddm data provider instance, or <code>null</code> if a matching ddm data provider instance could not be found
	 */
	@Override
	public DDMDataProviderInstance fetchDDMDataProviderInstanceByUuidAndGroupId(
		String uuid, long groupId) {

		return ddmDataProviderInstancePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the ddm data provider instance with the primary key.
	 *
	 * @param dataProviderInstanceId the primary key of the ddm data provider instance
	 * @return the ddm data provider instance
	 * @throws PortalException if a ddm data provider instance with the primary key could not be found
	 */
	@Override
	public DDMDataProviderInstance getDDMDataProviderInstance(
			long dataProviderInstanceId)
		throws PortalException {

		return ddmDataProviderInstancePersistence.findByPrimaryKey(
			dataProviderInstanceId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			ddmDataProviderInstanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DDMDataProviderInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"dataProviderInstanceId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ddmDataProviderInstanceLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			DDMDataProviderInstance.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"dataProviderInstanceId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			ddmDataProviderInstanceLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(DDMDataProviderInstance.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"dataProviderInstanceId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<DDMDataProviderInstance>() {

				@Override
				public void performAction(
						DDMDataProviderInstance ddmDataProviderInstance)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, ddmDataProviderInstance);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					DDMDataProviderInstance.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ddmDataProviderInstanceLocalService.
			deleteDDMDataProviderInstance(
				(DDMDataProviderInstance)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ddmDataProviderInstancePersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the ddm data provider instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ddm data provider instances
	 * @param companyId the primary key of the company
	 * @return the matching ddm data provider instances, or an empty list if no matches were found
	 */
	@Override
	public List<DDMDataProviderInstance>
		getDDMDataProviderInstancesByUuidAndCompanyId(
			String uuid, long companyId) {

		return ddmDataProviderInstancePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of ddm data provider instances matching the UUID and company.
	 *
	 * @param uuid the UUID of the ddm data provider instances
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of ddm data provider instances
	 * @param end the upper bound of the range of ddm data provider instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching ddm data provider instances, or an empty list if no matches were found
	 */
	@Override
	public List<DDMDataProviderInstance>
		getDDMDataProviderInstancesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<DDMDataProviderInstance> orderByComparator) {

		return ddmDataProviderInstancePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the ddm data provider instance matching the UUID and group.
	 *
	 * @param uuid the ddm data provider instance's UUID
	 * @param groupId the primary key of the group
	 * @return the matching ddm data provider instance
	 * @throws PortalException if a matching ddm data provider instance could not be found
	 */
	@Override
	public DDMDataProviderInstance getDDMDataProviderInstanceByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return ddmDataProviderInstancePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the ddm data provider instances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.dynamic.data.mapping.model.impl.DDMDataProviderInstanceModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ddm data provider instances
	 * @param end the upper bound of the range of ddm data provider instances (not inclusive)
	 * @return the range of ddm data provider instances
	 */
	@Override
	public List<DDMDataProviderInstance> getDDMDataProviderInstances(
		int start, int end) {

		return ddmDataProviderInstancePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ddm data provider instances.
	 *
	 * @return the number of ddm data provider instances
	 */
	@Override
	public int getDDMDataProviderInstancesCount() {
		return ddmDataProviderInstancePersistence.countAll();
	}

	/**
	 * Updates the ddm data provider instance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ddmDataProviderInstance the ddm data provider instance
	 * @return the ddm data provider instance that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public DDMDataProviderInstance updateDDMDataProviderInstance(
		DDMDataProviderInstance ddmDataProviderInstance) {

		return ddmDataProviderInstancePersistence.update(
			ddmDataProviderInstance);
	}

	/**
	 * Returns the ddm data provider instance local service.
	 *
	 * @return the ddm data provider instance local service
	 */
	public DDMDataProviderInstanceLocalService
		getDDMDataProviderInstanceLocalService() {

		return ddmDataProviderInstanceLocalService;
	}

	/**
	 * Sets the ddm data provider instance local service.
	 *
	 * @param ddmDataProviderInstanceLocalService the ddm data provider instance local service
	 */
	public void setDDMDataProviderInstanceLocalService(
		DDMDataProviderInstanceLocalService
			ddmDataProviderInstanceLocalService) {

		this.ddmDataProviderInstanceLocalService =
			ddmDataProviderInstanceLocalService;
	}

	/**
	 * Returns the ddm data provider instance persistence.
	 *
	 * @return the ddm data provider instance persistence
	 */
	public DDMDataProviderInstancePersistence
		getDDMDataProviderInstancePersistence() {

		return ddmDataProviderInstancePersistence;
	}

	/**
	 * Sets the ddm data provider instance persistence.
	 *
	 * @param ddmDataProviderInstancePersistence the ddm data provider instance persistence
	 */
	public void setDDMDataProviderInstancePersistence(
		DDMDataProviderInstancePersistence ddmDataProviderInstancePersistence) {

		this.ddmDataProviderInstancePersistence =
			ddmDataProviderInstancePersistence;
	}

	/**
	 * Returns the ddm data provider instance finder.
	 *
	 * @return the ddm data provider instance finder
	 */
	public DDMDataProviderInstanceFinder getDDMDataProviderInstanceFinder() {
		return ddmDataProviderInstanceFinder;
	}

	/**
	 * Sets the ddm data provider instance finder.
	 *
	 * @param ddmDataProviderInstanceFinder the ddm data provider instance finder
	 */
	public void setDDMDataProviderInstanceFinder(
		DDMDataProviderInstanceFinder ddmDataProviderInstanceFinder) {

		this.ddmDataProviderInstanceFinder = ddmDataProviderInstanceFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Returns the ddm data provider instance link local service.
	 *
	 * @return the ddm data provider instance link local service
	 */
	public com.liferay.dynamic.data.mapping.service.
		DDMDataProviderInstanceLinkLocalService
			getDDMDataProviderInstanceLinkLocalService() {

		return ddmDataProviderInstanceLinkLocalService;
	}

	/**
	 * Sets the ddm data provider instance link local service.
	 *
	 * @param ddmDataProviderInstanceLinkLocalService the ddm data provider instance link local service
	 */
	public void setDDMDataProviderInstanceLinkLocalService(
		com.liferay.dynamic.data.mapping.service.
			DDMDataProviderInstanceLinkLocalService
				ddmDataProviderInstanceLinkLocalService) {

		this.ddmDataProviderInstanceLinkLocalService =
			ddmDataProviderInstanceLinkLocalService;
	}

	/**
	 * Returns the ddm data provider instance link persistence.
	 *
	 * @return the ddm data provider instance link persistence
	 */
	public DDMDataProviderInstanceLinkPersistence
		getDDMDataProviderInstanceLinkPersistence() {

		return ddmDataProviderInstanceLinkPersistence;
	}

	/**
	 * Sets the ddm data provider instance link persistence.
	 *
	 * @param ddmDataProviderInstanceLinkPersistence the ddm data provider instance link persistence
	 */
	public void setDDMDataProviderInstanceLinkPersistence(
		DDMDataProviderInstanceLinkPersistence
			ddmDataProviderInstanceLinkPersistence) {

		this.ddmDataProviderInstanceLinkPersistence =
			ddmDataProviderInstanceLinkPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance",
			ddmDataProviderInstanceLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.dynamic.data.mapping.model.DDMDataProviderInstance");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return DDMDataProviderInstanceLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return DDMDataProviderInstance.class;
	}

	protected String getModelClassName() {
		return DDMDataProviderInstance.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				ddmDataProviderInstancePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = DDMDataProviderInstanceLocalService.class)
	protected DDMDataProviderInstanceLocalService
		ddmDataProviderInstanceLocalService;

	@BeanReference(type = DDMDataProviderInstancePersistence.class)
	protected DDMDataProviderInstancePersistence
		ddmDataProviderInstancePersistence;

	@BeanReference(type = DDMDataProviderInstanceFinder.class)
	protected DDMDataProviderInstanceFinder ddmDataProviderInstanceFinder;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@BeanReference(
		type = com.liferay.dynamic.data.mapping.service.DDMDataProviderInstanceLinkLocalService.class
	)
	protected com.liferay.dynamic.data.mapping.service.
		DDMDataProviderInstanceLinkLocalService
			ddmDataProviderInstanceLinkLocalService;

	@BeanReference(type = DDMDataProviderInstanceLinkPersistence.class)
	protected DDMDataProviderInstanceLinkPersistence
		ddmDataProviderInstanceLinkPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}