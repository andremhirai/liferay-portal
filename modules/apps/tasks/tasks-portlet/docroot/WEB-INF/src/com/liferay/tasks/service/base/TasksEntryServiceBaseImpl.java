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

package com.liferay.tasks.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserNotificationEventPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.social.kernel.service.persistence.SocialActivityPersistence;
import com.liferay.tasks.model.TasksEntry;
import com.liferay.tasks.service.TasksEntryService;
import com.liferay.tasks.service.persistence.TasksEntryFinder;
import com.liferay.tasks.service.persistence.TasksEntryPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the tasks entry remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.tasks.service.impl.TasksEntryServiceImpl}.
 * </p>
 *
 * @author Ryan Park
 * @see com.liferay.tasks.service.impl.TasksEntryServiceImpl
 * @generated
 */
public abstract class TasksEntryServiceBaseImpl
	extends BaseServiceImpl
	implements TasksEntryService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>TasksEntryService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.tasks.service.TasksEntryServiceUtil</code>.
	 */

	/**
	 * Returns the tasks entry local service.
	 *
	 * @return the tasks entry local service
	 */
	public com.liferay.tasks.service.TasksEntryLocalService
		getTasksEntryLocalService() {

		return tasksEntryLocalService;
	}

	/**
	 * Sets the tasks entry local service.
	 *
	 * @param tasksEntryLocalService the tasks entry local service
	 */
	public void setTasksEntryLocalService(
		com.liferay.tasks.service.TasksEntryLocalService
			tasksEntryLocalService) {

		this.tasksEntryLocalService = tasksEntryLocalService;
	}

	/**
	 * Returns the tasks entry remote service.
	 *
	 * @return the tasks entry remote service
	 */
	public TasksEntryService getTasksEntryService() {
		return tasksEntryService;
	}

	/**
	 * Sets the tasks entry remote service.
	 *
	 * @param tasksEntryService the tasks entry remote service
	 */
	public void setTasksEntryService(TasksEntryService tasksEntryService) {
		this.tasksEntryService = tasksEntryService;
	}

	/**
	 * Returns the tasks entry persistence.
	 *
	 * @return the tasks entry persistence
	 */
	public TasksEntryPersistence getTasksEntryPersistence() {
		return tasksEntryPersistence;
	}

	/**
	 * Sets the tasks entry persistence.
	 *
	 * @param tasksEntryPersistence the tasks entry persistence
	 */
	public void setTasksEntryPersistence(
		TasksEntryPersistence tasksEntryPersistence) {

		this.tasksEntryPersistence = tasksEntryPersistence;
	}

	/**
	 * Returns the tasks entry finder.
	 *
	 * @return the tasks entry finder
	 */
	public TasksEntryFinder getTasksEntryFinder() {
		return tasksEntryFinder;
	}

	/**
	 * Sets the tasks entry finder.
	 *
	 * @param tasksEntryFinder the tasks entry finder
	 */
	public void setTasksEntryFinder(TasksEntryFinder tasksEntryFinder) {
		this.tasksEntryFinder = tasksEntryFinder;
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
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
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
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
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
	 * Returns the user notification event local service.
	 *
	 * @return the user notification event local service
	 */
	public com.liferay.portal.kernel.service.UserNotificationEventLocalService
		getUserNotificationEventLocalService() {

		return userNotificationEventLocalService;
	}

	/**
	 * Sets the user notification event local service.
	 *
	 * @param userNotificationEventLocalService the user notification event local service
	 */
	public void setUserNotificationEventLocalService(
		com.liferay.portal.kernel.service.UserNotificationEventLocalService
			userNotificationEventLocalService) {

		this.userNotificationEventLocalService =
			userNotificationEventLocalService;
	}

	/**
	 * Returns the user notification event persistence.
	 *
	 * @return the user notification event persistence
	 */
	public UserNotificationEventPersistence
		getUserNotificationEventPersistence() {

		return userNotificationEventPersistence;
	}

	/**
	 * Sets the user notification event persistence.
	 *
	 * @param userNotificationEventPersistence the user notification event persistence
	 */
	public void setUserNotificationEventPersistence(
		UserNotificationEventPersistence userNotificationEventPersistence) {

		this.userNotificationEventPersistence =
			userNotificationEventPersistence;
	}

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.asset.kernel.service.AssetEntryService
		getAssetEntryService() {

		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.asset.kernel.service.AssetEntryService assetEntryService) {

		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the social activity local service.
	 *
	 * @return the social activity local service
	 */
	public com.liferay.social.kernel.service.SocialActivityLocalService
		getSocialActivityLocalService() {

		return socialActivityLocalService;
	}

	/**
	 * Sets the social activity local service.
	 *
	 * @param socialActivityLocalService the social activity local service
	 */
	public void setSocialActivityLocalService(
		com.liferay.social.kernel.service.SocialActivityLocalService
			socialActivityLocalService) {

		this.socialActivityLocalService = socialActivityLocalService;
	}

	/**
	 * Returns the social activity remote service.
	 *
	 * @return the social activity remote service
	 */
	public com.liferay.social.kernel.service.SocialActivityService
		getSocialActivityService() {

		return socialActivityService;
	}

	/**
	 * Sets the social activity remote service.
	 *
	 * @param socialActivityService the social activity remote service
	 */
	public void setSocialActivityService(
		com.liferay.social.kernel.service.SocialActivityService
			socialActivityService) {

		this.socialActivityService = socialActivityService;
	}

	/**
	 * Returns the social activity persistence.
	 *
	 * @return the social activity persistence
	 */
	public SocialActivityPersistence getSocialActivityPersistence() {
		return socialActivityPersistence;
	}

	/**
	 * Sets the social activity persistence.
	 *
	 * @param socialActivityPersistence the social activity persistence
	 */
	public void setSocialActivityPersistence(
		SocialActivityPersistence socialActivityPersistence) {

		this.socialActivityPersistence = socialActivityPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return TasksEntryService.class.getName();
	}

	protected Class<?> getModelClass() {
		return TasksEntry.class;
	}

	protected String getModelClassName() {
		return TasksEntry.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = tasksEntryPersistence.getDataSource();

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

	@BeanReference(
		type = com.liferay.tasks.service.TasksEntryLocalService.class
	)
	protected com.liferay.tasks.service.TasksEntryLocalService
		tasksEntryLocalService;

	@BeanReference(type = TasksEntryService.class)
	protected TasksEntryService tasksEntryService;

	@BeanReference(type = TasksEntryPersistence.class)
	protected TasksEntryPersistence tasksEntryPersistence;

	@BeanReference(type = TasksEntryFinder.class)
	protected TasksEntryFinder tasksEntryFinder;

	@BeanReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@BeanReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@BeanReference(type = com.liferay.portal.kernel.service.UserService.class)
	protected com.liferay.portal.kernel.service.UserService userService;

	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@BeanReference(
		type = com.liferay.portal.kernel.service.UserNotificationEventLocalService.class
	)
	protected
		com.liferay.portal.kernel.service.UserNotificationEventLocalService
			userNotificationEventLocalService;

	@BeanReference(type = UserNotificationEventPersistence.class)
	protected UserNotificationEventPersistence userNotificationEventPersistence;

	@BeanReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@BeanReference(
		type = com.liferay.asset.kernel.service.AssetEntryService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@BeanReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@BeanReference(
		type = com.liferay.social.kernel.service.SocialActivityLocalService.class
	)
	protected com.liferay.social.kernel.service.SocialActivityLocalService
		socialActivityLocalService;

	@BeanReference(
		type = com.liferay.social.kernel.service.SocialActivityService.class
	)
	protected com.liferay.social.kernel.service.SocialActivityService
		socialActivityService;

	@BeanReference(type = SocialActivityPersistence.class)
	protected SocialActivityPersistence socialActivityPersistence;

}