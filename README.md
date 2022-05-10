# SqlParser - SQL:2008 Parser for SIARD 2.2

This package contains a parser for SQL:2008 statements.
Its main intention is parsing and formatting.
It can also handle primitive evaluation of single-table queries.

## Getting started (for developers)

For building the binaries, Java JDK (1.8 or higher) and Ant must
have been installed. Adjust build.properties according to your system (if needed)

Generate sources from SQL Definition (var/*.g4) files. This step is necessary to resolve compilation errors in your IDE

```shell
ant generate
```

Run all tests:

```shell
ant test
```

Create the release:

```shell
ant release
```

## Documentation

[./doc/manual/user/index.html](./doc/manual/user/index.html) contains the manual for using the binaries.
[./doc/manual/developer/index.html](./doc/manual/user/index.html) is the manual for developers wishing
build the binaries or work on the code.  

More information about the build process can be found in
[./doc/manual/developer/build.html](./doc/manual/developer/build.html).

You may use an IDE of your choice for development (tested with intellij idea and eclipse) 
