# Gerenciador de arquivos com AWS S3
## Objetivo do projeto

- Sistema em que usuário pode realizar operações para gerenciar arquivos em Bucket do S3 na AWS.
- Objetivo do projeto foi explorar esse serviço e integrar juntamente de uma aplicação Java com Spring Boot.
- Entender mais sobre politicas de buckets, grupos de usuários, IAM, e  integração.

---

## Tecnologias utilizadas:
- Java
- Spring Boot
- AWS S3
- AWS IAM
- H2 DataBase

## Minhas principais implementações e aprendizados nesse projeto  
- Integração real com o **AWS S3** utilizando `AmazonS3Client`.  
- Configuração de **credenciais AWS** via Beans no Spring Context.  
- Implementação de **CRUD completo** para arquivos armazenados no S3.  
- Uso do IAM (Identity and Access Management) para configurar políticas de bucket com acesso restrito apenas a operações CRUD no S3.

---

## 🧾 Endpoints  

| Método | Endpoint | Descrição |
|---------|-----------|------------|
| **POST** | `/upload` | Faz upload de um arquivo para o S3 e salva os metadados no banco |
| **PUT** | `/update/{id}` | Atualiza um arquivo existente no S3 |
| **DELETE** | `/remove/{id}` | Remove o arquivo do S3 e do banco de dados |
| **GET** | `/` | Lista todos os arquivos cadastrados de forma ordenada |

## Visão geral  
- Projeto ótimo para explorar nova tecnologia, simbolo da minha proatividade e curiosidade. Além de entender mais como o mundo de Cloud funciona na prática com aplicões Backend.
- Focado no estudo e aprendizado prático.

<p>
  <a href="https://www.linkedin.com/in/gustavokowalski/" target="_blank" style="margin-right: 20px;">
    <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" />
  </a>

</p>
