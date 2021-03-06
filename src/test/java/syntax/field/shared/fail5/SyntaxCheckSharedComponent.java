/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package syntax.field.shared.fail5;

import org.wcardinal.controller.annotation.SharedComponent;
import org.wcardinal.controller.data.SString;
import org.wcardinal.controller.data.annotation.Historical;

@SharedComponent
public class SyntaxCheckSharedComponent {
	@Historical
	SString field_string_readonly;
}
