/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

import { isArray } from "../../../util/lang/is-array";
import { Properties } from "../../internal/properties";
import { Lock } from "../../lock";
import { SScalarMemory } from "./s-scalar-memory";
import { SScalarParentMemory } from "./s-scalar-parent-memory";
import { SType } from "./s-type";
import { WrapperConstructor } from "./wrapper-constructor";

export class SArrayNodeMemory extends SScalarMemory<unknown[]> {
	constructor(
		parent: SScalarParentMemory, name: string, properties: Properties,
		lock: Lock, wrapperConstructor: WrapperConstructor
	) {
		super( parent, name, properties, lock, wrapperConstructor, SType.ARRAY_NODE );
	}

	cast_( value: unknown ): unknown[] | null {
		if( isArray(value) ) {
			return value;
		}

		return null;
	}
}
