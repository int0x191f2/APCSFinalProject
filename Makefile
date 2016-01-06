SOURCES=$(shell find -type f -name "*.java")
OBJECTS=$(SOURCES:.java=.class)

all: 
	javac Panel.java
	javac Bookmark.java
	javac History.java
	javac BookmarkPanel.java
	javac HistoryPanel.java
	javac Browser.java

clean :
	rm *.class *.html package-list script.js stylesheet.css

javadoc :
	javadoc History.java && firefox index.html
