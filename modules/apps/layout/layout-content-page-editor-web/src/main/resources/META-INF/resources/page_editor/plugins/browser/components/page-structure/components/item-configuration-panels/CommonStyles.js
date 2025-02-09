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

import classNames from 'classnames';
import PropTypes from 'prop-types';
import React from 'react';

import {COMMON_STYLES_ROLES} from '../../../../../../app/config/constants/commonStylesRoles';
import {LAYOUT_DATA_ITEM_TYPES} from '../../../../../../app/config/constants/layoutDataItemTypes';
import {config} from '../../../../../../app/config/index';
import {
	useDispatch,
	useSelector,
} from '../../../../../../app/contexts/StoreContext';
import selectSegmentsExperienceId from '../../../../../../app/selectors/selectSegmentsExperienceId';
import updateItemStyle from '../../../../../../app/utils/updateItemStyle';
import {FieldSet} from './FieldSet';

export function CommonStyles({
	className,
	commonStylesValues,
	role = COMMON_STYLES_ROLES.styles,
	item,
}) {
	const {commonStyles} = config;
	const dispatch = useDispatch();
	const segmentsExperienceId = useSelector(selectSegmentsExperienceId);
	const selectedViewportSize = useSelector(
		(state) => state.selectedViewportSize
	);

	let styles = commonStyles;

	styles = styles.filter((fieldSet) =>
		role === COMMON_STYLES_ROLES.general
			? fieldSet.configurationRole === COMMON_STYLES_ROLES.general
			: fieldSet.configurationRole !== COMMON_STYLES_ROLES.general
	);

	if (item.type === LAYOUT_DATA_ITEM_TYPES.collection) {
		styles = styles.filter((fieldSet) =>
			fieldSet.styles.find((field) => field.name === 'display')
		);
	}

	return (
		<>
			<h1 className="sr-only">{Liferay.Language.get('common-styles')}</h1>
			<div
				className={classNames('page-editor__common-styles', className)}
			>
				{styles.map((fieldSet, index) => {
					return (
						<FieldSet
							fields={fieldSet.styles}
							item={item}
							key={index}
							label={fieldSet.label}
							languageId={config.defaultLanguageId}
							onValueSelect={(name, value) =>
								updateItemStyle({
									dispatch,
									itemId: item.itemId,
									segmentsExperienceId,
									selectedViewportSize,
									styleName: name,
									styleValue: value,
								})
							}
							values={commonStylesValues}
						/>
					);
				})}
			</div>
		</>
	);
}

CommonStyles.propTypes = {
	commonStylesValues: PropTypes.object.isRequired,
	item: PropTypes.object.isRequired,
};
