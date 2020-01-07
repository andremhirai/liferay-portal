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

package com.liferay.asset.kernel.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedGroupedModel;
import com.liferay.portal.kernel.model.change.tracking.CTModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AssetCategory service. Represents a row in the &quot;AssetCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.portlet.asset.model.impl.AssetCategoryModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.portlet.asset.model.impl.AssetCategoryImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetCategory
 * @generated
 */
@ProviderType
public interface AssetCategoryModel
	extends BaseModel<AssetCategory>, CTModel<AssetCategory>, LocalizedModel,
			MVCCModel, ShardedModel, StagedGroupedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a asset category model instance should use the {@link AssetCategory} interface instead.
	 */

	/**
	 * Returns the primary key of this asset category.
	 *
	 * @return the primary key of this asset category
	 */
	@Override
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this asset category.
	 *
	 * @param primaryKey the primary key of this asset category
	 */
	@Override
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the mvcc version of this asset category.
	 *
	 * @return the mvcc version of this asset category
	 */
	@Override
	public long getMvccVersion();

	/**
	 * Sets the mvcc version of this asset category.
	 *
	 * @param mvccVersion the mvcc version of this asset category
	 */
	@Override
	public void setMvccVersion(long mvccVersion);

	/**
	 * Returns the ct collection ID of this asset category.
	 *
	 * @return the ct collection ID of this asset category
	 */
	@Override
	public long getCtCollectionId();

	/**
	 * Sets the ct collection ID of this asset category.
	 *
	 * @param ctCollectionId the ct collection ID of this asset category
	 */
	@Override
	public void setCtCollectionId(long ctCollectionId);

	/**
	 * Returns the uuid of this asset category.
	 *
	 * @return the uuid of this asset category
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this asset category.
	 *
	 * @param uuid the uuid of this asset category
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the external reference code of this asset category.
	 *
	 * @return the external reference code of this asset category
	 */
	@AutoEscape
	public String getExternalReferenceCode();

	/**
	 * Sets the external reference code of this asset category.
	 *
	 * @param externalReferenceCode the external reference code of this asset category
	 */
	public void setExternalReferenceCode(String externalReferenceCode);

	/**
	 * Returns the category ID of this asset category.
	 *
	 * @return the category ID of this asset category
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this asset category.
	 *
	 * @param categoryId the category ID of this asset category
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the group ID of this asset category.
	 *
	 * @return the group ID of this asset category
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this asset category.
	 *
	 * @param groupId the group ID of this asset category
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this asset category.
	 *
	 * @return the company ID of this asset category
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this asset category.
	 *
	 * @param companyId the company ID of this asset category
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this asset category.
	 *
	 * @return the user ID of this asset category
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this asset category.
	 *
	 * @param userId the user ID of this asset category
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this asset category.
	 *
	 * @return the user uuid of this asset category
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this asset category.
	 *
	 * @param userUuid the user uuid of this asset category
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this asset category.
	 *
	 * @return the user name of this asset category
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this asset category.
	 *
	 * @param userName the user name of this asset category
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this asset category.
	 *
	 * @return the create date of this asset category
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this asset category.
	 *
	 * @param createDate the create date of this asset category
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this asset category.
	 *
	 * @return the modified date of this asset category
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this asset category.
	 *
	 * @param modifiedDate the modified date of this asset category
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the parent category ID of this asset category.
	 *
	 * @return the parent category ID of this asset category
	 */
	public long getParentCategoryId();

	/**
	 * Sets the parent category ID of this asset category.
	 *
	 * @param parentCategoryId the parent category ID of this asset category
	 */
	public void setParentCategoryId(long parentCategoryId);

	/**
	 * Returns the tree path of this asset category.
	 *
	 * @return the tree path of this asset category
	 */
	@AutoEscape
	public String getTreePath();

	/**
	 * Sets the tree path of this asset category.
	 *
	 * @param treePath the tree path of this asset category
	 */
	public void setTreePath(String treePath);

	/**
	 * Returns the name of this asset category.
	 *
	 * @return the name of this asset category
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this asset category.
	 *
	 * @param name the name of this asset category
	 */
	public void setName(String name);

	/**
	 * Returns the title of this asset category.
	 *
	 * @return the title of this asset category
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this asset category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this asset category
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this asset category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this asset category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this asset category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this asset category
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this asset category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this asset category
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this asset category.
	 *
	 * @return the locales and localized titles of this asset category
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this asset category.
	 *
	 * @param title the title of this asset category
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this asset category in the language.
	 *
	 * @param title the localized title of this asset category
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this asset category in the language, and sets the default locale.
	 *
	 * @param title the localized title of this asset category
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this asset category from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this asset category
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this asset category from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this asset category
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this asset category.
	 *
	 * @return the description of this asset category
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this asset category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this asset category
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this asset category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this asset category. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this asset category in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this asset category
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this asset category in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this asset category
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this asset category.
	 *
	 * @return the locales and localized descriptions of this asset category
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this asset category.
	 *
	 * @param description the description of this asset category
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this asset category in the language.
	 *
	 * @param description the localized description of this asset category
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this asset category in the language, and sets the default locale.
	 *
	 * @param description the localized description of this asset category
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(
		String description, Locale locale, Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this asset category from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this asset category
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this asset category from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this asset category
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale);

	/**
	 * Returns the vocabulary ID of this asset category.
	 *
	 * @return the vocabulary ID of this asset category
	 */
	public long getVocabularyId();

	/**
	 * Sets the vocabulary ID of this asset category.
	 *
	 * @param vocabularyId the vocabulary ID of this asset category
	 */
	public void setVocabularyId(long vocabularyId);

	/**
	 * Returns the last publish date of this asset category.
	 *
	 * @return the last publish date of this asset category
	 */
	@Override
	public Date getLastPublishDate();

	/**
	 * Sets the last publish date of this asset category.
	 *
	 * @param lastPublishDate the last publish date of this asset category
	 */
	@Override
	public void setLastPublishDate(Date lastPublishDate);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}