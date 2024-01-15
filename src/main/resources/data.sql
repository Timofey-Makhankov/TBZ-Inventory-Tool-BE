--USERS
insert into users (id, email, firstname, lastname, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James', 'Bond',
        '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'), -- Password: 1234
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler', 'Durden',
        '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6')  -- Password: 1234
ON CONFLICT DO NOTHING;

--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
       ('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
       ('d5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7', 'USER_READ'),
       ('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
       ('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
       ('64030c3a-c260-453c-847f-a46950a6ac21', 'ITEM_READ'),
       ('aa04799f-35c7-48bc-94b0-c156b8802969', 'ITEM_READ_ALL'),
       ('82e779f6-21fd-49df-84b4-c01f00766eff', 'ITEM_CREATE'),
       ('45ba7560-8459-4ae6-8edf-ffe204c7ddc3', 'ITEM_MODIFY'),
       ('430f4ad9-55cc-4cc4-a182-24a829de36e0', 'ITEM_DELETE')
       --('c97c5eda-4ce4-474a-9d60-139e452a4e97', ''),
       --('0f8577f4-d2bd-4ef0-9418-c8cddf3310da'),
       --('7ed7c22a-fce8-4789-98b2-6769d49a1737'),
       --('ccd65156-6dbf-4abb-82a7-118ce25ffb2a'),
       --('2033f5f7-881a-42aa-a307-79eaf83dce0f')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'), -- James Bond   - DEFAULT
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'), -- Tyler Durden - DEFAULT
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02'), -- Tyler Durden - USER
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'), -- James Bond   - ADMIN
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02')  -- James Bond   - USER
ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'), -- DEFAULT - DEFAULT
       ('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- USER    - GROUP_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'), -- ADMIN   - USER_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '21c942db-a275-43f8-bdd6-d048c21bf5ab'), -- ADMIN   - USER_DELETE
       ('ab505c92-7280-49fd-a7de-258e618df074', 'd5866d24-d7d2-4b1e-9b4c-dc8b0c8d4bd7'), -- ADMIN   - USER_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', '45ba7560-8459-4ae6-8edf-ffe204c7ddc3'), -- ADMIN   - ITEM_MODIFY
       ('ab505c92-7280-49fd-a7de-258e618df074', '64030c3a-c260-453c-847f-a46950a6ac21'), -- ADMIN   - ITEM_READ
       ('ab505c92-7280-49fd-a7de-258e618df074', 'aa04799f-35c7-48bc-94b0-c156b8802969'), -- ADMIN   - ITEM_READ_ALL
       ('ab505c92-7280-49fd-a7de-258e618df074', '82e779f6-21fd-49df-84b4-c01f00766eff'), -- ADMIN   - ITEM_CREATE
       ('ab505c92-7280-49fd-a7de-258e618df074', '430f4ad9-55cc-4cc4-a182-24a829de36e0')  -- ADMIN   - ITEM_DELETE
ON CONFLICT DO NOTHING;