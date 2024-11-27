INSERT INTO domains (program, batch, capacity, qualification) VALUES
        ('B.Tech Computer Science', '2024', 120, 'Bachelor'),
        ('B.Tech Electronics', '2024', 80, 'Bachelor'),
        ('M.Tech Data Science', '2024', 60, 'Master'),
        ('MBA Marketing', '2024', 100, 'Master');

INSERT INTO specialisation (code, name, description, year, credits_required) VALUES
        ('CS101', 'Artificial Intelligence', 'Focus on AI and Machine Learning', 2024, 48),
        ('EE201', 'Embedded Systems', 'Specialisation in embedded system design', 2024, 42),
        ('DS301', 'Data Analytics', 'Emphasis on data analytics and visualization', 2024, 48),
        ('MK401', 'Digital Marketing', 'Focus on digital strategies for marketing', 2024, 48);

INSERT INTO placement (organisation, profile, description, intake, minimum_grade) VALUES
        ('Google', 'Software Engineer', 'Develop scalable software solutions.', 20, 8.5),
        ('Amazon', 'Data Analyst', 'Analyze and interpret large datasets.', 15, 8.0),
        ('Intel', 'Hardware Engineer', 'Design and test embedded systems.', 10, 7.5),
        ('Tata Consultancy', 'Digital Marketing Executive', 'Manage digital campaigns.', 25, 7.0),
        ('Microsoft', 'Cloud Engineer', 'Develop and deploy cloud solutions.', 15, 8.0),
        ('Flipkart', 'Business Analyst', 'Support strategic decisions through data.', 12, 7.5),
        ('Infosys', 'Software Developer', 'Develop business software solutions.', 30, 7.0),
        ('HCL', 'System Engineer', 'Manage IT infrastructure.', 20, 7.5),
        ('Capgemini', 'Data Engineer', 'Build data pipelines and solutions.', 15, 7.8),
        ('Deloitte', 'Consultant', 'Provide strategic business consulting.', 25, 8.0),
        ('Cisco', 'Network Engineer', 'Design and maintain network systems.', 15, 8.2),
        ('Accenture', 'Cloud Consultant', 'Implement cloud-based solutions.', 20, 8.0),
        ('Paytm', 'Product Manager', 'Manage and enhance product offerings.', 10, 8.3),
        ('Wipro', 'Cybersecurity Analyst', 'Ensure cybersecurity for clients.', 12, 7.9);

INSERT INTO placement_filter (placement_id, specialisation, domain) VALUES
        (1, 1, 1),
        (2, 3, 1),
        (3, 2, 2),
        (4, 4, 4),
        (5, 1, 1),
        (6, 3, 1),
        (7, 1, 1),
        (8, 3, 1),
        (9, 3, 1),
        (10, 4, 4),
        (11, 2, 2),
        (12, 1, 1),
        (13, 1, 1),
        (14, 2, 2);
