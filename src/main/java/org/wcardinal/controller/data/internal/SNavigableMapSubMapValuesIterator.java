/*
 * Copyright (C) 2019 Toshiba Corporation
 * SPDX-License-Identifier: Apache-2.0
 */

package org.wcardinal.controller.data.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;

import org.wcardinal.util.thread.AutoCloseableReentrantLock;
import org.wcardinal.util.thread.Unlocker;

class SNavigableMapSubMapValuesIterator<V> implements Iterator<V> {
	final SMapContainer<V> container;
	final NavigableMap<String, V> map;
	final NavigableMap<String, V> internalMap;
	final AutoCloseableReentrantLock lock;
	final Iterator<Map.Entry<String, V>> iterator;
	Map.Entry<String, V> current = null;

	public SNavigableMapSubMapValuesIterator( final SMapContainer<V> container,
			final NavigableMap<String, V> map, final NavigableMap<String, V> internalMap,
			final Iterator<Map.Entry<String, V>> itr ){
		this.container = container;
		this.map = map;
		this.internalMap = internalMap;
		this.lock = container.getLock();
		this.iterator = itr;
	}

	@Override
	public boolean hasNext() {
		try( final AutoCloseableReentrantLock closeable = lock.open() ) {
			return iterator.hasNext();
		}
	}

	@Override
	public V next() {
		try( final AutoCloseableReentrantLock closeable = lock.open() ) {
			current = iterator.next();
			return ( current != null ? current.getValue() : null );
		}
	}

	@Override
	public void remove() {
		try( final Unlocker unlocker = container.lock() ) {
			if( current != null ){
				final String key = current.getKey();
				iterator.remove();
				container.onRemove( key );
				container.onChange();
				current = null;
			}
		}
	}
}
