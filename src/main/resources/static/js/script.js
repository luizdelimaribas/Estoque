// Aponta para o controller que está em /cadastrar
const API_URL = "http://localhost:8080/produtos";

function salvarProduto() {
  const nome = document.getElementById("nome").value;
  const valor = document.getElementById("valor").value;
  const quantidade = document.getElementById("quantidade").value;

  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nome, valor, quantidade })
  })
  .then(res => {
    if (!res.ok) throw new Error("Erro ao salvar");
    return res.json();
  })
  .then(() => {
    document.getElementById("mensagem").innerText = "Produto cadastrado com sucesso!";
    document.getElementById("nome").value = "";
    document.getElementById("valor").value = "";
    document.getElementById("quantidade").value = "";
  })
  .catch(err => alert(err));
}

function mostrarLista() {
  document.getElementById("cadastro").classList.add("hidden");
  document.getElementById("lista").classList.remove("hidden");
  carregarProdutos();
}

function mostrarCadastro() {
  document.getElementById("lista").classList.add("hidden");
  document.getElementById("cadastro").classList.remove("hidden");
}

function carregarProdutos() {
  fetch(API_URL + "/listaProdutos")
    .then(res => res.json())
    .then(produtos => {
      const tbody = document.querySelector("#tabela tbody");
      tbody.innerHTML = "";
      produtos.forEach(p => {
        const row = `<tr>
          <td>${p.id}</td>
          <td>${p.nome}</td>
          <td>${p.valor}</td>
          <td>${p.quantidade}</td>
        </tr>`;
        tbody.innerHTML += row;
      });
    });
}

function filtrar() {
  const filtro = document.getElementById("filtro").value.trim();
  if (!filtro) {
    carregarProdutos();
    return;
  }

  // tenta buscar por ID
  if (!isNaN(filtro)) {
    fetch(`${API_URL}/id/${filtro}`)
      .then(res => {
        if (!res.ok) throw new Error("Não encontrado");
        return res.json();
      })
      .then(p => {
        const tbody = document.querySelector("#tabela tbody");
        tbody.innerHTML = `<tr>
          <td>${p.id}</td>
          <td>${p.nome}</td>
          <td>${p.valor}</td>
          <td>${p.quantidade}</td>
        </tr>`;
      })
      .catch(() => alert("Produto não encontrado"));
  } else {
    // busca por nome
    fetch(`${API_URL}/nome/${filtro}`)
      .then(res => {
        if (!res.ok) throw new Error("Não encontrado");
        return res.json();
      })
      .then(p => {
        const tbody = document.querySelector("#tabela tbody");
        tbody.innerHTML = `<tr>
          <td>${p.id}</td>
          <td>${p.nome}</td>
          <td>${p.valor}</td>
          <td>${p.quantidade}</td>
        </tr>`;
      })
      .catch(() => alert("Produto não encontrado"));
  }
}