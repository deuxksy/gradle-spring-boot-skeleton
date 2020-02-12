# gradle
gradle 를 이용한 java-application 만들기

## 1. gradle 를 이용한 자바 프로젝트 생성하기
```cmd
D:\> mkdir gradle-spring-boot-skeleton
D:\> cd gradle-spring-boot-skeleton

D:\gradle-spring-boot-skeleton>gradle init
Starting a Gradle Daemon, 2 incompatible and 1 stopped Daemons could not be reused, use --status for details

Select type of project to generate:
  1: basic
  2: application
  3: library
  4: Gradle plugin
Enter selection (default: basic) [1..4] 2

Select implementation language:
  1: C++
  2: Groovy
  3: Java
  4: Kotlin
  5: Swift
Enter selection (default: Java) [1..5] 3

Select build script DSL:
  1: Groovy
  2: Kotlin
Enter selection (default: Groovy) [1..2] 1

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit 4) [1..4] 4

Project name (default: gradle-spring-boot-skeleton):
Source package (default: gradle.spring.boot.skeleton):

> Task :init
Get more help with your project: https://docs.gradle.org/6.1.1/userguide/tutorial_java_projects.html

BUILD SUCCESSFUL in 46s
2 actionable tasks: 2 executed

D:\gradle-spring-boot-skeleton>

```
## 2. 파일 구조
```cmd
D:.
├─.gradle
│  ├─6.1.1
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata-1
│  ├─buildOutputCleanup
│  ├─checksums
│  └─vcs-1
├─gradle
│  └─wrapper
├─src
│  ├─main
│  │  ├─java
│  │  │  └─gradle
│  │  │      └─spring
│  │  │          └─boot
│  │  │              └─skeleton
│  │  │                  └─ App.java
│  │  └─resources
│  └─test
│      ├─java
│      │  └─gradle
│      │      └─spring
│      │          └─boot
│      │              └─skeleton
│      └─resources
├─ build.gradle
├─ settings.gradle
├─ gradlew.bat
├─ .gitignore
└─ gradlew

```

## 참조
1. [Building Spring Boot 2 Applications with Gradle](https://guides.gradle.org/building-spring-boot-2-projects-with-gradle/)