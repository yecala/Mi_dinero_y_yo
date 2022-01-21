/*!
* Start Bootstrap - Simple Sidebar v6.0.3 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2021 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

function Mostrar() {
            document.getElementById("caja").style.display = "block";
        }
        function Ocultar() {
            document.getElementById("caja").style.display = "none";
        }

        function Mostrar_Ocultar() {
            var caja = document.getElementById("caja");

            if (caja.style.display === "none") {
                Mostrar();
            } else {
                Ocultar();
            }
        }

        function Mostrar2() {
            document.getElementById("caja2").style.display = "block";
        }
        function Ocultar2() {
            document.getElementById("caja2").style.display = "none";
        }
        function Mostrar_Ocultar2() {
            var caja2 = document.getElementById("caja2");

            if (caja2.style.display === "none") {
                Mostrar2();
            } else {
                Ocultar2();
            }
        }

        function cerrarSesion() {
            document.location.href = "index.html";
        }