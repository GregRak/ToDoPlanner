call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browserStart
echo.
echo RUNCRUD.BAT has errors - breaking work
goto fail

:browserStart
start C:\"Program Files (x86)"\Google\Chrome\Application\chrome.exe
start http://localhost:8080/crud/v1/tasks
if "%ERRORLEVEL%" == "0" goto ende
echo.
echo BROWSER START has errors - breaking work
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work finished