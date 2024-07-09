plugins {
    `java-library`
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
    implementation("ch.admin.bar:enterutilities:v2.2.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testImplementation("org.junit.vintage:junit-vintage-engine")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")
}

tasks.test {
    useJUnitPlatform()
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