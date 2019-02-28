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

package com.liferay.screens.service.base;

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
import com.liferay.portal.kernel.service.persistence.GroupPersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.screens.service.ScreensCommentService;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the screens comment remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.screens.service.impl.ScreensCommentServiceImpl}.
 * </p>
 *
 * @author José Manuel Navarro
 * @see com.liferay.screens.service.impl.ScreensCommentServiceImpl
 * @generated
 */
public abstract class ScreensCommentServiceBaseImpl
	extends BaseServiceImpl
	implements ScreensCommentService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ScreensCommentService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.screens.service.ScreensCommentServiceUtil</code>.
	 */

	/**
	 * Returns the screens asset entry remote service.
	 *
	 * @return the screens asset entry remote service
	 */
	public com.liferay.screens.service.ScreensAssetEntryService
		getScreensAssetEntryService() {

		return screensAssetEntryService;
	}

	/**
	 * Sets the screens asset entry remote service.
	 *
	 * @param screensAssetEntryService the screens asset entry remote service
	 */
	public void setScreensAssetEntryService(
		com.liferay.screens.service.ScreensAssetEntryService
			screensAssetEntryService) {

		this.screensAssetEntryService = screensAssetEntryService;
	}

	/**
	 * Returns the screens comment remote service.
	 *
	 * @return the screens comment remote service
	 */
	public ScreensCommentService getScreensCommentService() {
		return screensCommentService;
	}

	/**
	 * Sets the screens comment remote service.
	 *
	 * @param screensCommentService the screens comment remote service
	 */
	public void setScreensCommentService(
		ScreensCommentService screensCommentService) {

		this.screensCommentService = screensCommentService;
	}

	/**
	 * Returns the screens ddl record remote service.
	 *
	 * @return the screens ddl record remote service
	 */
	public com.liferay.screens.service.ScreensDDLRecordService
		getScreensDDLRecordService() {

		return screensDDLRecordService;
	}

	/**
	 * Sets the screens ddl record remote service.
	 *
	 * @param screensDDLRecordService the screens ddl record remote service
	 */
	public void setScreensDDLRecordService(
		com.liferay.screens.service.ScreensDDLRecordService
			screensDDLRecordService) {

		this.screensDDLRecordService = screensDDLRecordService;
	}

	/**
	 * Returns the screens ddm structure version remote service.
	 *
	 * @return the screens ddm structure version remote service
	 */
	public com.liferay.screens.service.ScreensDDMStructureVersionService
		getScreensDDMStructureVersionService() {

		return screensDDMStructureVersionService;
	}

	/**
	 * Sets the screens ddm structure version remote service.
	 *
	 * @param screensDDMStructureVersionService the screens ddm structure version remote service
	 */
	public void setScreensDDMStructureVersionService(
		com.liferay.screens.service.ScreensDDMStructureVersionService
			screensDDMStructureVersionService) {

		this.screensDDMStructureVersionService =
			screensDDMStructureVersionService;
	}

	/**
	 * Returns the screens journal article remote service.
	 *
	 * @return the screens journal article remote service
	 */
	public com.liferay.screens.service.ScreensJournalArticleService
		getScreensJournalArticleService() {

		return screensJournalArticleService;
	}

	/**
	 * Sets the screens journal article remote service.
	 *
	 * @param screensJournalArticleService the screens journal article remote service
	 */
	public void setScreensJournalArticleService(
		com.liferay.screens.service.ScreensJournalArticleService
			screensJournalArticleService) {

		this.screensJournalArticleService = screensJournalArticleService;
	}

	/**
	 * Returns the screens ratings entry remote service.
	 *
	 * @return the screens ratings entry remote service
	 */
	public com.liferay.screens.service.ScreensRatingsEntryService
		getScreensRatingsEntryService() {

		return screensRatingsEntryService;
	}

	/**
	 * Sets the screens ratings entry remote service.
	 *
	 * @param screensRatingsEntryService the screens ratings entry remote service
	 */
	public void setScreensRatingsEntryService(
		com.liferay.screens.service.ScreensRatingsEntryService
			screensRatingsEntryService) {

		this.screensRatingsEntryService = screensRatingsEntryService;
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
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.kernel.service.GroupLocalService
		getGroupLocalService() {

		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.kernel.service.GroupLocalService groupLocalService) {

		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.kernel.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.kernel.service.GroupService groupService) {

		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
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
		return ScreensCommentService.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

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
		type = com.liferay.screens.service.ScreensAssetEntryService.class
	)
	protected com.liferay.screens.service.ScreensAssetEntryService
		screensAssetEntryService;

	@BeanReference(type = ScreensCommentService.class)
	protected ScreensCommentService screensCommentService;

	@BeanReference(
		type = com.liferay.screens.service.ScreensDDLRecordService.class
	)
	protected com.liferay.screens.service.ScreensDDLRecordService
		screensDDLRecordService;

	@BeanReference(
		type = com.liferay.screens.service.ScreensDDMStructureVersionService.class
	)
	protected com.liferay.screens.service.ScreensDDMStructureVersionService
		screensDDMStructureVersionService;

	@BeanReference(
		type = com.liferay.screens.service.ScreensJournalArticleService.class
	)
	protected com.liferay.screens.service.ScreensJournalArticleService
		screensJournalArticleService;

	@BeanReference(
		type = com.liferay.screens.service.ScreensRatingsEntryService.class
	)
	protected com.liferay.screens.service.ScreensRatingsEntryService
		screensRatingsEntryService;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.GroupLocalService.class
	)
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.GroupService.class
	)
	protected com.liferay.portal.kernel.service.GroupService groupService;

	@ServiceReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;

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

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

}