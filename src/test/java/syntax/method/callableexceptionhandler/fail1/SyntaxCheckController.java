/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package syntax.method.callableexceptionhandler.fail1;

import org.wcardinal.controller.annotation.CallableExceptionHandler;
import org.wcardinal.controller.annotation.Controller;

@Controller
public class SyntaxCheckController {
	@CallableExceptionHandler( "foo" )
	void handler(){}
}
