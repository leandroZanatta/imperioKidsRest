(this["webpackJsonpimperio-kids"]=this["webpackJsonpimperio-kids"]||[]).push([[0],{140:function(e,a){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADcAAAAwCAYAAAC13uL+AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAAEnQAABJ0Ad5mH3gAAAFiSURBVGhD7di/a8JAFMDx/mNScHAvRcWhHUuXSoXirkPbxalLhwodqjhKBYd2qIMggkN/YIi2BY25v+PVF8ggHHjGl3LveMN3MIYjHy4+Yg6UUuBqguOa4LgmOK4JjmuC45rguEaGC0MFs+9f8Pz51vzZz/r8ULsOZSS4xWIJ9cYjZI4ujSqe1yOkbi3KSHDd/gAOjytaiC5WuGarF110/qwG48nHxi2oi9VtGeP+a0dMswqHQ2kZBNrvkmQNDmHNdg9Oyzfw/ulpz9k1a3D91yFkC1fROicX1/A19bXn7ZJ1OxdPXQqgdb85SmDqOBz5OPrxuElTbw6N+0603r7A1HH4GY/HF5ukpEA2uCQTVG7LbdENlBAeWs98Bopp1DDMGtzL2whypSoZDLNo59bruPr4hTn74JxGpDgn/6w6/ZohCFZwe/dkDGSFw3AYOPlqz9YExzXBcU1wXBMc1wTHMwV/aWjndLVAdaEAAAAASUVORK5CYII="},180:function(e,a,t){e.exports=t(311)},311:function(e,a,t){"use strict";t.r(a);var n=t(0),r=t.n(n),o=t(12),c=t.n(o),i=t(28),l=t(13),u=function(){var e=localStorage.getItem("@usuario_lar");return e?JSON.parse(e):null},s=function(e){var a=u();if(a){var t=a.permissaoProgramas.filter((function(a){return e===a.idPrograma}));if(1===t.length)return t[0]}return null},m=function(e){var a=s(e);return a&&a.flagLeitura},d=t(11),p=t(21),g=t(18),f=t(3),E=t(140),h=t.n(E),b=t(352),v=t(376),C=t(377),y=t(365),O=t(312),x=t(33),k=t(395),j=t(378),P=t(149),w=t.n(P),S=t(358),A=t(61),N=t.n(A);var B=t(359),D=t(363),I=t(362),q=t(353),T=t(361),W=t(104),H=t(391),L=t(360),U=t(388),R=t(141),V=t.n(R).a.create({baseURL:"https://".concat(window.location.hostname,":").concat(window.location.port),headers:{"Content-Type":"application/json"}}),G=t(70),z=t.n(G);function F(e){var a=e.onClick,t=e.icon;return r.a.createElement(O.a,{onClick:a,style:{paddingLeft:5,paddingRight:5,paddingTop:0,paddingBottom:0}},t)}var Y=Object(b.a)((function(e){return{cabecalho:{display:"flex",padding:e.spacing(2)},cabecalhoBotoes:{padding:e.spacing(0,2,0,0)},cabecalhoPesquisa:{flex:1,padding:e.spacing(0,0)}}}));function J(e){var a=Y(),t=e.children,n=r.a.useState([]),o=Object(d.a)(n,2),c=o[0],i=o[1],l=r.a.useState(""),u=Object(d.a)(l,2),s=u[0],m=u[1],p=r.a.useState(0),g=Object(d.a)(p,2),f=g[0],E=g[1],h=r.a.useState(0),b=Object(d.a)(h,2),v=b[0],C=b[1],y=function(){0!==f?E(0):x()},x=function(){V.get(e.data.url,{params:{valorPesquisa:s,pagina:f,registros:5}}).then((function(e){var a=e.data;C(a.totalElements),i(a.content)})).catch((function(e){}))};return r.a.useEffect((function(){return x()}),[]),r.a.useEffect((function(){return x()}),[f]),r.a.createElement(q.a,{component:W.a},r.a.createElement("div",{className:a.cabecalho},r.a.createElement("div",{className:a.cabecalhoBotoes},t),r.a.createElement(H.a,{id:"pesquisa",value:s,size:"small",placeholder:"Pesquisar",onKeyDown:function(e){13===e.keyCode&&(e.preventDefault(),y())},onChange:function(e){m(e.target.value)},className:a.cabecalhoPesquisa,variant:"outlined",InputProps:{endAdornment:r.a.createElement(O.a,{size:"small",onClick:y},r.a.createElement(z.a,{color:"action"}))}})),r.a.createElement(B.a,null,r.a.createElement(L.a,null,r.a.createElement(T.a,{key:e.data.key},e.data.columns.map((function(e){return r.a.createElement(I.a,null,e.label)})),e.data.actions&&r.a.createElement(I.a,{style:{width:e.data.actionWidth?e.data.actionWidth:100}}," A\xe7\xf5es"))),r.a.createElement(D.a,null,c.map((function(a){return r.a.createElement(T.a,{key:a[e.data.key]},e.data.columns.map((function(e){return r.a.createElement(I.a,null,a[e.name])})),e.data.actions&&r.a.createElement(I.a,{style:{width:e.data.actionWidth?e.data.actionWidth:100}}," ",e.data.actions.filter((function(e){return null==e.condition||e.condition(a)})).map((function(e){return r.a.createElement(F,{onClick:function(){return e.onClick(a)},icon:e.icon})}))," "))})))),r.a.createElement(U.a,{rowsPerPageOptions:[5],labelDisplayedRows:function(e){var a=e.from,t=e.to,n=e.count;return"Exibindo registros ".concat(a,"-").concat(t," de ").concat(n)},component:"div",backIconButtonText:"P\xe1gina Anterior",nextIconButtonText:"Pr\xf3xima P\xe1gina",count:v,rowsPerPage:5,page:f,onChangePage:function(e,a){E(a)}}))}var M=t(54),K=t.n(M),Q=t(55),X=t.n(Q),Z=t(56),_=t.n(Z),$=t(57),ee=t.n($),ae=t(366),te=t(390),ne=t(387),re=function(){return r.a.createElement(ie,null,(function(e){var a=e.snackbarIsOpen,t=e.message,n=e.type,o=e.closeSnackbar;return r.a.createElement(te.a,{anchorOrigin:{vertical:"top",horizontal:"center"},open:a,autoHideDuration:3e3,onClose:o},r.a.createElement(ne.a,{elevation:6,variant:"filled",severity:n},t))}))},oe=r.a.createContext();function ce(e){var a=r.a.useState(!1),t=Object(d.a)(a,2),n=t[0],o=t[1],c=r.a.useState(""),i=Object(d.a)(c,2),l=i[0],u=i[1],s=r.a.useState("success"),m=Object(d.a)(s,2),p=m[0],g=m[1],f=e.children;return r.a.createElement(oe.Provider,{value:{openSnackbar:function(e,a){u(e),g(a),o(!0)},closeSnackbar:function(){o(!1)},snackbarIsOpen:n,message:l,type:p}},r.a.createElement(re,null),f)}var ie=oe.Consumer;function le(){var e=Object(l.g)(),a=Object(n.useContext)(oe).openSnackbar,t=function(e){var t=e.response;t&&400===t.status?a(t.data.mensagem,"warning"):a("Ocorreu um erro n\xe3o tratado pelo servidor.","error")};return r.a.createElement("div",null,r.a.createElement(J,{data:{key:"idCaracteristica",url:"caracteristicas",columns:[{label:"C\xf3digo",name:"idCaracteristica"},{label:"Descri\xe7\xe3o",name:"descricao"}],actionWidth:120,actions:[{onClick:function(a){e.push("/admin/cadastro-caracteristicas",a)},icon:r.a.createElement(K.a,{color:"primary"})},{condition:function(e){return null==e.dataExclusao},onClick:function(e){V.delete("/caracteristicas/".concat(e.idCaracteristica)).then((function(){e.dataExclusao=new Date,a("Caracter\xedstica excluida com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(X.a,{color:"secondary"})},{condition:function(e){return null!=e.dataExclusao},onClick:function(e){V.put("/caracteristicas/".concat(e.idCaracteristica)).then((function(){e.dataExclusao=null,a("Caracter\xedstica reincluida com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(_.a,{color:"primary"})}]}},r.a.createElement(ae.a,{variant:"contained",color:"primary",onClick:function(){e.push("/admin/cadastro-caracteristicas")}},r.a.createElement(ee.a,null),"Adicionar")))}function ue(){var e=Object(l.g)(),a=Object(n.useContext)(oe).openSnackbar,t=function(e){var t=e.response;t&&400===t.status?a(t.data.mensagem,"warning"):a("Ocorreu um erro n\xe3o tratado pelo servidor.","error")};return r.a.createElement("div",null,r.a.createElement(J,{data:{key:"idCategoria",url:"categorias",columns:[{label:"C\xf3digo",name:"idCategoria"},{label:"Categoria Pai",name:"descricaoPai"},{label:"Descri\xe7\xe3o",name:"descricao"}],actions:[{onClick:function(a){e.push("/admin/cadastro-categorias",a)},icon:r.a.createElement(K.a,{color:"primary"})},{condition:function(e){return null==e.dataExclusao},onClick:function(e){V.delete("/categorias/".concat(e.idCategoria)).then((function(){e.dataExclusao=new Date,a("Categoria excluida com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(X.a,{color:"secondary"})},{condition:function(e){return null!=e.dataExclusao},onClick:function(e){V.put("/categorias/".concat(e.idCategoria)).then((function(){e.dataExclusao=null,a("Categoria reincluida com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(_.a,{color:"primary"})}]}},r.a.createElement(ae.a,{variant:"contained",color:"primary",onClick:function(){e.push("/admin/cadastro-categorias")}},r.a.createElement(ee.a,null),"Adicionar")))}var se=t(367),me=Object(b.a)((function(e){return{container:{padding:e.spacing(5,3,0,3)},containerAcao:{display:"flex",justifyContent:"flex-end",padding:e.spacing(3,0)}}}));var de=t(368),pe=t(369),ge=t(370),fe=Object(b.a)((function(e){return{dialog:{width:800,maxHeight:500}}}));function Ee(e){var a=fe(),t=e.onClose,n=e.open,o=e.titulo,c=e.data,i=r.a.useState([]),l=Object(d.a)(i,2),u=l[0],s=l[1],m=r.a.useState(""),p=Object(d.a)(m,2),g=p[0],f=p[1],E=r.a.useState(0),h=Object(d.a)(E,2),b=h[0],v=h[1],C=r.a.useState(0),y=Object(d.a)(C,2),x=y[0],k=y[1];r.a.useEffect((function(){return P()}),[]),r.a.useEffect((function(){return P()}),[b]);var j=function(){0!==b?v(0):P()},P=function(){V.get(c.url,{params:{valorPesquisa:g,pagina:b,registros:c.numerolinhas}}).then((function(e){var a=e.data;k(a.totalElements),s(a.content)})).catch((function(e){}))};return r.a.createElement(de.a,{onClose:function(){t(null)},open:n,maxWidth:"false","aria-labelledby":"simple-dialog-title","aria-describedby":"alert-dialog-description"},r.a.createElement(pe.a,{id:"simple-dialog-title"},"Pesquisa de ",o),r.a.createElement(ge.a,{className:a.dialog},r.a.createElement(q.a,{component:W.a},r.a.createElement(H.a,{id:"pesquisa",value:g,onKeyDown:function(e){13===e.keyCode&&(e.preventDefault(),j())},onChange:function(e){f(e.target.value)},fullWidth:!0,InputProps:{endAdornment:r.a.createElement(O.a,{onClick:j},r.a.createElement(z.a,{color:"action"}))}}),r.a.createElement(B.a,{stickyHeader:!0},r.a.createElement(L.a,null,r.a.createElement(T.a,{key:c.key},c.columns.map((function(e){return r.a.createElement(I.a,null,e.label)})))),r.a.createElement(D.a,null,u.map((function(e){return r.a.createElement(T.a,{key:e[c.key],onClick:function(){t(e)}},c.columns.map((function(a){return r.a.createElement(I.a,null,e[a.name])})))})))),r.a.createElement(U.a,{rowsPerPageOptions:[c.numerolinhas],labelDisplayedRows:function(e){var a=e.from,t=e.to,n=e.count;return"Exibindo registros ".concat(a,"-").concat(t," de ").concat(n)},component:"div",backIconButtonText:"P\xe1gina Anterior",nextIconButtonText:"Pr\xf3xima P\xe1gina",count:x,rowsPerPage:c.numerolinhas,page:b,onChangePage:function(e,a){v(a)}}))))}function he(e){var a=r.a.useState(!1),t=Object(d.a)(a,2),n=t[0],o=t[1],c=e.titulo,i=e.data,l=e.onValueChange,u=e.formatValue,s=r.a.useState(""),m=Object(d.a)(s,2),p=m[0],g=m[1];return r.a.createElement("div",null,r.a.createElement(H.a,{id:"pesquisa",fullWidth:!0,value:p,label:c||"",InputProps:{endAdornment:r.a.createElement(O.a,{size:"small",onClick:function(){o(!0)}},r.a.createElement(z.a,{color:"action"}))}}),r.a.createElement(Ee,{titulo:c,data:i,open:n,onClose:function(e){o(!1);var a=null!=e?u(e):"";g(a),l(e)}}))}var be=Object(b.a)((function(e){return{container:{padding:e.spacing(5,3,0,3)},containerAcao:{display:"flex",justifyContent:"flex-end",padding:e.spacing(3,0)}}}));var ve=t(145),Ce=t.n(ve);function ye(){var e=Object(l.g)(),a=Object(n.useContext)(oe).openSnackbar,t=function(e){var t=e.response;t&&400===t.status?a(t.data.mensagem,"warning"):a("Ocorreu um erro n\xe3o tratado pelo servidor.","error")};return r.a.createElement("div",null,r.a.createElement(J,{data:{key:"idProduto",url:"produtos",columns:[{label:"C\xf3digo",name:"idProduto"},{label:"Descri\xe7\xe3o",name:"descricao"}],actionWidth:140,actions:[{onClick:function(a){e.push("/admin/cadastro-produtos",a)},icon:r.a.createElement(K.a,{color:"primary"})},{condition:function(e){return null==e.dataExclusao},onClick:function(e){V.delete("/produtos/".concat(e.idProduto)).then((function(){e.dataExclusao=new Date,a("Produto excluido com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(X.a,{color:"secondary"})},{condition:function(e){return null!=e.dataExclusao},onClick:function(e){V.put("/produtos/".concat(e.idProduto)).then((function(){e.dataExclusao=null,a("Produto reincluido com sucesso","success")})).catch((function(e){return t(e)}))},icon:r.a.createElement(_.a,{color:"primary"})},{onClick:function(a){e.push("/admin/cadastro-produtos-imagem",a)},icon:r.a.createElement(Ce.a,{color:"primary"})}]}},r.a.createElement(ae.a,{variant:"contained",color:"primary",onClick:function(){e.push("/admin/cadastro-produtos")}},r.a.createElement(ee.a,null),"Adicionar")))}var Oe=t(356),xe=t(394),ke=t(386),je=t(364),Pe=t(371),we=t(372),Se=t(146),Ae=t.n(Se),Ne=(t(310),Object(b.a)((function(e){return{root:{flexShrink:0,marginLeft:e.spacing(1.5),padding:e.spacing(3)},formControl:{marginTop:e.spacing(1)},editor:{marginTop:e.spacing(3)},container:{padding:e.spacing(5,3,0,3)},containerAcao:{display:"flex",justifyContent:"flex-end",padding:e.spacing(3,0)}}})));function Be(){return r.a.createElement(J,{data:{key:"codigo",url:"usuarios",columns:[{label:"C\xf3digo",name:"codigo"},{label:"Descri\xe7\xe3o",name:"descricao"}]}})}var De=Object(b.a)((function(e){return{root:{width:"100%"},paper:{width:"100%",marginBottom:e.spacing(2)},table:{minWidth:750},visuallyHidden:{border:0,clip:"rect(0 0 0 0)",height:1,margin:-1,overflow:"hidden",padding:0,position:"absolute",top:20,width:1},buttonAddPhoto:{marginRight:e.spacing(1)}}})),Ie=t(373),qe=t(389),Te=Object(b.a)((function(e){return{cabecalho:{display:"flex",padding:e.spacing(2)},cabecalhoBotoes:{padding:e.spacing(0,2,0,0)}}})),We=function(){};function He(e){var a=Te(),t=e.children,o=e.codigoProduto,c=r.a.useState([]),i=Object(d.a)(c,2),l=i[0],u=i[1],s=Object(n.useContext)(oe).openSnackbar;r.a.useEffect((function(){return m()}),[]);var m=function(){V.get("/produtos/imagem/".concat(o)).then((function(e){var a=e.data;u(a)})).catch((function(e){var a=e.response;a&&400===a.status?s(a.data.mensagem,"warning"):s("Ocorreu um erro n\xe3o tratado pelo servidor.","error")}))};return r.a.createElement(q.a,{component:W.a},r.a.createElement("div",{className:a.cabecalho},r.a.createElement("div",{className:a.cabecalhoBotoes},t)),r.a.createElement(B.a,null,r.a.createElement(L.a,null,r.a.createElement(T.a,null,r.a.createElement(I.a,null,"Exibi\xe7\xe3o"),r.a.createElement(I.a,null,"C\xf3digo"),r.a.createElement(I.a,null,"Localiza\xe7\xe3o"),r.a.createElement(I.a,null,"Imagem"))),r.a.createElement(D.a,null,l.map((function(e){return r.a.createElement(T.a,null,r.a.createElement(I.a,null,r.a.createElement(qe.a,{checked:e.imagemPrincipal,onChange:We,inputProps:{"aria-label":"primary checkbox"}})),r.a.createElement(I.a,null,e.idImagemProduto),r.a.createElement(I.a,null,e.local),r.a.createElement(I.a,null,r.a.createElement("img",{src:"".concat(e.type,",").concat(e.content),height:50})))})))))}var Le=t(147),Ue=t.n(Le);var Re=[{id:1,path:"/admin/home",title:"Home",visible:!0,icon:r.a.createElement(N.a,null),component:function(e){return r.a.createElement("div",null,"Home")}},{id:1,path:"/admin/caracteristicas",title:"Caracteristicas",visible:!0,icon:r.a.createElement(N.a,null),component:function(){return r.a.createElement(le,null)}},{id:1,path:"/admin/categorias",title:"Categorias",visible:!0,icon:r.a.createElement(N.a,null),component:function(){return r.a.createElement("div",null,r.a.createElement(ue,null))}},{id:1,path:"/admin/cadastro-caracteristicas",title:"Cadastrar",visible:!1,component:function(e){var a=e.location.state,t=r.a.useState(Object.assign({idCaracteristica:null,descricao:""},a)),o=Object(d.a)(t,2),c=o[0],i=o[1],u=Object(n.useContext)(oe).openSnackbar,s=Object(l.g)(),m=me(),f=function(){s.push("/admin/caracteristicas")};return r.a.createElement(W.a,{className:m.container},r.a.createElement("form",{noValidate:!0},r.a.createElement(H.a,{name:"idCaracteristica",value:c.idCaracteristica,label:"C\xf3digo",disabled:!0}),r.a.createElement(H.a,{name:"descricao",value:c.descricao,onChange:function(e){i(Object(g.a)(Object(g.a)({},c),{},Object(p.a)({},e.target.name,e.target.value)))},fullWidth:!0,label:"Descri\xe7\xe3o"}),r.a.createElement(se.a,{fullWidth:!0,className:m.containerAcao},r.a.createElement(ae.a,{onClick:function(e){V.post("caracteristicas",c).then((function(){u("Caracter\xedstica cadastrada com sucesso","success"),f()})).catch((function(e){var a=e.response;a&&400===a.status?u(a.data.mensagem,"warning"):u("Ocorreu um erro n\xe3o tratado pelo servidor.","error")}))},variant:"contained",color:"primary"},"Salvar"),r.a.createElement(ae.a,{onClick:f,style:{marginLeft:5},variant:"contained",color:"secondary"},"Cancelar"))))}},{id:1,path:"/admin/cadastro-categorias",title:"Cadastrar",visible:!1,component:function(e){var a=e.location.state,t=r.a.useState(Object.assign({idCategoria:"",descricao:""},a)),o=Object(d.a)(t,2),c=o[0],i=o[1],u=Object(n.useContext)(oe).openSnackbar,s=Object(l.g)(),m=be(),f=function(){s.push("/admin/categorias")};return r.a.createElement(W.a,{className:m.container},r.a.createElement("form",{noValidate:!0},r.a.createElement(H.a,{name:"idCategoria",value:c.idCategoria,label:"C\xf3digo",disabled:!0}),r.a.createElement(he,{codigoPesquisa:1,rowsPerPage:20,onValueChange:function(e){return i(Object(g.a)(Object(g.a)({},c),{},{codigoCategoria:null!=e?e.idCategoria:null}))},formatValue:function(e){return e.idCategoria+" - "+e.descricao},data:{numerolinhas:20,key:"idCategoria",url:"categorias",columns:[{label:"C\xf3digo",name:"idCategoria"},{label:"Descri\xe7\xe3o",name:"descricao"}]},titulo:"Categoria"}),r.a.createElement(H.a,{name:"descricao",value:c.descricao,onChange:function(e){i(Object(g.a)(Object(g.a)({},c),{},Object(p.a)({},e.target.name,e.target.value)))},fullWidth:!0,label:"Descri\xe7\xe3o"}),r.a.createElement(se.a,{className:m.containerAcao},r.a.createElement(ae.a,{onClick:function(e){V.post("categorias",c).then((function(){u("Categoria cadastrada com sucesso","success"),f()})).catch((function(e){var a=e.response;a&&400===a.status?u(a.data.mensagem,"warning"):u("Ocorreu um erro n\xe3o tratado pelo servidor.","error")}))},variant:"contained",color:"primary"},"Salvar"),r.a.createElement(ae.a,{onClick:f,style:{marginLeft:5},variant:"contained",color:"secondary"},"Cancelar"))))}},{id:1,path:"/admin/produtos",title:"Produtos",visible:!0,icon:r.a.createElement(N.a,null),component:function(){return r.a.createElement("div",null,r.a.createElement(ye,null))}},{id:1,path:"/admin/cadastro-produtos",title:"Cadastro de Produto",visible:!1,component:function(e){var a=Ne(),t=Object(l.g)(),o=e.location.state,c=r.a.useState(Object.assign({idProduto:"",descricao:"",descricaoConteudo:"",codigoCategoria:"",codigoUnidade:null,controlaEstoque:!0,produtoOferta:!1,produtoDestaque:!1},o)),i=Object(d.a)(c,2),u=i[0],s=i[1],m=Object(n.useContext)(oe).openSnackbar,f=function(e,a){s(Object(g.a)(Object(g.a)({},u),{},Object(p.a)({},e,a)))},E=function(){t.push("/admin/produtos")};return r.a.createElement(W.a,{className:a.root},r.a.createElement("form",{noValidate:!0,autoComplete:"off"},r.a.createElement(H.a,{name:"idProduto",value:u.idProduto,label:"C\xf3digo",disabled:!0}),r.a.createElement(H.a,{value:u.descricao,onChange:function(e){return f("descricao",e.target.value)},fullWidth:!0,label:"Descri\xe7\xe3o"}),r.a.createElement(he,{codigoPesquisa:1,rowsPerPage:20,onValueChange:function(e){return f("codigoCategoria",null!=e?e.idCategoria:null)},formatValue:function(e){return e.idCategoria+" - "+e.descricao},data:{numerolinhas:20,key:"idCategoria",url:"categorias",columns:[{label:"C\xf3digo",name:"idCategoria"},{label:"Descri\xe7\xe3o",name:"descricao"}]},titulo:"Categoria"}),r.a.createElement(Oe.a,{fullWidth:!0,className:a.formControl},r.a.createElement(xe.a,{id:"lb-unidade"},"Unidade de Medida"),r.a.createElement(ke.a,{labelId:"lb-unidade",value:u.codigoUnidade,onChange:function(e){return f("codigoUnidade",e.target.value)},displayEmpty:!0},r.a.createElement(je.a,{value:1},"Kg"),r.a.createElement(je.a,{value:2},"Un"),r.a.createElement(je.a,{value:3},"Pc"))),r.a.createElement(Pe.a,{className:a.formControl,control:r.a.createElement(we.a,{color:"primary",checked:u.controlaEstoque,onChange:function(e){return f("controlaEstoque",e.target.checked)},name:"controlaEstoque"}),label:"Controla Estoque"}),r.a.createElement(Pe.a,{className:a.formControl,control:r.a.createElement(we.a,{color:"primary",checked:u.produtoOferta,onChange:function(e){return f("produtoOferta",e.target.checked)},name:"produtoOferta"}),label:"Produto em Oferta"}),r.a.createElement(Pe.a,{className:a.formControl,control:r.a.createElement(we.a,{color:"primary",checked:u.produtoDestaque,onChange:function(e){return f("produtoDestaque",e.target.checked)},name:"produtoDestaque"}),label:"Produto em Destaque"}),r.a.createElement(xe.a,{className:a.editor},"Breve descri\xe7\xe3o sobre o Produto"),r.a.createElement(Ae.a,{theme:"snow",value:u.descricaoConteudo,onChange:function(e){return f("descricaoConteudo",e)}}),r.a.createElement(se.a,{className:a.containerAcao},r.a.createElement(ae.a,{onClick:function(e){V.post("produtos",u).then((function(){m("Produto cadastrado com sucesso","success"),E()})).catch((function(e){var a=e.response;a&&400===a.status?m(a.data.mensagem,"warning"):m("Ocorreu um erro n\xe3o tratado pelo servidor.","error")}))},variant:"contained",color:"primary"},"Salvar"),r.a.createElement(ae.a,{onClick:E,style:{marginLeft:5},variant:"contained",color:"secondary"},"Cancelar"))))}},{id:1,path:"/admin/cadastro-produtos-imagem",title:"Cadastro de Imagens",visible:!1,component:function(e){var a=De(),t=r.a.useState(!1),o=Object(d.a)(t,2),c=o[0],i=o[1],l=r.a.useState(null),u=Object(d.a)(l,2),s=u[0],m=u[1],p=Object(n.useContext)(oe).openSnackbar,g=e.location.state,f=function(){i(!1)};return r.a.createElement("div",{className:a.root},r.a.createElement(W.a,{className:a.paper},r.a.createElement(He,{codigoProduto:g.idProduto},r.a.createElement(ae.a,{variant:"outlined",color:"primary",onClick:function(){i(!0)}},r.a.createElement(Ue.a,{color:"action",className:a.buttonAddPhoto}),"Cadastrar Imagem"),r.a.createElement(de.a,{open:c,onClose:f,"aria-labelledby":"form-dialog-title"},r.a.createElement(ge.a,null,r.a.createElement("input",{accept:"image/*",onChange:function(e){return m(e.target.files[0])},type:"file",id:"icon-button-file"})),r.a.createElement(Ie.a,null,r.a.createElement(ae.a,{onClick:f,color:"primary"},"Cancel"),r.a.createElement(ae.a,{onClick:function(){if(null!=s){var e=new FileReader;e.onloadend=function(){V.post("produtos/imagem",{imagem:e.result.replace(/^data:.+;base64,/,""),descricao:s.name,codigoProduto:g.idProduto}).then((function(){f(),p("Imagem Cadastrada com sucesso","success")})).catch((function(e){var a=e.response;a&&400===a.status?p(a.data.mensagem,"warning"):p("Ocorreu um erro n\xe3o tratado pelo servidor.","error")}))},e.readAsDataURL(s)}else p("Selecione uma imagem para o produto","warning")},color:"primary"},"Salvar"))))))}},{id:1,path:"/admin/usuarios",title:"Usu\xe1rios",visible:!0,icon:r.a.createElement(N.a,null),component:function(){return r.a.createElement("div",null,r.a.createElement(Be,null))}}],Ve=t(148),Ge=t.n(Ve),ze=t(314),Fe=t(374),Ye=t(375);function Je(e){var a=e.menu;return r.a.createElement(i.b,{to:a.path},r.a.createElement(ze.a,{button:!0},r.a.createElement(Fe.a,null,a.icon),r.a.createElement(Ye.a,{primary:a.title})))}var Me=Object(b.a)((function(e){return{root:{display:"flex"},toolbar:{paddingRight:24},toolbarIcon:Object(g.a)({display:"flex",alignItems:"center",justifyContent:"flex-end",padding:"0 8px"},e.mixins.toolbar),appBar:{zIndex:e.zIndex.drawer+1,transition:e.transitions.create(["width","margin"],{easing:e.transitions.easing.sharp,duration:e.transitions.duration.leavingScreen})},appBarShift:{marginLeft:240,width:"calc(100% - ".concat(240,"px)"),transition:e.transitions.create(["width","margin"],{easing:e.transitions.easing.sharp,duration:e.transitions.duration.enteringScreen})},drawerPaper:{position:"relative",whiteSpace:"nowrap",width:240,transition:e.transitions.create("width",{easing:e.transitions.easing.sharp,duration:e.transitions.duration.enteringScreen})},drawerPaperClose:Object(p.a)({overflowX:"hidden",transition:e.transitions.create("width",{easing:e.transitions.easing.sharp,duration:e.transitions.duration.leavingScreen}),width:e.spacing(7)},e.breakpoints.up("sm"),{width:e.spacing(9)}),menuButton:{marginRight:36},menuButtonHidden:{display:"none"},title:{flexGrow:1},user:{flexGrow:1,fontSize:12},fixedHeight:{height:240}}}));function Ke(e){var a=Me(),t=r.a.useState(!0),n=Object(d.a)(t,2),o=n[0],c=n[1],i=e.history,l=e.title;return r.a.createElement("div",{className:a.root},r.a.createElement(v.a,null),r.a.createElement(C.a,{position:"absolute",className:Object(f.a)(a.appBar,o&&a.appBarShift)},r.a.createElement(y.a,{className:a.toolbar},r.a.createElement(O.a,{edge:"start",color:"inherit","aria-label":"open drawer",onClick:function(){c(!0)},className:Object(f.a)(a.menuButton,o&&a.menuButtonHidden)},r.a.createElement(Ge.a,null)),r.a.createElement(x.a,{component:"h1",variant:"h6",color:"inherit",noWrap:!0,className:a.title},l),r.a.createElement(O.a,{color:"inherit",onClick:function(){localStorage.removeItem("@usuario_lar"),i.push("admin/login")}},r.a.createElement("img",{src:h.a,width:25,height:25,alt:"Sair"})))),r.a.createElement(k.a,{variant:"permanent",classes:{paper:Object(f.a)(a.drawerPaper,!o&&a.drawerPaperClose)},open:o},r.a.createElement("div",{className:a.toolbarIcon},r.a.createElement(O.a,{onClick:function(){c(!1)}},r.a.createElement(w.a,null))),r.a.createElement(j.a,null),r.a.createElement(S.a,null,r.a.createElement("div",null,Re.filter((function(e){return e.visible&&m(e.id)})).map((function(e,a){return r.a.createElement(Je,{key:a,menu:e})}))))))}var Qe=t(379),Xe=t(150),Ze=t(151),_e=t(154),$e=t(153),ea=function(e){Object(_e.a)(t,e);var a=Object($e.a)(t);function t(){return Object(Xe.a)(this,t),a.apply(this,arguments)}return Object(Ze.a)(t,[{key:"render",value:function(){return r.a.createElement(x.a,{variant:"body2",color:"textSecondary",align:"center"},"Copyright \xa9 ","Imp\xe9rio Kids"," ",(new Date).getFullYear(),".")}}]),t}(r.a.Component),aa=Object(b.a)((function(e){return{root:{display:"flex",minHeight:"100vh"},content:{display:"flex",flexDirection:"column",flexGrow:1},container:{paddingTop:e.spacing(1),paddingBottom:e.spacing(4),paddingLeft:e.spacing(1),paddingRight:e.spacing(1),flex:1},appBarSpacer:e.mixins.toolbar,paper:{padding:e.spacing(2),marginLeft:e.spacing(2),marginRight:e.spacing(2),flex:1},footer:{padding:e.spacing(2),marginTop:"auto",backgroundColor:"dark"===e.palette.type?e.palette.grey[800]:e.palette.grey[300]}}}));var ta=t(392),na=t(385),ra=Object(b.a)((function(e){return{paper:{marginTop:e.spacing(8),display:"flex",flexDirection:"column",alignItems:"center"},avatar:{margin:e.spacing(1),backgroundColor:e.palette.secondary.main},form:{width:"100%",marginTop:e.spacing(1)},submit:{margin:e.spacing(3,0,2)}}}));var oa=t(381),ca=t(384),ia=t(383),la=t(382),ua=t(152),sa=t.n(ua),ma=t(380),da=Object(b.a)((function(e){return{"@global":{ul:{margin:0,padding:0,listStyle:"none"}},appBar:{borderBottom:"1px solid ".concat(e.palette.divider)},toolbar:{flexWrap:"wrap"},toolbarTitle:{flexGrow:1},link:{margin:e.spacing(1,1.5)},heroContent:{padding:e.spacing(8,0,6)},cardHeader:{backgroundColor:"light"===e.palette.type?e.palette.grey[200]:e.palette.grey[700]},cardPricing:{display:"flex",justifyContent:"center",alignItems:"baseline",marginBottom:e.spacing(2)},footer:Object(p.a)({borderTop:"1px solid ".concat(e.palette.divider),marginTop:e.spacing(8),paddingTop:e.spacing(3),paddingBottom:e.spacing(3)},e.breakpoints.up("sm"),{paddingTop:e.spacing(6),paddingBottom:e.spacing(6)})}})),pa=[{title:"Free",price:"0",description:["10 users included","2 GB of storage","Help center access","Email support"],buttonText:"Sign up for free",buttonVariant:"outlined"},{title:"Pro",subheader:"Most popular",price:"15",description:["20 users included","10 GB of storage","Help center access","Priority email support"],buttonText:"Get started",buttonVariant:"contained"},{title:"Enterprise",price:"30",description:["50 users included","30 GB of storage","Help center access","Phone & email support"],buttonText:"Contact us",buttonVariant:"outlined"}],ga=[{title:"Company",description:["Team","History","Contact us","Locations"]},{title:"Features",description:["Cool stuff","Random feature","Team feature","Developer stuff","Another one"]},{title:"Resources",description:["Resource","Resource name","Another resource","Final resource"]},{title:"Legal",description:["Privacy policy","Terms of use"]}];var fa=[{exact:!0,path:"/",component:function(){var e=da();return r.a.createElement(r.a.Fragment,null,r.a.createElement(v.a,null),r.a.createElement(C.a,{position:"static",color:"default",elevation:0,className:e.appBar},r.a.createElement(y.a,{className:e.toolbar},r.a.createElement(x.a,{variant:"h6",color:"inherit",noWrap:!0,className:e.toolbarTitle},"Company name"),r.a.createElement("nav",null,r.a.createElement(ma.a,{variant:"button",color:"textPrimary",href:"#",className:e.link},"Features"),r.a.createElement(ma.a,{variant:"button",color:"textPrimary",href:"#",className:e.link},"Enterprise"),r.a.createElement(ma.a,{variant:"button",color:"textPrimary",href:"#",className:e.link},"Support")),r.a.createElement(ae.a,{href:"#",color:"primary",variant:"outlined",className:e.link},"Login"))),r.a.createElement(se.a,{maxWidth:"sm",component:"main",className:e.heroContent},r.a.createElement(x.a,{component:"h1",variant:"h2",align:"center",color:"textPrimary",gutterBottom:!0},"Pricing"),r.a.createElement(x.a,{variant:"h5",align:"center",color:"textSecondary",component:"p"},"Quickly build an effective pricing table for your potential customers with this layout. It's built with default Material-UI components with little customization.")),r.a.createElement(se.a,{maxWidth:"md",component:"main"},r.a.createElement(Qe.a,{container:!0,spacing:5,alignItems:"flex-end"},pa.map((function(a){return r.a.createElement(Qe.a,{item:!0,key:a.title,xs:12,sm:"Enterprise"===a.title?12:6,md:4},r.a.createElement(oa.a,null,r.a.createElement(la.a,{title:a.title,subheader:a.subheader,titleTypographyProps:{align:"center"},subheaderTypographyProps:{align:"center"},action:"Pro"===a.title?r.a.createElement(sa.a,null):null,className:e.cardHeader}),r.a.createElement(ia.a,null,r.a.createElement("div",{className:e.cardPricing},r.a.createElement(x.a,{component:"h2",variant:"h3",color:"textPrimary"},"$",a.price),r.a.createElement(x.a,{variant:"h6",color:"textSecondary"},"/mo")),r.a.createElement("ul",null,a.description.map((function(e){return r.a.createElement(x.a,{component:"li",variant:"subtitle1",align:"center",key:e},e)})))),r.a.createElement(ca.a,null,r.a.createElement(ae.a,{fullWidth:!0,variant:a.buttonVariant,color:"primary"},a.buttonText))))})))),r.a.createElement(se.a,{maxWidth:"md",component:"footer",className:e.footer},r.a.createElement(Qe.a,{container:!0,spacing:4,justify:"space-evenly"},ga.map((function(e){return r.a.createElement(Qe.a,{item:!0,xs:6,sm:3,key:e.title},r.a.createElement(x.a,{variant:"h6",color:"textPrimary",gutterBottom:!0},e.title),r.a.createElement("ul",null,e.description.map((function(e){return r.a.createElement("li",{key:e},r.a.createElement(ma.a,{href:"#",variant:"subtitle1",color:"textSecondary"},e))}))))}))),r.a.createElement(na.a,{mt:5},r.a.createElement(ea,null))))}},{path:"/admin/login",component:function(e){var a=ra(),t=Object(n.useContext)(oe).openSnackbar,o=r.a.useState({usuario:"",senha:""}),c=Object(d.a)(o,2),i=c[0],l=c[1],u=e.history,s=function(e){l(Object(g.a)(Object(g.a)({},i),{},Object(p.a)({},e.target.name,e.target.value)))};return r.a.createElement(se.a,{component:"main",maxWidth:"xs"},r.a.createElement(v.a,null),r.a.createElement("div",{className:a.paper},r.a.createElement(ta.a,{className:a.avatar}),r.a.createElement(x.a,{component:"h1",variant:"h5"},"Autentica\xe7\xe3o"),r.a.createElement("form",{className:a.form,noValidate:!0},r.a.createElement(H.a,{variant:"outlined",margin:"normal",required:!0,fullWidth:!0,id:"usuario",label:"Usu\xe1rio",name:"usuario",autoComplete:"usuario",autoFocus:!0,value:i.usuario,onChange:s}),r.a.createElement(H.a,{variant:"outlined",margin:"normal",required:!0,fullWidth:!0,name:"senha",label:"Senha",type:"password",id:"senha",autoComplete:"senha",value:i.senha,onChange:s}),r.a.createElement(ae.a,{type:"submit",fullWidth:!0,variant:"contained",color:"primary",className:a.submit,onClick:function(e){e.preventDefault(),V.post("/autenticacao",{usuario:i.usuario,senha:i.senha}).then((function(e){var a;a=e.data,localStorage.setItem("@usuario_lar",JSON.stringify(a)),t("Usu\xe1rio autenticado com sucesso","success"),u.push("/admin/home")})).catch((function(e){var a=e.response;400===a.status?t(a.data.mensagem,"warning"):t("Ocorreu um erro n\xe3o tratado pelo servidor","error")}))}},"Login"))),r.a.createElement(na.a,{mt:8},r.a.createElement(ea,null)))}},{path:"/admin",component:function(e){var a=aa(),t=e.routes,n=e.history,o=function(e){return r.a.createElement(l.b,{path:e.path,render:function(a){return r.a.createElement(e.component,Object.assign({},a,{routes:e.routes}))}})};return r.a.createElement("div",{className:a.root},r.a.createElement(Ke,{history:e.history,title:function(){var e=t.find((function(e){return e.path===n.location.pathname}));return e?e.title:""}()}),r.a.createElement("div",{className:a.content},r.a.createElement("div",{className:a.appBarSpacer}),r.a.createElement("div",{className:a.container},r.a.createElement(Qe.a,{item:!0,xs:12},r.a.createElement(l.d,null,t.filter((function(e){return null==e.codigoPrograma||m(e.codigoPrograma)})).map((function(e,a){return r.a.createElement(o,Object.assign({key:a},e))}))))),r.a.createElement("footer",{className:a.footer},r.a.createElement(ea,null))))},auth:!0,routes:Re}];function Ea(){return r.a.createElement(ce,null,r.a.createElement(i.a,null,r.a.createElement("div",null,r.a.createElement(l.d,null,fa.map((function(e,a){return r.a.createElement(ha,Object.assign({key:a},e))}))))))}function ha(e){return r.a.createElement(l.b,{path:e.path,exact:e.exact,render:function(a){return e.auth&&!function(){var e=localStorage.getItem("@usuario_lar");return null!==e&&null!=JSON.parse(e).idUsuario}()?r.a.createElement(l.a,{to:"/admin/login"}):r.a.createElement(e.component,Object.assign({},a,{routes:e.routes}))}})}var ba=function(){return r.a.createElement(Ea,null)};c.a.render(r.a.createElement(ba,null),document.getElementById("root"))}},[[180,1,2]]]);
//# sourceMappingURL=main.a3c42fd6.chunk.js.map