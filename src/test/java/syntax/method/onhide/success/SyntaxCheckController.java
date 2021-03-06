/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package syntax.method.onhide.success;

import org.wcardinal.controller.annotation.Controller;
import org.wcardinal.controller.annotation.OnHide;

@Controller
public class SyntaxCheckController {
	@OnHide
	void onHideA1(){}

	@OnHide
	void onHideA2( final String parameter ){}

	@OnHide
	void onHideA3( final Object parameter ){}
}
