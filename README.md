# Exercício: testes E2E para o SISFILA.

Neste exercício, você precisará criar testes de sistema para a aplicação web [SISFILA](https://gitlab.com/rodrigorgs/sisfila), criada em Rails. Os testes devem ser escritos em Java, usando o framework Selenium, e devem usar o padrão Page Object, de forma que o código de teste não deve acessar o objeto WebDriver (exceto para inicialização e encerramento).

## Configuração da aplicação SISFILA

Para testar o SISFILA, você precisará baixar **a branch `test` do [repositório do SISFILA](https://gitlab.com/rodrigorgs/sisfila)** e executar a aplicação usando o [Docker](https://www.docker.com/):

```sh
git clone https://gitlab.com/rodrigorgs/sisfila.git -b test
cd sisfila
docker-compose up --build
```

Quando aparecer `app_1    | * Listening on tcp://0.0.0.0:3000`, significa que o servidor iniciou. 

## Primeiro acesso

Para criar os usuários de teste da aplicação, acesse <http://localhost:3000/reset>. Os seguinte usuários serão criados:

- **Usuário**: admin@example.com | **Senha**: admin2222
- **Usuário**: tela@example.com | **Senha**: tela2222

Depois disso, para usar a aplicação, acesse <http://localhost:3000/>

## Outros caminhos importante

- `/admin` - interface admin, onde pode-se criar, editar, consultar e excluir qualquer entidade do sistema
- `/` - interface pública com link para o telão e para uma página de consulta de posição de aluno
- `/tela` - interface do telão onde os estudantes inserem seus nomes nas filas
- `/reset` - apaga todos os registros do banco de dados e recria os registros iniciais
- `/cria-cenario` - cria um cenário de teste com diversos colegiados, alunos e grupos. Veja os dados criados na interface admin.

## Casos de teste

Você deve criar os seguintes testes, reusando ao máximo o cenário de teste criando em `/cria-cenario` e as classes disponíveis no código base do exercício:

- Dado que não há usuário autenticado, o telão não deve mostrar o campo de texto para digitar número de matrícula
- Quando o usuário digita no telão uma matrícula que não está associada a um colegiado, o sistema deve informar "Número de matrícula não encontrado"
- Dado que um aluno não está na fila, quando ele digita o seu número de matrícula no telão, o sistema deve informar o nome e a posição do aluno na fila correta
- Dado que o aluno já está na fila, quando ele digita o seu número de matrícula no telão, o sistema deve informar a posição do aluno na fila
- Dado que existe um aluno na primeira posição da fila mais prioritária de um colegiado (aguardando ser chamado), quando este colegiado chama o próximo da fila, o telão deve exibir o nome desse aluno
- Dado que existe um aluno sendo atendido em um colegiado, quando este colegiado chama o próximo da fila, o telão deve parar de exibir o nome desse aluno
- Dado que um colegiado possui duas filas, e que existe exatamente um aluno aguardando atendimento em cada fila, quando o aluno na segunda fila consulta sua posição, o sistema deve informar que ele está na segunda posição
- Dado que existem dois alunos, um de cada colegiado, e que um aluno está sendo atendido e o outro é o próximo a ser atendido pelo seu colegiado, quando este colegiado chama o próximo aluno, o telão deve mostrar o nome de ambos os alunos
- Dado que existe um aluno que é o próximo a ser chamado na fila de seu colegiado, quando o coordenador de colegiado chama o próximo da fila, o sistema deve exibir ao coordenador o nome desse aluno

Além disso, você deve criar mais dois testes relevantes, a seu critério. Na seção abaixo do arquivo `README.md` do seu projeto, você deve descrever esses dois testes, assim como informar quais métodos do seu código Java implementam esses dois testes.

Siga as convenções adotadas no código fornecido como base.

## Testes customizados

### Teste 1

Escreva a descrição do teste 1.

- Método: `NomeDaClasse.nomeDoMetodoDoTeste1()`

### Teste 2

Escreva a descrição do teste 2.

- Método: `NomeDaClasse.nomeDoMetodoDoTeste2()`

## Solução

Uma possível [solução do exercício](https://github.com/matb25-20182/sisfila-selenium-roberio-e-seus-teclados) está disponível apenas para professores da disciplina.