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
 * Copyright (C) 2003-2016 Sebastiano Vigna
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
package it.unimi.dsi.fastutil.ints;
/** An abstract class providing basic methods for sorted sets implementing a type-specific interface. */
public abstract class AbstractIntSortedSet extends AbstractIntSet implements IntSortedSet {
 protected AbstractIntSortedSet() {}
 /** Delegates to the corresponding type-specific method.
	 * @deprecated Please use the corresponding type-specific method instead. */
 @Deprecated
 public IntSortedSet headSet( final Integer to ) {
  return headSet( to.intValue() );
 }
 /** Delegates to the corresponding type-specific method.
	 * @deprecated Please use the corresponding type-specific method instead. */
 @Deprecated
 public IntSortedSet tailSet( final Integer from ) {
  return tailSet( from.intValue() );
 }
 /** Delegates to the corresponding type-specific method.
	 * @deprecated Please use the corresponding type-specific method instead. */
 @Deprecated
 public IntSortedSet subSet( final Integer from, final Integer to ) {
  return subSet( from.intValue(), to.intValue() );
 }
 /** Delegates to the corresponding type-specific method.
	 * @deprecated Please use the corresponding type-specific method instead. */
 @Deprecated
 public Integer first() {
  return (Integer.valueOf(firstInt()));
 }
 /** Delegates to the corresponding type-specific method.
	 * @deprecated Please use the corresponding type-specific method instead. */
 @Deprecated
 public Integer last() {
  return (Integer.valueOf(lastInt()));
 }
 /** Delegates to the new covariantly stronger generic method. */
 @Deprecated
 public IntBidirectionalIterator intIterator() {
  return iterator();
 }
 public abstract IntBidirectionalIterator iterator();
}
