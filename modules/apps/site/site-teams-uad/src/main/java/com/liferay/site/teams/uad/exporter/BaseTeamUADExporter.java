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

package com.liferay.site.teams.uad.exporter;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.model.Team;
import com.liferay.portal.kernel.service.TeamLocalService;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.site.teams.uad.constants.SiteTeamsUADConstants;
import com.liferay.user.associated.data.exporter.DynamicQueryUADExporter;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the team UAD exporter.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link TeamUADExporter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseTeamUADExporter
	extends DynamicQueryUADExporter<Team> {

	@Override
	public Class<Team> getTypeClass() {
		return Team.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return teamLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return SiteTeamsUADConstants.USER_ID_FIELD_NAMES_TEAM;
	}

	@Override
	protected String toXmlString(Team team) {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portal.kernel.model.Team");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>teamId</column-name><column-value><![CDATA[");
		sb.append(team.getTeamId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(team.getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(team.getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	@Reference
	protected TeamLocalService teamLocalService;

}