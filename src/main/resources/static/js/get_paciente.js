$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/pacientes",
            success: function(response){
              $.each(response, (i, paciente) => {

                let direccion = paciente.domicilio.calle + " " + paciente.domicilio.numero + " " + paciente.domicilio.localidad + " " + paciente.domicilio.provincia;

                let edit_Btn = '<button' +
                                    ' type="button" class="btn_ico btn_edit_id" data-open="update_paciente_form">' +
                                    '<img' + ' id=' + '\"' + 'btn_id_' + paciente.id + '\"' + 'class= "icon" src="../images/userEdit.png">' +
                                    '</button>';

                let delete_Btn = '<button' +
                                    ' type="button" onClick="deleteBy('+ paciente.id + ')" class="btn_ico btn_delete_id">' +
                                     '<img '+ 'id=' + '\"' + 'btn_id_' + paciente.id + '\"' + 'class="icon" src="../images/userDelete.png">' +
                                    '</button>';

                let tr_id = 'tr_' + paciente.id;
                let pacienteRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td class=\"td_id\">' + paciente.id + '</td>' +
                          '<td class=\"td_first_name\">' + paciente.nombre + '</td>' +
                          '<td class=\"td_last_name\">' + paciente.apellido + '</td>' +
                          '<td class=\"td_dni\">' + paciente.dni + '</td>' +
                          '<td class=\"td_fecha_ingreso\">' + paciente.fecha_ingreso + '</td>' +
                          '<td class=\"td_domicilio\">' + direccion + '</td>' +
                          '<td>' + delete_Btn + edit_Btn + '</td>' +
                          '</tr>';
                $('#pacienteTable tbody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});