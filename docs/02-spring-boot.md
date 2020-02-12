# spring boot
Spring Boot 어플리케이션 실행 및 Test 모듈 동작 하게 하기

## build.gradle
```groovy
// spring boot plugin 추가하기
plugins {
    id 'org.springframework.boot' version '2.2.4.RELEASE'
    id 'io.spring.dependency-management' version '1.0.9.RELEASE'
}

//JUnit Jupiter 를 idea 에서 사용시 필요함
test {
    useJUnitPlatform()
}

dependencies {
    // Spring Boot
    implementation 'org.springframework.boot:spring-boot-starter-web'

    // JUnit Jupiter
    testImplementation ("org.springframework.boot:spring-boot-starter-test") {
        exclude module: "junit"
    }
    testImplementation "org.junit.jupiter:junit-jupiter-api:${junitJupiter}"
    testRuntimeOnly "org.junit.jupiter:junit-jupiter-engine:${junitJupiter}"
}
```

## source
- src/main/java/gradle.spring.boot.skeleton.App.java
- src/test/java/gradle.spring.boot.skeleton.AppTest.java