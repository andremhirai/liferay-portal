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

package com.liferay.account.admin.web.internal.dao.search;

import com.liferay.account.admin.web.internal.display.AccountEntryDisplay;
import com.liferay.account.model.AccountEntry;
import com.liferay.account.service.AccountEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.search.BaseModelSearchResult;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LinkedHashMapBuilder;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.vulcan.util.TransformUtil;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author Pei-Jung Lan
 */
public class AccountEntryDisplaySearchContainerFactory {

	public static SearchContainer create(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		return _create(
			liferayPortletRequest, liferayPortletResponse,
			new LinkedHashMap<>());
	}

	public static SearchContainer create(
		long userId, LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse) {

		LinkedHashMap<String, Object> params =
			LinkedHashMapBuilder.<String, Object>put(
				"accountUserIds", new long[] {userId}
			).build();

		return _create(liferayPortletRequest, liferayPortletResponse, params);
	}

	private static SearchContainer _create(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		LinkedHashMap<String, Object> params) {

		SearchContainer accountEntryDisplaySearchContainer =
			new SearchContainer(
				liferayPortletRequest, liferayPortletResponse.createRenderURL(),
				null, "no-accounts-were-found");

		accountEntryDisplaySearchContainer.setId("accountEntries");

		String orderByCol = ParamUtil.getString(
			liferayPortletRequest, "orderByCol", "name");

		accountEntryDisplaySearchContainer.setOrderByCol(orderByCol);

		String orderByType = ParamUtil.getString(
			liferayPortletRequest, "orderByType", "asc");

		accountEntryDisplaySearchContainer.setOrderByType(orderByType);

		accountEntryDisplaySearchContainer.setOrderByComparator(
			_getOrderByComparator(orderByCol, orderByType));

		accountEntryDisplaySearchContainer.setRowChecker(
			new EmptyOnClickRowChecker(liferayPortletResponse));

		ThemeDisplay themeDisplay =
			(ThemeDisplay)liferayPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		String keywords = ParamUtil.getString(
			liferayPortletRequest, "keywords", null);

		String navigation = ParamUtil.getString(
			liferayPortletRequest, "navigation", "active");

		params.put("status", _getStatus(navigation));

		BaseModelSearchResult<AccountEntry> baseModelSearchResult =
			AccountEntryLocalServiceUtil.search(
				themeDisplay.getCompanyId(), keywords, params,
				accountEntryDisplaySearchContainer.getStart(),
				accountEntryDisplaySearchContainer.getDelta(),
				accountEntryDisplaySearchContainer.getOrderByCol(),
				_isReverseOrder(
					accountEntryDisplaySearchContainer.getOrderByType()));

		List<AccountEntryDisplay> accountEntryDisplays =
			TransformUtil.transform(
				baseModelSearchResult.getBaseModels(), AccountEntryDisplay::of);

		accountEntryDisplaySearchContainer.setResults(accountEntryDisplays);

		accountEntryDisplaySearchContainer.setTotal(
			baseModelSearchResult.getLength());

		return accountEntryDisplaySearchContainer;
	}

	private static OrderByComparator _getOrderByComparator(
		String orderByCol, String orderByType) {

		if (Objects.equals(orderByCol, "name")) {
			return OrderByComparatorFactoryUtil.create(
				"AccountEntry", orderByCol, Objects.equals(orderByType, "asc"));
		}

		return null;
	}

	private static int _getStatus(String navigation) {
		if (Objects.equals(navigation, "inactive")) {
			return WorkflowConstants.STATUS_INACTIVE;
		}

		return WorkflowConstants.STATUS_APPROVED;
	}

	private static boolean _isReverseOrder(String orderByType) {
		if (Objects.equals(orderByType, "desc")) {
			return true;
		}

		return false;
	}

}