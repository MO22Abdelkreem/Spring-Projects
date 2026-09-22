$doctorImageUrls = @(
    "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1594824813581-2c974cb8c227?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1537368910025-700350fe46c7?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1551601651-2a8555f1a136?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1582750433449-648ed127bb54?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1527613426441-4da17471b66d?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1622902046580-2b47f47f5471?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1651008376811-b90baee60c1f?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1532938911079-1b06ac7ceec7?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1638202993928-7267aad84c31?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1584467735815-f778f274e296?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1576091160550-2173dba999ef?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1614862287983-5c55fb92f9e2?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1550831107-1553da8c8464?w=500&auto=format&fit=crop&q=80",
    "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=500&auto=format&fit=crop&q=80"
)

$targetDir1 = "uploads\images"
$targetDir2 = "ProfileMS\uploads\images"

if (!(Test-Path $targetDir1)) {
    New-Item -ItemType Directory -Force -Path $targetDir1 | Out-Null
}
if (!(Test-Path $targetDir2)) {
    New-Item -ItemType Directory -Force -Path $targetDir2 | Out-Null
}

$sqlUpdates = @("USE profiledb;")

# Doctors 6 to 25 (the 20 doctors)
for ($i = 0; $i -lt 20; $i++) {
    $doctorId = 6 + $i
    $url = $doctorImageUrls[$i]
    $uuid = [System.Guid]::NewGuid().ToString()
    $fileName = "$uuid.jpg"
    $filePath1 = Join-Path $targetDir1 $fileName
    $filePath2 = Join-Path $targetDir2 $fileName

    Write-Host "Downloading image for doctor ID $doctorId ($fileName)..."
    try {
        Invoke-WebRequest -Uri $url -OutFile $filePath1 -TimeoutSec 15 -UserAgent "Mozilla/5.0"
        Copy-Item -Path $filePath1 -Destination $filePath2 -Force
        Write-Host "  Success: $fileName"
    } catch {
        Write-Host "  Failed to download from $url, copying fallback image..."
        Copy-Item -Path "uploads\images\13c43ac5-5329-4ada-bf6f-bb1b3db24cc6.jpg" -Destination $filePath1 -Force
        Copy-Item -Path $filePath1 -Destination $filePath2 -Force
    }

    $dbImagePath = "/uploads/images/$fileName"
    $sqlUpdates += "UPDATE doctors SET image_url = '$dbImagePath' WHERE id = $doctorId;"
}

# Also handle doctors 3, 4, 5 if they don't have images
$otherDoctors = @(3, 4, 5)
foreach ($docId in $otherDoctors) {
    $uuid = [System.Guid]::NewGuid().ToString()
    $fileName = "$uuid.jpg"
    $filePath1 = Join-Path $targetDir1 $fileName
    $filePath2 = Join-Path $targetDir2 $fileName

    try {
        Invoke-WebRequest -Uri "https://images.unsplash.com/photo-1537368910025-700350fe46c7?w=500&auto=format&fit=crop&q=80" -OutFile $filePath1 -TimeoutSec 15 -UserAgent "Mozilla/5.0"
        Copy-Item -Path $filePath1 -Destination $filePath2 -Force
    } catch {
        Copy-Item -Path "uploads\images\13c43ac5-5329-4ada-bf6f-bb1b3db24cc6.jpg" -Destination $filePath1 -Force
        Copy-Item -Path $filePath1 -Destination $filePath2 -Force
    }
    $dbImagePath = "/uploads/images/$fileName"
    $sqlUpdates += "UPDATE doctors SET image_url = '$dbImagePath' WHERE id = $docId AND image_url IS NULL;"
}

$sqlContent = $sqlUpdates -join "`n"
Set-Content -Path "update_doctor_images.sql" -Value $sqlContent -Encoding UTF8
Write-Host "Generated update_doctor_images.sql successfully."
