# 🔥 IGNIS SPARK SEGUROS

<p align="center">
  <img src="https://ik.imagekit.io/phcarneiro9/IGNIS.png" alt="Ignis Spark" width="500">
</p>


<h3 align="center">
  ⚡ Seguro Inteligente para Veículos Elétricos 🚗
</h3>

<p align="center">
  Projeto Integrador — Bootcamp Java Full Stack | Generation Brasil
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk">
  <img src="https://img.shields.io/badge/Spring%20Boot-3-green?style=for-the-badge&logo=springboot">
  <img src="https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql">
  <img src="https://img.shields.io/badge/API-REST-black?style=for-the-badge">
</p>

---

# 1 - 📋 Descrição

O **Ignis Spark Seguros** é uma API REST desenvolvida para oferecer uma solução moderna e flexível de **seguros para veículos elétricos**, como 🚲 bicicletas, 🛴 patinetes, 🏍️ motos e 🚗 carros elétricos.

O sistema foi pensado para atender às novas necessidades da mobilidade elétrica, permitindo o gerenciamento de **usuários, clientes, veículos e apólices**, centralizando as principais informações relacionadas ao seguro.

Como diferencial, o projeto propõe modalidades de proteção mais flexíveis, permitindo que o cliente escolha a opção mais adequada à sua rotina, como **seguro diário, seguro por trajeto e planos personalizados**.

A solução busca unir **tecnologia, mobilidade elétrica e proteção**, oferecendo uma estrutura preparada para futuras funcionalidades e integrações.

------

# 2 - 🎯 Sobre essa API

## **2.1 Principais funcionalidades**

- 🚗 Oferecer seguros adaptados a diferentes tipos de veículos elétricos;
- 📅 Disponibilizar modalidades como seguro diário e por trajeto;
- 👤 Permitir o cadastro e gerenciamento de usuários e clientes;
- 🛵📍 Cadastrar e gerenciar veículos elétricos;
- 📄 Gerenciar apólices de seguros;
- 🔐 Garantir organização e segurança das informações;
- 🔗 Disponibilizar uma API REST para integração com outras aplicações;
- 🚀 Criar uma base tecnológica preparada para futuras funcionalidades.

------

# 3 - Diagrama de classes

### 🤝👥 Cliente

- `id`, `nome`, `cpf`, `data_nascimento`
- `telefone`, `email`, `endereco`
- `usuario_id`

### 📄 Apólice

- `id`, `numero_apolice`
- `data_inicio`, `data_fim`
- `tipo_cobertura`, `valor_seguro`
- `status`, `cliente_id`, `veiculo_id`

### 👤 Usuário

- `id`, `nome`, `email`, `senha`
- `foto`, `tipo`

### 🚗 Veículo

- `id`, `tipo`, `marca`, `modelo`
- `ano_fabricacao`, `placa`
- `valor_tabela`, `cliente_id`

# 4 - 🔗 Diagrama de entidades

<div align="center">

​    <img src="https://ik.imagekit.io/phcarneiro9/image.png" alt="Ignis Spark" width="600">

# 5 - 🚀 Tecnologias Utilizadas

| Item             | Tecnologia                      |
| ---------------- | ------------------------------- |
| 🌐 Servidor       | Tomcat embutido via Spring Boot |
| 👨‍💻 Linguagem     | Java 17                         |
| 🍃 Framework      | Spring Boot 3                   |
| 🌐 API            | Spring Web                      |
| 📦 ORM            | Spring Data JPA / Hibernate     |
| 🐬 Banco de Dados | MySQL 8.0                       |
| 🔧 Gerenciador    | Maven                           |

------

# 6 - ▶️ Como executar o projeto

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/Ignis-Code-Solutions/IgnisSparkSeguros.git
```

### 2️⃣ Entre na pasta

```bash
cd IgnisSparkSeguros
```

### 3️⃣ Configure o banco de dados

Crie um banco chamado:

```text
db_ignisspark
```

### 4️⃣ Configure o `application.properties`

Exemplo:

```properties
spring.application.name=IgnisSparkSeguros

spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://localhost:3306/db_ignisspark?createDatabaseIfNotExist=true&serverTimezone=America/Sao_Paulo&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

> ⚠️ Altere `spring.datasource.username` e `spring.datasource.password` de acordo com a configuração do seu MySQL.

------

## ▶️ Executando

Execute a classe principal do Spring Boot:

```text
IgnisSparkSegurosApplication.java
```

Ou utilize o Maven:

```bash
mvn spring-boot:run
```

------

# 👥 Equipe

A equipe **Ignis Code Solutions** é formada por estudantes do **Bootcamp Java Full Stack da Generation Brasil**, com foco na aplicação prática de **Java, Spring Boot, APIs REST, arquitetura em camadas e banco de dados**, utilizando boas práticas de desenvolvimento, trabalho em equipe e metodologias ágeis.

### 👨‍💻 Desenvolvedores

- André Luis Silva Rocha Nunes
- Daniel Araujo Chaves
- Elaine Alves Silva
- Jonathan Leão
- João Pedro Duo
- Luiza Valentina Paolinelli Guimarães
- Patrick Henrique Mendes Carneiro

------

### 🔥 IGNIS SPARK SEGUROS

**Protegendo o futuro da mobilidade elétrica.** ⚡🚗
