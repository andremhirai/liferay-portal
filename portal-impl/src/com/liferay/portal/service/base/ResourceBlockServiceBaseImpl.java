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

package com.liferay.portal.service.base;

import com.liferay.counter.kernel.service.persistence.CounterPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.ResourceBlock;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.ResourceBlockService;
import com.liferay.portal.kernel.service.persistence.ResourceActionPersistence;
import com.liferay.portal.kernel.service.persistence.ResourceBlockFinder;
import com.liferay.portal.kernel.service.persistence.ResourceBlockPermissionPersistence;
import com.liferay.portal.kernel.service.persistence.ResourceBlockPersistence;
import com.liferay.portal.kernel.service.persistence.ResourceTypePermissionFinder;
import com.liferay.portal.kernel.service.persistence.ResourceTypePermissionPersistence;
import com.liferay.portal.kernel.service.persistence.RoleFinder;
import com.liferay.portal.kernel.service.persistence.RolePersistence;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the resource block remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portal.service.impl.ResourceBlockServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.service.impl.ResourceBlockServiceImpl
 * @deprecated
 * @generated
 */
@Deprecated
public abstract class ResourceBlockServiceBaseImpl
	extends BaseServiceImpl
	implements ResourceBlockService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ResourceBlockService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.portal.kernel.service.ResourceBlockServiceUtil</code>.
	 */

	/**
	 * Returns the resource block local service.
	 *
	 * @return the resource block local service
	 */
	public com.liferay.portal.kernel.service.ResourceBlockLocalService
		getResourceBlockLocalService() {

		return resourceBlockLocalService;
	}

	/**
	 * Sets the resource block local service.
	 *
	 * @param resourceBlockLocalService the resource block local service
	 */
	public void setResourceBlockLocalService(
		com.liferay.portal.kernel.service.ResourceBlockLocalService
			resourceBlockLocalService) {

		this.resourceBlockLocalService = resourceBlockLocalService;
	}

	/**
	 * Returns the resource block remote service.
	 *
	 * @return the resource block remote service
	 */
	public ResourceBlockService getResourceBlockService() {
		return resourceBlockService;
	}

	/**
	 * Sets the resource block remote service.
	 *
	 * @param resourceBlockService the resource block remote service
	 */
	public void setResourceBlockService(
		ResourceBlockService resourceBlockService) {

		this.resourceBlockService = resourceBlockService;
	}

	/**
	 * Returns the resource block persistence.
	 *
	 * @return the resource block persistence
	 */
	public ResourceBlockPersistence getResourceBlockPersistence() {
		return resourceBlockPersistence;
	}

	/**
	 * Sets the resource block persistence.
	 *
	 * @param resourceBlockPersistence the resource block persistence
	 */
	public void setResourceBlockPersistence(
		ResourceBlockPersistence resourceBlockPersistence) {

		this.resourceBlockPersistence = resourceBlockPersistence;
	}

	/**
	 * Returns the resource block finder.
	 *
	 * @return the resource block finder
	 */
	public ResourceBlockFinder getResourceBlockFinder() {
		return resourceBlockFinder;
	}

	/**
	 * Sets the resource block finder.
	 *
	 * @param resourceBlockFinder the resource block finder
	 */
	public void setResourceBlockFinder(
		ResourceBlockFinder resourceBlockFinder) {

		this.resourceBlockFinder = resourceBlockFinder;
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
	 * Returns the counter persistence.
	 *
	 * @return the counter persistence
	 */
	public CounterPersistence getCounterPersistence() {
		return counterPersistence;
	}

	/**
	 * Sets the counter persistence.
	 *
	 * @param counterPersistence the counter persistence
	 */
	public void setCounterPersistence(CounterPersistence counterPersistence) {
		this.counterPersistence = counterPersistence;
	}

	/**
	 * Returns the permission remote service.
	 *
	 * @return the permission remote service
	 */
	public com.liferay.portal.kernel.service.PermissionService
		getPermissionService() {

		return permissionService;
	}

	/**
	 * Sets the permission remote service.
	 *
	 * @param permissionService the permission remote service
	 */
	public void setPermissionService(
		com.liferay.portal.kernel.service.PermissionService permissionService) {

		this.permissionService = permissionService;
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
	 * Returns the resource action local service.
	 *
	 * @return the resource action local service
	 */
	public com.liferay.portal.kernel.service.ResourceActionLocalService
		getResourceActionLocalService() {

		return resourceActionLocalService;
	}

	/**
	 * Sets the resource action local service.
	 *
	 * @param resourceActionLocalService the resource action local service
	 */
	public void setResourceActionLocalService(
		com.liferay.portal.kernel.service.ResourceActionLocalService
			resourceActionLocalService) {

		this.resourceActionLocalService = resourceActionLocalService;
	}

	/**
	 * Returns the resource action persistence.
	 *
	 * @return the resource action persistence
	 */
	public ResourceActionPersistence getResourceActionPersistence() {
		return resourceActionPersistence;
	}

	/**
	 * Sets the resource action persistence.
	 *
	 * @param resourceActionPersistence the resource action persistence
	 */
	public void setResourceActionPersistence(
		ResourceActionPersistence resourceActionPersistence) {

		this.resourceActionPersistence = resourceActionPersistence;
	}

	/**
	 * Returns the resource block permission local service.
	 *
	 * @return the resource block permission local service
	 */
	public com.liferay.portal.kernel.service.ResourceBlockPermissionLocalService
		getResourceBlockPermissionLocalService() {

		return resourceBlockPermissionLocalService;
	}

	/**
	 * Sets the resource block permission local service.
	 *
	 * @param resourceBlockPermissionLocalService the resource block permission local service
	 */
	public void setResourceBlockPermissionLocalService(
		com.liferay.portal.kernel.service.ResourceBlockPermissionLocalService
			resourceBlockPermissionLocalService) {

		this.resourceBlockPermissionLocalService =
			resourceBlockPermissionLocalService;
	}

	/**
	 * Returns the resource block permission persistence.
	 *
	 * @return the resource block permission persistence
	 */
	public ResourceBlockPermissionPersistence
		getResourceBlockPermissionPersistence() {

		return resourceBlockPermissionPersistence;
	}

	/**
	 * Sets the resource block permission persistence.
	 *
	 * @param resourceBlockPermissionPersistence the resource block permission persistence
	 */
	public void setResourceBlockPermissionPersistence(
		ResourceBlockPermissionPersistence resourceBlockPermissionPersistence) {

		this.resourceBlockPermissionPersistence =
			resourceBlockPermissionPersistence;
	}

	/**
	 * Returns the resource type permission local service.
	 *
	 * @return the resource type permission local service
	 */
	public com.liferay.portal.kernel.service.ResourceTypePermissionLocalService
		getResourceTypePermissionLocalService() {

		return resourceTypePermissionLocalService;
	}

	/**
	 * Sets the resource type permission local service.
	 *
	 * @param resourceTypePermissionLocalService the resource type permission local service
	 */
	public void setResourceTypePermissionLocalService(
		com.liferay.portal.kernel.service.ResourceTypePermissionLocalService
			resourceTypePermissionLocalService) {

		this.resourceTypePermissionLocalService =
			resourceTypePermissionLocalService;
	}

	/**
	 * Returns the resource type permission persistence.
	 *
	 * @return the resource type permission persistence
	 */
	public ResourceTypePermissionPersistence
		getResourceTypePermissionPersistence() {

		return resourceTypePermissionPersistence;
	}

	/**
	 * Sets the resource type permission persistence.
	 *
	 * @param resourceTypePermissionPersistence the resource type permission persistence
	 */
	public void setResourceTypePermissionPersistence(
		ResourceTypePermissionPersistence resourceTypePermissionPersistence) {

		this.resourceTypePermissionPersistence =
			resourceTypePermissionPersistence;
	}

	/**
	 * Returns the resource type permission finder.
	 *
	 * @return the resource type permission finder
	 */
	public ResourceTypePermissionFinder getResourceTypePermissionFinder() {
		return resourceTypePermissionFinder;
	}

	/**
	 * Sets the resource type permission finder.
	 *
	 * @param resourceTypePermissionFinder the resource type permission finder
	 */
	public void setResourceTypePermissionFinder(
		ResourceTypePermissionFinder resourceTypePermissionFinder) {

		this.resourceTypePermissionFinder = resourceTypePermissionFinder;
	}

	/**
	 * Returns the role local service.
	 *
	 * @return the role local service
	 */
	public com.liferay.portal.kernel.service.RoleLocalService
		getRoleLocalService() {

		return roleLocalService;
	}

	/**
	 * Sets the role local service.
	 *
	 * @param roleLocalService the role local service
	 */
	public void setRoleLocalService(
		com.liferay.portal.kernel.service.RoleLocalService roleLocalService) {

		this.roleLocalService = roleLocalService;
	}

	/**
	 * Returns the role remote service.
	 *
	 * @return the role remote service
	 */
	public com.liferay.portal.kernel.service.RoleService getRoleService() {
		return roleService;
	}

	/**
	 * Sets the role remote service.
	 *
	 * @param roleService the role remote service
	 */
	public void setRoleService(
		com.liferay.portal.kernel.service.RoleService roleService) {

		this.roleService = roleService;
	}

	/**
	 * Returns the role persistence.
	 *
	 * @return the role persistence
	 */
	public RolePersistence getRolePersistence() {
		return rolePersistence;
	}

	/**
	 * Sets the role persistence.
	 *
	 * @param rolePersistence the role persistence
	 */
	public void setRolePersistence(RolePersistence rolePersistence) {
		this.rolePersistence = rolePersistence;
	}

	/**
	 * Returns the role finder.
	 *
	 * @return the role finder
	 */
	public RoleFinder getRoleFinder() {
		return roleFinder;
	}

	/**
	 * Sets the role finder.
	 *
	 * @param roleFinder the role finder
	 */
	public void setRoleFinder(RoleFinder roleFinder) {
		this.roleFinder = roleFinder;
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
		return ResourceBlockService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ResourceBlock.class;
	}

	protected String getModelClassName() {
		return ResourceBlock.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = resourceBlockPersistence.getDataSource();

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
		type = com.liferay.portal.kernel.service.ResourceBlockLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceBlockLocalService
		resourceBlockLocalService;

	@BeanReference(type = ResourceBlockService.class)
	protected ResourceBlockService resourceBlockService;

	@BeanReference(type = ResourceBlockPersistence.class)
	protected ResourceBlockPersistence resourceBlockPersistence;

	@BeanReference(type = ResourceBlockFinder.class)
	protected ResourceBlockFinder resourceBlockFinder;

	@BeanReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@BeanReference(type = CounterPersistence.class)
	protected CounterPersistence counterPersistence;

	@BeanReference(
		type = com.liferay.portal.kernel.service.PermissionService.class
	)
	protected com.liferay.portal.kernel.service.PermissionService
		permissionService;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ResourceActionLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceActionLocalService
		resourceActionLocalService;

	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ResourceBlockPermissionLocalService.class
	)
	protected
		com.liferay.portal.kernel.service.ResourceBlockPermissionLocalService
			resourceBlockPermissionLocalService;

	@BeanReference(type = ResourceBlockPermissionPersistence.class)
	protected ResourceBlockPermissionPersistence
		resourceBlockPermissionPersistence;

	@BeanReference(
		type = com.liferay.portal.kernel.service.ResourceTypePermissionLocalService.class
	)
	protected
		com.liferay.portal.kernel.service.ResourceTypePermissionLocalService
			resourceTypePermissionLocalService;

	@BeanReference(type = ResourceTypePermissionPersistence.class)
	protected ResourceTypePermissionPersistence
		resourceTypePermissionPersistence;

	@BeanReference(type = ResourceTypePermissionFinder.class)
	protected ResourceTypePermissionFinder resourceTypePermissionFinder;

	@BeanReference(
		type = com.liferay.portal.kernel.service.RoleLocalService.class
	)
	protected com.liferay.portal.kernel.service.RoleLocalService
		roleLocalService;

	@BeanReference(type = com.liferay.portal.kernel.service.RoleService.class)
	protected com.liferay.portal.kernel.service.RoleService roleService;

	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;

	@BeanReference(type = RoleFinder.class)
	protected RoleFinder roleFinder;

}