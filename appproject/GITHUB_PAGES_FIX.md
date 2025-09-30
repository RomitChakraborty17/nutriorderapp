# 🔧 GitHub Pages Setup Fix

## Issue: `/web` folder option not showing in GitHub Pages settings

This happens because GitHub Pages only shows folder options AFTER you upload the files. Here's the correct order:

## ✅ Correct Deployment Steps:

### Step 1: Upload Files First
1. Go to your repository: `https://github.com/YOUR-USERNAME/nutriorder-webapp`
2. Click **"uploading an existing file"** 
3. **Upload ALL files** from your project folder including:
   - The entire `web/` folder with all its contents
   - `.github/` folder 
   - All other files (README.md, etc.)
4. Commit the files

### Step 2: Then Enable GitHub Pages
**Only AFTER uploading files:**
1. Go to repository **Settings** → **Pages**
2. Source: **"Deploy from a branch"**
3. Branch: **"main"** 
4. Folder: **"/web"** ← This option will now appear!
5. Click **Save**

## 🚨 Alternative: Root Deployment Method

If `/web` folder still doesn't appear, use this simpler approach:

### Option A: Move web files to root
1. Upload files like this:
   ```
   Repository Root/
   ├── index.html      (from web/index.html)
   ├── styles.css      (from web/styles.css) 
   ├── app.js          (from web/app.js)
   ├── manifest.json   (from web/manifest.json)
   └── README.md
   ```

2. GitHub Pages Settings:
   - Source: "Deploy from a branch"
   - Branch: "main"
   - Folder: **"/ (root)"**

### Option B: Use GitHub Actions (Automatic)
1. Just upload ALL files as-is (including web/ folder)
2. GitHub Pages Settings:
   - Source: **"GitHub Actions"**
   - It will automatically use the workflow file I created

## 🎯 Quick Fix Right Now:

**Method 1 - Simple Upload:**
1. Upload these 4 files to repository ROOT:
   - `web/index.html` → upload as `index.html`
   - `web/styles.css` → upload as `styles.css`  
   - `web/app.js` → upload as `app.js`
   - `web/manifest.json` → upload as `manifest.json`

2. Set Pages to deploy from "/ (root)"

**Method 2 - GitHub Actions:**
1. Upload ALL files exactly as they are
2. Set Pages source to "GitHub Actions"
3. It will auto-deploy from /web folder

## 🌐 Your Live URL:
`https://YOUR-USERNAME.github.io/nutriorder-webapp`

Choose the method that seems easier for you!
