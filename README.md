Intuito da aplicação -
Se direcionar a quem provê serviços financeiros, fazendo um intermédio de entradas para uma saida CSV.

Como usar -
Aplicativo é bem intuitivo, cadastra-se o cliente, ao clicar no nome do mesmo abrirá as opções de colocar as dívidas, rendas extras e possíveis "projetos". Caso o valor da conta seja positivo ele dirá o valor que se ganha com o rendimento mensal da conta, caso o valor seja negativo mostrará as opções de empréstimo do banco de dados.

Os empréstimos são colocados apenas via EndPoints.

Database -
A pasta Database contem o banco de dados (prevencao_dividas) em SQL, foi usado o MySQL como banco de dados.

Integrante -
Diogo Rafael Varela Butzke - 172316253

ENDPOINTS DISPONÍVEIS - API Spring Boot

CLIENTE (/clientes)
- GET /clientes               -> Listar todos os clientes
- POST /clientes              -> Criar cliente
- PUT /clientes/{id}          -> Atualizar cliente (nome, cpf, renda)
- PATCH /clientes/{id}        -> Atualizar somente a renda mensal
- DELETE /clientes/{id}       -> Deletar cliente

GASTO (/gastos)
- GET /gastos/cliente/{clienteId} -> Listar gastos por cliente
- POST /gastos                   -> Criar gasto (descricao, valor, cliente.id)
- DELETE /gastos/{id}           -> Deletar gasto

RECEITA EXTRA (/receitas)
- GET /receitas                 -> Listar todas as receitas
- GET /receitas/cliente/{clienteId} -> Listar receitas por cliente
- POST /receitas               -> Criar receita (descricao, valor, cliente.id)
- DELETE /receitas/{id}        -> Deletar receita

META FINANCEIRA (/metas)
- GET /metas                   -> Listar todas as metas
- GET /metas/cliente/{clienteId} -> Listar metas por cliente
- POST /metas                  -> Criar meta (descricao, valorAlvo, cliente.id)
- DELETE /metas/{id}           -> Deletar meta

EMPRESTIMO (/emprestimos)
- GET /emprestimos             -> Listar todos os empréstimos disponíveis
- POST /emprestimos            -> Criar empréstimo (banco, valorEmprestado, taxaJuros, parcelas)
- PUT /emprestimos/{id}        -> Atualizar empréstimo
- DELETE /emprestimos/{id}     -> Deletar empréstimo



----------------------------------------------------------------------------------------------------------------------




========================
JSONs de Exemplo de Uso
========================

1. Criar Cliente (POST /clientes)
{
  "nome": "João da Silva",
  "cpf": "123.456.789-00",
  "rendaMensal": 3000.00
}

2. Atualizar Cliente (PUT /clientes/{id})
{
  "nome": "João Atualizado",
  "cpf": "123.456.789-00",
  "rendaMensal": 3500.00
}

3. Atualizar apenas a renda (PATCH /clientes/{id})
3500.00

4. Criar Gasto (POST /gastos)
{
  "descricao": "Aluguel",
  "valor": 1200.00,
  "cliente": { "id": 1 }
}

5. Criar Receita Extra (POST /receitas)
{
  "descricao": "Freelancer",
  "valor": 500.00,
  "cliente": { "id": 1 }
}

6. Criar Meta Financeira (POST /metas)
{
  "descricao": "Viajar para praia",
  "valorAlvo": 2000.00,
  "cliente": { "id": 1 }
}

7. Criar Empréstimo (POST /emprestimos)
{
  "banco": "Banco Exemplo",
  "valorEmprestado": 2000.00,
  "taxaJuros": 2.5,
  "parcelas": 12
}

8. Atualizar Empréstimo (PUT /emprestimos/{id})
{
  "banco": "Banco Atualizado",
  "valorEmprestado": 2500.00,
  "taxaJuros": 3.0,
  "parcelas": 10
}

