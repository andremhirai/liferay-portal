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

package com.liferay.mobile.device.rules.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.mobile.device.rules.model.MDRRuleGroup;
import com.liferay.mobile.device.rules.service.MDRRuleGroupLocalService;
import com.liferay.mobile.device.rules.service.persistence.MDRRuleGroupFinder;
import com.liferay.mobile.device.rules.service.persistence.MDRRuleGroupPersistence;
import com.liferay.mobile.device.rules.service.persistence.MDRRulePersistence;
import com.liferay.portal.aop.AopService;
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
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the mdr rule group local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.mobile.device.rules.service.impl.MDRRuleGroupLocalServiceImpl}.
 * </p>
 *
 * @author Edward C. Han
 * @see com.liferay.mobile.device.rules.service.impl.MDRRuleGroupLocalServiceImpl
 * @generated
 */
public abstract class MDRRuleGroupLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, MDRRuleGroupLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>MDRRuleGroupLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.mobile.device.rules.service.MDRRuleGroupLocalServiceUtil</code>.
	 */

	/**
	 * Adds the mdr rule group to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRuleGroup the mdr rule group
	 * @return the mdr rule group that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MDRRuleGroup addMDRRuleGroup(MDRRuleGroup mdrRuleGroup) {
		mdrRuleGroup.setNew(true);

		return mdrRuleGroupPersistence.update(mdrRuleGroup);
	}

	/**
	 * Creates a new mdr rule group with the primary key. Does not add the mdr rule group to the database.
	 *
	 * @param ruleGroupId the primary key for the new mdr rule group
	 * @return the new mdr rule group
	 */
	@Override
	@Transactional(enabled = false)
	public MDRRuleGroup createMDRRuleGroup(long ruleGroupId) {
		return mdrRuleGroupPersistence.create(ruleGroupId);
	}

	/**
	 * Deletes the mdr rule group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleGroupId the primary key of the mdr rule group
	 * @return the mdr rule group that was removed
	 * @throws PortalException if a mdr rule group with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MDRRuleGroup deleteMDRRuleGroup(long ruleGroupId)
		throws PortalException {

		return mdrRuleGroupPersistence.remove(ruleGroupId);
	}

	/**
	 * Deletes the mdr rule group from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRuleGroup the mdr rule group
	 * @return the mdr rule group that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public MDRRuleGroup deleteMDRRuleGroup(MDRRuleGroup mdrRuleGroup) {
		return mdrRuleGroupPersistence.remove(mdrRuleGroup);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			MDRRuleGroup.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return mdrRuleGroupPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRRuleGroupModelImpl</code>.
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

		return mdrRuleGroupPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRRuleGroupModelImpl</code>.
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

		return mdrRuleGroupPersistence.findWithDynamicQuery(
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
		return mdrRuleGroupPersistence.countWithDynamicQuery(dynamicQuery);
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

		return mdrRuleGroupPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public MDRRuleGroup fetchMDRRuleGroup(long ruleGroupId) {
		return mdrRuleGroupPersistence.fetchByPrimaryKey(ruleGroupId);
	}

	/**
	 * Returns the mdr rule group matching the UUID and group.
	 *
	 * @param uuid the mdr rule group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching mdr rule group, or <code>null</code> if a matching mdr rule group could not be found
	 */
	@Override
	public MDRRuleGroup fetchMDRRuleGroupByUuidAndGroupId(
		String uuid, long groupId) {

		return mdrRuleGroupPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the mdr rule group with the primary key.
	 *
	 * @param ruleGroupId the primary key of the mdr rule group
	 * @return the mdr rule group
	 * @throws PortalException if a mdr rule group with the primary key could not be found
	 */
	@Override
	public MDRRuleGroup getMDRRuleGroup(long ruleGroupId)
		throws PortalException {

		return mdrRuleGroupPersistence.findByPrimaryKey(ruleGroupId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(mdrRuleGroupLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MDRRuleGroup.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ruleGroupId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			mdrRuleGroupLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(MDRRuleGroup.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"ruleGroupId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(mdrRuleGroupLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(MDRRuleGroup.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("ruleGroupId");
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

		exportActionableDynamicQuery.setGroupId(
			portletDataContext.getScopeGroupId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<MDRRuleGroup>() {

				@Override
				public void performAction(MDRRuleGroup mdrRuleGroup)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, mdrRuleGroup);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(MDRRuleGroup.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return mdrRuleGroupLocalService.deleteMDRRuleGroup(
			(MDRRuleGroup)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return mdrRuleGroupPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the mdr rule groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the mdr rule groups
	 * @param companyId the primary key of the company
	 * @return the matching mdr rule groups, or an empty list if no matches were found
	 */
	@Override
	public List<MDRRuleGroup> getMDRRuleGroupsByUuidAndCompanyId(
		String uuid, long companyId) {

		return mdrRuleGroupPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of mdr rule groups matching the UUID and company.
	 *
	 * @param uuid the UUID of the mdr rule groups
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of mdr rule groups
	 * @param end the upper bound of the range of mdr rule groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching mdr rule groups, or an empty list if no matches were found
	 */
	@Override
	public List<MDRRuleGroup> getMDRRuleGroupsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MDRRuleGroup> orderByComparator) {

		return mdrRuleGroupPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the mdr rule group matching the UUID and group.
	 *
	 * @param uuid the mdr rule group's UUID
	 * @param groupId the primary key of the group
	 * @return the matching mdr rule group
	 * @throws PortalException if a matching mdr rule group could not be found
	 */
	@Override
	public MDRRuleGroup getMDRRuleGroupByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return mdrRuleGroupPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the mdr rule groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.mobile.device.rules.model.impl.MDRRuleGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of mdr rule groups
	 * @param end the upper bound of the range of mdr rule groups (not inclusive)
	 * @return the range of mdr rule groups
	 */
	@Override
	public List<MDRRuleGroup> getMDRRuleGroups(int start, int end) {
		return mdrRuleGroupPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of mdr rule groups.
	 *
	 * @return the number of mdr rule groups
	 */
	@Override
	public int getMDRRuleGroupsCount() {
		return mdrRuleGroupPersistence.countAll();
	}

	/**
	 * Updates the mdr rule group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mdrRuleGroup the mdr rule group
	 * @return the mdr rule group that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public MDRRuleGroup updateMDRRuleGroup(MDRRuleGroup mdrRuleGroup) {
		return mdrRuleGroupPersistence.update(mdrRuleGroup);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			MDRRuleGroupLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		mdrRuleGroupLocalService = (MDRRuleGroupLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return MDRRuleGroupLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return MDRRuleGroup.class;
	}

	protected String getModelClassName() {
		return MDRRuleGroup.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = mdrRuleGroupPersistence.getDataSource();

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

	protected MDRRuleGroupLocalService mdrRuleGroupLocalService;

	@Reference
	protected MDRRuleGroupPersistence mdrRuleGroupPersistence;

	@Reference
	protected MDRRuleGroupFinder mdrRuleGroupFinder;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected MDRRulePersistence mdrRulePersistence;

	@Reference
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}