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

package com.liferay.layout.template.admin.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.layout.template.admin.constants.LayoutTemplateAdminPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jürgen Kapler
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=110",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_BUILD
	},
	service = PanelApp.class
)
public class GroupPageTemplatesPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return LayoutTemplateAdminPortletKeys.GROUP_PAGE_TEMPLATES;
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		if (!group.isCompany()) {
			return false;
		}

		return super.isShow(permissionChecker, group);
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + LayoutTemplateAdminPortletKeys.GROUP_PAGE_TEMPLATES + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}