# fastutil-gwt
This is a bare minimal copy of [fastutil](https://github.com/vigna/fastutil) modified to operate a little better on [GWT](http://www.gwtproject.org).
The selection of code (and the work to do project configuration) was done by Daniel Ennis in [fastutil-lite](https://github.com/aikar/fastutil-lite).

This only includes a few int and long collections, targeting the hashmaps.

## Repo
Maven:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io/</url>
</repository>
```
Gradle:
```gradle
maven {
    name = "jitpack.io"
    url = "https://jitpack.io/"
}
```

## v2.1 - about 50kb~ depending on number of collections

v2.1 strips out everything from fastutil but the int- and long-keyed open hash maps, and/or the custom hash strategy versions.

### All of these collections need:
Group and version is the same for all

**group**: `com.github.tommyettinger`

**version**: `2.1-SNAPSHOT`

**artifact**: `fastutil-base`

### Int Hashmaps need:

**artifact**: `fastutil-intbase`

### Long Hashmaps need:

**artifact**: `fastutil-intbase`

### Hashmaps

**Int2ObjectOpenHashMap**: `fastutil-inthashmap`

**Int2ObjectOpenCustomHashMap**: `fastutil-intcustomhashmap`

**Long2ObjectOpenHashMap**: `fastutil-longhashmap`

**Long2ObjectOpenCustomHashMap**: `fastutil-longcustomhashmap`

### Example
You should have at least 3 artifacts, `core`, `intbase` or `longbase` (or both), and then one or more of the desired collections.

```xml
    <dependencies>
        <dependency>
            <groupId>com.github.tommyettinger.fastutil-gwt</groupId>
            <artifactId>fastutil-base</artifactId>
            <version>-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.github.tommyettinger.fastutil-gwt</groupId>
            <artifactId>fastutil-longbase</artifactId>
            <version>-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>com.github.tommyettinger.fastutil-gwt</groupId>
            <artifactId>fastutil-longbase</artifactId>
            <version>-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
```

Relocating should not be necessary for this since ABI is unlikely to change. I am using snapshots until I feel the build is 'correct' and works, then it will go to a release.

# License
fastutil is released under the [Apache v2 license](LICENSE.md), and this project uses the same license.

fastutil-gwt changes some implementation details of fastutil to operate effectively on Google Web Toolkit.
