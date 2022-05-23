INSERT INTO USUARIO(id, nome, email, senha) VALUES(1, 'Aluno', 'aluno@email.com', '$2a$10$yIj7fRynb50wjwO6J4X8cu4Pj0eo190vWkpEL49ozzF1tnaT2Vd9K');
INSERT INTO USUARIO(id, nome, email, senha) VALUES(2, 'moderador', 'moderador@email.com', '$2a$10$yIj7fRynb50wjwO6J4X8cu4Pj0eo190vWkpEL49ozzF1tnaT2Vd9K');

INSERT INTO CURSO(id, nome, categoria) VALUES(1, 'Spring Boot', 'Programação');
INSERT INTO CURSO(id, nome, categoria) VALUES(2, 'HTML 5', 'Front-end');

INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(1, 'Dúvida', 'Erro ao criar projeto', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(2, 'Dúvida 2', 'Projeto não compila', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(id, titulo, mensagem, data_criacao, status, autor_id, curso_id) VALUES(3, 'Dúvida 3', 'Tag HTML', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);

INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIO_PERFIL(usuario_id, perfil_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIL(usuario_id, perfil_id) VALUES(2, 2);