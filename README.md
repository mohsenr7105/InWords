# InWords
InWords is an android library which converts digits and numbers to words.

## How to install
### in gradle
Add it in your root build.gradle at the end of repositories:
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
  then add the depenceny
  ```
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
### other ways
see [InWords on jitpack](https://jitpack.io/#mimrahe/inwords/v1.0)

## How to use
add the library dependency to your app development
then call in this way:
```java
long number = 54835783745783;
String numberInWords = ir.mimrahe.inwords.InWords.from(getApplicationContext(), number);
Log.d("in words of " + number, numberInWords);
// results "fifty-four trillion, eight hundred thirty-five billion, seven hundred eighty-three million, seven hundred forty-five thousand, seven hundred eighty-three"
