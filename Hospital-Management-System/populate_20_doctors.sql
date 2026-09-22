-- SQL Script to Populate 20 Doctors across Different Departments
-- Password for all doctors: doctor@123 (BCrypt hash: $2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC)

-- 1. Insert 20 Doctor profiles into profiledb.doctors
USE profiledb;

INSERT INTO doctors (id, username, email, dob, phone, address, license_no, blood_group, total_exp, department, specialization, image_url)
VALUES
(6, 'dr_wilson', 'dr.wilson@hospital.com', '1982-03-15', '+1-555-0111', '101 Medical Center Dr, Boston, MA', 'DOC-LIC-2001', 'O_POSITIVE', 14, 'Cardiology', 'Interventional Cardiology', NULL),
(7, 'dr_clark', 'dr.clark@hospital.com', '1985-07-22', '+1-555-0112', '102 Medical Center Dr, Boston, MA', 'DOC-LIC-2002', 'A_POSITIVE', 11, 'Neurology', 'Cognitive & Behavioral Neurology', NULL),
(8, 'dr_brown', 'dr.brown@hospital.com', '1979-11-05', '+1-555-0113', '103 Medical Center Dr, Boston, MA', 'DOC-LIC-2003', 'B_POSITIVE', 16, 'Orthopedics', 'Joint Replacement & Sports Medicine', NULL),
(9, 'dr_davis', 'dr.davis@hospital.com', '1988-02-18', '+1-555-0114', '104 Medical Center Dr, Boston, MA', 'DOC-LIC-2004', 'AB_POSITIVE', 9, 'Pediatrics', 'General & Neonatal Care', NULL),
(10, 'dr_miller', 'dr.miller@hospital.com', '1984-09-30', '+1-555-0115', '105 Medical Center Dr, Boston, MA', 'DOC-LIC-2005', 'O_NEGATIVE', 12, 'Dermatology', 'Clinical & Aesthetic Dermatology', NULL),
(11, 'dr_garcia', 'dr.garcia@hospital.com', '1981-06-12', '+1-555-0116', '106 Medical Center Dr, Boston, MA', 'DOC-LIC-2006', 'A_NEGATIVE', 15, 'Oncology', 'Medical Oncology & Hematology', NULL),
(12, 'dr_martinez', 'dr.martinez@hospital.com', '1983-12-08', '+1-555-0117', '107 Medical Center Dr, Boston, MA', 'DOC-LIC-2007', 'B_NEGATIVE', 13, 'Gastroenterology', 'Hepatology & Endoscopy', NULL),
(13, 'dr_anderson', 'dr.anderson@hospital.com', '1986-04-25', '+1-555-0118', '108 Medical Center Dr, Boston, MA', 'DOC-LIC-2008', 'O_POSITIVE', 10, 'Ophthalmology', 'Cornea & Refractive Surgery', NULL),
(14, 'dr_taylor', 'dr.taylor@hospital.com', '1978-01-19', '+1-555-0119', '109 Medical Center Dr, Boston, MA', 'DOC-LIC-2009', 'A_POSITIVE', 17, 'Psychiatry', 'Adult & Neuropsychiatry', NULL),
(15, 'dr_thomas', 'dr.thomas@hospital.com', '1989-08-14', '+1-555-0120', '110 Medical Center Dr, Boston, MA', 'DOC-LIC-2010', 'B_POSITIVE', 8, 'Pulmonology', 'Respiratory & Critical Care', NULL),
(16, 'dr_white', 'dr.white@hospital.com', '1982-10-03', '+1-555-0121', '111 Medical Center Dr, Boston, MA', 'DOC-LIC-2011', 'AB_NEGATIVE', 14, 'Endocrinology', 'Diabetes & Thyroid Disorders', NULL),
(17, 'dr_harris', 'dr.harris@hospital.com', '1985-05-20', '+1-555-0122', '112 Medical Center Dr, Boston, MA', 'DOC-LIC-2012', 'O_POSITIVE', 11, 'Nephrology', 'Kidney Diseases & Dialysis', NULL),
(18, 'dr_martin', 'dr.martin@hospital.com', '1980-09-17', '+1-555-0123', '113 Medical Center Dr, Boston, MA', 'DOC-LIC-2013', 'A_POSITIVE', 15, 'Urology', 'Endourology & Urologic Oncology', NULL),
(19, 'dr_thompson', 'dr.thompson@hospital.com', '1990-03-29', '+1-555-0124', '114 Medical Center Dr, Boston, MA', 'DOC-LIC-2014', 'B_NEGATIVE', 7, 'Otolaryngology', 'Head, Neck & Sinus Surgery', NULL),
(20, 'dr_jackson', 'dr.jackson@hospital.com', '1977-11-11', '+1-555-0125', '115 Medical Center Dr, Boston, MA', 'DOC-LIC-2015', 'O_NEGATIVE', 18, 'Rheumatology', 'Autoimmune & Joint Disorders', NULL),
(21, 'dr_lee', 'dr.lee@hospital.com', '1984-06-07', '+1-555-0126', '116 Medical Center Dr, Boston, MA', 'DOC-LIC-2016', 'A_NEGATIVE', 12, 'Radiology', 'Diagnostic & Interventional Radiology', NULL),
(22, 'dr_perez', 'dr.perez@hospital.com', '1983-02-23', '+1-555-0127', '117 Medical Center Dr, Boston, MA', 'DOC-LIC-2017', 'AB_POSITIVE', 13, 'General Surgery', 'Minimally Invasive & Laparoscopic Surgery', NULL),
(23, 'dr_robinson', 'dr.robinson@hospital.com', '1988-12-04', '+1-555-0128', '118 Medical Center Dr, Boston, MA', 'DOC-LIC-2018', 'O_POSITIVE', 9, 'Emergency Medicine', 'Trauma & Acute Resuscitation', NULL),
(24, 'dr_hall', 'dr.hall@hospital.com', '1981-08-16', '+1-555-0129', '119 Medical Center Dr, Boston, MA', 'DOC-LIC-2019', 'B_POSITIVE', 15, 'Gynecology', 'Maternal-Fetal Medicine & Women Health', NULL),
(25, 'dr_allen', 'dr.allen@hospital.com', '1986-10-28', '+1-555-0130', '120 Medical Center Dr, Boston, MA', 'DOC-LIC-2020', 'A_POSITIVE', 10, 'Anesthesiology', 'Surgical Anesthesia & Pain Management', NULL);

-- 2. Insert corresponding 20 Doctor user accounts into userdb.users
USE userdb;

INSERT INTO users (id, username, password, email, role, profile_id)
VALUES
(11, 'dr_wilson', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.wilson@hospital.com', 'DOCTOR', 6),
(12, 'dr_clark', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.clark@hospital.com', 'DOCTOR', 7),
(13, 'dr_brown', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.brown@hospital.com', 'DOCTOR', 8),
(14, 'dr_davis', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.davis@hospital.com', 'DOCTOR', 9),
(15, 'dr_miller', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.miller@hospital.com', 'DOCTOR', 10),
(16, 'dr_garcia', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.garcia@hospital.com', 'DOCTOR', 11),
(17, 'dr_martinez', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.martinez@hospital.com', 'DOCTOR', 12),
(18, 'dr_anderson', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.anderson@hospital.com', 'DOCTOR', 13),
(19, 'dr_taylor', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.taylor@hospital.com', 'DOCTOR', 14),
(20, 'dr_thomas', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.thomas@hospital.com', 'DOCTOR', 15),
(21, 'dr_white', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.white@hospital.com', 'DOCTOR', 16),
(22, 'dr_harris', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.harris@hospital.com', 'DOCTOR', 17),
(23, 'dr_martin', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.martin@hospital.com', 'DOCTOR', 18),
(24, 'dr_thompson', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.thompson@hospital.com', 'DOCTOR', 19),
(25, 'dr_jackson', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.jackson@hospital.com', 'DOCTOR', 20),
(26, 'dr_lee', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.lee@hospital.com', 'DOCTOR', 21),
(27, 'dr_perez', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.perez@hospital.com', 'DOCTOR', 22),
(28, 'dr_robinson', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.robinson@hospital.com', 'DOCTOR', 23),
(29, 'dr_hall', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.hall@hospital.com', 'DOCTOR', 24),
(30, 'dr_allen', '$2a$12$JcjsABOQRDnTfo2mgqypVe/s8qlRUifXp5dX1Fuqm3H1Fx0GigEhC', 'dr.allen@hospital.com', 'DOCTOR', 25);
