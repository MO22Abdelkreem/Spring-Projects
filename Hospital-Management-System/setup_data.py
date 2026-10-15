import os
import shutil
import uuid
import urllib.request
import subprocess

UPLOADS_ROOT = r"D:\spring projects\Hospital Management System\Hospital-Management-System\uploads\images"
UPLOADS_PROFILE = r"D:\spring projects\Hospital Management System\Hospital-Management-System\ProfileMS\uploads\images"

os.makedirs(UPLOADS_ROOT, exist_ok=True)
os.makedirs(UPLOADS_PROFILE, exist_ok=True)

# 1. Delete all existing images
print("Step 1: Deleting old images...")
for folder in [UPLOADS_ROOT, UPLOADS_PROFILE]:
    for f in os.listdir(folder):
        file_path = os.path.join(folder, f)
        if os.path.isfile(file_path):
            os.remove(file_path)
            print(f"Deleted {file_path}")

print("Cleaned existing upload directories.")

# 2. Define doctor photos and details
doctors_info = [
    {
        "id": 1,
        "username": "dr.mohamed",
        "email": "dr.mohamed@gmail.com",
        "department": "Internal Medicine",
        "specialization": "General Internal Medicine",
        "license_no": "DOC-LIC-1001",
        "phone": "+1-555-0101",
        "address": "100 Medical Center Dr, Boston, MA",
        "total_exp": 14,
        "blood_group": "O_POSITIVE",
        "dob": "1981-04-12",
        "photo_url": "https://images.unsplash.com/photo-1537368910025-700350fe46c7?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 2,
        "username": "mohamed",
        "email": "doctor2@gmail.com",
        "department": "Family Medicine",
        "specialization": "Primary Care & Preventive Health",
        "license_no": "DOC-LIC-1002",
        "phone": "+1-555-0102",
        "address": "100 Medical Center Dr, Boston, MA",
        "total_exp": 10,
        "blood_group": "A_POSITIVE",
        "dob": "1986-09-18",
        "photo_url": "https://images.unsplash.com/photo-1622253692010-333f2da6031d?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 3,
        "username": "dr_alex",
        "email": "dr.alex@example.com",
        "department": "Cardiovascular",
        "specialization": "Cardiology",
        "license_no": "LIC12345",
        "phone": "1234567890",
        "address": "123 Heart St",
        "total_exp": 10,
        "blood_group": "O_POSITIVE",
        "dob": "1980-05-15",
        "photo_url": "https://images.unsplash.com/photo-1612349317150-e413f6a5b16d?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 4,
        "username": "dr_sarah",
        "email": "dr.sarah@example.com",
        "department": "Pediatrics",
        "specialization": "Pediatrics",
        "license_no": "LIC67890",
        "phone": "9876543210",
        "address": "456 Kid Ln",
        "total_exp": 8,
        "blood_group": "A_NEGATIVE",
        "dob": "1985-08-22",
        "photo_url": "https://images.unsplash.com/photo-1559839734-2b71ea197ec2?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 5,
        "username": "DrSmith",
        "email": "smith@test.com",
        "department": "Cardiology",
        "specialization": "Preventive Cardiology",
        "license_no": "DOC-LIC-1005",
        "phone": "+1-555-0105",
        "address": "100 Medical Center Dr, Boston, MA",
        "total_exp": 16,
        "blood_group": "B_POSITIVE",
        "dob": "1979-11-20",
        "photo_url": "https://images.unsplash.com/photo-1579684385127-1ef15d508118?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 6,
        "username": "dr_wilson",
        "email": "dr.wilson@hospital.com",
        "department": "Cardiology",
        "specialization": "Interventional Cardiology",
        "license_no": "DOC-LIC-2001",
        "phone": "+1-555-0111",
        "address": "101 Medical Center Dr, Boston, MA",
        "total_exp": 14,
        "blood_group": "O_POSITIVE",
        "dob": "1982-03-15",
        "photo_url": "https://images.unsplash.com/photo-1576091160399-112ba8d25d1d?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 7,
        "username": "dr_clark",
        "email": "dr.clark@hospital.com",
        "department": "Neurology",
        "specialization": "Cognitive & Behavioral Neurology",
        "license_no": "DOC-LIC-2002",
        "phone": "+1-555-0112",
        "address": "102 Medical Center Dr, Boston, MA",
        "total_exp": 11,
        "blood_group": "A_POSITIVE",
        "dob": "1985-07-22",
        "photo_url": "https://images.unsplash.com/photo-1582750433449-648ed127bb54?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 8,
        "username": "dr_brown",
        "email": "dr.brown@hospital.com",
        "department": "Orthopedics",
        "specialization": "Joint Replacement & Sports Medicine",
        "license_no": "DOC-LIC-2003",
        "phone": "+1-555-0113",
        "address": "103 Medical Center Dr, Boston, MA",
        "total_exp": 16,
        "blood_group": "B_POSITIVE",
        "dob": "1979-11-05",
        "photo_url": "https://images.unsplash.com/photo-1629909613654-28e377c37b09?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 9,
        "username": "dr_davis",
        "email": "dr.davis@hospital.com",
        "department": "Pediatrics",
        "specialization": "General & Neonatal Care",
        "license_no": "DOC-LIC-2004",
        "phone": "+1-555-0114",
        "address": "104 Medical Center Dr, Boston, MA",
        "total_exp": 9,
        "blood_group": "AB_POSITIVE",
        "dob": "1988-02-18",
        "photo_url": "https://images.unsplash.com/photo-1584515979956-d9f6e5d09982?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 10,
        "username": "dr_miller",
        "email": "dr.miller@hospital.com",
        "department": "Dermatology",
        "specialization": "Clinical & Aesthetic Dermatology",
        "license_no": "DOC-LIC-2005",
        "phone": "+1-555-0115",
        "address": "105 Medical Center Dr, Boston, MA",
        "total_exp": 12,
        "blood_group": "O_NEGATIVE",
        "dob": "1984-09-30",
        "photo_url": "https://images.unsplash.com/photo-1643297654416-05795d62e39c?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 11,
        "username": "dr_garcia",
        "email": "dr.garcia@hospital.com",
        "department": "Oncology",
        "specialization": "Medical Oncology & Hematology",
        "license_no": "DOC-LIC-2006",
        "phone": "+1-555-0116",
        "address": "106 Medical Center Dr, Boston, MA",
        "total_exp": 15,
        "blood_group": "A_NEGATIVE",
        "dob": "1981-06-12",
        "photo_url": "https://images.unsplash.com/photo-1622902046580-2b47f47f5471?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 12,
        "username": "dr_martinez",
        "email": "dr.martinez@hospital.com",
        "department": "Gastroenterology",
        "specialization": "Hepatology & Endoscopy",
        "license_no": "DOC-LIC-2007",
        "phone": "+1-555-0117",
        "address": "107 Medical Center Dr, Boston, MA",
        "total_exp": 13,
        "blood_group": "B_NEGATIVE",
        "dob": "1983-12-08",
        "photo_url": "https://images.unsplash.com/photo-1560250097-0b93528c311a?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 13,
        "username": "dr_anderson",
        "email": "dr.anderson@hospital.com",
        "department": "Ophthalmology",
        "specialization": "Cornea & Refractive Surgery",
        "license_no": "DOC-LIC-2008",
        "phone": "+1-555-0118",
        "address": "108 Medical Center Dr, Boston, MA",
        "total_exp": 10,
        "blood_group": "O_POSITIVE",
        "dob": "1986-04-25",
        "photo_url": "https://images.unsplash.com/photo-1614608682850-e0d6ed316d47?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 14,
        "username": "dr_taylor",
        "email": "dr.taylor@hospital.com",
        "department": "Psychiatry",
        "specialization": "Adult & Neuropsychiatry",
        "license_no": "DOC-LIC-2009",
        "phone": "+1-555-0119",
        "address": "109 Medical Center Dr, Boston, MA",
        "total_exp": 17,
        "blood_group": "A_POSITIVE",
        "dob": "1978-01-19",
        "photo_url": "https://images.unsplash.com/photo-1527613426441-4da17471b66d?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 15,
        "username": "dr_thomas",
        "email": "dr.thomas@hospital.com",
        "department": "Pulmonology",
        "specialization": "Respiratory & Critical Care",
        "license_no": "DOC-LIC-2010",
        "phone": "+1-555-0120",
        "address": "110 Medical Center Dr, Boston, MA",
        "total_exp": 8,
        "blood_group": "B_POSITIVE",
        "dob": "1989-08-14",
        "photo_url": "https://images.unsplash.com/photo-1584467735871-8e85353a8413?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 16,
        "username": "dr_white",
        "email": "dr.white@hospital.com",
        "department": "Endocrinology",
        "specialization": "Diabetes & Thyroid Disorders",
        "license_no": "DOC-LIC-2011",
        "phone": "+1-555-0121",
        "address": "111 Medical Center Dr, Boston, MA",
        "total_exp": 14,
        "blood_group": "AB_NEGATIVE",
        "dob": "1982-10-03",
        "photo_url": "https://images.unsplash.com/photo-1651008376811-b90baee60c1f?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 17,
        "username": "dr_harris",
        "email": "dr.harris@hospital.com",
        "department": "Nephrology",
        "specialization": "Kidney Diseases & Dialysis",
        "license_no": "DOC-LIC-2012",
        "phone": "+1-555-0122",
        "address": "112 Medical Center Dr, Boston, MA",
        "total_exp": 11,
        "blood_group": "O_POSITIVE",
        "dob": "1985-05-20",
        "photo_url": "https://images.unsplash.com/photo-1584820927498-cfe5211fd8bf?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 18,
        "username": "dr_martin",
        "email": "dr.martin@hospital.com",
        "department": "Urology",
        "specialization": "Endourology & Urologic Oncology",
        "license_no": "DOC-LIC-2013",
        "phone": "+1-555-0123",
        "address": "113 Medical Center Dr, Boston, MA",
        "total_exp": 15,
        "blood_group": "A_POSITIVE",
        "dob": "1980-09-17",
        "photo_url": "https://images.unsplash.com/photo-1588776814546-1ffcf47267a5?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 19,
        "username": "dr_thompson",
        "email": "dr.thompson@hospital.com",
        "department": "Otolaryngology",
        "specialization": "Head, Neck & Sinus Surgery",
        "license_no": "DOC-LIC-2014",
        "phone": "+1-555-0124",
        "address": "114 Medical Center Dr, Boston, MA",
        "total_exp": 7,
        "blood_group": "B_NEGATIVE",
        "dob": "1990-03-29",
        "photo_url": "https://images.unsplash.com/photo-1551884170-09fb70a3a2ed?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 20,
        "username": "dr_jackson",
        "email": "dr.jackson@hospital.com",
        "department": "Rheumatology",
        "specialization": "Autoimmune & Joint Disorders",
        "license_no": "DOC-LIC-2015",
        "phone": "+1-555-0125",
        "address": "115 Medical Center Dr, Boston, MA",
        "total_exp": 18,
        "blood_group": "O_NEGATIVE",
        "dob": "1977-11-11",
        "photo_url": "https://images.unsplash.com/photo-1573496359142-b8d87734a5a2?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 21,
        "username": "dr_lee",
        "email": "dr.lee@hospital.com",
        "department": "Radiology",
        "specialization": "Diagnostic & Interventional Radiology",
        "license_no": "DOC-LIC-2016",
        "phone": "+1-555-0126",
        "address": "116 Medical Center Dr, Boston, MA",
        "total_exp": 12,
        "blood_group": "A_NEGATIVE",
        "dob": "1984-06-07",
        "photo_url": "https://images.unsplash.com/photo-1550831107-1553da8c8464?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 22,
        "username": "dr_perez",
        "email": "dr.perez@hospital.com",
        "department": "General Surgery",
        "specialization": "Minimally Invasive & Laparoscopic Surgery",
        "license_no": "DOC-LIC-2017",
        "phone": "+1-555-0127",
        "address": "117 Medical Center Dr, Boston, MA",
        "total_exp": 13,
        "blood_group": "AB_POSITIVE",
        "dob": "1983-02-23",
        "photo_url": "https://images.unsplash.com/photo-1532938911079-1b06ac7ceec7?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 23,
        "username": "dr_robinson",
        "email": "dr.robinson@hospital.com",
        "department": "Emergency Medicine",
        "specialization": "Trauma & Acute Resuscitation",
        "license_no": "DOC-LIC-2018",
        "phone": "+1-555-0128",
        "address": "118 Medical Center Dr, Boston, MA",
        "total_exp": 9,
        "blood_group": "O_POSITIVE",
        "dob": "1988-12-04",
        "photo_url": "https://images.unsplash.com/photo-1638202993928-7267aad84c31?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 24,
        "username": "dr_hall",
        "email": "dr.hall@hospital.com",
        "department": "Gynecology",
        "specialization": "Maternal-Fetal Medicine & Women Health",
        "license_no": "DOC-LIC-2019",
        "phone": "+1-555-0129",
        "address": "119 Medical Center Dr, Boston, MA",
        "total_exp": 15,
        "blood_group": "B_POSITIVE",
        "dob": "1981-08-16",
        "photo_url": "https://images.unsplash.com/photo-1591604021695-0c69b7c05981?w=500&auto=format&fit=crop&q=80"
    },
    {
        "id": 25,
        "username": "dr_allen",
        "email": "dr.allen@hospital.com",
        "department": "Anesthesiology",
        "specialization": "Surgical Anesthesia & Pain Management",
        "license_no": "DOC-LIC-2020",
        "phone": "+1-555-0130",
        "address": "120 Medical Center Dr, Boston, MA",
        "total_exp": 10,
        "blood_group": "A_POSITIVE",
        "dob": "1986-10-28",
        "photo_url": "https://images.unsplash.com/photo-1618498082410-b4aa22193b38?w=500&auto=format&fit=crop&q=80"
    }
]

# 3. Define patient details (4 existing + 16 new)
patients_info = [
    # Existing patients 1..4
    {
        "id": 1,
        "username": "Mahommd",
        "email": "Patient1@gmail.com",
        "dob": "1988-03-14",
        "phone": "+1-555-0301",
        "blood_group": "O_POSITIVE",
        "aadhar_no": "900180027001",
        "address": "742 Evergreen Terr, Boston, MA",
        "allergies": "None",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/men/32.jpg",
        "is_new": False
    },
    {
        "id": 2,
        "username": "john_doe",
        "email": "john.doe@example.com",
        "dob": "1990-10-10",
        "phone": "5551234567",
        "blood_group": "B_POSITIVE",
        "aadhar_no": "111122223333",
        "address": "789 Elm St",
        "allergies": "Pollen",
        "chronic_disease": "Hypertension",
        "photo_url": "https://randomuser.me/api/portraits/men/44.jpg",
        "is_new": False
    },
    {
        "id": 3,
        "username": "jane_smith",
        "email": "jane.smith@example.com",
        "dob": "1995-12-05",
        "phone": "5559876543",
        "blood_group": "AB_POSITIVE",
        "aadhar_no": "444455556666",
        "address": "321 Oak Ave",
        "allergies": "Penicillin",
        "chronic_disease": "Asthma",
        "photo_url": "https://randomuser.me/api/portraits/women/44.jpg",
        "is_new": False
    },
    {
        "id": 4,
        "username": "TestUser",
        "email": "test@test.com",
        "dob": "1993-07-25",
        "phone": "+1-555-0304",
        "blood_group": "A_POSITIVE",
        "aadhar_no": "900180027004",
        "address": "21 Jump St, Boston, MA",
        "allergies": "Sulfa",
        "chronic_disease": "Mild Asthma",
        "photo_url": "https://randomuser.me/api/portraits/men/52.jpg",
        "is_new": False
    },
    # New patients 5..20
    {
        "id": 5,
        "username": "emily_watson",
        "email": "emily.watson@example.com",
        "dob": "1994-06-15",
        "phone": "+1-555-0305",
        "blood_group": "A_POSITIVE",
        "aadhar_no": "900180027005",
        "address": "12 Beacon St, Boston, MA",
        "allergies": "Latex",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/women/24.jpg",
        "is_new": True
    },
    {
        "id": 6,
        "username": "michael_chen",
        "email": "michael.chen@example.com",
        "dob": "1985-11-22",
        "phone": "+1-555-0306",
        "blood_group": "O_POSITIVE",
        "aadhar_no": "900180027006",
        "address": "45 Tremont St, Boston, MA",
        "allergies": "None",
        "chronic_disease": "Hypertension",
        "photo_url": "https://randomuser.me/api/portraits/men/22.jpg",
        "is_new": True
    },
    {
        "id": 7,
        "username": "sarah_jenkins",
        "email": "sarah.jenkins@example.com",
        "dob": "1991-03-09",
        "phone": "+1-555-0307",
        "blood_group": "B_POSITIVE",
        "aadhar_no": "900180027007",
        "address": "78 Boylston St, Boston, MA",
        "allergies": "Pollen",
        "chronic_disease": "Asthma",
        "photo_url": "https://randomuser.me/api/portraits/women/28.jpg",
        "is_new": True
    },
    {
        "id": 8,
        "username": "david_rodriguez",
        "email": "david.rodriguez@example.com",
        "dob": "1982-08-30",
        "phone": "+1-555-0308",
        "blood_group": "AB_POSITIVE",
        "aadhar_no": "900180027008",
        "address": "101 Newbury St, Boston, MA",
        "allergies": "Penicillin",
        "chronic_disease": "Type 2 Diabetes",
        "photo_url": "https://randomuser.me/api/portraits/men/33.jpg",
        "is_new": True
    },
    {
        "id": 9,
        "username": "olivia_taylor",
        "email": "olivia.taylor@example.com",
        "dob": "1996-12-18",
        "phone": "+1-555-0309",
        "blood_group": "O_NEGATIVE",
        "aadhar_no": "900180027009",
        "address": "134 Commonwealth Ave, Boston, MA",
        "allergies": "None",
        "chronic_disease": "Migraine",
        "photo_url": "https://randomuser.me/api/portraits/women/36.jpg",
        "is_new": True
    },
    {
        "id": 10,
        "username": "james_wilson",
        "email": "james.wilson@example.com",
        "dob": "1975-04-05",
        "phone": "+1-555-0310",
        "blood_group": "A_NEGATIVE",
        "aadhar_no": "900180027010",
        "address": "156 Hanover St, Boston, MA",
        "allergies": "Aspirin",
        "chronic_disease": "High Cholesterol",
        "photo_url": "https://randomuser.me/api/portraits/men/41.jpg",
        "is_new": True
    },
    {
        "id": 11,
        "username": "sophia_martinez",
        "email": "sophia.martinez@example.com",
        "dob": "1998-02-14",
        "phone": "+1-555-0311",
        "blood_group": "B_NEGATIVE",
        "aadhar_no": "900180027011",
        "address": "189 Charles St, Boston, MA",
        "allergies": "None",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/women/48.jpg",
        "is_new": True
    },
    {
        "id": 12,
        "username": "daniel_anderson",
        "email": "daniel.anderson@example.com",
        "dob": "1989-10-27",
        "phone": "+1-555-0312",
        "blood_group": "O_POSITIVE",
        "aadhar_no": "900180027012",
        "address": "210 Cambridge St, Boston, MA",
        "allergies": "Dust Mites",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/men/55.jpg",
        "is_new": True
    },
    {
        "id": 13,
        "username": "emma_thomas",
        "email": "emma.thomas@example.com",
        "dob": "1992-07-03",
        "phone": "+1-555-0313",
        "blood_group": "A_POSITIVE",
        "aadhar_no": "900180027013",
        "address": "235 State St, Boston, MA",
        "allergies": "None",
        "chronic_disease": "Hypothyroidism",
        "photo_url": "https://randomuser.me/api/portraits/women/58.jpg",
        "is_new": True
    },
    {
        "id": 14,
        "username": "lucas_jackson",
        "email": "lucas.jackson@example.com",
        "dob": "1980-05-19",
        "phone": "+1-555-0314",
        "blood_group": "AB_NEGATIVE",
        "aadhar_no": "900180027014",
        "address": "260 Atlantic Ave, Boston, MA",
        "allergies": "Shellfish",
        "chronic_disease": "GERD",
        "photo_url": "https://randomuser.me/api/portraits/men/60.jpg",
        "is_new": True
    },
    {
        "id": 15,
        "username": "mia_white",
        "email": "mia.white@example.com",
        "dob": "1995-09-11",
        "phone": "+1-555-0315",
        "blood_group": "O_POSITIVE",
        "aadhar_no": "900180027015",
        "address": "285 Congress St, Boston, MA",
        "allergies": "None",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/women/62.jpg",
        "is_new": True
    },
    {
        "id": 16,
        "username": "alex_harris",
        "email": "alexander.harris@example.com",
        "dob": "1987-01-28",
        "phone": "+1-555-0316",
        "blood_group": "B_POSITIVE",
        "aadhar_no": "900180027016",
        "address": "310 Seaport Blvd, Boston, MA",
        "allergies": "Ibuprofen",
        "chronic_disease": "Hypertension",
        "photo_url": "https://randomuser.me/api/portraits/men/65.jpg",
        "is_new": True
    },
    {
        "id": 17,
        "username": "isabella_martin",
        "email": "isabella.martin@example.com",
        "dob": "1993-11-08",
        "phone": "+1-555-0317",
        "blood_group": "A_POSITIVE",
        "aadhar_no": "900180027017",
        "address": "340 Summer St, Boston, MA",
        "allergies": "None",
        "chronic_disease": "Allergic Rhinitis",
        "photo_url": "https://randomuser.me/api/portraits/women/67.jpg",
        "is_new": True
    },
    {
        "id": 18,
        "username": "benjamin_lee",
        "email": "benjamin.lee@example.com",
        "dob": "1978-06-24",
        "phone": "+1-555-0318",
        "blood_group": "O_NEGATIVE",
        "aadhar_no": "900180027018",
        "address": "365 Dorchester Ave, Boston, MA",
        "allergies": "None",
        "chronic_disease": "Arthritis",
        "photo_url": "https://randomuser.me/api/portraits/men/72.jpg",
        "is_new": True
    },
    {
        "id": 19,
        "username": "charlotte_clark",
        "email": "charlotte.clark@example.com",
        "dob": "1997-04-16",
        "phone": "+1-555-0319",
        "blood_group": "B_NEGATIVE",
        "aadhar_no": "900180027019",
        "address": "390 Broadway, Boston, MA",
        "allergies": "None",
        "chronic_disease": "None",
        "photo_url": "https://randomuser.me/api/portraits/women/75.jpg",
        "is_new": True
    },
    {
        "id": 20,
        "username": "william_hall",
        "email": "william.hall@example.com",
        "dob": "1984-12-02",
        "phone": "+1-555-0320",
        "blood_group": "AB_POSITIVE",
        "aadhar_no": "900180027020",
        "address": "415 Harrison Ave, Boston, MA",
        "allergies": "Peanuts",
        "chronic_disease": "Mild Eczema",
        "photo_url": "https://randomuser.me/api/portraits/men/78.jpg",
        "is_new": True
    }
]

# Helper to download image and save to both upload directories
def download_image(url):
    filename = f"{uuid.uuid4()}.jpg"
    dest1 = os.path.join(UPLOADS_ROOT, filename)
    dest2 = os.path.join(UPLOADS_PROFILE, filename)
    req = urllib.request.Request(url, headers={'User-Agent': 'Mozilla/5.0'})
    with urllib.request.urlopen(req, timeout=15) as resp:
        data = resp.read()
    with open(dest1, "wb") as f1:
        f1.write(data)
    with open(dest2, "wb") as f2:
        f2.write(data)
    return f"/uploads/images/{filename}"

print("Step 2: Downloading doctor images...")
for doc in doctors_info:
    try:
        image_url = download_image(doc["photo_url"])
        doc["image_url"] = image_url
        print(f"Doctor {doc['id']} ({doc['username']}): saved as {image_url}")
    except Exception as e:
        print(f"Failed to download image for doctor {doc['id']}: {e}")
        raise

print("Step 3: Downloading patient images...")
for pat in patients_info:
    try:
        image_url = download_image(pat["photo_url"])
        pat["image_url"] = image_url
        print(f"Patient {pat['id']} ({pat['username']}): saved as {image_url}")
    except Exception as e:
        print(f"Failed to download image for patient {pat['id']}: {e}")
        raise

# 4. Generate SQL Statements
sql_lines = []

# Update Doctors
sql_lines.append("-- Update Doctors in profiledb")
for doc in doctors_info:
    sql = f"""UPDATE profiledb.doctors SET 
        department = '{doc['department']}', 
        specialization = '{doc['specialization']}', 
        license_no = '{doc['license_no']}', 
        phone = '{doc['phone']}', 
        address = '{doc['address']}', 
        total_exp = {doc['total_exp']}, 
        blood_group = '{doc['blood_group']}', 
        dob = '{doc['dob']}', 
        image_url = '{doc['image_url']}' 
        WHERE id = {doc['id']};"""
    sql_lines.append(sql)

# Update existing Patients
sql_lines.append("\n-- Update Existing Patients in profiledb")
for pat in patients_info:
    if not pat["is_new"]:
        sql = f"""UPDATE profiledb.patients SET 
            dob = '{pat['dob']}', 
            phone = '{pat['phone']}', 
            blood_group = '{pat['blood_group']}', 
            aadhar_no = '{pat['aadhar_no']}', 
            address = '{pat['address']}', 
            allergies = '{pat['allergies']}', 
            chronic_disease = '{pat['chronic_disease']}', 
            image_url = '{pat['image_url']}' 
            WHERE id = {pat['id']};"""
        sql_lines.append(sql)

# Insert New Patients
sql_lines.append("\n-- Insert New Patients in profiledb")
for pat in patients_info:
    if pat["is_new"]:
        sql = f"""INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES ({pat['id']}, '{pat['dob']}', '{pat['aadhar_no']}', '{pat['address']}', '{pat['allergies']}', '{pat['chronic_disease']}', '{pat['email']}', '{pat['phone']}', '{pat['username']}', '{pat['blood_group']}', '{pat['image_url']}');"""
        sql_lines.append(sql)

# Insert Users for new patients
sql_lines.append("\n-- Insert New Patient Users in userdb")
# Standard bcrypt for password "password"
DEFAULT_PW_HASH = "$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy"
for pat in patients_info:
    if pat["is_new"]:
        sql = f"""INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES ({pat['id']}, '{pat['email']}', '{DEFAULT_PW_HASH}', '{pat['username']}', 'PATIENT');"""
        sql_lines.append(sql)

# 5. Generate appointments (5 appointments for EVERY doctor 1..25)
specialty_cases = {
    "Internal Medicine": [
        ("Annual Comprehensive Health Screening", "Patient routine preventive exam and baseline bloodwork review"),
        ("Hypertension Management Consultation", "Patient reports elevated home BP readings over the past two weeks"),
        ("Fatigue & Vitamin Deficiency Workup", "Evaluation of persistent fatigue, ordering metabolic and iron panel"),
        ("Follow-up on Lipid Panel", "Review of cholesterol panel results and lifestyle recommendations"),
        ("Unexplained Weight Loss Evaluation", "Diagnostic workup for unintended 10lb weight loss in 3 months")
    ],
    "Family Medicine": [
        ("Annual Family Wellness Exam", "Routine physical exam, immunizations update, and preventative counseling"),
        ("Seasonal Allergies and Sinus Check", "Patient experiencing nasal congestion, sneezing, and watery eyes"),
        ("Type 2 Diabetes Routine Follow-up", "Quarterly check-in to review continuous glucose monitor logs"),
        ("Mild Flu Symptoms Consultation", "Low grade fever, sore throat, and muscle aches for 3 days"),
        ("Chronic Back Strain Follow-up", "Checking progress after 4 weeks of physical therapy")
    ],
    "Cardiovascular": [
        ("Post-Myocardial Infarction Checkup", "Echocardiogram follow-up and dual antiplatelet therapy review"),
        ("Heart Palpitations & Arrhythmia Consult", "Patient reports racing pulse at rest, Holter monitor review"),
        ("Hypertensive Heart Disease Follow-up", "Adjusting ACE inhibitor dosage and checking renal profile"),
        ("Cardiovascular Risk Assessment", "Family history of CAD, calculating 10-year ASCVD risk score"),
        ("Congestive Heart Failure Checkup", "Assessing fluid status, pedal edema, and diuretic response")
    ],
    "Cardiology": [
        ("Interventional Angiogram Follow-up", "Post-coronary stent placement assessment and recovery review"),
        ("Aortic Stenosis Surveillance", "Annual echocardiogram comparison and symptom monitoring"),
        ("Exercise Stress Test Follow-up", "Discussing treadmill nuclear stress test findings and next steps"),
        ("Dyspnea on Exertion Investigation", "Investigating shortness of breath when climbing stairs"),
        ("Lipid Lowering Statin Therapy Review", "Evaluating LDL reduction and monitoring liver enzymes")
    ],
    "Pediatrics": [
        ("Well-Child Development Assessment", "Growth milestones check, height/weight percentiles, and developmental screening"),
        ("Routine Pediatric Vaccination Series", "Scheduled MMR and varicella immunizations administration"),
        ("Pediatric Asthma Management", "Inhaler technique review and updated asthma action plan"),
        ("Recurrent Otitis Media Follow-up", "Bilateral ear canal otoscopy following 10-day antibiotic course"),
        ("Nutritional Counseling & Growth Check", "Reviewing dietary intake and pediatric vitamin supplementation")
    ],
    "Neurology": [
        ("Chronic Migraine Prophylaxis Review", "Assessing efficacy of CGRP antagonist and headache log"),
        ("Post-Concussion Syndrome Follow-up", "Evaluating cognitive recovery, light sensitivity, and return-to-work"),
        ("Peripheral Neuropathy Assessment", "Bilateral lower extremity nerve conduction study discussion"),
        ("Tremor & Movement Disorder Evaluation", "Resting tremor vs essential tremor differential diagnosis"),
        ("Epilepsy Medication & EEG Review", "Seizure-free interval review and anti-epileptic drug monitoring")
    ],
    "Orthopedics": [
        ("Knee Osteoarthritis Joint Injection", "Corticosteroid injection consult and knee range of motion exam"),
        ("Post-ACL Reconstruction Follow-up", "Week 6 post-operative stability check and PT progression"),
        ("Rotator Cuff Tendinopathy Check", "Shoulder impingement tests and ultrasound review"),
        ("Carpal Tunnel Syndrome Assessment", "Phalen and Tinel test, conservative splinting management"),
        ("Lumbar Radiculopathy Consult", "L4-L5 disc bulge evaluation and physical therapy referral")
    ],
    "Dermatology": [
        ("Full-Body Skin Cancer Screening", "Dermoscopic examination of suspicious pigmented lesions"),
        ("Severe Plaque Psoriasis Review", "Monitoring response to biologic therapy and PASI score"),
        ("Cystic Acne Treatment Follow-up", "Evaluating oral isotretinoin response and routine lab checks"),
        ("Atopic Dermatitis Flare Consult", "Topical calcineurin inhibitor prescription and skin barrier care"),
        ("Atypical Mole Biopsy Follow-up", "Reviewing pathology report of excised left shoulder nevus")
    ],
    "Oncology": [
        ("Oncology Surveillance & PET Review", "Post-remission surveillance PET-CT scan review"),
        ("Chemotherapy Cycle 3 Pre-Assessment", "Complete blood count and organ function check prior to cycle"),
        ("Immunotherapy Tolerance Consult", "Monitoring for immune-related adverse events and thyroid levels"),
        ("Targeted Therapy Clinical Checkup", "Reviewing molecular testing and oral targeted agent response"),
        ("Post-Surgical Tumor Margin Review", "Multidisciplinary tumor board recommendations discussion")
    ],
    "Gastroenterology": [
        ("Gastroesophageal Reflux Disease Consult", "Refractory GERD evaluation and discussion of upper endoscopy"),
        ("Ulcerative Colitis Maintenance Review", "Fecal calprotectin follow-up and biologic dosage verification"),
        ("Nonalcoholic Fatty Liver Follow-up", "FibroScan result analysis and metabolic counseling"),
        ("Chronic Abdominal Pain & IBS Workup", "Low-FODMAP diet progress and symptom trigger analysis"),
        ("Colonoscopy Screening Pre-Procedure", "Pre-screening anesthesia and bowel prep instructions")
    ],
    "Ophthalmology": [
        ("Comprehensive Diabetic Retinopathy Screen", "Dilated fundus examination and OCT macula scan review"),
        ("Glaucoma Intraocular Pressure Check", "Goldmann applanation tonometry and visual field inspection"),
        ("Cataract Pre-Operative Consultation", "Intraocular lens biometry and surgery scheduling discussion"),
        ("Dry Eye Disease Management", "Tear break-up time test and punctal plug evaluation"),
        ("Sudden Visual Floater Assessment", "Peripheral retinal exam to rule out retinal tear or detachment")
    ],
    "Psychiatry": [
        ("Major Depressive Disorder Follow-up", "PHQ-9 score reassessment and SSRI titration discussion"),
        ("Generalized Anxiety Disorder Checkup", "GAD-7 monitoring and mindfulness therapeutic integration"),
        ("ADHD Medication Optimization", "Symptom rating scale review and stimulant dosage monitoring"),
        ("Bipolar Mood Stabilization Consult", "Mood charting review and therapeutic serum level verification"),
        ("Sleep Architecture & Insomnia Follow-up", "Sleep hygiene protocol and non-benzodiazepine management")
    ],
    "Pulmonology": [
        ("Severe COPD Maintenance Follow-up", "Spirometry FEV1 review and dual bronchodilator optimization"),
        ("Obstructive Sleep Apnea CPAP Review", "Compliance data download and mask fitting evaluation"),
        ("Interstitial Lung Disease Surveillance", "High-resolution chest CT follow-up and DLCO assessment"),
        ("Chronic Refractory Cough Investigation", "Ruling out cough-variant asthma and post-nasal drip"),
        ("Post-Pneumonia Pulmonary Follow-up", "Follow-up chest X-ray to confirm complete infiltrate resolution")
    ],
    "Endocrinology": [
        ("Type 1 Diabetes Insulin Pump Review", "Continuous glucose sensor telemetry and basal-bolus fine-tuning"),
        ("Hashimoto Thyroiditis Follow-up", "TSH and free T4 titration for levothyroxine optimization"),
        ("Osteoporosis DEXA Scan Review", "T-score analysis and bisphosphonate therapy discussion"),
        ("Polycystic Ovary Syndrome Management", "Hormonal panel and metabolic insulin-resistance review"),
        ("Adrenal Nodule Incidentaloma Workup", "Endocrine hormone screening to confirm non-functioning status")
    ],
    "Nephrology": [
        ("Chronic Kidney Disease Stage 3 Follow-up", "eGFR trajectory check, proteinuria evaluation, and BP control"),
        ("Recurrent Nephrolithiasis Prevention", "24-hour urine collection analysis and dietary stone prevention"),
        ("Glomerulonephritis Remission Check", "Urine sediment microscopy and immunosuppressive drug monitoring"),
        ("Polycystic Kidney Disease Monitoring", "Renal ultrasound comparison and blood pressure management"),
        ("Electrolyte Imbalance Evaluation", "Investigating recurrent hypokalemia and aldosterone-renin ratio")
    ],
    "Urology": [
        ("Benign Prostatic Hyperplasia Check", "IPSS symptom score and alpha-blocker therapy assessment"),
        ("Elevated PSA Diagnostic Consult", "PSA velocity tracking and multiparametric MRI prostate review"),
        ("Overactive Bladder Follow-up", "Bladder diary review and anticholinergic efficacy check"),
        ("Hematuria Workup Consultation", "Discussing flexible cystoscopy and renal ultrasound results"),
        ("Post-Vasectomy Verification Check", "Semen analysis confirmation and post-op recovery check")
    ],
    "Otolaryngology": [
        ("Chronic Rhinosinusitis Evaluation", "Nasal endoscopy and sinus CT scan correlation"),
        ("Sensorineural Hearing Loss Assessment", "Pure-tone audiometry and hearing aid consultation"),
        ("Vocal Cord Nodule & Dysphonia Check", "Video stroboscopy and speech pathology referral"),
        ("Recurrent Tonsillitis Surgical Consult", "Assessing tonsillectomy criteria based on infection frequency"),
        ("Benign Paroxysmal Positional Vertigo", "Dix-Hallpike diagnostic test and Epley maneuver therapy")
    ],
    "Rheumatology": [
        ("Rheumatoid Arthritis Disease Activity", "DAS28 score assessment and methotrexate safety labs"),
        ("Systemic Lupus Erythematosus Review", "Complement levels (C3, C4), anti-dsDNA, and urinalysis"),
        ("Ankylosing Spondylitis Follow-up", "Sacroiliac joint MRI review and biologic response check"),
        ("Chronic Gouty Arthritis Consult", "Serum uric acid target verification and allopurinol titration"),
        ("Sjogren Syndrome Symptom Management", "Schirmer test and secretagogue medication follow-up")
    ],
    "Radiology": [
        ("Pre-Interventional Biopsy Consultation", "CT-guided lung nodule biopsy procedure review and consent"),
        ("MRI Musculoskeletal Review With Patient", "Detailed explanation of knee multi-ligament tear imaging"),
        ("Ultrasound-Guided Drainage Consult", "Post-procedure ultrasound check for abdominal fluid collection"),
        ("Neuro-Imaging Case Discussion", "Brain MRI with contrast review explaining ischemic findings"),
        ("Thyroid Nodule TIRADS Consultation", "Thyroid ultrasound TIRADS-4 nodule fine-needle aspiration plan")
    ],
    "General Surgery": [
        ("Laparoscopic Cholecystectomy Post-Op", "Week 2 post-op wound check and dietary fat tolerance review"),
        ("Inguinal Hernia Pre-Operative Consult", "Examining reducible groin hernia and mesh repair planning"),
        ("Post-Appendectomy Healing Check", "Port sites inspection and clearance for normal physical activities"),
        ("Soft Tissue Lipoma Excision Follow-up", "Suture removal and histopathology review of excised tissue"),
        ("Bowel Resection Recovery Consultation", "Stoma care check and gastrointestinal transit progression")
    ],
    "Emergency Medicine": [
        ("Post-ER Discharge Wound Care & Redressing", "Evaluating laceration repair closure on right forearm"),
        ("Acute Traumatic Contusion Follow-up", "Monitoring blunt chest wall trauma resolution and pain relief"),
        ("Mild Head Injury Post-ER Recheck", "Cognitive symptom inventory 72 hours post-concussion"),
        ("Ankle Inversion Sprain Follow-up", "Weight-bearing tolerance and ankle stabilizer brace check"),
        ("Post-Anaphylaxis Recovery Review", "Epinephrine autoinjector training and allergy immunology referral")
    ],
    "Gynecology": [
        ("Routine Annual Gynecological Well-Check", "Cervical cytology Pap smear and pelvic organ examination"),
        ("Second Trimester Prenatal Consultation", "20-week anatomy ultrasound review and maternal vitals check"),
        ("Uterine Fibroid Symptom Evaluation", "Pelvic ultrasound review and heavy menstrual bleeding management"),
        ("Menopausal Transition & HRT Consult", "Vasomotor symptoms check and hormone replacement safety review"),
        ("Polycystic Ovarian Follicle Follow-up", "Transvaginal ultrasound monitoring and menstrual cycle regulation")
    ],
    "Anesthesiology": [
        ("Pre-Operative Anesthesia Risk Assessment", "Airway evaluation (Mallampati III) and cardiac clearance review"),
        ("Chronic Intractable Back Pain Consult", "Lumbar epidural steroid injection planning and medication review"),
        ("Post-Thoracotomy Neuropathic Pain Follow-up", "Intercostal nerve block evaluation and gabapentinoid adjustment"),
        ("Complex Regional Pain Syndrome Check", "Sympathetic block response and physical therapy integration"),
        ("Sedation Plan for High-Risk Endoscopy", "MAC anesthesia pre-screening for patient with severe sleep apnea")
    ]
}

# Base time dates for appointments (spread between Oct 20, 2026 and Nov 25, 2026)
appointment_dates = [
    ("2026-10-20", "09:00:00"),
    ("2026-10-22", "10:30:00"),
    ("2026-10-26", "11:15:00"),
    ("2026-10-29", "14:00:00"),
    ("2026-11-03", "15:30:00"),
    ("2026-11-06", "09:45:00"),
    ("2026-11-10", "11:00:00"),
    ("2026-11-13", "14:30:00"),
    ("2026-11-17", "16:00:00"),
    ("2026-11-20", "10:15:00")
]

sql_lines.append("\n-- Insert 5 appointments for EACH doctor (1..25)")
patient_id_counter = 1
for doc in doctors_info:
    doc_id = doc["id"]
    dept = doc["department"]
    cases = specialty_cases.get(dept, specialty_cases["Internal Medicine"])
    
    # We assign 5 appointments for this doctor
    for i in range(5):
        reason, notes = cases[i % len(cases)]
        
        # Select patient in round robin across all 20 patients
        pat_id = ((patient_id_counter - 1) % 20) + 1
        patient_id_counter += 1
        
        # Calculate distinct time for this doctor
        # Each doctor gets distinct date & time
        date_idx = (doc_id * 2 + i) % len(appointment_dates)
        base_date, base_time = appointment_dates[date_idx]
        
        # Vary minutes slightly per doctor so no collisions across the board
        hour, minute, sec = map(int, base_time.split(":"))
        minute = (minute + (doc_id * 3) % 45) % 60
        app_time = f"{base_date} {hour:02d}:{minute:02d}:00.000000"
        
        sql = f"""INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('{app_time}', {doc_id}, {pat_id}, '{notes.replace("'", "''")}', '{reason.replace("'", "''")}', 'SCHEDULED');"""
        sql_lines.append(sql)

sql_content = "\n".join(sql_lines)
with open("update_system.sql", "w", encoding="utf-8") as f:
    f.write(sql_content)

print(f"Step 4: SQL generated with {len(sql_lines)} statements. Saved to update_system.sql.")

# 6. Execute SQL script
print("Step 5: Executing SQL script into MySQL...")
cmd = 'mysql -u root -pqutoz2274 < update_system.sql'
proc = subprocess.run(cmd, shell=True, capture_output=True, text=True)
if proc.returncode != 0:
    print("Error executing SQL:", proc.stderr)
else:
    print("SQL execution successful!")
    print(proc.stdout)

print("Setup completed successfully.")
