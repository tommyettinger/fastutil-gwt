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
 *
 *
 *
 * For the sorting and binary search code:
 *
 * Copyright (C) 1999 CERN - European Organization for Nuclear Research.
 *
 *   Permission to use, copy, modify, distribute and sell this software and
 *   its documentation for any purpose is hereby granted without fee,
 *   provided that the above copyright notice appear in all copies and that
 *   both that copyright notice and this permission notice appear in
 *   supporting documentation. CERN makes no representations about the
 *   suitability of this software for any purpose. It is provided "as is"
 *   without expressed or implied warranty. 
 */
package it.unimi.dsi.fastutil.longs;
import it.unimi.dsi.fastutil.Arrays;
import it.unimi.dsi.fastutil.Hash;

import java.util.Random;
/** A class providing static methods and objects that do useful things with type-specific arrays.
 *
 * <p>In particular, the <code>ensureCapacity()</code>, <code>grow()</code>,
 * <code>trim()</code> and <code>setLength()</code> methods allow to handle
 * arrays much like array lists. This can be very useful when efficiency (or
 * syntactic simplicity) reasons make array lists unsuitable.
 * 
 * @see java.util.Arrays
 */
public class LongArrays {
 private LongArrays() {}
 /** A static, final, empty array. */
 public final static long[] EMPTY_ARRAY = {};
 /** Ensures that an array can contain the given number of entries.
	 *
	 * <P>If you cannot foresee whether this array will need again to be
	 * enlarged, you should probably use <code>grow()</code> instead.
	 *
	 * @param array an array.
	 * @param length the new minimum length for this array.
	 * @return <code>array</code>, if it contains <code>length</code> entries or more; otherwise,
	 * an array with <code>length</code> entries whose first <code>array.length</code>
	 * entries are the same as those of <code>array</code>.
	 */
 public static long[] ensureCapacity( final long[] array, final int length ) {
  if ( length > array.length ) {
      final long[] t =
              new long[length];
   System.arraycopy( array, 0, t, 0, array.length );
   return t;
  }
  return array;
 }
 /** Ensures that an array can contain the given number of entries, preserving just a part of the array.
	 *
	 * @param array an array.
	 * @param length the new minimum length for this array.
	 * @param preserve the number of elements of the array that must be preserved in case a new allocation is necessary.
	 * @return <code>array</code>, if it can contain <code>length</code> entries or more; otherwise,
	 * an array with <code>length</code> entries whose first <code>preserve</code>
	 * entries are the same as those of <code>array</code>.
	 */
 public static long[] ensureCapacity( final long[] array, final int length, final int preserve ) {
  if ( length > array.length ) {
      final long[] t =
              new long[length];
   System.arraycopy( array, 0, t, 0, preserve );
   return t;
  }
  return array;
 }
 /** Grows the given array to the maximum between the given length and
	 * the current length multiplied by two, provided that the given
	 * length is larger than the current length.
	 *
	 * <P>If you want complete control on the array growth, you
	 * should probably use <code>ensureCapacity()</code> instead.
	 *
	 * @param array an array.
	 * @param length the new minimum length for this array.
	 * @return <code>array</code>, if it can contain <code>length</code>
	 * entries; otherwise, an array with
	 * max(<code>length</code>,<code>array.length</code>/&phi;) entries whose first
	 * <code>array.length</code> entries are the same as those of <code>array</code>.
	 * */
 public static long[] grow( final long[] array, final int length ) {
  if ( length > array.length ) {
   final int newLength = (int)Math.max( Math.min( 2L * array.length, Arrays.MAX_ARRAY_SIZE ), length );
      final long[] t =
              new long[newLength];
   System.arraycopy( array, 0, t, 0, array.length );
   return t;
  }
  return array;
 }
 /** Grows the given array to the maximum between the given length and
	 * the current length multiplied by two, provided that the given
	 * length is larger than the current length, preserving just a part of the array.
	 *
	 * <P>If you want complete control on the array growth, you
	 * should probably use <code>ensureCapacity()</code> instead.
	 *
	 * @param array an array.
	 * @param length the new minimum length for this array.
	 * @param preserve the number of elements of the array that must be preserved in case a new allocation is necessary.
	 * @return <code>array</code>, if it can contain <code>length</code>
	 * entries; otherwise, an array with
	 * max(<code>length</code>,<code>array.length</code>/&phi;) entries whose first
	 * <code>preserve</code> entries are the same as those of <code>array</code>.
	 * */
 public static long[] grow( final long[] array, final int length, final int preserve ) {
  if ( length > array.length ) {
   final int newLength = (int)Math.max( Math.min( 2L * array.length, Arrays.MAX_ARRAY_SIZE ), length );
      final long[] t =
              new long[newLength];
   System.arraycopy( array, 0, t, 0, preserve );
   return t;
  }
  return array;
 }
 /** Trims the given array to the given length.
	 *
	 * @param array an array.
	 * @param length the new maximum length for the array.
	 * @return <code>array</code>, if it contains <code>length</code>
	 * entries or less; otherwise, an array with
	 * <code>length</code> entries whose entries are the same as
	 * the first <code>length</code> entries of <code>array</code>.
	 * 
	 */
 public static long[] trim( final long[] array, final int length ) {
  if ( length >= array.length ) return array;
     final long[] t =
             length == 0 ? EMPTY_ARRAY : new long[length];
  System.arraycopy( array, 0, t, 0, length );
  return t;
 }
 /** Sets the length of the given array.
	 *
	 * @param array an array.
	 * @param length the new length for the array.
	 * @return <code>array</code>, if it contains exactly <code>length</code>
	 * entries; otherwise, if it contains <em>more</em> than
	 * <code>length</code> entries, an array with <code>length</code> entries
	 * whose entries are the same as the first <code>length</code> entries of
	 * <code>array</code>; otherwise, an array with <code>length</code> entries
	 * whose first <code>array.length</code> entries are the same as those of
	 * <code>array</code>.
	 * 
	 */
 public static long[] setLength( final long[] array, final int length ) {
  if ( length == array.length ) return array;
  if ( length < array.length ) return trim( array, length );
  return ensureCapacity( array, length );
 }
 /** Returns a copy of a portion of an array.
	 *
	 * @param array an array.
	 * @param offset the first element to copy.
	 * @param length the number of elements to copy.
	 * @return a new array containing <code>length</code> elements of <code>array</code> starting at <code>offset</code>.
	 */
 public static long[] copy( final long[] array, final int offset, final int length ) {
  ensureOffsetLength( array, offset, length );
  final long[] a =
   length == 0 ? EMPTY_ARRAY : new long[ length ];
  System.arraycopy( array, offset, a, 0, length );
  return a;
 }
 /** Returns a copy of an array.
	 *
	 * @param array an array.
	 * @return a copy of <code>array</code>.
	 */
 public static long[] copy( final long[] array ) {
  return array.clone();
 }
 /** Fills the given array with the given value.
	 *
	 * @param array an array.
	 * @param value the new value for all elements of the array.
	 * @deprecated Please use the corresponding {@link java.util.Arrays} method.
	 */
 @Deprecated
 public static void fill( final long[] array, final long value ) {
  int i = array.length;
  while( i-- != 0 ) array[ i ] = value;
 }
 /** Fills a portion of the given array with the given value.
	 *
	 * @param array an array.
	 * @param from the starting index of the portion to fill (inclusive).
	 * @param to the end index of the portion to fill (exclusive).
	 * @param value the new value for all elements of the specified portion of the array.
	 * @deprecated Please use the corresponding {@link java.util.Arrays} method.
	 */
 @Deprecated
 public static void fill( final long[] array, final int from, int to, final long value ) {
  ensureFromTo( array, from, to );
  if ( from == 0 ) while( to-- != 0 ) array[ to ] = value;
  else for( int i = from; i < to; i++ ) array[ i ] = value;
 }
 /** Returns true if the two arrays are elementwise equal.
	 *
	 * @param a1 an array.
	 * @param a2 another array.
	 * @return true if the two arrays are of the same length, and their elements are equal.
	 * @deprecated Please use the corresponding {@link java.util.Arrays} method, which is intrinsified in recent JVMs.
	 */
 @Deprecated
 public static boolean equals( final long[] a1, final long[] a2) {
  int i = a1.length;
  if ( i != a2.length ) return false;
  while( i-- != 0 ) if (! ( (a1[ i ]) == (a2[ i ]) ) ) return false;
  return true;
 }
 /** Ensures that a range given by its first (inclusive) and last (exclusive) elements fits an array.
	 *
	 * <P>This method may be used whenever an array range check is needed.
	 *
	 * @param a an array.
	 * @param from a start index (inclusive).
	 * @param to an end index (exclusive).
	 * @throws IllegalArgumentException if <code>from</code> is greater than <code>to</code>.
	 * @throws ArrayIndexOutOfBoundsException if <code>from</code> or <code>to</code> are greater than the array length or negative.
	 */
 public static void ensureFromTo( final long[] a, final int from, final int to ) {
  Arrays.ensureFromTo( a.length, from, to );
 }
 /** Ensures that a range given by an offset and a length fits an array.
	 *
	 * <P>This method may be used whenever an array range check is needed.
	 *
	 * @param a an array.
	 * @param offset a start index.
	 * @param length a length (the number of elements in the range).
	 * @throws IllegalArgumentException if <code>length</code> is negative.
	 * @throws ArrayIndexOutOfBoundsException if <code>offset</code> is negative or <code>offset</code>+<code>length</code> is greater than the array length.
	 */
 public static void ensureOffsetLength( final long[] a, final int offset, final int length ) {
  Arrays.ensureOffsetLength( a.length, offset, length );
 }
 /** Ensures that two arrays are of the same length.
	 *
	 * @param a an array.
	 * @param b another array.
	 * @throws IllegalArgumentException if the two argument arrays are not of the same length.
	 */
 public static void ensureSameLength( final long[] a, final long[] b ) {
  if ( a.length != b.length ) throw new IllegalArgumentException( "Array size mismatch: " + a.length + " != " + b.length );
 }
 /** Shuffles the specified array fragment using the specified pseudorandom number generator.
	 * 
	 * @param a the array to be shuffled.
	 * @param from the index of the first element (inclusive) to be shuffled.
	 * @param to the index of the last element (exclusive) to be shuffled.
	 * @param random a pseudorandom number generator (please use a <a href="http://dsiutils.dsi.unimi.it/docs/it/unimi/dsi/util/XorShiftStarRandom.html">XorShift*</a> generator).
	 * @return <code>a</code>.
	 */
 public static long[] shuffle( final long[] a, final int from, final int to, final Random random ) {
  for( int i = to - from; i-- != 0; ) {
   final int p = random.nextInt( i + 1 );
   final long t = a[ from + i ];
   a[ from + i ] = a[ from + p ];
   a[ from + p ] = t;
  }
  return a;
 }
 /** Shuffles the specified array using the specified pseudorandom number generator.
	 * 
	 * @param a the array to be shuffled.
	 * @param random a pseudorandom number generator (please use a <a href="http://dsiutils.dsi.unimi.it/docs/it/unimi/dsi/util/XorShiftStarRandom.html">XorShift*</a> generator).
	 * @return <code>a</code>.
	 */
 public static long[] shuffle( final long[] a, final Random random ) {
  for( int i = a.length; i-- != 0; ) {
   final int p = random.nextInt( i + 1 );
   final long t = a[ i ];
   a[ i ] = a[ p ];
   a[ p ] = t;
  }
  return a;
 }
 /** Reverses the order of the elements in the specified array.
	 * 
	 * @param a the array to be reversed.
	 * @return <code>a</code>.
	 */
 public static long[] reverse( final long[] a ) {
  final int length = a.length;
  for( int i = length / 2; i-- != 0; ) {
   final long t = a[ length - i - 1 ];
   a[ length - i - 1 ] = a[ i ];
   a[ i ] = t;
  }
  return a;
 }
 /** Reverses the order of the elements in the specified array fragment.
	 * 
	 * @param a the array to be reversed.
	 * @param from the index of the first element (inclusive) to be reversed.
	 * @param to the index of the last element (exclusive) to be reversed.
	 * @return <code>a</code>.
	 */
 public static long[] reverse( final long[] a, final int from, final int to ) {
  final int length = to - from;
  for( int i = length / 2; i-- != 0; ) {
   final long t = a[ from + length - i - 1 ];
   a[ from + length - i - 1 ] = a[ from + i ];
   a[ from + i ] = t;
  }
  return a;
 }
 /** A type-specific content-based hash strategy for arrays. */
 private static final class ArrayHashStrategy implements Hash.Strategy<long[]>, java.io.Serializable {
  private static final long serialVersionUID = -7046029254386353129L;
  public int hashCode( final long[] o ) {
   return java.util.Arrays.hashCode( o );
  }
  public boolean equals( final long[] a, final long[] b ) {
   return java.util.Arrays.equals( a, b );
  }
 }
 /** A type-specific content-based hash strategy for arrays.
	 *
	 * <P>This hash strategy may be used in custom hash collections whenever keys are
	 * arrays, and they must be considered equal by content. This strategy
	 * will handle <code>null</code> correctly, and it is serializable.
	 */
 public final static Hash.Strategy<long[]> HASH_STRATEGY = new ArrayHashStrategy();
}
