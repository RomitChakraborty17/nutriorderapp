@echo off
echo ========================================
echo   NutriOrder Web App Deployment Setup
echo ========================================
echo.

echo Step 1: Checking Git installation...
git --version >nul 2>&1
if %errorlevel% neq 0 (
    echo Git is not installed. Please install Git from https://git-scm.com/download/win
    echo After installing Git, run this script again.
    pause
    exit /b 1
)
echo Git is installed!

echo.
echo Step 2: Setting up repository...
if exist .git (
    echo Repository already initialized.
) else (
    git init
    echo Repository initialized.
)

echo.
echo Step 3: Adding files to repository...
git add .
git commit -m "Initial commit - NutriOrder Web App v1.0"

echo.
echo Step 4: Repository is ready!
echo.
echo ========================================
echo   NEXT STEPS TO DEPLOY:
echo ========================================
echo.
echo 1. Go to https://github.com and create a new repository
echo 2. Name it: nutriorder-webapp
echo 3. Make it PUBLIC
echo 4. Do NOT initialize with README
echo.
echo 5. Copy and run these commands:
echo.
echo    git remote add origin https://github.com/YOUR-USERNAME/nutriorder-webapp.git
echo    git branch -M main
echo    git push -u origin main
echo.
echo 6. Go to Settings > Pages > Deploy from branch > main > /web
echo.
echo Your app will be live at:
echo https://YOUR-USERNAME.github.io/nutriorder-webapp
echo.
echo ========================================
pause
