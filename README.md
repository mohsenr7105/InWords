# InWords
InWords is an android library which converts digits and numbers to words.

## How to install
### in gradle
Add it in your root build.gradle at the end of repositories:
```json
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  then add the depenceny
  ```json
  dependencies {
	        compile 'com.github.mimrahe:inwords:v1.0'
	}
  ```
  ### in maven
  ```xml
  <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  ```
  then add the dependency
  ```xml
  <dependency>
	    <groupId>com.github.mimrahe</groupId>
	    <artifactId>inwords</artifactId>
	    <version>v1.0</version>
	</dependency>
  ```
