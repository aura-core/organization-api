# organization-api
Responsible for managing entities and business logic about the organization

- [ ] integrar keycloak
  - [ ] clientes
    - [ ] criar
    - [ ] atualizar
    - [ ] deletar
  - [ ] usuarios
    - [ ] criar
    - [ ] atualizar
    - [ ] deletar
  - [ ] autorização
  - [ ] autenticação

- [ ] audit entity (atualizar o SpringSecurityAuditorAware)
- [ ] adicionar regras nos controller de permissionamento
- [ ] tests
- [ ] integrar s3


## integrar s3

- #!/bin/bash

- Criação de um usuário IAM
aws --endpoint-url=http://localhost:4566 iam create-user --user-name myuser

- Associação de permissões ao usuário
aws --endpoint-url=http://localhost:4566 iam add-user-to-group --user-name myuser --group-name admin

- Criação de uma chave de acesso para o usuário
aws --endpoint-url=http://localhost:4566 iam create-access-key --user-name myuser