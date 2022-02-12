/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */





   
function crearBolsillo(){
            var tabla = $("#tablaBolsillo");
   tabla.append("<tr class='table-active' id='fila'>"+
                    "<td >"+
                        "<div class='p-4'>"+
                            "<input hidden='' name='idBolsillo' class='form-control'  type='text'  disabled=''>"+
                        "</div>"+
                    "</td>"+

                    "<td class='col-6' >"+
                        "<div class='p-4 col-xs-4'>"+
                            "<label for='ex3'>Nombre bolsillo</label>"+
                            "<input name='txtnombre' class='form-control' id='inputnom' type='text' >"+
                        "</div>"+

                    "</td>"+
                    "<td>"+
                        "<div class=' p-4 col-xs-3'>"+
                            "<label for='ex2'>Presupuesto</label>"+
                            "<input name='txtpresupuesto' class='form-control' id='inputpresu' type='text' >"+
                        "</div>"+
                    "</td>"+
                    "<td>"+
                        "<div class='p-4 col-xs-3'>"+
                            "<label for='ex2'>Gasto real</label>"+
                            "<input name='txtgasto' class='form-control' id='inputgasto' type='text' >"+
                        "</div>"+
                    "</td>"+

                "</tr>");
        var button = document.getElementById("btnGuardar");        
        button.disabled = true;
       
};

/*
var inputnom= Document.getElementById("inputnom");
var inputpresu= Document.getElementById("inputpresu");
var inputgasto= Document.getElementById("inputgasto");
var fila= Document.getElementById("fila");
var columna = document.createElement("td");
var textoCelda = document.createElement("<button type='submit' name='accion' class='btn btn-outline-success' id='btnDelete' value='Delete'>Delete</button>");

if (inputnom.value !== "" && inputpresu.value !== "" ) {
    columna.appendChild(textoCelda);
    fila.appendChild(columna);
                 
}*/
