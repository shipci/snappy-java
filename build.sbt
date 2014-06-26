import SonatypeKeys._

sonatypeSettings

name := "snappy-java"

organization := "org.xerial.snappy" 

organizationName := "xerial.org"

description  := "snappy-java: A fast compression/decompression library"

profileName := "org.xerial" 

version := "1.1.1-M3" 

pomExtra := {
   <url>https://github.comm/xerial/snappy-java</url>
   <licenses>
       <license>
           <name>The Apache Software License, Version 2.0</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
        </license>
    </licenses>
    <developers>
        <developer>
            <id>leo</id>
            <name>Taro L. Saito</name>
            <email>leo@xerial.org</email>
            <organization>Xerial Project</organization>
            <roles>
                <role>Architect</role>
                <role>Project Manager</role>
                <role>Chief Developer</role>
            </roles>
            <timezone>+9</timezone>
        </developer>
    </developers>
    <organization>
        <name>xerial.org</name>
        <url>http://xerial.org/</url>
    </organization>
    <issueManagement>
        <email>leo@xerial.org</email>
        <system>GitHub</system>
        <organization>Xerial Project</organization>
        <url>http://github.com/xerial/snappy-java/issues/list</url>
    </issueManagement>
    <role>Architect</role>
    <inceptionYear>2011</inceptionYear>
    <scm>
        <connection>scm:git@github.com:xerial/snappy-java.git</connection>
        <developerConnection>scm:git:git@github.com:xerial/snappy-java.git</developerConnection>
        <url>git@github.com:xerial/snappy-java.git</url>
    </scm>
}

javacOptions in (Compile, compile) ++= Seq("-encoding", "UTF-8", "-Xlint:unchecked", "-Xlint:deprecation", "-source", "1.6", "-target", "1.6")

testOptions += Tests.Argument(TestFrameworks.JUnit, "-q", "-v")

//concurrentRestrictions in Global := Seq(Tags.limit(Tags.Test, 1))

autoScalaLibrary := false

crossPaths := false

logBuffered in Test := false

incOptions := incOptions.value.withNameHashing(true)

libraryDependencies ++= Seq(
   "junit" % "junit" % "4.8.2" % "test",
   "org.codehaus.plexus" % "plexus-classworlds" % "2.4" % "test",
   "org.xerial" % "xerial-core" % "1.0.21" % "test",
   "org.osgi" % "org.osgi.core" % "4.3.0" % "provided",
   "com.novocode" % "junit-interface" % "0.10" % "test"
)

osgiSettings


OsgiKeys.exportPackage := Seq("org.xerial.snappy")

OsgiKeys.bundleSymbolicName := "org.xerial.snappy.snappy-java"

OsgiKeys.bundleActivator := Option("org.xerial.snappy.SnappyBundleActivator")

OsgiKeys.importPackage := Seq("""org.osgi.framework;version="[1.5,2)"""")

OsgiKeys.additionalHeaders := Map(
  "Bundle-NativeCode" -> Seq(
"org/xerial/snappy/native/Windows/x86_64/snappyjava.dll;osname=win32;processor=x86-64",
"org/xerial/snappy/native/Windows/x86/snappyjava.dll;osname=win32;processor=x86",
"org/xerial/snappy/native/Mac/x86/libsnappyjava.jnilib;osname=macosx;processor=x86",
"org/xerial/snappy/native/Mac/x86_64/libsnappyjava.jnilib;osname=macosx;processor=x86-64",
"org/xerial/snappy/native/Linux/x86_64/libsnappyjava.so;osname=linux;processor=x86-64",
"org/xerial/snappy/native/Linux/x86/libsnappyjava.so;osname=linux;processor=x86",
"org/xerial/snappy/native/Linux/arm/libsnappyjava.so;osname=linux;processor=arm",
"org/xerial/snappy/native/Linux/ppc64/libsnappyjava.so;osname=linux;processor=ppc64",
"org/xerial/snappy/native/Linux/ppc64le/libsnappyjava.so;osname=linux;processor=ppc64le",
"org/xerial/snappy/native/SunOS/x86/libsnappyjava.so;osname=sunos;processor=x86",
"org/xerial/snappy/native/SunOS/x86_64/libsnappyjava.so;osname=sunos;processor=x86-64",
"org/xerial/snappy/native/SunOS/sparc/libsnappyjava.so;osname=sunos;processor=sparc"
).mkString(","),
 "Bundle-DocURL" -> "http://www.xerial.org/",
 "Bundle-License" -> "http://www.apache.org/licenses/LICENSE-2.0.txt",
 "Bundle-ActivationPolicy" -> "lazy",
 "Bundle-Name" -> "snappy-java: A fast compression/decompression library"
)
