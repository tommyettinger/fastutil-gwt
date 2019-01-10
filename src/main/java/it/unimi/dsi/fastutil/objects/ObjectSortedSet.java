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
package it.unimi.dsi.fastutil.objects;
import java.util.SortedSet;
import java.util.Collection;
/** A type-specific {@link SortedSet}; provides some additional methods that use polymorphism to avoid (un)boxing.
 *
 * <P>Additionally, this interface strengthens {@link #iterator()},
 * {@link #comparator()} (for primitive types), {@link SortedSet#subSet(Object,Object)}, 
 * {@link SortedSet#headSet(Object)} and {@link SortedSet#tailSet(Object)}.
 *
 * @see SortedSet
 */
public interface ObjectSortedSet <K> extends ObjectSet <K>, SortedSet<K> {
 /** Returns a type-specific {@link it.unimi.dsi.fastutil.BidirectionalIterator} on the elements in
	 * this set, starting from a given element of the domain (optional operation).
	 *
	 * <P>This method returns a type-specific bidirectional iterator with given
	 * starting point. The starting point is any element comparable to the
	 * elements of this set (even if it does not actually belong to the
	 * set). The next element of the returned iterator is the least element of
	 * the set that is greater than the starting point (if there are no
	 * elements greater than the starting point, {@link
	 * it.unimi.dsi.fastutil.BidirectionalIterator#hasNext() hasNext()} will return
	 * <code>false</code>). The previous element of the returned iterator is
	 * the greatest element of the set that is smaller than or equal to the
	 * starting point (if there are no elements smaller than or equal to the
	 * starting point, {@link it.unimi.dsi.fastutil.BidirectionalIterator#hasPrevious()
	 * hasPrevious()} will return <code>false</code>).
	 *  
	 * <P>Note that passing the last element of the set as starting point and
	 * calling {@link it.unimi.dsi.fastutil.BidirectionalIterator#previous() previous()} you can traverse the
	 * entire set in reverse order.
	 *
	 * @param fromElement an element to start from.
	 * @return a bidirectional iterator on the element in this set, starting at the given element.
	 * @throws UnsupportedOperationException if this set does not support iterators with a starting point.
	 */
 ObjectBidirectionalIterator <K> iterator( K fromElement );
 /** Returns a type-specific {@link it.unimi.dsi.fastutil.BidirectionalIterator} iterator on the collection.
	 *
	 * <P>The iterator returned by the {@link #iterator()} method and by this
	 * method are identical; however, using this method you can save a type casting.
	 *
	 * Note that this specification strengthens the one given in the corresponding type-specific
	 * {@link Collection}.
	 *
	 * @deprecated As of <code>fastutil</code> 5, replaced by {@link #iterator()}.
	 */
 @Deprecated
 ObjectBidirectionalIterator <K> objectIterator();
 /** Returns a type-specific {@link it.unimi.dsi.fastutil.BidirectionalIterator} on the elements in
	 * this set.
	 *
	 * <P>This method returns a parameterised bidirectional iterator. The iterator
	 * can be moreover safely cast to a type-specific iterator.
	 *
	 * Note that this specification strengthens the one given in the corresponding type-specific
	 * {@link Collection}.
	 *
	 * @return a bidirectional iterator on the element in this set. 
	 */
 ObjectBidirectionalIterator <K> iterator();
 /** Returns a view of the portion of this sorted set whose elements range from <code>fromElement</code>, inclusive, to <code>toElement</code>, exclusive.
	 *
	 * <P>Note that this specification strengthens the one given in {@link SortedSet#subSet(Object,Object)}.
	 *
	 * @see SortedSet#subSet(Object,Object)
	 */
 ObjectSortedSet <K> subSet( K fromElement, K toElement) ;
 /** Returns a view of the portion of this sorted set whose elements are strictly less than <code>toElement</code>.
	 *
	 * <P>Note that this specification strengthens the one given in {@link SortedSet#headSet(Object)}.
	 *
	 * @see SortedSet#headSet(Object)
	 */
 ObjectSortedSet <K> headSet( K toElement );
 /** Returns a view of the portion of this sorted set whose elements are greater than or equal to <code>fromElement</code>.
	 *
	 * <P>Note that this specification strengthens the one given in {@link SortedSet#tailSet(Object)}.
	 *
	 * @see SortedSet#tailSet(Object)
	 */
 ObjectSortedSet <K> tailSet( K fromElement );
}
