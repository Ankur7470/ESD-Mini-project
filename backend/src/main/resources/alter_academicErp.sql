ALTER TABLE placement_filter
    ADD CONSTRAINT FK_placement
        FOREIGN KEY (placement_id) REFERENCES placement(id),
    ADD CONSTRAINT FK_specialisation
        FOREIGN KEY (specialisation) REFERENCES specialisation(specialisation_id),
    ADD CONSTRAINT FK_domain
        FOREIGN KEY (domain) REFERENCES domains(domain_id);

ALTER TABLE students
    ADD CONSTRAINT FK_student_domain
        FOREIGN KEY (domain) REFERENCES domains(domain_id),
    ADD CONSTRAINT FK_student_specialisation
        FOREIGN KEY (specialisation) REFERENCES specialisation(specialisation_id),
    ADD CONSTRAINT FK_student_placement
        FOREIGN KEY (placement_id) REFERENCES placement(id);

ALTER TABLE placement_student
    ADD CONSTRAINT FK_placement_student
        FOREIGN KEY (placement_id) REFERENCES placement(id),
    ADD CONSTRAINT FK_student
        FOREIGN KEY (student_id) REFERENCES students(student_id);

