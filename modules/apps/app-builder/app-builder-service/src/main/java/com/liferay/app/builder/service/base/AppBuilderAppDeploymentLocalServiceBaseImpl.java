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

package com.liferay.app.builder.service.base;

import com.liferay.app.builder.model.AppBuilderAppDeployment;
import com.liferay.app.builder.service.AppBuilderAppDeploymentLocalService;
import com.liferay.app.builder.service.persistence.AppBuilderAppDeploymentPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
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
 * Provides the base implementation for the app builder app deployment local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.app.builder.service.impl.AppBuilderAppDeploymentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.app.builder.service.impl.AppBuilderAppDeploymentLocalServiceImpl
 * @generated
 */
public abstract class AppBuilderAppDeploymentLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, AppBuilderAppDeploymentLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AppBuilderAppDeploymentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.app.builder.service.AppBuilderAppDeploymentLocalServiceUtil</code>.
	 */

	/**
	 * Adds the app builder app deployment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderAppDeployment the app builder app deployment
	 * @return the app builder app deployment that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppBuilderAppDeployment addAppBuilderAppDeployment(
		AppBuilderAppDeployment appBuilderAppDeployment) {

		appBuilderAppDeployment.setNew(true);

		return appBuilderAppDeploymentPersistence.update(
			appBuilderAppDeployment);
	}

	/**
	 * Creates a new app builder app deployment with the primary key. Does not add the app builder app deployment to the database.
	 *
	 * @param appBuilderAppDeploymentId the primary key for the new app builder app deployment
	 * @return the new app builder app deployment
	 */
	@Override
	@Transactional(enabled = false)
	public AppBuilderAppDeployment createAppBuilderAppDeployment(
		long appBuilderAppDeploymentId) {

		return appBuilderAppDeploymentPersistence.create(
			appBuilderAppDeploymentId);
	}

	/**
	 * Deletes the app builder app deployment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderAppDeploymentId the primary key of the app builder app deployment
	 * @return the app builder app deployment that was removed
	 * @throws PortalException if a app builder app deployment with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AppBuilderAppDeployment deleteAppBuilderAppDeployment(
			long appBuilderAppDeploymentId)
		throws PortalException {

		return appBuilderAppDeploymentPersistence.remove(
			appBuilderAppDeploymentId);
	}

	/**
	 * Deletes the app builder app deployment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderAppDeployment the app builder app deployment
	 * @return the app builder app deployment that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public AppBuilderAppDeployment deleteAppBuilderAppDeployment(
		AppBuilderAppDeployment appBuilderAppDeployment) {

		return appBuilderAppDeploymentPersistence.remove(
			appBuilderAppDeployment);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			AppBuilderAppDeployment.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return appBuilderAppDeploymentPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.model.impl.AppBuilderAppDeploymentModelImpl</code>.
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

		return appBuilderAppDeploymentPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.model.impl.AppBuilderAppDeploymentModelImpl</code>.
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

		return appBuilderAppDeploymentPersistence.findWithDynamicQuery(
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
		return appBuilderAppDeploymentPersistence.countWithDynamicQuery(
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

		return appBuilderAppDeploymentPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public AppBuilderAppDeployment fetchAppBuilderAppDeployment(
		long appBuilderAppDeploymentId) {

		return appBuilderAppDeploymentPersistence.fetchByPrimaryKey(
			appBuilderAppDeploymentId);
	}

	/**
	 * Returns the app builder app deployment with the primary key.
	 *
	 * @param appBuilderAppDeploymentId the primary key of the app builder app deployment
	 * @return the app builder app deployment
	 * @throws PortalException if a app builder app deployment with the primary key could not be found
	 */
	@Override
	public AppBuilderAppDeployment getAppBuilderAppDeployment(
			long appBuilderAppDeploymentId)
		throws PortalException {

		return appBuilderAppDeploymentPersistence.findByPrimaryKey(
			appBuilderAppDeploymentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			appBuilderAppDeploymentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AppBuilderAppDeployment.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"appBuilderAppDeploymentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			appBuilderAppDeploymentLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			AppBuilderAppDeployment.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"appBuilderAppDeploymentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			appBuilderAppDeploymentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(AppBuilderAppDeployment.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName(
			"appBuilderAppDeploymentId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return appBuilderAppDeploymentLocalService.
			deleteAppBuilderAppDeployment(
				(AppBuilderAppDeployment)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return appBuilderAppDeploymentPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the app builder app deployments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.app.builder.model.impl.AppBuilderAppDeploymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of app builder app deployments
	 * @param end the upper bound of the range of app builder app deployments (not inclusive)
	 * @return the range of app builder app deployments
	 */
	@Override
	public List<AppBuilderAppDeployment> getAppBuilderAppDeployments(
		int start, int end) {

		return appBuilderAppDeploymentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of app builder app deployments.
	 *
	 * @return the number of app builder app deployments
	 */
	@Override
	public int getAppBuilderAppDeploymentsCount() {
		return appBuilderAppDeploymentPersistence.countAll();
	}

	/**
	 * Updates the app builder app deployment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param appBuilderAppDeployment the app builder app deployment
	 * @return the app builder app deployment that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public AppBuilderAppDeployment updateAppBuilderAppDeployment(
		AppBuilderAppDeployment appBuilderAppDeployment) {

		return appBuilderAppDeploymentPersistence.update(
			appBuilderAppDeployment);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AppBuilderAppDeploymentLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		appBuilderAppDeploymentLocalService =
			(AppBuilderAppDeploymentLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AppBuilderAppDeploymentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return AppBuilderAppDeployment.class;
	}

	protected String getModelClassName() {
		return AppBuilderAppDeployment.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				appBuilderAppDeploymentPersistence.getDataSource();

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

	protected AppBuilderAppDeploymentLocalService
		appBuilderAppDeploymentLocalService;

	@Reference
	protected AppBuilderAppDeploymentPersistence
		appBuilderAppDeploymentPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

}