@echo off
echo Generating ANTLR lexer and parser...

java -jar "C:\antlr4\antlr-4.13.1-complete.jar" -Dlanguage=Java -visitor -listener src\antlr\*.g4

echo Done.
pause
