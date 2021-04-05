DOCUMENTAÇÃO DAS ROTAS

ROTAS PARA SEREM CRIADAS:

-----user-----

/login
POST realiza a autenticação e autorização na plataforma.
DELETE remove a autenticação na plataforma

/join
POST realiza a criação de um usuario

/auth/refresh_token
POST recria a autenticação e autorização

/auth/forgot
POST envia um email para recuperar senha

-----categories-----

/categories
GET retorna todas as categorias,
POST cria uma categoria,

/categories/id
GET retorna a categoria com as subcategorias
PUT edita uma categoria,
DELETE deleta uma categoria   -----@OBS@----- Proteger categories com subcategories de exclusão ! -----@OBS@-----

-----sub-categories-----

/subcategories
GET retorna todas as sub-categorias,
POST cria uma sub-categorias,

/subcategories/id
GET retorna a sub-categoria com os itens
PUT edita uma sub-categorias,
DELETE deleta uma sub-categorias

-----item-----

/item
POST cria um item,

/item/id ou dominio/nome-item
GET retorna o item
PUT edita um item,
DELETE deleta um item

