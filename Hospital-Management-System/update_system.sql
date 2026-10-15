-- Update Doctors in profiledb
UPDATE profiledb.doctors SET 
        department = 'Internal Medicine', 
        specialization = 'General Internal Medicine', 
        license_no = 'DOC-LIC-1001', 
        phone = '+1-555-0101', 
        address = '100 Medical Center Dr, Boston, MA', 
        total_exp = 14, 
        blood_group = 'O_POSITIVE', 
        dob = '1981-04-12', 
        image_url = '/uploads/images/b9963872-8d26-456d-aed7-e8ce3ab48118.jpg' 
        WHERE id = 1;
UPDATE profiledb.doctors SET 
        department = 'Family Medicine', 
        specialization = 'Primary Care & Preventive Health', 
        license_no = 'DOC-LIC-1002', 
        phone = '+1-555-0102', 
        address = '100 Medical Center Dr, Boston, MA', 
        total_exp = 10, 
        blood_group = 'A_POSITIVE', 
        dob = '1986-09-18', 
        image_url = '/uploads/images/5f4e0fa6-d0b0-4596-9b18-b82e8f79538a.jpg' 
        WHERE id = 2;
UPDATE profiledb.doctors SET 
        department = 'Cardiovascular', 
        specialization = 'Cardiology', 
        license_no = 'LIC12345', 
        phone = '1234567890', 
        address = '123 Heart St', 
        total_exp = 10, 
        blood_group = 'O_POSITIVE', 
        dob = '1980-05-15', 
        image_url = '/uploads/images/cceca813-ab78-460c-b3f7-dfdd20ce8d63.jpg' 
        WHERE id = 3;
UPDATE profiledb.doctors SET 
        department = 'Pediatrics', 
        specialization = 'Pediatrics', 
        license_no = 'LIC67890', 
        phone = '9876543210', 
        address = '456 Kid Ln', 
        total_exp = 8, 
        blood_group = 'A_NEGATIVE', 
        dob = '1985-08-22', 
        image_url = '/uploads/images/3fabb909-f4c6-48d0-9bda-ea71125cb8f6.jpg' 
        WHERE id = 4;
UPDATE profiledb.doctors SET 
        department = 'Cardiology', 
        specialization = 'Preventive Cardiology', 
        license_no = 'DOC-LIC-1005', 
        phone = '+1-555-0105', 
        address = '100 Medical Center Dr, Boston, MA', 
        total_exp = 16, 
        blood_group = 'B_POSITIVE', 
        dob = '1979-11-20', 
        image_url = '/uploads/images/e87fb94b-4d31-4492-82aa-5dc422568f96.jpg' 
        WHERE id = 5;
UPDATE profiledb.doctors SET 
        department = 'Cardiology', 
        specialization = 'Interventional Cardiology', 
        license_no = 'DOC-LIC-2001', 
        phone = '+1-555-0111', 
        address = '101 Medical Center Dr, Boston, MA', 
        total_exp = 14, 
        blood_group = 'O_POSITIVE', 
        dob = '1982-03-15', 
        image_url = '/uploads/images/f87f6ec4-4b88-48f1-b52a-c56c0167d202.jpg' 
        WHERE id = 6;
UPDATE profiledb.doctors SET 
        department = 'Neurology', 
        specialization = 'Cognitive & Behavioral Neurology', 
        license_no = 'DOC-LIC-2002', 
        phone = '+1-555-0112', 
        address = '102 Medical Center Dr, Boston, MA', 
        total_exp = 11, 
        blood_group = 'A_POSITIVE', 
        dob = '1985-07-22', 
        image_url = '/uploads/images/d1f506ed-5213-4451-8359-6c93c5154f88.jpg' 
        WHERE id = 7;
UPDATE profiledb.doctors SET 
        department = 'Orthopedics', 
        specialization = 'Joint Replacement & Sports Medicine', 
        license_no = 'DOC-LIC-2003', 
        phone = '+1-555-0113', 
        address = '103 Medical Center Dr, Boston, MA', 
        total_exp = 16, 
        blood_group = 'B_POSITIVE', 
        dob = '1979-11-05', 
        image_url = '/uploads/images/50011b41-8231-4e25-a367-b8cca8a64afb.jpg' 
        WHERE id = 8;
UPDATE profiledb.doctors SET 
        department = 'Pediatrics', 
        specialization = 'General & Neonatal Care', 
        license_no = 'DOC-LIC-2004', 
        phone = '+1-555-0114', 
        address = '104 Medical Center Dr, Boston, MA', 
        total_exp = 9, 
        blood_group = 'AB_POSITIVE', 
        dob = '1988-02-18', 
        image_url = '/uploads/images/b45e949f-3a2b-4f2c-b5f1-46971c7fa1bd.jpg' 
        WHERE id = 9;
UPDATE profiledb.doctors SET 
        department = 'Dermatology', 
        specialization = 'Clinical & Aesthetic Dermatology', 
        license_no = 'DOC-LIC-2005', 
        phone = '+1-555-0115', 
        address = '105 Medical Center Dr, Boston, MA', 
        total_exp = 12, 
        blood_group = 'O_NEGATIVE', 
        dob = '1984-09-30', 
        image_url = '/uploads/images/5c74e743-a279-4523-a883-51b147dec20d.jpg' 
        WHERE id = 10;
UPDATE profiledb.doctors SET 
        department = 'Oncology', 
        specialization = 'Medical Oncology & Hematology', 
        license_no = 'DOC-LIC-2006', 
        phone = '+1-555-0116', 
        address = '106 Medical Center Dr, Boston, MA', 
        total_exp = 15, 
        blood_group = 'A_NEGATIVE', 
        dob = '1981-06-12', 
        image_url = '/uploads/images/f98958a4-32d3-4bb3-b266-0fe031dfc902.jpg' 
        WHERE id = 11;
UPDATE profiledb.doctors SET 
        department = 'Gastroenterology', 
        specialization = 'Hepatology & Endoscopy', 
        license_no = 'DOC-LIC-2007', 
        phone = '+1-555-0117', 
        address = '107 Medical Center Dr, Boston, MA', 
        total_exp = 13, 
        blood_group = 'B_NEGATIVE', 
        dob = '1983-12-08', 
        image_url = '/uploads/images/9e1ee640-f5b5-4469-a2bb-d4b7d29a933b.jpg' 
        WHERE id = 12;
UPDATE profiledb.doctors SET 
        department = 'Ophthalmology', 
        specialization = 'Cornea & Refractive Surgery', 
        license_no = 'DOC-LIC-2008', 
        phone = '+1-555-0118', 
        address = '108 Medical Center Dr, Boston, MA', 
        total_exp = 10, 
        blood_group = 'O_POSITIVE', 
        dob = '1986-04-25', 
        image_url = '/uploads/images/09d4f4b7-c1bd-49ec-ae71-beffb3922886.jpg' 
        WHERE id = 13;
UPDATE profiledb.doctors SET 
        department = 'Psychiatry', 
        specialization = 'Adult & Neuropsychiatry', 
        license_no = 'DOC-LIC-2009', 
        phone = '+1-555-0119', 
        address = '109 Medical Center Dr, Boston, MA', 
        total_exp = 17, 
        blood_group = 'A_POSITIVE', 
        dob = '1978-01-19', 
        image_url = '/uploads/images/e9d3ab61-2cd6-4b52-a2d2-3183f4bcd1de.jpg' 
        WHERE id = 14;
UPDATE profiledb.doctors SET 
        department = 'Pulmonology', 
        specialization = 'Respiratory & Critical Care', 
        license_no = 'DOC-LIC-2010', 
        phone = '+1-555-0120', 
        address = '110 Medical Center Dr, Boston, MA', 
        total_exp = 8, 
        blood_group = 'B_POSITIVE', 
        dob = '1989-08-14', 
        image_url = '/uploads/images/63c8bf9b-a066-4d3b-8d82-f8877aab5fa6.jpg' 
        WHERE id = 15;
UPDATE profiledb.doctors SET 
        department = 'Endocrinology', 
        specialization = 'Diabetes & Thyroid Disorders', 
        license_no = 'DOC-LIC-2011', 
        phone = '+1-555-0121', 
        address = '111 Medical Center Dr, Boston, MA', 
        total_exp = 14, 
        blood_group = 'AB_NEGATIVE', 
        dob = '1982-10-03', 
        image_url = '/uploads/images/6ac47732-4783-4bcd-aebf-049fcda612cb.jpg' 
        WHERE id = 16;
UPDATE profiledb.doctors SET 
        department = 'Nephrology', 
        specialization = 'Kidney Diseases & Dialysis', 
        license_no = 'DOC-LIC-2012', 
        phone = '+1-555-0122', 
        address = '112 Medical Center Dr, Boston, MA', 
        total_exp = 11, 
        blood_group = 'O_POSITIVE', 
        dob = '1985-05-20', 
        image_url = '/uploads/images/359bec74-33b7-45f1-87aa-826b75f6c54f.jpg' 
        WHERE id = 17;
UPDATE profiledb.doctors SET 
        department = 'Urology', 
        specialization = 'Endourology & Urologic Oncology', 
        license_no = 'DOC-LIC-2013', 
        phone = '+1-555-0123', 
        address = '113 Medical Center Dr, Boston, MA', 
        total_exp = 15, 
        blood_group = 'A_POSITIVE', 
        dob = '1980-09-17', 
        image_url = '/uploads/images/cf0f3003-dfa8-40cc-8a47-9e8275e56388.jpg' 
        WHERE id = 18;
UPDATE profiledb.doctors SET 
        department = 'Otolaryngology', 
        specialization = 'Head, Neck & Sinus Surgery', 
        license_no = 'DOC-LIC-2014', 
        phone = '+1-555-0124', 
        address = '114 Medical Center Dr, Boston, MA', 
        total_exp = 7, 
        blood_group = 'B_NEGATIVE', 
        dob = '1990-03-29', 
        image_url = '/uploads/images/9a54bc73-fbeb-4f77-a4d1-db21ada83901.jpg' 
        WHERE id = 19;
UPDATE profiledb.doctors SET 
        department = 'Rheumatology', 
        specialization = 'Autoimmune & Joint Disorders', 
        license_no = 'DOC-LIC-2015', 
        phone = '+1-555-0125', 
        address = '115 Medical Center Dr, Boston, MA', 
        total_exp = 18, 
        blood_group = 'O_NEGATIVE', 
        dob = '1977-11-11', 
        image_url = '/uploads/images/17baa66d-3fa3-46dc-9383-71e787dbcc85.jpg' 
        WHERE id = 20;
UPDATE profiledb.doctors SET 
        department = 'Radiology', 
        specialization = 'Diagnostic & Interventional Radiology', 
        license_no = 'DOC-LIC-2016', 
        phone = '+1-555-0126', 
        address = '116 Medical Center Dr, Boston, MA', 
        total_exp = 12, 
        blood_group = 'A_NEGATIVE', 
        dob = '1984-06-07', 
        image_url = '/uploads/images/bacd1274-4fd5-4b8d-9870-0beb564b223b.jpg' 
        WHERE id = 21;
UPDATE profiledb.doctors SET 
        department = 'General Surgery', 
        specialization = 'Minimally Invasive & Laparoscopic Surgery', 
        license_no = 'DOC-LIC-2017', 
        phone = '+1-555-0127', 
        address = '117 Medical Center Dr, Boston, MA', 
        total_exp = 13, 
        blood_group = 'AB_POSITIVE', 
        dob = '1983-02-23', 
        image_url = '/uploads/images/91287534-836b-4f2c-8de4-7bb26d60510d.jpg' 
        WHERE id = 22;
UPDATE profiledb.doctors SET 
        department = 'Emergency Medicine', 
        specialization = 'Trauma & Acute Resuscitation', 
        license_no = 'DOC-LIC-2018', 
        phone = '+1-555-0128', 
        address = '118 Medical Center Dr, Boston, MA', 
        total_exp = 9, 
        blood_group = 'O_POSITIVE', 
        dob = '1988-12-04', 
        image_url = '/uploads/images/16d0a329-5c38-475e-bdfe-54b7d62aca44.jpg' 
        WHERE id = 23;
UPDATE profiledb.doctors SET 
        department = 'Gynecology', 
        specialization = 'Maternal-Fetal Medicine & Women Health', 
        license_no = 'DOC-LIC-2019', 
        phone = '+1-555-0129', 
        address = '119 Medical Center Dr, Boston, MA', 
        total_exp = 15, 
        blood_group = 'B_POSITIVE', 
        dob = '1981-08-16', 
        image_url = '/uploads/images/a3ea47ed-8af0-4909-833f-16fb1865d739.jpg' 
        WHERE id = 24;
UPDATE profiledb.doctors SET 
        department = 'Anesthesiology', 
        specialization = 'Surgical Anesthesia & Pain Management', 
        license_no = 'DOC-LIC-2020', 
        phone = '+1-555-0130', 
        address = '120 Medical Center Dr, Boston, MA', 
        total_exp = 10, 
        blood_group = 'A_POSITIVE', 
        dob = '1986-10-28', 
        image_url = '/uploads/images/95b85573-4add-4bd7-b912-0b48a60d07b5.jpg' 
        WHERE id = 25;

-- Update Existing Patients in profiledb
UPDATE profiledb.patients SET 
            dob = '1988-03-14', 
            phone = '+1-555-0301', 
            blood_group = 'O_POSITIVE', 
            aadhar_no = '900180027001', 
            address = '742 Evergreen Terr, Boston, MA', 
            allergies = 'None', 
            chronic_disease = 'None', 
            image_url = '/uploads/images/546b11af-429c-4fb2-86de-f2d037d515e7.jpg' 
            WHERE id = 1;
UPDATE profiledb.patients SET 
            dob = '1990-10-10', 
            phone = '5551234567', 
            blood_group = 'B_POSITIVE', 
            aadhar_no = '111122223333', 
            address = '789 Elm St', 
            allergies = 'Pollen', 
            chronic_disease = 'Hypertension', 
            image_url = '/uploads/images/c25ced27-c90e-42ab-8be3-1a0b9ada9b3e.jpg' 
            WHERE id = 2;
UPDATE profiledb.patients SET 
            dob = '1995-12-05', 
            phone = '5559876543', 
            blood_group = 'AB_POSITIVE', 
            aadhar_no = '444455556666', 
            address = '321 Oak Ave', 
            allergies = 'Penicillin', 
            chronic_disease = 'Asthma', 
            image_url = '/uploads/images/c05f8a93-648d-4785-8787-c7f487c77ee7.jpg' 
            WHERE id = 3;
UPDATE profiledb.patients SET 
            dob = '1993-07-25', 
            phone = '+1-555-0304', 
            blood_group = 'A_POSITIVE', 
            aadhar_no = '900180027004', 
            address = '21 Jump St, Boston, MA', 
            allergies = 'Sulfa', 
            chronic_disease = 'Mild Asthma', 
            image_url = '/uploads/images/69f50bf3-a29c-475f-ac7d-762153111000.jpg' 
            WHERE id = 4;

-- Insert New Patients in profiledb
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (5, '1994-06-15', '900180027005', '12 Beacon St, Boston, MA', 'Latex', 'None', 'emily.watson@example.com', '+1-555-0305', 'emily_watson', 'A_POSITIVE', '/uploads/images/57a68de3-b9e5-428f-a50a-be8d4b026dd4.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (6, '1985-11-22', '900180027006', '45 Tremont St, Boston, MA', 'None', 'Hypertension', 'michael.chen@example.com', '+1-555-0306', 'michael_chen', 'O_POSITIVE', '/uploads/images/10dcb9f6-a7ef-4986-bd71-e6ace0114818.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (7, '1991-03-09', '900180027007', '78 Boylston St, Boston, MA', 'Pollen', 'Asthma', 'sarah.jenkins@example.com', '+1-555-0307', 'sarah_jenkins', 'B_POSITIVE', '/uploads/images/6579dd35-fcf0-479f-af3e-c8b5742f681f.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (8, '1982-08-30', '900180027008', '101 Newbury St, Boston, MA', 'Penicillin', 'Type 2 Diabetes', 'david.rodriguez@example.com', '+1-555-0308', 'david_rodriguez', 'AB_POSITIVE', '/uploads/images/2b6c17ad-0c57-4981-8c34-507c01ef6217.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (9, '1996-12-18', '900180027009', '134 Commonwealth Ave, Boston, MA', 'None', 'Migraine', 'olivia.taylor@example.com', '+1-555-0309', 'olivia_taylor', 'O_NEGATIVE', '/uploads/images/01cac8ad-76a5-4c48-9ad1-b5f92ccfc553.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (10, '1975-04-05', '900180027010', '156 Hanover St, Boston, MA', 'Aspirin', 'High Cholesterol', 'james.wilson@example.com', '+1-555-0310', 'james_wilson', 'A_NEGATIVE', '/uploads/images/6f520203-f966-4d26-8664-8202dda1a65d.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (11, '1998-02-14', '900180027011', '189 Charles St, Boston, MA', 'None', 'None', 'sophia.martinez@example.com', '+1-555-0311', 'sophia_martinez', 'B_NEGATIVE', '/uploads/images/be70c341-b08f-4816-aa6d-2e49da3ee300.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (12, '1989-10-27', '900180027012', '210 Cambridge St, Boston, MA', 'Dust Mites', 'None', 'daniel.anderson@example.com', '+1-555-0312', 'daniel_anderson', 'O_POSITIVE', '/uploads/images/ba960d29-1d77-4d10-a02f-93b10eba82dc.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (13, '1992-07-03', '900180027013', '235 State St, Boston, MA', 'None', 'Hypothyroidism', 'emma.thomas@example.com', '+1-555-0313', 'emma_thomas', 'A_POSITIVE', '/uploads/images/7b142be0-b52e-451a-a56b-2b37014d8711.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (14, '1980-05-19', '900180027014', '260 Atlantic Ave, Boston, MA', 'Shellfish', 'GERD', 'lucas.jackson@example.com', '+1-555-0314', 'lucas_jackson', 'AB_NEGATIVE', '/uploads/images/eacc7af4-01a3-4c38-b4da-4ffc77f718f0.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (15, '1995-09-11', '900180027015', '285 Congress St, Boston, MA', 'None', 'None', 'mia.white@example.com', '+1-555-0315', 'mia_white', 'O_POSITIVE', '/uploads/images/fad6551b-14ae-4e9c-a5cc-78966faa8067.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (16, '1987-01-28', '900180027016', '310 Seaport Blvd, Boston, MA', 'Ibuprofen', 'Hypertension', 'alexander.harris@example.com', '+1-555-0316', 'alex_harris', 'B_POSITIVE', '/uploads/images/7db2be51-2ea2-4874-9944-80490eff31f7.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (17, '1993-11-08', '900180027017', '340 Summer St, Boston, MA', 'None', 'Allergic Rhinitis', 'isabella.martin@example.com', '+1-555-0317', 'isabella_martin', 'A_POSITIVE', '/uploads/images/f87bfb79-0854-4965-a43a-cd32d2583679.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (18, '1978-06-24', '900180027018', '365 Dorchester Ave, Boston, MA', 'None', 'Arthritis', 'benjamin.lee@example.com', '+1-555-0318', 'benjamin_lee', 'O_NEGATIVE', '/uploads/images/922b3f93-26a2-47cd-9648-dd96dafa4560.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (19, '1997-04-16', '900180027019', '390 Broadway, Boston, MA', 'None', 'None', 'charlotte.clark@example.com', '+1-555-0319', 'charlotte_clark', 'B_NEGATIVE', '/uploads/images/54bf1b17-ec48-4aa4-ac5d-d3e2ee168059.jpg');
INSERT INTO profiledb.patients 
            (id, dob, aadhar_no, address, allergies, chronic_disease, email, phone, username, blood_group, image_url) 
            VALUES (20, '1984-12-02', '900180027020', '415 Harrison Ave, Boston, MA', 'Peanuts', 'Mild Eczema', 'william.hall@example.com', '+1-555-0320', 'william_hall', 'AB_POSITIVE', '/uploads/images/5a211ced-4c00-44ae-8b71-56f045caf340.jpg');

-- Insert New Patient Users in userdb
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (5, 'emily.watson@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'emily_watson', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (6, 'michael.chen@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'michael_chen', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (7, 'sarah.jenkins@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'sarah_jenkins', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (8, 'david.rodriguez@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'david_rodriguez', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (9, 'olivia.taylor@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'olivia_taylor', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (10, 'james.wilson@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'james_wilson', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (11, 'sophia.martinez@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'sophia_martinez', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (12, 'daniel.anderson@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'daniel_anderson', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (13, 'emma.thomas@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'emma_thomas', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (14, 'lucas.jackson@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'lucas_jackson', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (15, 'mia.white@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'mia_white', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (16, 'alexander.harris@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'alex_harris', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (17, 'isabella.martin@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'isabella_martin', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (18, 'benjamin.lee@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'benjamin_lee', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (19, 'charlotte.clark@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'charlotte_clark', 'PATIENT');
INSERT INTO userdb.users (profile_id, email, password, username, role) 
            VALUES (20, 'william.hall@example.com', '$2a$10$uBNTSxJwztYU1/LKPAbYjO0ybjim1Gyb8rfpZ0SS9eik1nWd754Oy', 'william_hall', 'PATIENT');

-- Insert 5 appointments for EACH doctor (1..25)
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:18:00.000000', 1, 1, 'Patient routine preventive exam and baseline bloodwork review', 'Annual Comprehensive Health Screening', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:03:00.000000', 1, 2, 'Patient reports elevated home BP readings over the past two weeks', 'Hypertension Management Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:33:00.000000', 1, 3, 'Evaluation of persistent fatigue, ordering metabolic and iron panel', 'Fatigue & Vitamin Deficiency Workup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:48:00.000000', 1, 4, 'Review of cholesterol panel results and lifestyle recommendations', 'Follow-up on Lipid Panel', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:03:00.000000', 1, 5, 'Diagnostic workup for unintended 10lb weight loss in 3 months', 'Unexplained Weight Loss Evaluation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:36:00.000000', 2, 6, 'Routine physical exam, immunizations update, and preventative counseling', 'Annual Family Wellness Exam', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:51:00.000000', 2, 7, 'Patient experiencing nasal congestion, sneezing, and watery eyes', 'Seasonal Allergies and Sinus Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:06:00.000000', 2, 8, 'Quarterly check-in to review continuous glucose monitor logs', 'Type 2 Diabetes Routine Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:36:00.000000', 2, 9, 'Low grade fever, sore throat, and muscle aches for 3 days', 'Mild Flu Symptoms Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:06:00.000000', 2, 10, 'Checking progress after 4 weeks of physical therapy', 'Chronic Back Strain Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:09:00.000000', 3, 11, 'Echocardiogram follow-up and dual antiplatelet therapy review', 'Post-Myocardial Infarction Checkup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:39:00.000000', 3, 12, 'Patient reports racing pulse at rest, Holter monitor review', 'Heart Palpitations & Arrhythmia Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:09:00.000000', 3, 13, 'Adjusting ACE inhibitor dosage and checking renal profile', 'Hypertensive Heart Disease Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:24:00.000000', 3, 14, 'Family history of CAD, calculating 10-year ASCVD risk score', 'Cardiovascular Risk Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:09:00.000000', 3, 15, 'Assessing fluid status, pedal edema, and diuretic response', 'Congestive Heart Failure Checkup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:12:00.000000', 4, 16, 'Growth milestones check, height/weight percentiles, and developmental screening', 'Well-Child Development Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:27:00.000000', 4, 17, 'Scheduled MMR and varicella immunizations administration', 'Routine Pediatric Vaccination Series', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:12:00.000000', 4, 18, 'Inhaler technique review and updated asthma action plan', 'Pediatric Asthma Management', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:42:00.000000', 4, 19, 'Bilateral ear canal otoscopy following 10-day antibiotic course', 'Recurrent Otitis Media Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:27:00.000000', 4, 20, 'Reviewing dietary intake and pediatric vitamin supplementation', 'Nutritional Counseling & Growth Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:15:00.000000', 5, 1, 'Post-coronary stent placement assessment and recovery review', 'Interventional Angiogram Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:45:00.000000', 5, 2, 'Annual echocardiogram comparison and symptom monitoring', 'Aortic Stenosis Surveillance', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:30:00.000000', 5, 3, 'Discussing treadmill nuclear stress test findings and next steps', 'Exercise Stress Test Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:15:00.000000', 5, 4, 'Investigating shortness of breath when climbing stairs', 'Dyspnea on Exertion Investigation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:45:00.000000', 5, 5, 'Evaluating LDL reduction and monitoring liver enzymes', 'Lipid Lowering Statin Therapy Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:33:00.000000', 6, 6, 'Post-coronary stent placement assessment and recovery review', 'Interventional Angiogram Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:18:00.000000', 6, 7, 'Annual echocardiogram comparison and symptom monitoring', 'Aortic Stenosis Surveillance', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:48:00.000000', 6, 8, 'Discussing treadmill nuclear stress test findings and next steps', 'Exercise Stress Test Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:03:00.000000', 6, 9, 'Investigating shortness of breath when climbing stairs', 'Dyspnea on Exertion Investigation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:18:00.000000', 6, 10, 'Evaluating LDL reduction and monitoring liver enzymes', 'Lipid Lowering Statin Therapy Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:51:00.000000', 7, 11, 'Assessing efficacy of CGRP antagonist and headache log', 'Chronic Migraine Prophylaxis Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:06:00.000000', 7, 12, 'Evaluating cognitive recovery, light sensitivity, and return-to-work', 'Post-Concussion Syndrome Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:21:00.000000', 7, 13, 'Bilateral lower extremity nerve conduction study discussion', 'Peripheral Neuropathy Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:51:00.000000', 7, 14, 'Resting tremor vs essential tremor differential diagnosis', 'Tremor & Movement Disorder Evaluation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:21:00.000000', 7, 15, 'Seizure-free interval review and anti-epileptic drug monitoring', 'Epilepsy Medication & EEG Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:24:00.000000', 8, 16, 'Corticosteroid injection consult and knee range of motion exam', 'Knee Osteoarthritis Joint Injection', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:54:00.000000', 8, 17, 'Week 6 post-operative stability check and PT progression', 'Post-ACL Reconstruction Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:24:00.000000', 8, 18, 'Shoulder impingement tests and ultrasound review', 'Rotator Cuff Tendinopathy Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:39:00.000000', 8, 19, 'Phalen and Tinel test, conservative splinting management', 'Carpal Tunnel Syndrome Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:24:00.000000', 8, 20, 'L4-L5 disc bulge evaluation and physical therapy referral', 'Lumbar Radiculopathy Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:27:00.000000', 9, 1, 'Growth milestones check, height/weight percentiles, and developmental screening', 'Well-Child Development Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:42:00.000000', 9, 2, 'Scheduled MMR and varicella immunizations administration', 'Routine Pediatric Vaccination Series', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:27:00.000000', 9, 3, 'Inhaler technique review and updated asthma action plan', 'Pediatric Asthma Management', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:57:00.000000', 9, 4, 'Bilateral ear canal otoscopy following 10-day antibiotic course', 'Recurrent Otitis Media Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:42:00.000000', 9, 5, 'Reviewing dietary intake and pediatric vitamin supplementation', 'Nutritional Counseling & Growth Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:30:00.000000', 10, 6, 'Dermoscopic examination of suspicious pigmented lesions', 'Full-Body Skin Cancer Screening', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:00:00.000000', 10, 7, 'Monitoring response to biologic therapy and PASI score', 'Severe Plaque Psoriasis Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:45:00.000000', 10, 8, 'Evaluating oral isotretinoin response and routine lab checks', 'Cystic Acne Treatment Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:30:00.000000', 10, 9, 'Topical calcineurin inhibitor prescription and skin barrier care', 'Atopic Dermatitis Flare Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:00:00.000000', 10, 10, 'Reviewing pathology report of excised left shoulder nevus', 'Atypical Mole Biopsy Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:48:00.000000', 11, 11, 'Post-remission surveillance PET-CT scan review', 'Oncology Surveillance & PET Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:33:00.000000', 11, 12, 'Complete blood count and organ function check prior to cycle', 'Chemotherapy Cycle 3 Pre-Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:03:00.000000', 11, 13, 'Monitoring for immune-related adverse events and thyroid levels', 'Immunotherapy Tolerance Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:18:00.000000', 11, 14, 'Reviewing molecular testing and oral targeted agent response', 'Targeted Therapy Clinical Checkup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:33:00.000000', 11, 15, 'Multidisciplinary tumor board recommendations discussion', 'Post-Surgical Tumor Margin Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:06:00.000000', 12, 16, 'Refractory GERD evaluation and discussion of upper endoscopy', 'Gastroesophageal Reflux Disease Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:21:00.000000', 12, 17, 'Fecal calprotectin follow-up and biologic dosage verification', 'Ulcerative Colitis Maintenance Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:36:00.000000', 12, 18, 'FibroScan result analysis and metabolic counseling', 'Nonalcoholic Fatty Liver Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:06:00.000000', 12, 19, 'Low-FODMAP diet progress and symptom trigger analysis', 'Chronic Abdominal Pain & IBS Workup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:36:00.000000', 12, 20, 'Pre-screening anesthesia and bowel prep instructions', 'Colonoscopy Screening Pre-Procedure', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:39:00.000000', 13, 1, 'Dilated fundus examination and OCT macula scan review', 'Comprehensive Diabetic Retinopathy Screen', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:09:00.000000', 13, 2, 'Goldmann applanation tonometry and visual field inspection', 'Glaucoma Intraocular Pressure Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:39:00.000000', 13, 3, 'Intraocular lens biometry and surgery scheduling discussion', 'Cataract Pre-Operative Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:54:00.000000', 13, 4, 'Tear break-up time test and punctal plug evaluation', 'Dry Eye Disease Management', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:39:00.000000', 13, 5, 'Peripheral retinal exam to rule out retinal tear or detachment', 'Sudden Visual Floater Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:42:00.000000', 14, 6, 'PHQ-9 score reassessment and SSRI titration discussion', 'Major Depressive Disorder Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:57:00.000000', 14, 7, 'GAD-7 monitoring and mindfulness therapeutic integration', 'Generalized Anxiety Disorder Checkup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:42:00.000000', 14, 8, 'Symptom rating scale review and stimulant dosage monitoring', 'ADHD Medication Optimization', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:12:00.000000', 14, 9, 'Mood charting review and therapeutic serum level verification', 'Bipolar Mood Stabilization Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:57:00.000000', 14, 10, 'Sleep hygiene protocol and non-benzodiazepine management', 'Sleep Architecture & Insomnia Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:00:00.000000', 15, 11, 'Spirometry FEV1 review and dual bronchodilator optimization', 'Severe COPD Maintenance Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:30:00.000000', 15, 12, 'Compliance data download and mask fitting evaluation', 'Obstructive Sleep Apnea CPAP Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:15:00.000000', 15, 13, 'High-resolution chest CT follow-up and DLCO assessment', 'Interstitial Lung Disease Surveillance', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:00:00.000000', 15, 14, 'Ruling out cough-variant asthma and post-nasal drip', 'Chronic Refractory Cough Investigation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:30:00.000000', 15, 15, 'Follow-up chest X-ray to confirm complete infiltrate resolution', 'Post-Pneumonia Pulmonary Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:18:00.000000', 16, 16, 'Continuous glucose sensor telemetry and basal-bolus fine-tuning', 'Type 1 Diabetes Insulin Pump Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:03:00.000000', 16, 17, 'TSH and free T4 titration for levothyroxine optimization', 'Hashimoto Thyroiditis Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:33:00.000000', 16, 18, 'T-score analysis and bisphosphonate therapy discussion', 'Osteoporosis DEXA Scan Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:48:00.000000', 16, 19, 'Hormonal panel and metabolic insulin-resistance review', 'Polycystic Ovary Syndrome Management', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:03:00.000000', 16, 20, 'Endocrine hormone screening to confirm non-functioning status', 'Adrenal Nodule Incidentaloma Workup', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:36:00.000000', 17, 1, 'eGFR trajectory check, proteinuria evaluation, and BP control', 'Chronic Kidney Disease Stage 3 Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:51:00.000000', 17, 2, '24-hour urine collection analysis and dietary stone prevention', 'Recurrent Nephrolithiasis Prevention', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:06:00.000000', 17, 3, 'Urine sediment microscopy and immunosuppressive drug monitoring', 'Glomerulonephritis Remission Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:36:00.000000', 17, 4, 'Renal ultrasound comparison and blood pressure management', 'Polycystic Kidney Disease Monitoring', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:06:00.000000', 17, 5, 'Investigating recurrent hypokalemia and aldosterone-renin ratio', 'Electrolyte Imbalance Evaluation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:09:00.000000', 18, 6, 'IPSS symptom score and alpha-blocker therapy assessment', 'Benign Prostatic Hyperplasia Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:39:00.000000', 18, 7, 'PSA velocity tracking and multiparametric MRI prostate review', 'Elevated PSA Diagnostic Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:09:00.000000', 18, 8, 'Bladder diary review and anticholinergic efficacy check', 'Overactive Bladder Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:24:00.000000', 18, 9, 'Discussing flexible cystoscopy and renal ultrasound results', 'Hematuria Workup Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:09:00.000000', 18, 10, 'Semen analysis confirmation and post-op recovery check', 'Post-Vasectomy Verification Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:12:00.000000', 19, 11, 'Nasal endoscopy and sinus CT scan correlation', 'Chronic Rhinosinusitis Evaluation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:27:00.000000', 19, 12, 'Pure-tone audiometry and hearing aid consultation', 'Sensorineural Hearing Loss Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:12:00.000000', 19, 13, 'Video stroboscopy and speech pathology referral', 'Vocal Cord Nodule & Dysphonia Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:42:00.000000', 19, 14, 'Assessing tonsillectomy criteria based on infection frequency', 'Recurrent Tonsillitis Surgical Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:27:00.000000', 19, 15, 'Dix-Hallpike diagnostic test and Epley maneuver therapy', 'Benign Paroxysmal Positional Vertigo', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:15:00.000000', 20, 16, 'DAS28 score assessment and methotrexate safety labs', 'Rheumatoid Arthritis Disease Activity', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:45:00.000000', 20, 17, 'Complement levels (C3, C4), anti-dsDNA, and urinalysis', 'Systemic Lupus Erythematosus Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:30:00.000000', 20, 18, 'Sacroiliac joint MRI review and biologic response check', 'Ankylosing Spondylitis Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:15:00.000000', 20, 19, 'Serum uric acid target verification and allopurinol titration', 'Chronic Gouty Arthritis Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:45:00.000000', 20, 20, 'Schirmer test and secretagogue medication follow-up', 'Sjogren Syndrome Symptom Management', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:33:00.000000', 21, 1, 'CT-guided lung nodule biopsy procedure review and consent', 'Pre-Interventional Biopsy Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:18:00.000000', 21, 2, 'Detailed explanation of knee multi-ligament tear imaging', 'MRI Musculoskeletal Review With Patient', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:48:00.000000', 21, 3, 'Post-procedure ultrasound check for abdominal fluid collection', 'Ultrasound-Guided Drainage Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:03:00.000000', 21, 4, 'Brain MRI with contrast review explaining ischemic findings', 'Neuro-Imaging Case Discussion', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:18:00.000000', 21, 5, 'Thyroid ultrasound TIRADS-4 nodule fine-needle aspiration plan', 'Thyroid Nodule TIRADS Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:51:00.000000', 22, 6, 'Week 2 post-op wound check and dietary fat tolerance review', 'Laparoscopic Cholecystectomy Post-Op', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-06 09:06:00.000000', 22, 7, 'Examining reducible groin hernia and mesh repair planning', 'Inguinal Hernia Pre-Operative Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:21:00.000000', 22, 8, 'Port sites inspection and clearance for normal physical activities', 'Post-Appendectomy Healing Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:51:00.000000', 22, 9, 'Suture removal and histopathology review of excised tissue', 'Soft Tissue Lipoma Excision Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:21:00.000000', 22, 10, 'Stoma care check and gastrointestinal transit progression', 'Bowel Resection Recovery Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-10 11:24:00.000000', 23, 11, 'Evaluating laceration repair closure on right forearm', 'Post-ER Discharge Wound Care & Redressing', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-13 14:54:00.000000', 23, 12, 'Monitoring blunt chest wall trauma resolution and pain relief', 'Acute Traumatic Contusion Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:24:00.000000', 23, 13, 'Cognitive symptom inventory 72 hours post-concussion', 'Mild Head Injury Post-ER Recheck', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:39:00.000000', 23, 14, 'Weight-bearing tolerance and ankle stabilizer brace check', 'Ankle Inversion Sprain Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:24:00.000000', 23, 15, 'Epinephrine autoinjector training and allergy immunology referral', 'Post-Anaphylaxis Recovery Review', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-17 16:27:00.000000', 24, 16, 'Cervical cytology Pap smear and pelvic organ examination', 'Routine Annual Gynecological Well-Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-20 10:42:00.000000', 24, 17, '20-week anatomy ultrasound review and maternal vitals check', 'Second Trimester Prenatal Consultation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:27:00.000000', 24, 18, 'Pelvic ultrasound review and heavy menstrual bleeding management', 'Uterine Fibroid Symptom Evaluation', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:57:00.000000', 24, 19, 'Vasomotor symptoms check and hormone replacement safety review', 'Menopausal Transition & HRT Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:42:00.000000', 24, 20, 'Transvaginal ultrasound monitoring and menstrual cycle regulation', 'Polycystic Ovarian Follicle Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-20 09:30:00.000000', 25, 1, 'Airway evaluation (Mallampati III) and cardiac clearance review', 'Pre-Operative Anesthesia Risk Assessment', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-22 10:00:00.000000', 25, 2, 'Lumbar epidural steroid injection planning and medication review', 'Chronic Intractable Back Pain Consult', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-26 11:45:00.000000', 25, 3, 'Intercostal nerve block evaluation and gabapentinoid adjustment', 'Post-Thoracotomy Neuropathic Pain Follow-up', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-10-29 14:30:00.000000', 25, 4, 'Sympathetic block response and physical therapy integration', 'Complex Regional Pain Syndrome Check', 'SCHEDULED');
INSERT INTO appointmentdb.appointments 
            (appointment_time, doctor_id, patient_id, notes, reason, status) 
            VALUES ('2026-11-03 15:00:00.000000', 25, 5, 'MAC anesthesia pre-screening for patient with severe sleep apnea', 'Sedation Plan for High-Risk Endoscopy', 'SCHEDULED');