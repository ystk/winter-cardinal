/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

import { Exception } from "./exception";

/**
 * Thrown to indicate that there are no element.
 *
 *     throw NoSuchElementException.create();
 *
 * Must use `isInstance` static method instead of the `instanceof` to check
 * whether an error is an instance of this class.
 * This limitation comes from the fact that the custom exceptions inheriting
 * from the Error class are not printed well in the console.
 *
 *     const e = NoSuchElementException.create();
 *
 *     console.log( e instanceof NoSuchElementException ); // => false
 *     console.log( NoSuchElementException.isInstance( e ) ); // => true
 */
export class NoSuchElementException extends Exception {
	constructor() {
		super();
	}

	static getId(): string {
		return "NoSuchElementException";
	}

	static getMessage(): string {
		return "no such element";
	}
}
