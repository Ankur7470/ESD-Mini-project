INSERT INTO domains (program, batch, capacity, qualification) VALUES
        ('Computer Science', 'Batch A', 50, 'Bachelors'),
        ('Mechanical Engineering', 'Batch B', 60, 'Bachelors'),
        ('Electrical Engineering', 'Batch C', 40, 'Bachelors'),
        ('Civil Engineering', 'Batch D', 70, 'Bachelors'),
        ('Information Technology', 'Batch E', 55, 'Bachelors'),
        ('Chemical Engineering', 'Batch F', 45, 'Bachelors'),
        ('Aerospace Engineering', 'Batch G', 50, 'Bachelors');

INSERT INTO specialisation (code, name, description, year, credits_required) VALUES
        ('CS101', 'Artificial Intelligence', 'Introduction to AI', 1, 20),
        ('CS102', 'Data Science', 'Introduction to Data Science', 2, 18),
        ('CS103', 'Machine Learning', 'Advanced Machine Learning', 3, 22),
        ('ME101', 'Thermodynamics', 'Introduction to Thermodynamics', 1, 20),
        ('ME102', 'Fluid Mechanics', 'Basic Fluid Mechanics', 2, 18),
        ('EE101', 'Electrical Circuits', 'Basic Electrical Circuits', 1, 20),
        ('CE101', 'Structural Analysis', 'Fundamentals of Structural Analysis', 1, 20),
        ('IT101', 'Web Development', 'Frontend and backend development', 1, 18),
        ('CH101', 'Process Engineering', 'Chemical process optimization', 2, 20),
        ('AE101', 'Aerospace Dynamics', 'Aerodynamics and propulsion', 1, 22);

INSERT INTO placement (organisation, profile, description, intake, minimum_grade) VALUES
        ('ABC Corp', 'Software Engineer', 'Develop software solutions', 30, 7),
        ('XYZ Ltd', 'Data Analyst', 'Analyze data to derive insights', 25, 6.5),
        ('Tech Solutions', 'Data Scientist', 'Develop AI solutions', 20, 7.5),
        ('Innovatech', 'Cloud Engineer', 'Build cloud infrastructures', 15, 6.8),
        ('GlobalTech', 'Full Stack Developer', 'Develop web applications', 40, 7),
        ('Fintech Inc', 'Financial Analyst', 'Analyze financial data', 35, 7.2),
        ('AutoMotive', 'Mechanical Engineer', 'Design and optimize mechanical systems', 30, 7.3),
        ('CodeWave', 'Frontend Developer', 'Create engaging web interfaces', 25, 7),
        ('DataCrunch', 'Data Engineer', 'Develop and manage data pipelines', 20, 7.5),
        ('SkyTech', 'Aerospace Engineer', 'Innovate in aerospace systems', 10, 8),
        ('EcoChem', 'Chemical Engineer', 'Design eco-friendly chemical processes', 30, 7.2);
--
INSERT INTO students (roll_num, first_name, last_name, email, photograph_path, cgpa, total_credits, graduation_year, domain, specialisation, placement_id)
VALUES
        ('CS101', 'Emma', 'Stone', 'emma.stone@example.com', '/images/emma.jpg', 8.2, 45, 2024, 1, 1, 1),
        ('CS102', 'John', 'Doe', 'john.doe@example.com', '/images/john.jpg', 7.8, 20, 2024, 1, 2, 2),
        ('ME101', 'Alice', 'Johnson', 'alice.johnson@example.com', '/images/alice.jpg', 7.5, 32, 2024, 2, 4, 7),
        ('EE101', 'Bob', 'Williams', 'bob.williams@example.com', '/images/bob.jpg', 6.9, 34, 2024, 3, 6, 4),
        ('IT101', 'Sophia', 'Brown', 'sophia.brown@example.com', '/images/sophia.jpg', 8.5, 50, 2025, 4, 7, 8),
        ('CH101', 'Liam', 'Green', 'liam.green@example.com', '/images/liam.jpg', 7.6, 40, 2025, 5, 8, 9),
        ('AE101', 'Mia', 'Taylor', 'mia.taylor@example.com', '/images/mia.jpg', 9.0, 60, 2025, 6, 9, 10);
--
INSERT INTO placement_student (placement_id, student_id, cv_application, about, acceptance, comments)
VALUES
        (1, 1, '/cv/emma_cv.pdf', 'Enthusiastic about software development', 1, 'Great potential for this role'),
        (2, 2, '/cv/john_cv.pdf', 'Passionate about data analytics', 1, 'Strong analytical skills'),
        (7, 3, '/cv/alice_cv.pdf', 'Interested in thermodynamics research', 0, 'Needs to improve subject understanding'),
        (4, 4, '/cv/bob_cv.pdf', 'Looking for a career in electrical circuits', NULL, 'Pending review'),
        (8, 5, '/cv/sophia_cv.pdf', 'Passionate about web development', 1, 'Great problem-solving skills'),
        (9, 6, '/cv/liam_cv.pdf', 'Interested in process optimization', 1, 'Promising candidate for chemical engineering roles'),
        (10, 7, '/cv/mia_cv.pdf', 'Aiming for innovation in aerospace engineering', NULL, 'Pending detailed interview');

INSERT INTO placement_filter (placement_id, specialisation, domain)
VALUES
         (1, 1, 1),
         (2, 2, 1),
         (3, 3, 1),
         (7, 4, 2),
         (5, NULL, 1),
         (6, NULL, 3),
         (8, 7, 4),
         (9, 8, 5),
         (10, 9, 6);
