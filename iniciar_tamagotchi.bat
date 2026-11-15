@echo off
title Tamagotchi
cd /d "%~dp0Tamagotchi\dist"
where javaw >nul 2>&1
if %ERRORLEVEL% EQU 0 (
    start "" javaw -jar Tamagotchi.jar
) else (
    start "" java -jar Tamagotchi.jar
)
