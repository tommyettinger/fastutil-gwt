/* Copyright (C) 1991-2014 Free Software Foundation, Inc.
   This file is part of the GNU C Library.

   The GNU C Library is free software; you can redistribute it and/or
   modify it under the terms of the GNU Lesser General Public
   License as published by the Free Software Foundation; either
   version 2.1 of the License, or (at your option) any later version.

   The GNU C Library is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
   Lesser General Public License for more details.

   You should have received a copy of the GNU Lesser General Public
   License along with the GNU C Library; if not, see
   <http://www.gnu.org/licenses/>.  */
/* This header is separate from features.h so that the compiler can
   include it implicitly at the start of every compilation.  It must
   not itself include <features.h> or any other header that includes
   <features.h> because the implicit include comes before any feature
   test macros that may be defined in a source file before it first
   explicitly includes a system header.  GCC knows the name of this
   header in order to preinclude it.  */
/* glibc's intent is to support the IEC 559 math functionality, real
   and complex.  If the GCC (4.9 and later) predefined macros
   specifying compiler intent are available, use them to determine
   whether the overall intent is to support these features; otherwise,
   presume an older compiler has intent to support these features and
   define these macros by default.  */
/* wchar_t uses ISO/IEC 10646 (2nd ed., published 2011-03-15) /
   Unicode 6.0.  */
/* We do not support C11 <threads.h>.  */
/* Generic definitions */
/* Assertions (useful to generate conditional code) */
/* Current type and class (and size, if applicable) */
/* Value methods */
/* Interfaces (keys) */
/* Interfaces (values) */
/* Abstract implementations (keys) */
/* Abstract implementations (values) */
/* Static containers (keys) */
/* Static containers (values) */
/* Implementations */
/* Synchronized wrappers */
/* Unmodifiable wrappers */
/* Other wrappers */
/* Methods (keys) */
/* Methods (values) */
/* Methods (keys/values) */
/* Methods that have special names depending on keys (but the special names depend on values) */
/* Equality */
/* Object/Reference-only definitions (keys) */
/* Primitive-type-only definitions (keys) */
/* Object/Reference-only definitions (values) */
/*		 
 * Copyright (C) 2002-2016 Sebastiano Vigna
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package it.unimi.dsi.fastutil.longs;
import it.unimi.dsi.fastutil.objects.ObjectCollection;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.util.Map;
/** A type-specific {@link Map}; provides some additional methods that use polymorphism to avoid (un)boxing, and handling of a default return value.
 *
 * <P>Besides extending the corresponding type-specific {@linkplain it.unimi.dsi.fastutil.Function function}, this interface strengthens {@link #entrySet()},
 * {@link #keySet()} and {@link #values()}. Maps returning entry sets of type {@link FastEntrySet} support also fast iteration.
 *
 * <P>A submap or subset may or may not have an
 * independent default return value (which however must be initialized to the
 * default return value of the originator).
 *
 * @see Map
 */
public interface Long2ObjectMap <V> extends Long2ObjectFunction <V>, Map<Long,V> {
 /** An entry set providing fast iteration. 
	 *
	 * <p>In some cases (e.g., hash-based classes) iteration over an entry set requires the creation
	 * of a large number of {@link java.util.Map.Entry} objects. Some <code>fastutil</code>
	 * maps might return {@linkplain #entrySet() entry set} objects of type <code>FastEntrySet</code>: in this case, {@link #fastIterator() fastIterator()}
	 * will return an iterator that is guaranteed not to create a large number of objects, <em>possibly
	 * by returning always the same entry</em> (of course, mutated).
	 */
 public interface FastEntrySet <V> extends ObjectSet<Long2ObjectMap.Entry <V> > {
  /** Returns a fast iterator over this entry set; the iterator might return always the same entry object, suitably mutated.
		 *
		 * @return a fast iterator over this entry set; the iterator might return always the same {@link java.util.Map.Entry} object, suitably mutated.
		 */
  public ObjectIterator<Long2ObjectMap.Entry <V> > fastIterator();
 }
 /** Returns a set view of the mappings contained in this map.
	 *  <P>Note that this specification strengthens the one given in {@link Map#entrySet()}.
	 *
	 * @return a set view of the mappings contained in this map.
	 * @see Map#entrySet()
	 */
 ObjectSet<Map.Entry<Long, V>> entrySet();
 /** Returns a type-specific set view of the mappings contained in this map.
	 *
	 * <p>This method is necessary because there is no inheritance along
	 * type parameters: it is thus impossible to strengthen {@link #entrySet()}
	 * so that it returns an {@link it.unimi.dsi.fastutil.objects.ObjectSet}
	 * of type-specific entries (the latter makes it possible to
	 * access keys and values with type-specific methods).
	 *
	 * @return a type-specific set view of the mappings contained in this map.
	 * @see #entrySet()
	 */
 ObjectSet<Long2ObjectMap.Entry <V> > long2ObjectEntrySet();
 /** Returns a set view of the keys contained in this map.
	 *  <P>Note that this specification strengthens the one given in {@link Map#keySet()}.
	 *
	 * @return a set view of the keys contained in this map.
	 * @see Map#keySet()
	 */
 LongSet keySet();
 /** Returns a set view of the values contained in this map.
	 *  <P>Note that this specification strengthens the one given in {@link Map#values()}.
	 *
	 * @return a set view of the values contained in this map.
	 * @see Map#values()
	 */
 ObjectCollection <V> values();
 /** A type-specific {@link java.util.Map.Entry}; provides some additional methods
	 *  that use polymorphism to avoid (un)boxing.
	 *
	 * @see java.util.Map.Entry
	 */
 interface Entry <V> extends Map.Entry <Long,V> {
  /** {@inheritDoc}
		 * @deprecated Please use the corresponding type-specific method instead. */
  @Deprecated
  @Override
  Long getKey();
  /**
		 * @see java.util.Map.Entry#getKey()
		 */
  long getLongKey();
 }
}
