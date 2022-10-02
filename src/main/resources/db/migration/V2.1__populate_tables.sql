INSERT INTO ADVISORS
values (1, 'test_0@email.com', 'user_associate', 'first_name_1', 'last_name_1', 'ASSOCIATE');
INSERT INTO ADVISORS
values (2, 'test_1@email.com', 'user_partner', 'first_name_1', 'last_name_1', 'PARTNER');
INSERT INTO ADVISORS
values (3, 'test_2@email.com', 'user_senior', 'first_name_1', 'last_name_1', 'SENIOR');
INSERT INTO ADVISORS
values (4, 'test_01@email.com', 'user_associate_1', 'first_name_1', 'last_name_1', 'ASSOCIATE');
INSERT INTO ADVISORS
values (5, 'test_11@email.com', 'user_partner_1', 'first_name_1', 'last_name_1', 'PARTNER');
INSERT INTO ADVISORS
values (6, 'test_21@email.com', 'user_senior_1', 'first_name_1', 'last_name_1', 'SENIOR');


INSERT INTO APPLICANTS
values (1, 'applicant_1@email.com', 'applicant_1', 'first_name_1', 'last_name_1', '123455123', 'city_1', 'street_1', 1,
        54321, 2);
INSERT INTO APPLICANTS
values (2, 'applicant_2@email.com', 'applicant_2', 'first_name_2', 'last_name_2', '123451233', 'city_2', 'street_2', 2,
        11111, 444);


INSERT INTO APPLICANT_PHONES values ('123123123123', 'HOME', 1);
INSERT INTO APPLICANT_PHONES values ('233333333', 'WORK', 1);
INSERT INTO APPLICANT_PHONES values ('4444444444', 'MOBILE', 2);
INSERT INTO APPLICANT_PHONES values ('2334421233', 'WORK', 2);


INSERT INTO applications(id,amount, status, applicant_id) VALUES (1, 123444.00, 'NEW', 1);
INSERT INTO applications(id,amount, status, applicant_id) VALUES (2, 9000.00, 'NEW', 2);
INSERT INTO applications(id,amount, status, applicant_id) VALUES (3, 42000.00, 'NEW', 1);
INSERT INTO applications(id,amount, status, applicant_id) VALUES (4, 1111.00, 'NEW', 2);