# File Manager — Integração com Amazon S3  

[![My Skills](https://skillicons.dev/icons?i=java,spring,aws,git)](https://skillicons.dev)  
![Status](https://img.shields.io/badge/Concluído-brightgreen)

---

## 📖 Visão Geral  
API REST desenvolvida em **Java + Spring Boot 3** para gerenciar o **upload, atualização e exclusão de arquivos** diretamente no **Amazon S3**.  

O objetivo foi explorar o serviço S3 e implementar uma solução de armazenamento de objetos desacoplada, entendendo na prática como funcionam políticas, permissões, grupos e usuários dentro do ecossistema AWS e integrar o serviço a uma aplicação Spring Boot.

---

## ⚙️ Funcionalidades  
- Upload de arquivos para o S3.  
- Atualização e exclusão de arquivos no S3.  
- Persistência dos metadados no banco de dados.
- Achar todos os arquivos ordenados. 
- Logs e mensagens padronizadas para rastreabilidade.  

---

## 🔧 Principais Aprendizados  
- Integração real com o **AWS S3** utilizando `AmazonS3Client`.  
- Configuração de **credenciais AWS** via Beans no Spring Context.  
- Implementação de **CRUD completo** para arquivos armazenados no S3.  
- Uso do IAM (Identity and Access Management) para configurar políticas de bucket com acesso restrito apenas a operações CRUD no S3.

---

## 🧰 Tecnologias Utilizadas  
- **Java 21**  
- **Spring Boot 3**  
- **Spring Data JPA**  
- **AWS S3 (SDK Java)**  

---

## 🧩 Estrutura do Projeto 
```
├── controller # Endpoints REST
├── service # Regras de negócio e integração com AWS S3
├── entity # Entidade File
├── config # Configurações
├── dto # Objetos de transferência de dados
├── repository # Persistência (Spring Data JPA)
└── exception # Exceções personalizadas e handler global
```

## 🧾 Endpoints  

| Método | Endpoint | Descrição |
|---------|-----------|------------|
| **POST** | `/upload` | Faz upload de um arquivo para o S3 e salva os metadados no banco |
| **PUT** | `/update/{id}` | Atualiza um arquivo existente no S3 |
| **DELETE** | `/remove/{id}` | Remove o arquivo do S3 e do banco de dados |
| **GET** | `/` | Lista todos os arquivos cadastrados de forma ordenada |

## 🧠 Aprendizado  
Esse projeto me ajudou a compreender de forma prática como o **Amazon S3** lida com **armazenamento, autenticação e permissões**, além de aplicar esses conceitos em uma API REST funcional utilizando Spring Boot.
