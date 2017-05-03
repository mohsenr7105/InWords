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
	        compile 'com.github.mimrahe:inwords:v1.2'
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
	    <version>v1.2</version>
	</dependency>
  ```
### other ways
see [InWords on jitpack](https://jitpack.io/#mimrahe/inwords)

## How to use
add the library dependency to your app development
then call in this way:
```java
long number = 54835783745783;
String numberInWords = ir.mimrahe.inwords.InWords.from(getApplicationContext(), number);
Log.d("in words of " + number, numberInWords);
// results "fifty-four trillion, eight hundred thirty-five billion, seven hundred eighty-three million, seven hundred forty-five thousand, seven hundred eighty-three"
```
**this is a local based tool so persian in words is supported**
```java
Log.d("in words in persian", numberInWords);
// results "پنجاه و چهار تریلیون و هشت صد و سی و پنج میلیارد و هفتصد و هشتاد و سه میلیون و هفتصد و چهل و پنج هزار و هفت صد و هشتاد و سه"
```

### How to extend for your local language
this tool is for languages that has numbers order that is like english numbers

english numbers is 0-9, 10-19, 20-90, 100-900 that has different patterns between 0-9 and 10-19

define this string resources for your language:
```xml
<resources>
    <!-- replace values with your local language -->
    <string name="inwords_n0">zero</string>
    <string name="inwords_n1">one</string>
    <string name="inwords_n2">two</string>
    <string name="inwords_n3">three</string>
    <string name="inwords_n4">four</string>
    <string name="inwords_n5">five</string>
    <string name="inwords_n6">six</string>
    <string name="inwords_n7">seven</string>
    <string name="inwords_n8">eight</string>
    <string name="inwords_n9">nine</string>
    <string name="inwords_n10">ten</string>
    <string name="inwords_n11">eleven</string>
    <string name="inwords_n12">twelve</string>
    <string name="inwords_n13">thirteen</string>
    <string name="inwords_n14">fourteen</string>
    <string name="inwords_n15">fifteen</string>
    <string name="inwords_n16">sixteen</string>
    <string name="inwords_n17">seventeen</string>
    <string name="inwords_n18">eighteen</string>
    <string name="inwords_n19">nineteen</string>
    <string name="inwords_n20">twenty</string>
    <string name="inwords_n30">thirty</string>
    <string name="inwords_n40">forty</string>
    <string name="inwords_n50">fifty</string>
    <string name="inwords_n60">sixty</string>
    <string name="inwords_n70">seventy</string>
    <string name="inwords_n80">eighty</string>
    <string name="inwords_n90">ninety</string>
    <string name="inwords_n100">one hundred</string>
    <string name="inwords_n200">two hundred</string>
    <string name="inwords_n300">three hundred</string>
    <string name="inwords_n400">four hundred</string>
    <string name="inwords_n500">five hundred</string>
    <string name="inwords_n600">six hundred</string>
    <string name="inwords_n700">seven hundred</string>
    <string name="inwords_n800">eight hundred</string>
    <string name="inwords_n900">nine hundred</string>
    <string name="inwords_n0x3">thousands</string>
    <string name="inwords_n0x6">millions</string>
    <string name="inwords_n0x9">milliards</string>
    <string name="inwords_n0x12">trillions</string>
    <string name="inwords_n0x15">trilliards</string>
    <string name="inwords_empty"/><!-- don't touch this item -->
    <string name="inwords_digits_delimiter"></string><!-- this delimiter place between digits -->
    <string name="inwords_3digits_delimiter">,</string><!-- this delimiter place between 3digits -->
</resources>
```
**Note**

example for delimiters:

number 345,456: three hundred forty five thousand , four hundred fifty six

""(empty) is inwords_digits_delimiter

","(comma) is inwords_3digits_delimiter

other example

three hundred _ forty _ five _ thousand * four hundred _ fifty _ six

"_" is inwords_digits_delimiter

"*" is inwords_3digits_delimiter
## License
**GNU General Public License v3.0**

Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.
