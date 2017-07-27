# MavenAssignment
Assume a text file with a sample content as follows:

AMZN - 90,MS - 80

GOOG - 100,AMZN - 90,MS - 80

AMZN - 90

This a program that takes a text file (such as the above) as a command line argument and prints them in the descending order of their overall value, where the overall value of each line is the value of all stocks (price * quantity) in a given line.
In which price of each stocks has been taken from rate.txt file.

An example run would be:

>> test1.txt

GOOG - 100,AMZN - 90,MS - 80

AMZN - 90,MS - 80

AMZN - 90

#How to Run

Please make sure compling the code in jdk 1.7.

Please right click on pom.xml file and click on 'Run As' then select 'Maven build'

In Goals enter "clean package exec:java -DFileName=test.txt".

In Goals  'test.txt' is input file you can also use 'test1.txt'

Then console will display the  result as we expect and also Junit testcases.


