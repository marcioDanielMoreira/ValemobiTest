<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- TAGS PARA O USO DO STRUTS NO JSP -->
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Valemobi</title>

<!-- IMPORTAÇÃO DOS CSS e DOS JSs -->
<jsp:include page="../../template/imports/imports.jsp"></jsp:include>
</head>
<body>

	<div id="wrapper">

		<!-- IMPORTANDO O TEMPLATE PADRÃO DA TELA -->
		<jsp:include page="../../template/cabecalho.jsp"></jsp:include>

		<div id="page-wrapper">
			<!-- AQUI INICIA-SE A MONTAGEM DA TELA -->
			<!-- Utiliza-se o conceito de linha(row) e coluna(col-??-0a12) -->

			<!-- CABEÇALHO INFORMATIVO DA TELA -->
			<div class="row">
				<div class="col-xs-12">
					<h2 class="page-header">
						<i class="glyphicon glyphicon-education"></i>
						Mercadoria
						<small style="font-size: 45%">
							<i class="glyphicon glyphicon-forward"></i>
							Cadastro e Listagem de Mercadorias
						</small>
					</h2>
				</div>
			</div>

			<!-- O CORPO DA TELA -->
			<div class="row">
				<div class="col-xs-12">

					<!-- CONFIGURAÇÃO IMPORTANTE PARA O FUNCIONAMENTO DO STRUTS (html:form) -->
					<!-- Sempre que o form sofrer um SUBMIT, ele executará o action -->
					<html:form styleId="form_mercadoria" action="mercadoriaAction.do" method="post">
						<html:hidden styleId="method" property="method" value="nada"/>

						<div class="panel panel-primary">
							<div class="panel-heading">
								<logic:messagesPresent message="false">
									<div class="alert alert-danger">
										<html:messages id="message" message="false">
											<bean:write filter='false' name='message' />
										</html:messages>
									</div>
								</logic:messagesPresent>
								<logic:messagesPresent message="true">
									<div class="alert alert-success">
										<html:messages id="message" message="true">
											<bean:write filter='false' name='message' />
										</html:messages>
									</div>
								</logic:messagesPresent>
							</div>
							<div class="panel-body">

								<!-- CRIACAO DOS CAMPOS JUNTAMENTE COM SUAS LABELS -->
								<div class="row">
									<div class="form-group col-xs-12 col-sm-3 col-md-2 col-lg-2">
										<label for="id">Código</label>
										<html:text styleClass="form-control bloqueado" styleId="id" name="mercadoriaForm" property="id" />
									</div>

									<div class="form-group col-xs-12 col-sm-4 col-md-6 col-lg-6">
										<label for="nome">Nome</label>
										<html:text styleClass="form-control obrigatorio" styleId="nome"  name="mercadoriaForm" property="nome" />
									</div>

									<div class="form-group col-xs-12 col-sm-5 col-md-4 col-lg-4">
										<label for="tipo">Tipo</label>
										<html:text styleClass="form-control  obrigatorio tipo" styleId="tipo"  name="mercadoriaForm" property="tipo" />
									</div>

									<div class="form-group col-xs-12 col-sm-4 col-md-2 col-lg-2">
										<label for="preco">Preço</label>
										<html:text styleClass="form-control text-right decimal obrigatorio" styleId="preco"  name="mercadoriaForm" property="preco" />
									</div>

									<div class="form-group col-xs-12 col-sm-4 col-md-2 col-lg-2">
										<label for="quantidade">Quantidade</label>
										<html:text styleClass="form-control text-right unitario obrigatorio" styleId="quantidade"  name="mercadoriaForm" property="quantidade" />
									</div>

									<div class="form-group col-xs-12 col-sm-6 col-md-2 col-lg-2">
										<label for="tipoNegocio">Tipo do Negócio</label>
										<html:select styleClass="form-control obrigatorio" styleId="tipoNegocio" name="mercadoriaForm" property="tipoNegocio">
											<html:option value="">Selecione</html:option>
											<html:option value="Compra">Compra</html:option>
											<html:option value="Venda">Venda</html:option>
										</html:select>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12 table-responsive">
										<table class="table table-bordered table-striped table-hover">
											<thead>
												<tr class="bg-primary">
													<th class="text-center">#</th>
													<th>Nome</th>
													<th>Tipo</th>
													<th>Preço</th>
													<th>Quantidade</th>
													<th>Tipo do Negócio</th>
													<th class="text-center">Selecionar</th>
												</tr>											
											</thead>
											<!-- PROPRIEDADES:
											id - Objeto corrente do FOR
											indexId - è o contador como por exemplo o (i)
											name - Nome do Form onde a lista esta
											property - Nome do atributo que representa a lista
											type = Tipo do Objeto que esta dentro(ArrayList<type>) da lista -->
											<logic:iterate id="mercadoriaCorrente" indexId="i" name="mercadoriaForm" property="mercadorias" type="br.com.valemobiteste.sistema.mercadoria.backend.model.MercadoriaPO">
												<tr>
													<td class="text-center">${mercadoriaCorrente.id}</td>
													<td>${mercadoriaCorrente.nome}</td>
													<td>${mercadoriaCorrente.tipo}</td>
													<td>${mercadoriaCorrente.preco}</td>
													<td>${mercadoriaCorrente.quantidade}</td>
													<td>${mercadoriaCorrente.tipoNegocio}</td>
													<td class="text-center">
														<a href="${rootWeb}/mercadoriaAction.do?method=selecionar&id=${mercadoriaCorrente.id}">
															<i class="glyphicon glyphicon-edit btn btn-xs btn-success"></i>
														</a>
													</td>
												</tr>
											</logic:iterate>
										</table>
									</div>
								
								</div>
							</div>
							<div class="panel-footer">
								<div class="row">
									
										<logic:notPresent name="mercadoriaForm" property="id">
										<div class="form-group col-xs-6 col-sm-4 col-md-3 col-lg-3">	
											<button type="submit" id="inserir" class="btn btn-success btn-block">
												<i class="glyphicon glyphicon-floppy-save"></i>
												Inserir
											</button>
										</div>
										</logic:notPresent>
										
										<logic:present name="mercadoriaForm" property="id">
										<div class="form-group col-xs-6 col-sm-4 col-md-3 col-lg-3">
											<button type="submit" id="alterar" class="btn btn-primary btn-block">
												<i class="glyphicon glyphicon-retweet"></i>
												Alterar
											</button>
										</div>

										<div class="form-group col-xs-6 col-sm-4 col-md-3 col-lg-3">
											<button type="button" id="excluir" class="btn btn-danger btn-block">
												<i class="glyphicon glyphicon-remove"></i>
												Excluir
											</button>
										</div>
										</logic:present>

										<div class="form-group col-xs-6 col-sm-4 col-md-3 col-lg-3">
											<button type="button" id="pesquisar" class="btn btn-info btn-block">
												<i class="glyphicon glyphicon-th-list"></i>
												Pesquisar
											</button>
										</div>

										<div class="form-group col-xs-6 col-sm-4 col-md-3 col-lg-3">
											<button type="button" id="limpar" class="btn btn-warning btn-block">
												<i class="glyphicon glyphicon-erase"></i>
												Limpar
											</button>
										</div>
									
								</div>
							</div>
						</div>

					</html:form>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		/* 
		 EXECUTADO NA CARGA DA PAGINA 
		 Trabalhando com JQuery para manipular os componentes
		 # pega os elementos pelo ID - $("#nome")
		 . pega os elementos por CLASS - $(".bloqueado")
		 attr serve para adicionar atributos em tempo de execução
		 */
		 $(document).ready(function(){
			 /* Bem vindo ao ambiente JQuery */
			 
			 $("#nome").focus();
			 
			// Desliga o auto-complete da pagina
			$("#form_mercadoria").attr("autocomplete" , "off");
			
			/* Criando uma estilização para campos Bloqueados */
			$(".bloqueado").attr("readonly","readonly");
			$(".bloqueado").css("font-weight", "bold");
			$(".bloqueado").css("cursor","not-allowed");
			
			/* Criando a estilização para os campos Obrigatorios */
			$(".obrigatorio").attr("required", "required");
			$(".obrigatorio").css("border-color", "red");
			
			/* Definindo o tamanho maximo dos campos */
			$("#nome").attr("maxlength", 80); //Pegar o tamanho do PO
			$("#tipo").attr("maxlength", 50);
			$("#preco").attr("maxlength", 20);
			$("#tipoNegocio").attr("maxlength", 10);

			/* Setando o Placeholder dos campos */
			$("#nome").attr('placeholder', 'Nome'); //Pegar o tamanho do PO
			$("#tipo").attr("placeholder", "Tipo");
			$("#ra").attr("placeholder", "RA");
			$("#turma").attr("placeholder", "Turma");
		
			
			$('.decimal').mask('##0,00', {
				placeholder : "0,00",
				reverse : true
			});
			
			$('.unitario').mask('##00', {
				placeholder : "00",
				reverse : true
			});
			
			/* DEFININDO OS EVENTOS DOS BOTOES */
			$("#inserir").click(function(){
				$("#method").val("inserir");
			});
			
			$("#alterar").click(function(){
				$("#method").val("inserir");
			});
			
			$("#excluir").click(function(){
				$("#method").val("excluir");
				$("#form_mercadoria").submit();
			});
			
			$("#pesquisar").click(function(){
				$("#method").val("filtrar");
				$("#form_mercadoria").submit();
			});
			
			$("#limpar").click(function() {
				$("#method").val("abrirTela");
				$("#form_mercadoria").submit();
			});
		 });
	</script>

</body>
</html>