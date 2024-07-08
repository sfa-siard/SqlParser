# SqlParser - SIARD SQL:2008 Parser
This package contains a parser for SQL:2008 statements. Its main intention is parsing and formatting, but it can also handle primitive evaluation of single-table queries.

## Prerequisites
For building the binaries, Java JDK (1.8 or higher) must be installed. Generating sources from SQL Definition (*.g4) files is necessary to resolve compilation errors in your IDE, before running any tests.

### Generate sources and build the project
```shell
./gradlew clean build
```

Run all tests:
```shell
./gradlew check
```

### Create a release
This creates a new tag and pushes the tag to main branch.
```shell
./gradlew release
```

## Documentation
- [User's Manual](./doc/manual/user/index.html) 
- [Developer's Manual](./doc/manual/user/index.html)  

## Declaration
Contributions to the codebase have been made with the support of Codeium. Codeium is AI-powered code completion tool, that is trained exclusively on natural language and source code data with [permissive licenses](https://codeium.com/blog/copilot-trains-on-gpl-codeium-does-not ). 

