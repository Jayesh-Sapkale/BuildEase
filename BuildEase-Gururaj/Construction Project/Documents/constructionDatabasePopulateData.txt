use construction;
INSERT INTO address (adr_line1, adr_line2, city, country, state, zipcode)
VALUES 
    ('12 MG Road', 'Flat 102', 'Bengaluru', 'India', 'Karnataka', '560001'),
    ('45 Park Street', '', 'Kolkata', 'India', 'West Bengal', '700016'),
    ('23 Anna Salai', 'Apt 4B', 'Chennai', 'India', 'Tamil Nadu', '600002'),
    ('67 Connaught Place', 'Building 5', 'New Delhi', 'India', 'Delhi', '110001'),
    ('89 Marine Drive', '', 'Mumbai', 'India', 'Maharashtra', '400020'),
    ('56 Rajpur Road', 'House 3', 'Dehradun', 'India', 'Uttarakhand', '248001'),
    ('101 Residency Road', 'Suite 3A', 'Bengaluru', 'India', 'Karnataka', '560025'),
    ('78 Banjara Hills', '', 'Hyderabad', 'India', 'Telangana', '500034'),
    ('34 Lal Darwaja', '', 'Ahmedabad', 'India', 'Gujarat', '380001'),
    ('92 Gariahat', 'Floor 2', 'Kolkata', 'India', 'West Bengal', '700029');

INSERT INTO basic_details (birth_date, first_name, gender, last_name)
VALUES 
    ('1985-05-15', 'Arjun', 'Male', 'Sharma'),
    ('1990-08-20', 'Priya', 'Female', 'Kapoor'),
    ('1978-11-30', 'Ravi', 'Male', 'Varma'),
    ('1983-02-14', 'Sneha', 'Female', 'Patel'),
    ('1992-06-25', 'Ankit', 'Male', 'Mehta'),
    ('1988-12-10', 'Nisha', 'Female', 'Bajaj'),
    ('1984-09-18', 'Vikram', 'Male', 'Rao'),
    ('1995-03-05', 'Aditi', 'Female', 'Chopra'),
    ('1981-07-22', 'Rohan', 'Male', 'Joshi'),
    ('1977-01-29', 'Divya', 'Female', 'Nair');

INSERT INTO contact_details (contact_number, email, url)
VALUES 
    ('9876543210', 'arjun.sharma@example.com', 'https://www.arjunsharma.com'),
    ('9988776655', 'priya.kapoor@example.com', 'https://www.priyakapoor.com'),
    ('9123456789', 'ravi.varma@example.com', 'https://www.ravivarma.com'),
    ('9876541230', 'sneha.patel@example.com', 'https://www.snehapatel.com'),
    ('9008765432', 'ankit.mehta@example.com', 'https://www.ankitmehta.com'),
    ('9812345678', 'nisha.bajaj@example.com', 'https://www.nishabajaj.com'),
    ('9876123456', 'vikram.rao@example.com', 'https://www.vikramrao.com'),
    ('9876654321', 'aditi.chopra@example.com', 'https://www.aditichopra.com'),
    ('9001234567', 'rohan.joshi@example.com', 'https://www.rohanjoshi.com'),
    ('9823456789', 'divya.nair@example.com', 'https://www.divyanair.com');

INSERT INTO admin (password, role, user_name, last_login, last_password_change, address_id, basic_details_id, contact_details_id)
VALUES 
    ('adminPwd123', 'Admin', 'admin_arjun', '2024-08-08', '2024-08-08', 1, 1, 1),
    ('adminPwd456', 'Admin', 'admin_priya', '2024-08-08', '2024-08-08', 2, 2, 2),
    ('adminPwd789', 'Admin', 'admin_ravi', '2024-08-08', '2024-08-08', 3, 3, 3),
    ('adminPwd101', 'Admin', 'admin_sneha', '2024-08-08', '2024-08-08', 4, 4, 4),
    ('adminPwd202', 'Admin', 'admin_ankit', '2024-08-08', '2024-08-08', 5, 5, 5),
    ('adminPwd303', 'Admin', 'admin_nisha', '2024-08-08', '2024-08-08', 6, 6, 6),
    ('adminPwd404', 'Admin', 'admin_vikram', '2024-08-08', '2024-08-08', 7, 7, 7),
    ('adminPwd505', 'Admin', 'admin_aditi', '2024-08-08', '2024-08-08', 8, 8, 8),
    ('adminPwd606', 'Admin', 'admin_rohan', '2024-08-08', '2024-08-08', 9, 9, 9),
    ('adminPwd707', 'Admin', 'admin_divya', '2024-08-08', '2024-08-08', 10, 10, 10);


INSERT INTO builder (password, role, user_name, availability, construction_type, emergency_contact_number, rate_per_month, years_of_experience, address_id, basic_details_id, contact_details_id)
VALUES
('builderPwd123', 'Builder', 'builder_raj', 'YES', 'HOUSE', '9876543210', 50000, 10, 1, 1, 1),
('builderSecure456', 'Builder', 'builder_neha', 'NO', 'APARTMENT', '9876543211', 60000, 8, 2, 2, 2),
('builderPass789', 'Builder', 'builder_amit', 'YES', 'WAREHOUSE', '9876543212', 55000, 12, 3, 3, 3),
('secureBuilder101', 'Builder', 'builder_pooja', 'YES', 'MALL', '9876543213', 70000, 15, 4, 4, 4),
('passwordBuilder202', 'Builder', 'builder_vikram', 'NO', 'HOUSE', '9876543214', 48000, 7, 5, 5, 5),
('builderPwd303', 'Builder', 'builder_shweta', 'YES', 'APARTMENT', '9876543215', 62000, 9, 6, 6, 6),
('securePass404', 'Builder', 'builder_arun', 'YES', 'WAREHOUSE', '9876543216', 53000, 11, 7, 7, 7),
('passwordBuilder505', 'Builder', 'builder_rahul', 'NO', 'MALL', '9876543217', 75000, 13, 8, 8, 8),
('builderSecure606', 'Builder', 'builder_anita', 'YES', 'HOUSE', '9876543218', 52000, 10, 9, 9, 9),
('builderPass707', 'Builder', 'builder_sanjay', 'YES', 'APARTMENT', '9876543219', 68000, 14, 10, 10, 10);

INSERT INTO customer (password, role, user_name, account_creation_date, address_id, basic_details_id, contact_details_id)
VALUES
('password123', 'Customer', 'john_doe', '2024-01-15', 1, 1, 1),
('securePass456', 'Customer', 'jane_doe', '2024-03-22', 2, 2, 2),
('mypassword789', 'Customer', 'alice_smith', '2024-05-10', 3, 3, 3),
('pass9876', 'Customer', 'bob_johnson', '2024-06-01', 4, 4, 4),
('secure4567', 'Customer', 'carol_williams', '2024-07-20', 5, 5, 5),
('strongPass8', 'Customer', 'david_jones', '2024-08-15', 6, 6, 6),
('pass4321', 'Customer', 'eva_brown', '2024-09-10', 7, 7, 7),
('safePass1', 'Customer', 'frank_davis', '2024-10-01', 8, 8, 8),
('password567', 'Customer', 'grace_miller', '2024-11-05', 9, 9, 9),
('secure789', 'Customer', 'henry_wilson', '2024-12-01', 10, 10, 10);

INSERT INTO builder_review (rating, review, review_date, builder_id, customer_id)
VALUES
(5, 'Excellent work and great attention to detail.', '2024-07-01', 1, 1),
(4, 'Good job overall, but there were some delays.', '2024-07-15', 2, 2),
(3, 'Average experience, not what I expected.', '2024-08-01', 3, 3),
(5, 'Outstanding service and quality!', '2024-08-15', 4, 4),
(4, 'Very satisfied with the result.', '2024-09-01', 5, 5),
(2, 'Not as good as I hoped.', '2024-09-15', 6, 6),
(3, 'Mediocre, could be improved.', '2024-10-01', 7, 7),
(4, 'Good, but had some minor issues.', '2024-10-15', 8, 8),
(5, 'Exceptional work, highly recommend!', '2024-11-01', 9, 9),
(4, 'Satisfactory, with some room for improvement.', '2024-11-15', 10, 10);


INSERT INTO company (company_id, annual_revenue, construction_type, founding_date, license_number, name, number_of_employees, address_id, builder_id, contact_details_id) VALUES
(1, 5000000, 'APARTMENT', '2001-01-01', 123456789, 'Tata Housing', 1200, 1, 1, 1),
(2, 7500000, 'MALL', '1995-06-15', 987654321, 'DLF Ltd.', 2000, 2, 2, 2),
(3, 6000000, 'WAREHOUSE', '2010-09-23', 112233445, 'GMR Infrastructure', 800, 3, 3, 3),
(4, 4500000, 'HOUSE', '2005-03-10', 223344556, 'L&T Realty', 950, 4, 4, 4),
(5, 8500000, 'APARTMENT', '2000-11-28', 334455667, 'Godrej Properties', 1500, 5, 5, 5),
(6, 7000000, 'MALL', '1998-07-14', 445566778, 'Oberoi Realty', 1800, 6, 6, 6),
(7, 5500000, 'WAREHOUSE', '2012-04-21', 556677889, 'Shapoorji Pallonji', 850, 7, 7, 7),
(8, 6500000, 'HOUSE', '2007-09-30', 667788990, 'Mahindra Lifespaces', 1100, 8, 8, 8),
(9, 9000000, 'APARTMENT', '1999-02-17', 778899001, 'Prestige Estates', 1700, 9, 9, 9),
(10, 8000000, 'MALL', '1996-12-05', 889900112, 'Brigade Group', 1600, 10, 10, 10);

INSERT INTO construction_details (construction_detail_id, area_in_sq_ft, builder_name, construction_description, construction_type) VALUES
(1, 5000, 'Tata Projects', 'Residential Apartments in Mumbai', 'APARTMENT'),
(2, 15000, 'DLF Builders', 'Shopping Mall in Delhi', 'MALL'),
(3, 8000, 'GMR Builders', 'Warehouse in Hyderabad', 'WAREHOUSE'),
(4, 3000, 'L&T Construction', 'Luxury Villas in Bangalore', 'HOUSE'),
(5, 7000, 'Godrej Construction', 'High-rise Apartments in Pune', 'APARTMENT'),
(6, 14000, 'Oberoi Constructions', 'Commercial Mall in Mumbai', 'MALL'),
(7, 9000, 'Shapoorji Builders', 'Storage Warehouse in Chennai', 'WAREHOUSE'),
(8, 3500, 'Mahindra Constructions', 'Independent Houses in Chennai', 'HOUSE'),
(9, 7500, 'Prestige Constructions', 'Apartments in Kochi', 'APARTMENT'),
(10, 13000, 'Brigade Constructions', 'Shopping Complex in Bangalore', 'MALL');

INSERT INTO project (project_id, end_date, project_description, project_name, project_status, start_date, total_price, address_id, builder_id, construction_details_id, customer_id) VALUES
(1, '2025-01-01', 'Luxury Apartments in South Mumbai', 'The Crest', 'IN_PROGRESS', '2023-01-01', 25000000, 1, 1, 1, 1),
(2, '2024-12-31', 'High-end Mall in South Delhi', 'DLF Promenade', 'IN_PROGRESS', '2022-12-01', 40000000, 2, 2, 2, 2),
(3, '2024-06-30', 'Large Warehouse in Gachibowli', 'GMR Logistics', 'COMPLETE', '2023-06-01', 15000000, 3, 3, 3, 3),
(4, '2025-09-15', 'Luxury Villas in Whitefield', 'L&T Villas', 'PENDING', '2024-03-15', 35000000, 4, 4, 4, 4),
(5, '2024-08-30', 'Residential Complex in Baner', 'Godrej Horizon', 'IN_PROGRESS', '2023-08-01', 27000000, 5, 5, 5, 5),
(6, '2024-04-10', 'Commercial Mall in Andheri', 'Oberoi Mall', 'COMPLETE', '2022-04-10', 38000000, 6, 6, 6, 6),
(7, '2025-02-20', 'Storage Facility in Ambattur', 'Shapoorji Storage', 'IN_PROGRESS', '2023-02-20', 18000000, 7, 7, 7, 7),
(8, '2024-11-10', 'Independent Houses in Adyar', 'Mahindra Greens', 'PENDING', '2023-11-10', 22000000, 8, 8, 8, 8),
(9, '2024-10-25', 'High-rise Apartments in Kakkanad', 'Prestige Habitat', 'IN_PROGRESS', '2023-10-25', 29000000, 9, 9, 9, 9),
(10, '2024-07-15', 'Shopping Complex in Whitefield', 'Brigade Orion', 'IN_PROGRESS', '2022-07-15', 36000000, 10, 10, 10, 10);


