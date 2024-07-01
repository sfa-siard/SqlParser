plugins {
    id("java")
    id("antlr")
    id("pl.allegro.tech.build.axion-release") version "1.14.3"
}

group = "ch.admin.bar"
version = scmVersion.version

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.5.2-1")
    antlr("org.antlr:antlr4-runtime:4.5.2-1")
    antlr("org.antlr:antlr4-master:4.5.2-1")
    implementation("com.microsoft.sqlserver:mssql-jdbc:12.2.0.jre8")

    // legacy dependencies -
    implementation(fileTree("lib") { include("*.jar") })

    // test dependencies
    testImplementation("junit:junit:4.13.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.junit.vintage:junit-vintage-engine")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    archiveFileName.set("sqlparser.jar")
}

tasks.getByName("assemble").dependsOn("testJar")

tasks.register<Jar>("testJar") {
    archiveFileName.set("sqlparser-test.jar")
    from(project.the<SourceSetContainer>()["test"].output)
}

tasks.register<JavaExec>("keywordgenerator") {
    mainClass.set("ch.enterag.sqlparser.KeywordGenerator")
    classpath = sourceSets["test"].runtimeClasspath
}

tasks.build {
    dependsOn("keywordgenerator")
}
tasks.generateGrammarSource {
    outputDirectory = File("src/main/java/ch/enterag/sqlparser/generated")
    include("Sql.g4")
    arguments = arguments + listOf(
            "-visitor",
            "-no-listener",
            "-package",
            "ch.enterag.sqlparser.generated",
    )
}