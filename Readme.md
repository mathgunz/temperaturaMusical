# Temperatura Musical

Serviço responsável por sugerir músicas com base na temperatura da cidade fornecida.

## Tecnologias Utilizadas

- **Spring Boot 3**: Framework para desenvolvimento rápido de aplicações Java.
- **Java 17**: Versão do Java utilizada no projeto.
- **PostgreSQL**: Banco de dados relacional utilizado.
- **Keycloak**: Solução de gerenciamento de identidade e acesso.
- **Gradle**: Ferramenta de construção e gerenciamento de dependências.

## Funcionalidades

- Autenticação e autorização com Keycloak.
- Api de consulta que retorna musicas.

## Requisitos

- Java 17
- PostgreSQL 13 (ou superior)
- Keycloak 21.x (ou superior)
- Gradle 7.x (ou superior)

## Configuração

### Clonando o Repositório

```bash
git clone git@github.com:mathgunz/temperaturaMusical.git
cd temperaturaMusical
````

## Documentação da API
### Autenticação
Você pode obter um token de autenticação fazendo uma chamada para o endpoint de login.

Exemplo de chamada com curl:

```bash
curl --location 'http://15.228.12.204:9090/api/v1/login/token?username=user&password=123456' \
--header 'accept: application/json'
Observação: Substitua user e 123456 pelo nome de usuário e senha apropriados.
````

Consultar Músicas por Temperatura
Você pode consultar músicas por temperatura usando o seguinte endpoint:

URL do Endpoint:

```bash
http://15.228.12.204:9090/api/v1/cidades/jundiai/musicas-por-temperatura
````

A documentação interativa da API está disponível através do Swagger. Você pode acessar a interface do Swagger para testar os endpoints diretamente através do navegador.
URL do Swagger:

```bash
http://15.228.12.204:9090/swagger-ui.html
````

## Processo de Deploy

1. Criar Imagem Docker

    Certifique-se de que você tem um Dockerfile no seu projeto.
    Crie a imagem Docker:

    ```bash
    docker build -t nome-do-repositorio:latest .
    ````
2. Gerar Tag

    Gere uma tag para a imagem Docker:

    ```bash
    docker tag nome-do-repositorio:latest seu-usuario/nome-do-repositorio:versao
    ```

3. Subir para Nuvem Docker Hub
    Faça login no Docker Hub:
    ```bash
    docker login
    ```
    Suba a imagem para o Docker Hub:

    ```bash
    docker push seu-usuario/nome-do-repositorio:versao
    ```
4. Acessar via SSH Máquina EC2
    Conecte-se à sua instância EC2 via SSH:

    ```bash
    ssh -i "caminho/para/sua-chave.pem" ec2-user@ip-da-sua-instancia
    ```
5. Atualizar o Serviço via Docker Compose
    Navegue até o diretório onde está o arquivo docker-compose.yml:
    ```bash
    cd caminho/para/seu/docker-compose
    ```
    Atualize o serviço com a nova imagem:
    ```bash
    Copiar código
    docker-compose pull
    docker-compose up -d
    ```