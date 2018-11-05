set JAVA_HOME=F:\MyDevelop\jdk8\
set GRADLE_HOME=F:\MyDevelop\gradle-4.10.2\
set GRADLE_USER_HOME=F:\MyDevelop\gradle-user-home\
set PATH=%JAVA_HOME%bin;%PATH%
set PATH=%GRADLE_HOME%bin;%PATH%
set OUTPUT_DIR=D:\System\Desktop\vote-service
set BASE_DIR=%~dp0
cd %BASE_DIR%votedata
call gradle clean
call gradle build
cd %BASE_DIR%static
call gulp
copy %BASE_DIR%votedata\build\libs\votedata-1.0.0.0.jar %OUTPUT_DIR%\dataservice\
xcopy /E /Y %BASE_DIR%static\dist %OUTPUT_DIR%\html