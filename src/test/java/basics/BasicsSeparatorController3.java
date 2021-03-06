/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package basics;

import org.springframework.beans.factory.annotation.Autowired;

import org.wcardinal.controller.annotation.Controller;

@Controller(separators={}, separatorMessages="--MESSAGE--")
public class BasicsSeparatorController3 {
	@Autowired
	BasicsSeparatorPage page;
}
