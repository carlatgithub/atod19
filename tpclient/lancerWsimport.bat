set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_25
set WSDL_URL=http://localhost:8080/tpws/services/CalculTva?wsdl
cd /d "%~dp0"
"%JAVA_HOME%/bin/wsimport" -keep -d src/main/java    %WSDL_URL%
pause
REM + refresh eclipse