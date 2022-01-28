/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

$(document).ready(function () {
   
        $("#btnAgregar").click(function () {
            var tabla = $("#tablaBolsillo");
   tabla.append("<tr class='table-active'>"+

                    "<td class='col-6' >"+
                        "<div class='p-4 col-xs-4'>"+
                            "<label for='ex3'>Nombre bolsillo</label>"+
                            "<input class='form-control' id='ex3' type='text'>"+
                        "</div>"+

                    "</td>"+
                    "<td>"+
                        "<div class=' p-4 col-xs-3'>"+
                            "<label for='ex2'>Presupuesto</label>"+
                            "<input class='form-control' id='ex2' type='text'>"+
                        "</div>"+
                    "</td>"+
                    "<td>"+
                        "<div class='p-4 col-xs-3'>"+
                            "<label for='ex2'>Gasto real</label>"+
                            "<input class='form-control' id='ex2' type='text'>"+
                        "</div>"+
                    "</td>"+

                "</tr>");
        });
});
