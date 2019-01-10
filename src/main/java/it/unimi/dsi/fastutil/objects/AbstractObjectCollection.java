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
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
/** An abstract class providing basic methods for collections implementing a type-specific interface.
 *
 * <P>In particular, this class provide {@link #iterator()}, <code>add()</code>, {@link #remove(Object)} and
 * {@link #contains(Object)} methods that just call the type-specific counterpart. 
 */
public abstract class AbstractObjectCollection <K> extends AbstractCollection<K> implements ObjectCollection <K> {
 protected AbstractObjectCollection() {}
 public Object[] toArray() {
  final Object[] a = new Object[ size() ];
  it.unimi.dsi.fastutil.objects.ObjectIterators.unwrap( iterator(), a );
  return a;
 }
 @SuppressWarnings("unchecked")
 public <T> T[] toArray( T[] a ) {
  final int size = size();
  if ( a.length < size ) a = (T[])java.lang.reflect.Array.newInstance( a.getClass().getComponentType(), size );
  it.unimi.dsi.fastutil.objects.ObjectIterators.unwrap( iterator(), a );
  if ( size < a.length ) a[ size ] = null;
  return a;
 }
 /** Adds all elements of the given collection to this collection.
	 *
	 * @param c a collection.
	 * @return <code>true</code> if this collection changed as a result of the call.
	 */
 public boolean addAll( Collection<? extends K> c ) {
  boolean retVal = false;
  final Iterator<? extends K> i = c.iterator();
  int n = c.size();
  while( n-- != 0 ) if ( add( i.next() ) ) retVal = true;
  return retVal;
 }
 public boolean add( K k ) {
  throw new UnsupportedOperationException();
 }
 /** Delegates to the new covariantly stronger generic method. */
 @Deprecated
 public ObjectIterator <K> objectIterator() {
  return iterator();
 }
 public abstract ObjectIterator <K> iterator();
 /** Checks whether this collection contains all elements from the given collection.
	 *
	 * @param c a collection.
	 * @return <code>true</code> if this collection contains all elements of the argument.
	 */
 public boolean containsAll( Collection<?> c ) {
  int n = c.size();
  final Iterator<?> i = c.iterator();
  while( n-- != 0 ) if ( ! contains( i.next() ) ) return false;
  return true;
 }
 /** Retains in this collection only elements from the given collection.
	 *
	 * @param c a collection.
	 * @return <code>true</code> if this collection changed as a result of the call.
	 */
 public boolean retainAll( Collection<?> c ) {
  boolean retVal = false;
  int n = size();
  final Iterator<?> i = iterator();
  while( n-- != 0 ) {
   if ( ! c.contains( i.next() ) ) {
    i.remove();
    retVal = true;
   }
  }
  return retVal;
 }
 /** Remove from this collection all elements in the given collection.
	 * If the collection is an instance of this class, it uses faster iterators.
	 *
	 * @param c a collection.
	 * @return <code>true</code> if this collection changed as a result of the call.
	 */
 public boolean removeAll( Collection<?> c ) {
  boolean retVal = false;
  int n = c.size();
  final Iterator<?> i = c.iterator();
  while( n-- != 0 ) if ( remove( i.next() ) ) retVal = true;
  return retVal;
 }
 public boolean isEmpty() {
  return size() == 0;
 }
 public String toString() {
  final StringBuilder s = new StringBuilder();
  final ObjectIterator <K> i = iterator();
  int n = size();
  Object k;
  boolean first = true;
  s.append("{");
  while(n-- != 0) {
   if (first) first = false;
   else s.append(", ");
   k = i.next();
   if (this == k) s.append("(this collection)"); else
    s.append(String.valueOf(k));
  }
  s.append("}");
  return s.toString();
 }
}
