use construction;

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
