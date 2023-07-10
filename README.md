# Micro serviço para cadastro de pessoas
- Responsabilidade desse microserviço é gerencias qualquer tipo de pessoa.

## Regras de negócio
1. Fornecer um endpoint */pessoa* para fazer criação e listar as pessoas cadatradas
2. Validar se o CPF *não foi* infomado, se não informado disparar uma exception para informar 
    - "CPF não informado"
3. Validar se o CPF *foi* infomado, se informado valida se o mesmo é valido
    3.1. Se CPF for invalido disparar uma exception para informar 
	  - "CPF informado é invalido."
	  
    3.2. Se CPF for valido cadastrar
4. No momento do cadastro caso ja exista uma pessoa com o cpf ou com o RG informado retornar uma exception informando que ja existe pessoa cadastrada com esses dados.5. 
    - "Ja existe uma pessoa cadastrada com esse CPF"
 - POST: */pessoa*
    - ```
        {
          "nmNome": "João Silva",
          "cdCpf": "123.456.789-00",
          "cdRg": "12.345.678-9",
          "dtNascimento": "01/01/1990",
          "nmSexo": "masculino",
          "nmEstadoCivil": "solteiro",
        }
        ```
 - GET: */pessoa*
     -  ```
        [
          {
            "idPessoa": 1,
            "nmNome": "João Silva",
            "cdCpf": "123.456.789-00",
            "cdRg": "12.345.678-9",
            "dtNascimento": "01/01/1990",
            "nmSexo": "masculino",
            "nmEstadoCivil": "solteiro"
          },
          {
            "idPessoa": 2,
            "nmNome": "João Silva 2",
            "cdCpf": "123.456.789-00",
            "cdRg": "12.345.678-10",
            "dtNascimento": "01/01/1990",
            "nmSexo": "masculino",
            "nmEstadoCivil": "solteiro"
          }
        ]
        ```
5. Fornecer um endpoint */pessoa/{id}* para recuperar pessoa por id
 - GET:*/pessoa/{id}*
    - ```
      {
        "idPessoa": 2,
        "nmNome": "João Silva 2",
        "cdCpf": "123.456.789-00",
        "cdRg": "12.345.678-10",
        "dtNascimento": "01/01/1990",
        "nmSexo": "masculino",
        "nmEstadoCivil": "solteiro"
      }
        ```
6. Fornecer endpoint */pessoa/{id}* para atualizar pessoa por id
 - PUT:*/pessoa/{id}*
    - ```
      {
        "idPessoa": 2,
        "nmNome": "João Silva 2",
        "cdCpf": "123.456.789-00",
        "cdRg": "12.345.678-10",
        "dtNascimento": "01/01/1990",
        "nmSexo": "masculino",
        "nmEstadoCivil": "solteiro"
      }
        ```
7. Fornecer endpoint **/pessoa/{id}** para deletar pessoa por id
 - DELETE: */pessoa/{id}*
    - ```
      {
        "idPessoa": 2,
        "nmNome": "João Silva 2",
        "cdCpf": "123.456.789-00",
        "cdRg": "12.345.678-10",
        "dtNascimento": "01/01/1990",
        "nmSexo": "masculino",
        "nmEstadoCivil": "solteiro"
      }
        ```
8. Fornecer um endpoint */pessoa/{cdCpf}* para recuperar pessoa cdCpf
 - GET: */pessoa/{cdCpf}*
    - ```
      {
        "idPessoa": 2,
        "nmNome": "João Silva 2",
        "cdCpf": "123.456.789-00",
        "cdRg": "12.345.678-10",
        "dtNascimento": "01/01/1990",
        "nmSexo": "masculino",
        "nmEstadoCivil": "solteiro"
      }
        ```
